package stepdefinitions.apisteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojos.RoomApiRequest;
import pojos.RoomApiResponse;
import utilities.ApiUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.IOException;
import java.util.List;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.ApiUtils.*;
import static utilities.Authentication.generateToken;
import static utilities.ReadTxt.*;
import static utilities.WriteToTxt.saveRoomApiData;

public class RoomApiStepDefs {


    RoomApiRequest roomApi = new RoomApiRequest();
    Response response;
    Faker faker = new Faker();
    RoomApiResponse actualRoomApi;  // postUpdatedRoom
    int createdRoomID;
    RoomApiResponse updatedRoom;     // putUpdatedRoom


    @Given("user sets base url for room creation")
    public void userSetsBaseUrlForRoomCreation() {
//        spec = new RequestSpecBuilder().setBaseUri("https://medunna.com").build();
        spec.pathParams("first","api","second","rooms"); // https://medunna.com/api/rooms

    }

    @When("user sets the expected room data")
    public void userSetsTheExpectedRoomData() {

        roomApi.setDescription("this is a test room description");
        roomApi.setRoomType("TWIN");
        roomApi.setRoomNumber(faker.number().numberBetween(5000, 7000));
        roomApi.setPrice(5000.50);
        roomApi.setStatus(true);

    }

    @And("user sends post request for room creation")
    public void userSendsPostRequestForRoomCreation() {

        response = postRequestRoomApi(generateToken(), ConfigurationReader.getProperty("room_endpoint"),roomApi);
        response.prettyPrint();
    }

    @And("user saves data")
    public void userSavesData()  {

//        saveRoomApiData(roomApi);
    }

    @Then("user validates room data")
    public void userValidatesRoomData() throws IOException {

        response.then().statusCode(201); // validation

        System.out.println("time " + response.getTime());

        long responseTime = response.getTime();
        Assert.assertTrue(responseTime < 500L);


        ObjectMapper obj = new ObjectMapper(); // desrialization from json to java
        actualRoomApi = obj.readValue(response.asString(), RoomApiResponse.class);

        createdRoomID = actualRoomApi.getId();

//        1.way
//        Assert.assertEquals(roomApi.getRoomNumber(),actualRoomApi.getRoomNumber());
//        System.out.println("expected " + roomApi.getRoomNumber());
//        System.out.println("actual " + actualRoomApi.getRoomNumber());

//        2. way
//        List<String> expectedRoomApiData = getRoomApiiData();
//        System.out.println("expected:"+ expectedRoomApiData);// bizim olusturdugumuz bilgi
//
//        List<String> actualRoomApiData = getApiiRoomData();
//        System.out.println("actual: "+actualRoomApiData); // databasedeki butun bilgiler
//
//        Assert.assertTrue(actualRoomApiData.containsAll(expectedRoomApiData));




    }

    @Then("send get request to validate created room")
    public void sendGetRequestToValidateCreatedRoom() {

        String endpoint = "https://medunna.com/api/rooms/" + createdRoomID;
        response = getRequest(generateToken(),endpoint);
        response.then().statusCode(200);


//        spec.pathParams("first","api","second","rooms","third",54523);
//        response = getRequest1(generateToken());


//        spec.pathParams("parameter1","1","parametre2","boards","parametre3",id,"parametre4",fieldName);
//
//        RequestPOJO requestPOJO = new RequestPOJO(ConfigReader.getProperty("key"),ConfigReader.getProperty("token"));
//        response = given().
//                contentType(ContentType.JSON).
//                spec(spec).
//                body(requestPOJO).
//                when().get("{parameter1}/{parametre2}/{parametre3}/{parametre4}");

    }


    @Then("send put request to update room type")
    public void sendPutRequestToUpdateRoomType() {


        actualRoomApi.setRoomType("DELUXE");
        response = ApiUtils.putRequest(generateToken(),ConfigurationReader.getProperty("room_endpoint") ,actualRoomApi);

        /*
        * put request sonrasi donen object json oldugu icinonu java object e cevirmemiz gerekiyor.
        * bunun iciinde object mapper de kullanabilirdik ama burda extract kullandik,
        * extracten snra as methodu ile hangi objeye ceviriceksek onu as methodunun icine yaziyoruz
        * */

        updatedRoom = response.then().extract().as(RoomApiResponse.class);
//        actualRoomApi = response.then().extract().as(RoomApiResponse.class);  // deserialization
        response.then().statusCode(200);

        System.out.println("Update room validation- PUT request");
        Assert.assertEquals("DELUXE", updatedRoom.getRoomType());

    }

    @Then("send get request to validate updated room")
    public void sendGetRequestToValidateUpdatedRoom() {
        String endpoint = "https://medunna.com/api/rooms/" + createdRoomID;
        response = getRequest(generateToken(),endpoint);

        response.then().statusCode(200);
        System.out.println("Update room validation - GET request");
        Assert.assertEquals("DELUXE", updatedRoom.getRoomType());
    }

    @Then("send delete request to delete room")
    public void sendDeleteRequestToDeleteRoom() {
        String endpoint = "https://medunna.com/api/rooms/" + createdRoomID;
        System.out.println("Delete request");
        response = ApiUtils.deleteRequest(generateToken(),endpoint);

        response.then().statusCode(204);

    }

    @Then("send get request to validate the room is deleted")
    public void sendGetRequestToValidateTheRoomIsDeleted() {
        String endpoint = "https://medunna.com/api/rooms/" + createdRoomID;
        response = getRequest(generateToken(),endpoint);

        response.then().statusCode(404);
        System.out.println("Delete room validation - GET request");
    }
}
