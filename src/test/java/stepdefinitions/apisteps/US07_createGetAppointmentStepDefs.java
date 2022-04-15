package stepdefinitions.apisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Appointment;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;

import static utilities.WriteToTxt.saveAppointData;

public class US07_createGetAppointmentStepDefs {
    Response response;
    Faker faker = new Faker();

    Appointment appointment = new Appointment();
  //  Appointment appointments[];

    @Given("user sets the base url")
    public void userSetsTheBaseUrl() {

        spec.pathParams("first", "api", "second", "appointments","third","request");
    }

    @When("user sets the expected appointment data")
    public void userSetsTheExpectedAppointmentData() {

    appointment.setFirstname("Cori");
    appointment.setLastname("Beer");
    appointment.setEmail("patient3@qa.team");
    appointment.setSsn("888-88-8766");
    appointment.setPhoneNumber("1111111111");
    appointment.setDate("2022-06-01");


}

    @And("user creates post request for appointment")
    public void userCreatesPostRequestForAppointment() {
        response = given().spec(spec).contentType(ContentType.JSON).body(appointment).when().post("/{first}/{second}/{third}");

    }

    @And("user saves appointment data to correspondent file")
    public void userSavesAppointmentDataToCorrespondentFile() {

        saveAppointData(appointment);
    }

    @Then("user validates appointment data")
    public void userValidatesAppointmentData() {
        response.then().statusCode(201);
        response.prettyPrint();
        //Appointment  actualData = obj.readValue(response.asString(), Appointment.class);





    }
}
