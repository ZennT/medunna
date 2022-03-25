package stepdefinitions.apisteps;

import pojos.NewPatientCreation;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigurationReader;

import java.io.IOException;
import java.util.List;

import static Hooks.Hooks.spec;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;
import static utilities.ReadTxt.getPatients;
import static utilities.ReadTxt.getPatientsNames;
import static utilities.WriteToTxt.savePatientData;


public class US15_PatientTestStepDefs {

    Response response;

    NewPatientCreation newPatientCreation = new NewPatientCreation();
    Faker faker = new Faker();
    NewPatientCreation [] patientCreations;


    @Given("user provides the necessary path params")
    public void user_provides_the_necessary_path_params() {
        spec.pathParams("first", "api", "second", "patients");
    }


    @And("user sets the expected data")
    public void userSetsTheExpectedData() {
        NewPatientCreation expectedData = new NewPatientCreation("jisi","jisi","1981-05-27","darcel.considine@yahoo.com",
                "123-456-7810","FEMALE","Apositive","tall grass cres","doon");
    }


    @Given("user sending the GET request and gets the response")
    public void user_sending_the_get_request_and_gets_the_response() {
        response = getRequest(generateToken(), ConfigurationReader.getProperty("patient_endpoint"));

    }

    @When("user saving the api records to correspondent files")
    public void user_saving_the_api_records_to_correspondent_files() throws IOException {
        response.then().statusCode(200);
        response.prettyPrint();
//       deserialization
        ObjectMapper obj = new ObjectMapper();
        patientCreations = obj.readValue(response.asString(),NewPatientCreation[].class);
        //        saving data
        savePatientData(patientCreations);

    }

    @Then("user validating api records")
    public void user_validating_api_records() {
        List<String> expectedData = getPatients();

        //System.out.println("expected:"+ expectedData);
        List<String> actualTestItems = getPatientsNames();
        //System.out.println("actual: "+actualTestItems);
        Assert.assertTrue(actualTestItems.containsAll(expectedData));

    }


}
