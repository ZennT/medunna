package stepdefinitions.apisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;

/*
Room 35747
room number 6564
room type PREMIUM_DELUXE
status full
price 1000
description special room
created date 23/03/22 00:47


 */
public class US16_RoomCreateDeleteAPIStepDefs {

    Response response;
    Map<String, Object> expectedData = new HashMap<>();

    @Given("user sets Medunna base url")
    public void userSetsMedunnaBaseUrl() {
//        RequestSpecification spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
        spec.pathParams("first","api","second", "rooms", "third", 35747);
    }

    @When("user sends get request and get the response")
    public void userSendsGetRequestAndGetTheResponse() {
//        response = given().headers("Authorization", "Bearer" + generateToken(),
//                        "ContentType", ContentType.JSON,
//                "Accept", ContentType.JSON).
//                when().get(ConfigurationReader.getProperty("room_endpoint"));

        response = getRequest(generateToken(), ConfigurationReader.getProperty("room_endpoint"));
    }

    @And("user sets the expected data")
    public void userSetsTheExpectedData() {
        //expectedData = new HashMap<>();
        expectedData.put("roomNumber", 6564);
        expectedData.put("roomType", "PREMIUM_DELUXE");

    }

    @Then("user does the validation")
    public void userDoesTheValidation() {
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);
    }
}
