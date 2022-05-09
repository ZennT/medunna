package stepdefinitions.apisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;;
import java.util.HashMap;
import java.util.Map;
import static Hooks.Hooks.spec;
import static utilities.ApiUtils.*;
import static utilities.Authentication.generateToken;

import org.junit.Assert;
import utilities.ConfigurationReader;


public class RoomApiSecondStepsDefs {
    Faker faker = new Faker();
    Response response;
    Map <String,Object> createdRoomData;
    Map <String,Object> actualRoomData;
    Object createdRoomId;
    JsonPath json;



    @Given("User sets base url for new room creation")
    public void userSetsBaseUrlForNewRoomCreation() {
        spec.pathParams("first","api","second","rooms");
    }

    @When("User sets the expected data for a new room")
    public void userSetsTheExpectedDataForANewRoom() {
        createdRoomData = new HashMap<>();
        createdRoomData.put("price",4000);
        createdRoomData.put("roomNumber",faker.number().numberBetween(4000,7000));
        createdRoomData.put("roomType","DELUXE");
        createdRoomData.put("status",true);
        createdRoomData.put("description", "this is a test room");
    }

    @And("User sends post request and gets response for a new room")
    public void userSendsPostRequestAndGetsResponseForANewRoom() {
        response = postRequestRoomApiSecond(generateToken(), ConfigurationReader.getProperty("room_endpoint"),createdRoomData);
        response.prettyPrint();
    }

    @And("User validates the new room")
    public void userValidatesTheNewRoom() {
        response.then().statusCode(201);
        actualRoomData = response.as(HashMap.class); //deserialization
        Assert.assertEquals(createdRoomData.get("roomNumber"),actualRoomData.get("roomNumber"));
        System.out.println("roomNumber " + createdRoomData.get("roomNumber")+ " " + "actual roomNumber " + actualRoomData.get("roomNumber") );
        System.out.println("**********************");

        //jsonpath sadece validate etmek icin kullaniyourz,. ornek olarak yazdik, yukarida map ile basladik diger islemlere map olarak devam ediyourz
//        json = response.jsonPath();
//        assertEquals(createdRoomData.get("roomType"),json.getString("roomType"));
//        json.prettyPrint();
    }

    @And("User sends get request to reach newly created room")
    public void userSendsGetRequestToReachNewlyCreatedRoom() {
        createdRoomId = actualRoomData.get("id");
        System.out.println("room id " + createdRoomData);
        // 1. Way String endpoint = "https://medunna.com/api/rooms/" + createdRoomId;
        // response = getRequest(generateToken(),endpoint);

        response = getRequest(generateToken(),ConfigurationReader.getProperty("room_endpoint" )+"/" + createdRoomId);
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @And("User sends put request to update new room")
    public void userSendsPutRequestToUpdateNewRoom() {
        //updatedRoomData = new HashMap<>();

        actualRoomData.put("roomType","TWIN");
        actualRoomData.put("price","1000");

        response = putRequestRoomSecond(generateToken(),ConfigurationReader.getProperty("room_endpoint" ),actualRoomData);
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Then("user deletes created room")
    public void userDeletesCreatedRoom() {
        response = deleteRequest(generateToken(),ConfigurationReader.getProperty("room_endpoint" )+"/" + createdRoomId);
        response.then().statusCode(204);
    }

    @Then("user verifies that created room deleted")
    public void userVerifiesThatCreatedRoomDeleted() {
        response=getRequest(generateToken(),ConfigurationReader.getProperty("room_endpoint" )+"/" + createdRoomId);
        response.then().statusCode(404);
    }


}
