package stepdefinitions.apisteps;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import org.junit.Assert;
import pages.DoctorAppointment;
import utilities.ConfigurationReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;
import static utilities.ReadTxt.*;
import static utilities.WriteToTxt.saveApiAppointment;

public class US10_ValidateAppointmentApiStepDefs {
    DoctorAppointment doctorAppointment=new DoctorAppointment();
    DoctorAppointment[] doctorAppointments;
    Response response;
    //static DoctorAppointment expectedData;
    @When("Doctor set Medunna base url")
    public void doctor_set_medunna_base_url() {
        //URL: https://medunna.com/api/appointments
        spec.pathParams("first","api","second","appointments");
    }
    @When("Doctor send the GET request and GET the response")
    public void doctor_send_the_get_request_and_get_the_response() {
        response = given().headers(
                "Authorization",
                "Bearer " + generateToken(),
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().get(ConfigurationReader.getProperty("api_appointments_endpoint"));
        response.prettyPrint();
    }
    @And("Doctor deserialize data json to java")
    public void doctorDeserializeDataJsonToJava() throws IOException {
        response.then().statusCode(200);
        ObjectMapper objectMapper=new ObjectMapper();
        doctorAppointments =objectMapper.readValue(response.asString(),DoctorAppointment[].class);

    }
    @And("Doctor saves the patient data to correspondent files")
    public void doctorSavesThePatientDataToCorrespondentFiles() {
        saveApiAppointment(doctorAppointment);


    }

    @And("Doctor validates expected data with API")
    public void doctorValidatesExpectedDataWithAPI() {
        List<String> expectedData = getDoctorAppointment_1();
        //System.out.println("expected:"+ expectedData);
        List<String> actualTestItems = getDoctorAppointment_2();
        //System.out.println("actual: "+actualTestItems);
        Assert.assertTrue(actualTestItems.containsAll(expectedData));

 //WITHOUT SAVING TO TEXT FILE:
//               "id": 38181,
//                "startDate": "2022-04-23T00:00:00Z",
//              "endDate": "2022-04-23T01:00:00Z",
//                "status": "COMPLETED",
//        expectedData=new DoctorAppointment("38181","2022-04-23T00:00:00Z","2022-04-23T01:00:00Z","COMPLETED");
//
    }


}
