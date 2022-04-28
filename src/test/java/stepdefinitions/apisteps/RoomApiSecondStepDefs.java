package stepdefinitions.apisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.Ha;
import io.restassured.response.Response;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static Hooks.Hooks.spec;
import static utilities.ApiUtils.postRequestRoomApiSecond;
import static utilities.Authentication.generateToken;

public class RoomApiSecondStepDefs {

    /*
    {
  "createdBy": "string",
  "createdDate": "2022-04-28T22:28:02.338Z",
  "description": "string",
  "id": 0,
  "price": 0,
  "roomNumber": 0,
  "roomType": "TWIN",
  "status": true
}
     */
    Faker faker = new Faker();
    Response response;
    Map<String, Object> createdRoomData;

    @Given("User sets base url for new room creation")
    public void userSetsBaseUrlForNewRoomCreation() {
        spec.pathParams("first","api","second","rooms");
    }

    @When("User sets the expected data for a new room")
    public void userSetsTheExpectedDataForANewRoom() {

        createdRoomData = new HashMap<>();
        createdRoomData.put("price",4000);
//        createdRoomData.put("price",faker.number().numberBetween(4000,6000));
        createdRoomData.put("roomNumber",faker.number().numberBetween(4000,7000));
        createdRoomData.put("roomType", "DELUXE");
        createdRoomData.put("status", true);
        createdRoomData.put("description","this is a test room");

    }

    @And("User sends post request and gets response for a new room")
    public void userSendsPostRequestAndGetsResponseForANewRoom() {
        response = postRequestRoomApiSecond(generateToken(), ConfigurationReader.getProperty("room_endpoint"),createdRoomData);
        response.prettyPrint();

    }

    @And("User validates the new room")
    public void userValidatesTheNewRoom() {
    }

    @And("User sends get request to reach newly created room")
    public void userSendsGetRequestToReachNewlyCreatedRoom() {
    }

    @And("User sends put request to update new room")
    public void userSendsPutRequestToUpdateNewRoom() {
    }
}
