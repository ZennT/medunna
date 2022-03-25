package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigurationReader;
import utilities.Driver;

import static utilities.DatabaseUtility.createConnection;

public class Hooks {
    @Before
    public void setUp(){


    }

    //
    public static RequestSpecification spec;

    @Before( value = "@ApiRegistrant")
    public void setup(){

        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();


    }


    @Before(order = 1, value = "@UIRegistration")
    public void navigateToRegistrationPage(){

        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_registration_url"));

    }

    @Before( value = "@EndToEnd")
    public void createNewDBConnection(){

        createConnection(ConfigurationReader.getProperty("db_credentials_url"),
                ConfigurationReader.getProperty("db_username"),
                ConfigurationReader.getProperty("db_password"));

    }


    @Before(order = 1, value = "@Appointment")
    public void navigateToLandingPage(){

        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_registration_url"));

    }

    @Before(value = "@UIAppointment")
    public void navigateToAppointmentPage(){

        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));

    }

    @Before(value = "@UIHome")
    public void navigateToHomePage(){

        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));

    }
    @Before(order = 1, value = "@UILogin")
    public void navigateToLoginPage(){


        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));

    }

    @Before( value = "@TestItemApi")
    public void postTestItemSetup(){
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
    }

    @Before( value = "@US_15_Api_test")
    public void setuppatient(){

        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();


    }



































    @Before(order = 1, value = "@UILoginStaff")
    public void navigateToLoginPageStaff(){
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));

    }

    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()) {
            final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png","screenshots");
        }





//        Driver.closeDriver
    }

















}

