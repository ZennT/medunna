package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.US06_UserSettingPage;
import pages.US10_ValidateAppointmentPage;
import pojos.TimeSlots;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US10_ValidateAppointmentStepDefs {
    US10_ValidateAppointmentPage validateAppointmentPage=new US10_ValidateAppointmentPage();
    TimeSlots timeSlots=new TimeSlots();
    US06_UserSettingPage userSettingPage = new US06_UserSettingPage();

    @Given("doctor go to on the Medunna Sign in  Page")
    public void doctor_go_to_on_the_medunna_sign_in_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
        Driver.waitAndClick(userSettingPage.accountMenu);
        Driver.waitAndClick(userSettingPage.signIn);
    }

    @Given("doctor provides username")
    public void doctor_provides_username() {
        Driver.waitAndSendText(validateAppointmentPage.username,"doctor79");
        Driver.wait(2);
    }

    @Given("doctor provides password")
    public void doctor_provides_password() {
        Driver.waitAndSendText(validateAppointmentPage.password, "doctor");
    }

    @Given("doctor clicks sign in button")
    public void doctor_clicks_sign_in_button() {
        Driver.waitAndClick(validateAppointmentPage.signInButton);
    }

    @Given("doctor clicks MY PAGES")
    public void doctor_clicks_my_pages() {
        Driver.waitAndClick(validateAppointmentPage.mypages);
    }

    @Given("doctor clicks My Appointments")
    public void doctor_clicks_my_appointments() {
        Driver.waitAndClick(validateAppointmentPage.myappointments);
    }
    @Given("doctor needs to be in Appointments page")
    public void doctor_needs_to_be_in_appointments_page() {
        Driver.waitForVisibility(validateAppointmentPage.Heading,1);
        Assert.assertTrue(validateAppointmentPage.Heading.isDisplayed());
    }


    @And("doctor selects Appointment date from datefrom and dateto")
    public void doctorSelectsAppointmentDateFromDatefromAndDateto() {
        Assert.assertTrue(Driver.waitForVisibility(validateAppointmentPage.fromDate,1).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(validateAppointmentPage.toDate,1).isDisplayed());

    }
    @Given("doctor should see appointment details")
    public void doctor_should_see_appointment_details() {
        for(WebElement x : validateAppointmentPage.appoinmentlist){
            //System.out.println(x.getText());
            Assert.assertTrue(x.isDisplayed());
        }


  }




}
