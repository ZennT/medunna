package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DoctorRequestTestPage;
import utilities.Driver;

public class US12_DoctorRequestTestSteps {

    DoctorRequestTestPage doctorRequestTestPage = new DoctorRequestTestPage();



    @Given("doctor clicks on sign in dropdown")
    public void doctorClicksOnSignInDropdown() {

        Driver.waitAndClick(doctorRequestTestPage.loginButton);
    }

    @Then("doctor clicks on sign in")
    public void doctorClikcOnSignIn() {

        Driver.waitAndClick(doctorRequestTestPage.signInButton1);
    }

    @And("doctor provides username")
    public void doctorProvidesUsername() {
        String doctorUsername = "doctor79";
        Driver.waitAndSendText(doctorRequestTestPage.username, doctorUsername);
    }

    @And("doctor provides password")
    public void doctorProvidesPassword() {
        String doctorPassword = "doctor";

        Driver.waitAndSendText(doctorRequestTestPage.password, doctorPassword);
    }

    @Then("doctor clicks on  sign in button")
    public void doctorClicksOnSignInButton() {
        Driver.waitAndClick(doctorRequestTestPage.signInButton2);
    }

    @And("doctor clicks on MY PAGES dropdown")
    public void doctorClicksOnMYPAGESDropdown() {
        Driver.waitAndClick(doctorRequestTestPage.myPages);
    }

    @Then("doctor clicks on My Appointments")
    public void doctorClicksOnMyAppointments() {
        Driver.waitAndClick(doctorRequestTestPage.myAppointments);
    }

    @And("doctor clicks on Edit button of a patient")
    public void doctorClicksOnEditButtonOfAPatient() {
        Driver.waitAndClick(doctorRequestTestPage.editButton);
    }

    @And("doctor clicks on Request A Test button")
    public void doctorClicksOnRequestATestButton() {
        Driver.waitAndClick(doctorRequestTestPage.requestTestButton);
    }

    @And("doctor navigates to Test Items page and verifies the page")
    public void doctorNavigatesToTestItemsPageAndVerifiesThePage() {
        boolean text = doctorRequestTestPage.textOfTestItems.isDisplayed();
        Assert.assertTrue(text);
        String yazi = doctorRequestTestPage.textOfTestItems.getText();
        System.out.println(yazi);
    }

    @Then("doctor clicks on Urea checkbox to check")
    public void doctorClicksOnUreaCheckboxToCheck() {
        Driver.waitAndClick(doctorRequestTestPage.urea);
        Driver.wait(1);

    }

    @And("doctor clicks on Urea checkbox to uncheck")
    public void doctorClicksOnUreaCheckboxToUncheck() {
        Driver.waitAndClick(doctorRequestTestPage.urea);
        Driver.wait(1);

    }

    @Then("doctor clicks on Creatinine checkbox to check")
    public void doctorClicksOnCreatinineCheckboxToCheck() {
        Driver.waitAndClick(doctorRequestTestPage.creatinine);
        Driver.wait(1);

    }

    @And("doctor clicks on Creatinine checkbox to uncheck")
    public void doctorClicksOnCreatinineCheckboxToUncheck() {
        Driver.waitAndClick(doctorRequestTestPage.creatinine);
        Driver.wait(1);
    }

    @Then("doctor clicks on Sodium checkbox to check")
    public void doctorClicksOnSodiumCheckboxToCheck() {
        Driver.waitAndClick(doctorRequestTestPage.sodium);
        Driver.wait(1);
    }

    @And("doctor clicks on Sodium checkbox to uncheck")
    public void doctorClicksOnSodiumCheckboxToUncheck() {
        Driver.waitAndClick(doctorRequestTestPage.sodium);
        Driver.wait(1);
    }

    @Then("doctor clicks on Potassium checkbox to check")
    public void doctorClicksOnPotassiumCheckboxToCheck() {
        Driver.waitAndClick(doctorRequestTestPage.potassium);
        Driver.wait(1);
    }

    @And("doctor clicks on Potassium checkbox to uncheck")
    public void doctorClicksOnPotassiumCheckboxToUncheck() {
        Driver.waitAndClick(doctorRequestTestPage.potassium);
        Driver.wait(1);
    }

    @Then("doctor clicks on Total protein checkbox to check")
    public void doctorClicksOnTotalProteinCheckboxToCheck() {
        Driver.waitAndClick(doctorRequestTestPage.totalProtein);
        Driver.wait(1);
    }

    @And("doctor clicks on Total protein checkbox to uncheck")
    public void doctorClicksOnTotalProteinCheckboxToUncheck() {
        Driver.waitAndClick(doctorRequestTestPage.totalProtein);
        Driver.wait(1);
    }

    @Then("doctor clicks on Albumin checkbox to check")
    public void doctorClicksOnAlbuminCheckboxToCheck() {
        Driver.waitAndClick(doctorRequestTestPage.albumin);
        Driver.wait(1);
    }

    @And("doctor clicks on Albumin checkbox to uncheck")
    public void doctorClicksOnAlbuminCheckboxToUncheck() {
        Driver.waitAndClick(doctorRequestTestPage.albumin);
        Driver.wait(1);
    }

    @Then("doctor clicks on Hemoglobin checkbox to check")
    public void doctorClicksOnHemoglobinCheckboxToCheck() {
        Driver.waitAndClick(doctorRequestTestPage.hemoglobin);
        Driver.wait(1);
    }

    @And("doctor clicks on Hemoglobin checkbox to uncheck")
    public void doctorClicksOnHemoglobinCheckboxToUncheck() {
        Driver.waitAndClick(doctorRequestTestPage.hemoglobin);
        Driver.wait(1);
    }

}
