package stepdefinitions.apisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Ui09PatientInfoApiStep {

    Response response;
    Map<String,Object> expectedData;
    public static RequestSpecification spec;

    @Given("set the base url")
    public void set_the_base_url() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();

        spec.pathParams("first","api","second","patients","third",4861);
    }

    @Given("send the get request and get response")
    public void send_the_get_request_and_get_response() {
        response= given().headers("Authorization","Bearer"+ ConfigurationReader.getProperty("token"),
                "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).when().get(ConfigurationReader.getProperty("patient_endpoint"));
    }

    @Given("set the expected data")
    public void set_the_expected_data() {
        expectedData = new HashMap<>();
        expectedData.put("firstName","emir");
        expectedData.put("lastName","ihsan");
        expectedData.put("email","emir@gmail.com");

    }

    @Then("do validation")
    public void do_validation() {
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println(actualData.toString());
        Assert.assertEquals(expectedData.get("firstName"),actualData.get("firstName"));
        Assert.assertEquals(expectedData.get("lastName"),actualData.get("lastName"));
        Assert.assertEquals(expectedData.get("email"),actualData.get("email"));



    }




}
