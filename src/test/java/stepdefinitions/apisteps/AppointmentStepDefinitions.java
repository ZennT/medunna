package stepdefinitions.apisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import utilities.ConfigurationReader;

import java.util.*;

import static Hooks.Hooks.spec;
import static utilities.ApiUtils.postRequestRoomApi;
import static utilities.Authentication.generateToken;

public class AppointmentStepDefinitions  {

    Map<String, String> requestBody;
    Response response;



    @Given("user sets base url for appointment creation")
    public void userSetsBaseUrlForAppointmentCreation() {
        spec.pathParams("first","api","second","appointments"); // https://medunna.com/api/apppointments
    }

    @When("user creates appointment data")
    public void userCreatesAppointmentData() {
        // map, String, json, java objesi

        requestBody= new HashMap<>(); // linkedhashmap --> insertion order  treemap --> natural order
//                                      sol taraf interface yaziyoruz, sag tarafa class yaziyoruz veya interface yazip bunlar arasinda gecis yapabiliriz

        requestBody.put("email","stri123ng@gmail.com");
        requestBody.put("firstName","string");
        requestBody.put("lastName","string");
        requestBody.put("phone","125-456-8765");
        requestBody.put("startDate","2022-04-18");
        requestBody.put("ssn","125-45-8765");

    }

    @And("user sends post request for appointment creation")
    public void userSendsPostRequestForAppointmentCreation() {
//        response = postRequestRoomApi(generateToken(), "https://www.medunna.com/api/appointments/request",requestBody);
        response = postRequestRoomApi(generateToken(), ConfigurationReader.getProperty("appointment_post_endpoint"),requestBody);
        response.prettyPrint();
    }

    @Then("user validates appointment")
    public void userValidatesAppointment() {
    }
}
