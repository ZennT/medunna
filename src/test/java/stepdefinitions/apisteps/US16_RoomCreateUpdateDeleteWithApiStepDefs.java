package stepdefinitions.apisteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.RoomCreateUpdateDelete;
import utilities.ConfigurationReader;

import java.io.IOException;
import java.util.List;

import static Hooks.Hooks.spec;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.getRequest;
import static utilities.ApiUtils.postRequestRoom;
import static utilities.Authentication.generateToken;
import static utilities.ReadTxt.*;
import static utilities.WriteToTxt.saveAllRoomData;
import static utilities.WriteToTxt.saveRoomData;

public class US16_RoomCreateUpdateDeleteWithApiStepDefs {

    RoomCreateUpdateDelete room = new RoomCreateUpdateDelete();
    Response response;
    RoomCreateUpdateDelete[] roomCreateUpdateDelete;
    Faker faker = new Faker();


    @Given("user sets path params to create room")
    public void userSetsPathParamsToCreateRoom() {
        spec.pathParams("first","api","second", "rooms");
    }


    @When("user sets expected data for new room creation")
    public void userSetsExpectedDataForNewRoomCreation() {

        room.setCreatedBy("admin79");
        room.setDescription("this is a test description");
        room.setPrice(faker.number().numberBetween(5000, 10000));
        room.setRoomNumber(faker.number().numberBetween(5000, 7000));
        room.setRoomType("DELUXE");
        room.setStatus(true);
    }


    @When("user sends post request and gets response to create a room")
    public void userSendsPostRequestAndGetsResponseToCreateARoom() {
        response = postRequestRoom(generateToken(), ConfigurationReader.getProperty("room_endpoint"), room);
        response.prettyPrint();
    }

    @And("user saves room records to corresponding files")
    public void userSavesRoomRecordsToCorrespondingFiles() {
        saveRoomData(room);

    }

    @Then("user does room validation")
    public void userDoesRoomValidation() throws IOException {
        response.then().statusCode(201);
        ObjectMapper obj = new ObjectMapper();
        RoomCreateUpdateDelete actualData = obj.readValue(response.asString(),RoomCreateUpdateDelete.class);

        assertEquals(room.getCreatedBy(),actualData.getCreatedBy());
        assertEquals(room.getDescription(), actualData.getDescription());
        assertEquals(room.getPrice(), actualData.getPrice());
        assertEquals(room.getRoomNumber(), actualData.getRoomNumber());
        assertEquals(room.getRoomType(), actualData.getRoomType());
        assertEquals(room.isStatus(), actualData.isStatus());
    }


    @Given("user sends get request to read room data")
    public void userSendsGetRequestToReadRoomData() {
        response = getRequest(generateToken(), ConfigurationReader.getProperty("room_endpoint"));
//        response.prettyPrint();
    }

    @And("user deserializes room data to Java")
    public void userDeserializesRoomDataToJava() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        roomCreateUpdateDelete = obj.readValue(response.asString(),RoomCreateUpdateDelete[].class);

    }

    @And("user saves room data to correspondent file")
    public void userSavesRoomDataToCorrespondentFile() {
        saveAllRoomData(roomCreateUpdateDelete);

    }


    @Then("user validates expected new created room records with Api")
    public void userValidatesExpectedNewCreatedRoomRecordsWithApi() {
        List<String> expectedRoomData = getRoomData();
        System.out.println("expected:"+ expectedRoomData);
        List<String> actualRoomData = getApiRoomData();
        System.out.println("actual: "+actualRoomData);
        Assert.assertTrue(actualRoomData.containsAll(expectedRoomData));
    }
}
