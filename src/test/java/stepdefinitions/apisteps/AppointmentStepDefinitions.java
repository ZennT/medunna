package stepdefinitions.apisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static Hooks.Hooks.spec;
import static utilities.Authentication.generateToken;

public class AppointmentStepDefinitions {
    Map <String, String> requestBody;
    Response response;

    @Given("user sets base url for appointment creation")
    public void userSetsBaseUrlForAppointmentCreation() {
        spec.pathParams("first","api","second","appointments"); // https://medunna.com/api/rooms
    }

    @And("user creates appointment data")
    public void userCreatesAppointmentData() {
        //map,String,json,java objesi
        requestBody = new HashMap<>(); // sol tarafi interface uzerirnden yaziyoruz sag tarafida yazdigimiz claslar interfaceler arazsinda gecis yapabiliyourz flexbility kazandiriyoe
        requestBody.put("email", "string@gmail.com");
        requestBody.put("firstName","string");
        requestBody.put("lastName","string");
        requestBody.put("phone","789-908-9087");
        requestBody.put("ssn","787-78-8907");

    }

    @And("user sends post request for appointment creation")
    public void userSendsPostRequestForAppointmentCreation() {
      //  response = postRequestAppointmentApi(generateToken(), ConfigurationReader.getProperty("appointment_post_endpoint"),requestBody);
        response.prettyPrint();
    }

    @Then("user validates appointment")
    public void userValidatesAppointment() {
    }
}
