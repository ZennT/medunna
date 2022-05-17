package stepdefinitions.apisteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.RoomApiRequest;
import pojos.RoomApiResponse;
import utilities.ApiUtils;
import utilities.ConfigurationReader;

import java.io.IOException;

import static Hooks.Hooks.spec;
import static utilities.ApiUtils.postRequestRoomApi;
import static utilities.Authentication.generateToken;

public class RoomApiSteps {
    RoomApiRequest roomApi = new RoomApiRequest();
    Response response;
    Faker faker = new Faker();
    RoomApiResponse actualRoomApi;
    int createdRoomID;
    RoomApiResponse updatedRoom;


    @Given("user sets base url for room creation")
    public void userSetsBaseUrlForRoomCreation() {
        spec.pathParams("first","api","second","rooms"); // https://medunna.com/api/rooms

    }

    @And("user sets the expected room data")
    public void userSetsTheExpectedRoomData() {
        roomApi.setDescription("this is a test room description");
        roomApi.setRoomType("TWIN");
        roomApi.setRoomNumber(30790);
        roomApi.setPrice(5000.50);
        roomApi.setStatus(true);
    }

    @And("user sends post request for room creation")
    public void userSendsPostRequestForRoomCreation() {
    response = postRequestRoomApi(generateToken(), ConfigurationReader.getProperty("room_endpoint"),roomApi);
    response.prettyPrint();

    }



    @And("user saves data")
    public void userSavesData() {
        //saveRoomApiData(roomApi);

    }

    @Then("user validates room data")
    public void userValidatesRoomData() throws IOException {
        response.then().statusCode(201);
        ObjectMapper obj = new ObjectMapper();
        actualRoomApi = obj.readValue(response.asString(), RoomApiResponse.class);
        createdRoomID = actualRoomApi.getId();

        // 1.way
// Assert.assertEquals(roomApi.getRoomNumber(),actualRoomApi.getRoomNumber());
// System.out.println("expected " + roomApi.getRoomNumber());
// System.out.println("actual " + actualRoomApi.getRoomNumber());

// 2. way
// List<String> expectedRoomApiData = getRoomApiiData();
// System.out.println("expected:"+ expectedRoomApiData);// bizim olusturdugumuz bilgi
//
// List<String> actualRoomApiData = getApiiRoomData();
// System.out.println("actual: "+actualRoomApiData); // databasedeki butun bilgiler
//
// Assert.assertTrue(actualRoomApiData.containsAll(expectedRoomApiData));


    }

    @Then("send get request to validate created room")
    public void sendGetRequestToValidateCreatedRoom() {
        String endpoint = "https://medunna.com/api/rooms/" + createdRoomID;
        response = ApiUtils.getRequest(generateToken(),endpoint);
        response.then().statusCode(200);


    }

    @Then("send put request to update room type")
    public void sendPutRequestToUpdateRoomType() {
         actualRoomApi.setRoomType("DELUXE");
         response = ApiUtils.putRequest(generateToken(),ConfigurationReader.getProperty("room_endpoint"),actualRoomApi);

         /**
          * put request sonrasi donen object json oldugu icinonu java object e cevirmemiz gerekiyor.
          * bunun iciinde object mapper de kullanabilirdik ama burda extract kullandik
          *  extracten snra as methodu ile hangi objeye ceviriceksek onu as methodunun icine yaziyoruz
 * */
        updatedRoom= response.then().extract().as(RoomApiResponse.class);
         response.then().statusCode(200);
         System.out.println("Update room validation- PUT request");
         Assert.assertEquals("DELUXE", updatedRoom.getRoomType());


    }

    @Then("send get request to validate updated room")
    public void sendGetRequestToValidateUpdatedRoom() {
        String endpoint = "https://medunna.com/api/rooms/" + createdRoomID;
         response = ApiUtils.getRequest(generateToken(),endpoint);
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
         response = ApiUtils.getRequest(generateToken(),endpoint);
         response.then().statusCode(404);
         System.out.println("Delete room validation - GET request");

    }

}
