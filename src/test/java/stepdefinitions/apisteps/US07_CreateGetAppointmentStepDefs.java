package stepdefinitions.apisteps;

import baseUrl.Medunna;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.AppointmentCase07;
import utilities.ConfigurationReader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static utilities.ApiUtils.postRequestAppointment;
import static utilities.Authentication.generateToken;

public class US07_CreateGetAppointmentStepDefs extends Medunna {

    AppointmentCase07 app = new AppointmentCase07();
    Faker faker = new Faker();


    @Given("user sets the base url")
    public void userSetsTheBaseUrl() {
        spec.pathParams("first", "api","second","appointments","third","request");

    }

    @When("user sets the expected appointment data")
    public void userSetsTheExpectedAppointmentData() {
        app.setCreatedBy("admin79");
        app.setFirstName(faker.name().firstName());
        app.setLastName(faker.name().lastName());
        app.seteMail(faker.internet().emailAddress());
        app.setSsn("179-22-" + faker.number().digits(4));
        app.setStartDate("2022-06-01");
        app.setPhone("333-333-" + faker.number().digits(4));

//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.of(2022,04,05,20,50);
//        System.out.println(dtf.format(now));

    }

    @And("user creates post request for appointment")
    public void userCreatesPostRequestForAppointment() {

        Response response = given().spec(spec).contentType(ContentType.JSON).body(app).when().post("/{first}/{second}/{third}");


//        Response response1 = postRequestAppointment(generateToken(), ConfigurationReader.getProperty("appointment_endpoint"), app);
        response.prettyPrint();

//        Response response3 = given().spec(spec).headers("Authorization", "Bearer " +generateToken(),
//                "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).body(app).when().post("/{first}/{second}");
//        //OPTIONAL ....when().post(ConfigurationReader.getProperty("api_rooms_endpoint"));
//        response3.prettyPrint();

    }

    @And("user saves appointment data to the corresponding file")
    public void userSavesAppointmentDataToTheCorrespondingFile() {
    }

    @Then("user validates appointment data")
    public void userValidatesAppointmentData() {
    }
}
