package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DoctorPage;
import pages.SignInPage;
import utilities.Driver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class US013_RequestTestResultAndInpatientByDoctorStepDefs {

    DoctorPage doctorPage = new DoctorPage();
    SignInPage signInPage= new SignInPage();


    @And("user clicks on sign in dropdown")
    public void userClicksOnSignInDropdown() {
        Driver.waitAndClick(signInPage.signDropdown);
    }

    @And("Doctor clicks on sign in button")
    public void Doctor_clicks_on_sign_button() {
     Driver.waitAndClick(signInPage.loginDropdown);

    }

    @Given("Doctor provide valid {string} and {string}")
    public void doctor_provide_valid_and(String username, String password) {
//        signInPage.username.sendKeys(username);
//        signInPage.password.sendKeys(password);
        Driver.waitAndSendText(signInPage.username,username);
        Driver.waitAndSendText(signInPage.password,password);
    }


    @And("Doctor clicks on My Pages dropdown")
    public void doctorClicksOnMyPagesDropdown() {
        Driver.waitAndClick(doctorPage.myPagesDropDown);
      //  doctorPage.myPagesDropDown.click();
    }

    @And("Doctor clicks on My Appointments")
    public void doctorClicksOnMyAppointments() {
        Driver.waitAndClick(doctorPage.myAppointments);
        Driver.wait(2);
    }

    @And("doctor selects appointment date from {string} and {string}")
    public void doctorSelectsAppointmentDateFromAnd(String dateFrom, String dateTo) {
        Driver.waitAndSendText(doctorPage.toDate, dateTo);
        Driver.waitAndSendText(doctorPage.fromDate, dateFrom);
        Driver.wait(3);

        // From sending direct data
//        Driver.waitAndSendText(doctorPage.fromDate,"03-10-2022");  //03-05-2022
//        Driver.waitAndSendText(doctorPage.toDate, "03-23-2022");   //03-15-2022
    }

    @And("Doctor clicks on Edit button for patient")
    public void doctorClicksOnEditButtonForPatient() {
        Driver.wait(3);
        Driver.waitAndClick(doctorPage.edit2);
      //  Driver.wait(3);
    }

    @And("Doctor clicks on Show Test Result button")
    public void doctorClicksOnShowTestResultButton() {
       Driver.wait(3);
      //  doctorPage.showTestResult.sendKeys(Keys.PAGE_UP);
        Driver.waitAndClick(doctorPage.showTestResult);
        Driver.wait(3);
    }



    @Then("Doctor clicks on View Result button")
    public void doctorClicksOnViewResultButton() {
        Driver.waitAndClick(doctorPage.viewResult1);
        Driver.wait(3);

    }



    @Then("Doctor should see and verify all test information")
    public void doctorShouldSeeAndVerifyAllTestInformation() throws IOException {

        List<String > expected_list= Arrays.asList("ID Name Result Default Min. Value Default Max. Value Test Description Date");
        List<String> actual_list= new ArrayList<>();
        for(WebElement x: doctorPage.viewTestResultHeaderList) {
            actual_list.add(x.getText());
        }
        assertEquals(expected_list,actual_list);
        System.out.println(expected_list); }

    @And("Doctor clicks on Request Inpatient button")
    public void doctorClicksOnRequestInpatientButton() {
        Driver.wait(3);
        Driver.waitAndClick(doctorPage.requestInpatient);

    }

    @Then("Doctor Verifies message {string}")
    public void doctorVerifiesMessage(String message) {
        Driver.wait(3);
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.requestAlreadyDoneMessageToastContainer,2).isDisplayed());
    }

    @Then("Doctor clicks on Sign out button")
    public void doctorClicksOnSignOutButton() {
        Driver.wait(1);
        Driver.waitAndClick(signInPage.loginDropdown);
        Driver.waitAndClick(doctorPage.signOut);
        Driver.wait(1);
    }



}
