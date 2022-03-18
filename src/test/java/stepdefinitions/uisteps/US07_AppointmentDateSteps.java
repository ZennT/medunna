package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.US07_AppointmentDatePage;
import utilities.Driver;

import static utilities.DateUtils.getDate;

public class US07_AppointmentDateSteps {

    US07_AppointmentDatePage appointmentDatePage = new US07_AppointmentDatePage();

    @Given("user sees and verifies Appointment DateTime text")
    public void user_sees_and_verifies_appointment_date_time_text() {

        String actualText = appointmentDatePage.date_time_text.getText();

        Assert.assertEquals("Appointment DateTime", actualText);


    }

    @And("user sends the current date")
    public void userSendsTheCurrentDate() throws InterruptedException {


        appointmentDatePage.dateTextbox.sendKeys("03-17-2022" + Keys.ENTER);
        Driver.wait(1);
        appointmentDatePage.dateTextbox.clear();

    }

    @Given("user sends a valid date")
    public void user_sends_a_valid_date() {

        appointmentDatePage.dateTextbox.sendKeys("05-11-2022" + Keys.ENTER);

        appointmentDatePage.dateTextbox.clear();

    }
    @Then("user verifies the date as mm-day-year")
    public void userVerifiesTheDateAsMmDayYear() throws InterruptedException {

        appointmentDatePage.dateTextbox.sendKeys("14-01-2021" + Keys.ENTER);

        String errorMessage = appointmentDatePage.pastDateText.getText();

        Assert.assertTrue(errorMessage.contains("Appointment date"));
    }


}
