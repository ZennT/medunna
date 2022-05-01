package stepdefinitions.apisteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.Ha;
import io.cucumber.java.it.Ma;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static Hooks.Hooks.spec;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.*;
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
    Map<String, Object> createdRoomData;  // gonderdigimiz data
    Map<String, Object> actualRoomData;    // database deki hali

    Object createdRoomId;
    String endpoint;
//    JsonPath json;


    @Given("User sets base url for new room creation")
    public void userSetsBaseUrlForNewRoomCreation() {
        spec.pathParams("first","api","second","rooms");
    }

    @When("User sets the expected data for a new room")
    public void userSetsTheExpectedDataForANewRoom() {

        createdRoomData = new HashMap<>();
        createdRoomData.put("price",4000);
//      createdRoomData.put("price",faker.number().numberBetween(4000,6000));
        createdRoomData.put("roomNumber",faker.number().numberBetween(4000,7000));
        createdRoomData.put("roomType", "DELUXE");
        createdRoomData.put("status", true);
        createdRoomData.put("description","this is a test room");

    }

    @And("User sends post request and gets response for a new room")
    public void userSendsPostRequestAndGetsResponseForANewRoom() {
//        response = postRequestRoomApiSecond(ConfigurationReader.getProperty("token"), ConfigurationReader.getProperty("room_endpoint"),createdRoomData);
        response = postRequestRoomApiSecond(generateToken(), ConfigurationReader.getProperty("room_endpoint"),createdRoomData);

        response.prettyPrint();

    }

    @And("User validates the new room")
    public void userValidatesTheNewRoom() {
       response.then().statusCode(201);


        actualRoomData = response.as(HashMap.class);  // deserialization with map
        Assert.assertEquals(createdRoomData.get("roomNumber"),actualRoomData.get("roomNumber"));
        System.out.println("********************");

//        jsonpath sadece validate etmek icin kullaniyoruz, ornek olarak yazdik, yukarida map ile basladik diger islemlere map olarak devam ediyoruz
//        json = response.jsonPath();
//        assertEquals(createdRoomData.get("roomType"),json.getString("roomType"));
//        json.prettyPrint();


        System.out.println("created roomNumber " + createdRoomData.get("roomNumber") + " " + "actual roomNumber " + actualRoomData.get("roomNumber"));



    }

    @And("User sends get request to reach newly created room")
    public void userSendsGetRequestToReachNewlyCreatedRoom() {
        createdRoomId = actualRoomData.get("id");

//        createdRoomId = json.get("id");
        System.out.println("room id " + createdRoomId);

//1.way
        endpoint = "https://medunna.com/api/rooms/" + createdRoomId;
        response = getRequest(generateToken(),endpoint);

//2.way
//        response = getRequest(generateToken(),ConfigurationReader.getProperty("room_endpoint" ) + "/" + createdRoomId);


        response.then().statusCode(200);
        response.prettyPrint();

    }


    @And("User sends put request to update new room")
    public void userSendsPutRequestToUpdateNewRoom() {
//        put --> full update ama partial icin de kullaniliyor
//        updatedRoomData = new HashMap<>();

        actualRoomData.put("roomType", "TWIN");
        actualRoomData.put("price", 1000);




        response = putRequestRoomSecond(generateToken(),ConfigurationReader.getProperty("room_endpoint"), actualRoomData);
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Then("User deletes created room")
    public void userDeletesCreatedRoom() {
        response = deleteRequest(generateToken(),endpoint);
        response.then().statusCode(204);
    }

    @Then("User verifies that created room is deleted")
    public void userVerifiesThatCreatedRoomIsDeleted() {
        response = getRequest(generateToken(),endpoint);
        response.then().statusCode(404);
    }
}

//???
//    Gson gson = new GsonBuilder()
//            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
//            .create();
//
//    User user = gson.fromJson(jsonString, User.class);