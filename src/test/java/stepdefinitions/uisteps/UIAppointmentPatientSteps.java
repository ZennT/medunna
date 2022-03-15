package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AppointmentPatientPage;
import pojos.AppointmentPatient;
import utilities.Driver;

//import static utilities.WriteToTxt.saveAppointData;

public class UIAppointmentPatientSteps {

    AppointmentPatientPage appointmentPatientPage = new AppointmentPatientPage();
    Faker faker = new Faker();
    AppointmentPatient appointmentPatient = new AppointmentPatient();


    @Given("user clicks on make an appointment")
    public void user_clicks_on_make_an_appointment() {

        Driver.waitAndClick(appointmentPatientPage.MakeAnAppointmentButton);


    }
    @Given("user provides the appointment name {string}")
    public void user_provides_the_appointment_name(String firstname) {
        firstname = faker.name().firstName();
        appointmentPatient.setFirstname(firstname);

        Driver.waitAndSendText(appointmentPatientPage.firstnameTextbox, firstname);

    }
    @Given("user provides the appointment lastname {string}")
    public void user_provides_the_appointment_lastname(String lastname) {
        lastname = faker.name().lastName();
        appointmentPatient.setLastname(lastname);
        Driver.waitAndSendText(appointmentPatientPage.lastnameTextbox, lastname);

    }
    @Given("user provides ssn and email {string} and {string}")
    public void user_provides_ssn_and_email_and(String ssn, String email) {
        ssn = faker.idNumber().ssnValid();
        email = faker.internet().emailAddress();
        appointmentPatient.setSsn(ssn);
        appointmentPatient.setEmail(email);


        Driver.waitAndSendText(appointmentPatientPage.ssnTextbox, ssn);
        Driver.waitAndSendText(appointmentPatientPage.emailTextbox, email);

    }
    @When("user provides the phone number {string}")
    public void user_provides_the_phone_number(String phoneNumber) {
//        phoneNumber = faker.phoneNumber().cellPhone();
//        appointment.setPhoneNumber(phoneNumber);

        Driver.waitAndSendText(appointmentPatientPage.phoneTextbox, phoneNumber);
    }
    //    @When("user provides the date {string}")
//    public void user_provides_the_date(String date) {
//        //05-04-2022
////      date = getDate();
//  //      appointment.setDate(date);
//
//        Driver.waitAndSendText(appointmentPage.dateTextbox, date);
//
//
//    }
    @Then("user requests appointment and verifies the success message")
    public void user_requests_appointment_and_verifies_the_success_message() {

        Driver.waitAndClick(appointmentPatientPage.requestButton);
        //saveAppointData(appointmentPatient);
        Assert.assertTrue(Driver.waitForVisibility(appointmentPatientPage.successMessageToastContainer, 5).isDisplayed());
    }


    @Then("user clicks on signin dropdown")
    public void user_clicks_on_signin_dropdown() {
        Driver.waitAndClick(appointmentPatientPage.signinDropdown);
    }

    @Then("user clicks on register button")
    public void user_clicks_on_register_button() {
        Driver.waitAndClick(appointmentPatientPage.registerButton);
        Driver.wait(3);
    }


    @Then("user enters ssn number as {string}")
    public void user_enters_ssn_number_as(String ssn) {
        ssn=appointmentPatient.getSsn();
        Driver.waitAndSendText(appointmentPatientPage.ssnTextbox,ssn);
    }

    @Then("user enters firstname as firstname as {string} and lastname as {string}")
    public void user_enters_firstname_as_firstname_as_and_lastname_as(String firstname, String lastname) {
        firstname = appointmentPatient.getFirstname();
        lastname = appointmentPatient.getLastname();
        Driver.waitAndSendText(appointmentPatientPage.firstnameTextbox,firstname);
        Driver.waitAndSendText(appointmentPatientPage.lastnameTextbox,lastname);
    }



    @Then("user enters username as {string}")
    public void user_enters_username(String username) {
        username = faker.name().username();
        appointmentPatient.setUsername(username);
        Driver.waitAndSendText(appointmentPatientPage.usernameTextbox,username);
    }
    @Then("user enters email as {string}")
    public void user_enters_email(String email) {
        Driver.wait(3);
        // email=appointment.getEmail();
        email = faker.internet().emailAddress();
        appointmentPatient.setEmail(email);
        Driver.waitAndSendText(appointmentPatientPage.emailTextbox,email);
    }
    @Then("user enters new passport as {string}")
    public void user_enters_new_passport(String password) {
        password = faker.internet().password(8,15, true, true);
        appointmentPatient.setPassword(password);
        Driver.waitAndSendText(appointmentPatientPage.newPasswordTextbox,password);
    }
    @Then("user confirms password as {string}")
    public void user_confirms_password(String password) {
        password = appointmentPatient.getPassword();
        Driver.waitAndSendText(appointmentPatientPage.confirmPasswordTextbox,password);
    }
    @Then("user clicks on register2 button")
    public void user_clicks_on_register2_button() {
        //   Driver.wait(1);
        Driver.waitAndClick(appointmentPatientPage.register2Button);
        Driver.wait(2);
    }

    @Then("user clicks on signin2 dropdown")
    public void user_clicks_on_signin2_dropdown() {
        Driver.waitAndClick(appointmentPatientPage.signinDropdown);

    }
    @Then("user clicks on Sign in button")
    public void user_clicks_on_sign_in_button() {
        Driver.waitAndClick(appointmentPatientPage.sign_inButton);
    }
    @Then("user enters username2 as {string}")
    public void user_enters_username2_as(String username) {
        username = appointmentPatient.getUsername();
        Driver.waitAndSendText(appointmentPatientPage.usernameTextbox, username);

    }
    @Then("user enters password2 as {string}")
    public void user_enters_password2_as(String password) {
        password = appointmentPatient.getPassword();
        Driver.waitAndSendText(appointmentPatientPage.passwordTextbox, password);

    }

    @Then("user clicks on Sign in2 button and verifies signin")
    public void user_clicks_on_Sign_in2_button_and_verifies_signin() {

        Driver.waitAndClick(appointmentPatientPage.signin2Button);
        //saveAppointData(appointment);
        Assert.assertTrue(Driver.waitForVisibility(appointmentPatientPage.signInConfirmation, 5).isDisplayed());
        Driver.wait(1);
        Driver.closeDriver();
    }

    @Given("user provides invalid ssn as {string}")
    public void user_provides_invalid_ssn_as(String ssn) {

        Driver.waitAndSendText(appointmentPatientPage.ssnTextbox, ssn);

    }
    @Given("user verifies the ssn error message")
    public void user_verifies_the_ssn_error_message() {
        appointmentPatientPage.ssnTextbox.sendKeys(Keys.ENTER);
        Driver.wait(2);
        Assert.assertTrue(Driver.waitForVisibility(appointmentPatientPage.invalidSsnMessage, 5).isDisplayed());
    }
    @Given("user provides invalid email as {string}")
    public void user_provides_invalid_email_as(String email) {
        Driver.waitAndSendText(appointmentPatientPage.emailTextbox, email);

    }
    @Given("user verifies the email error message")
    public void user_verifies_the_email_error_message() {
        appointmentPatientPage.emailTextbox.sendKeys(Keys.ENTER);
        Driver.wait(2);
        Assert.assertTrue(Driver.waitForVisibility(appointmentPatientPage.invalidEmailMessage, 5).isDisplayed());

    }

    @Given("user provides invalid phone number as {string}")
    public void user_provides_invalid_phone_number_as(String phoneNumber) {
        Driver.waitAndSendText(appointmentPatientPage.phoneTextbox, phoneNumber);


    }
    @Given("user verifies the phone number error message")
    public void user_verifies_the_phone_number_error_message() {
        appointmentPatientPage.phoneTextbox.sendKeys(Keys.ENTER);
        Driver.wait(2);
        Assert.assertTrue(Driver.waitForVisibility(appointmentPatientPage.invalidPhoneNumberMessage, 5).isDisplayed());

    }

    @Given("user keeps firstname blank and verifies error message")
    public void user_keeps_firstname_blank_and_verifies_error_message() {
        appointmentPatientPage.firstnameTextbox.sendKeys(Keys.ENTER);
        Driver.wait(1);
        Assert.assertTrue(Driver.waitForVisibility(appointmentPatientPage.blankFirstnameMessage, 5).isDisplayed());

    }
    @Given("user keeps lastname blank and verifies error message")
    public void user_keeps_lastname_blank_and_verifies_error_message() {
        appointmentPatientPage.lastnameTextbox.sendKeys(Keys.ENTER);
        Driver.wait(1);
        Assert.assertTrue(Driver.waitForVisibility(appointmentPatientPage.blankLastnameMessage, 5).isDisplayed());

    }
    @Given("user keeps ssn blank and verifies error message")
    public void user_keeps_ssn_blank_and_verifies_error_message() {
        appointmentPatientPage.ssnTextbox.sendKeys(Keys.ENTER);
        Driver.wait(1);
        Assert.assertTrue(Driver.waitForVisibility(appointmentPatientPage.blankSsnMessage, 5).isDisplayed());

    }
    @Given("user keeps email blank and verifies error message")
    public void user_keeps_email_blank_and_verifies_error_message() {
        appointmentPatientPage.emailTextbox.sendKeys(Keys.ENTER);
        Driver.wait(1);
        Assert.assertTrue(Driver.waitForVisibility(appointmentPatientPage.blankEmailMessage, 5).isDisplayed());

    }
    @Given("user keeps phonenumber blank and verifies error message")
    public void user_keeps_phonenumber_blank_and_verifies_error_message() {
        appointmentPatientPage.phoneTextbox.sendKeys(Keys.ENTER);
        Driver.wait(1);
        Assert.assertTrue(Driver.waitForVisibility(appointmentPatientPage.blankPhoneNumberMessage, 5).isDisplayed());

    }
}