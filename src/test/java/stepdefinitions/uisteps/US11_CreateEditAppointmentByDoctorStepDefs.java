package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.DoctorPage;
import pages.SignInPage;
import pages.US10_ValidateAppointmentPage;
import pages.US11_CreateEditAppointmentByDoctor;
import utilities.Driver;

import javax.swing.*;

public class US11_CreateEditAppointmentByDoctorStepDefs {


    SignInPage signInPage = new SignInPage();
    DoctorPage doctorPage = new DoctorPage();
    US11_CreateEditAppointmentByDoctor createEditAppointmentByDoctor = new US11_CreateEditAppointmentByDoctor();
    Actions action = new Actions(Driver.getDriver());

    @And("user provides  doctor username")
    public void userProvidesDoctorUsername() {
        String doctorUsername = "doctor79";
        Driver.waitAndSendText(signInPage.username, doctorUsername);
    }

    @And("user provides doctor password")
    public void userProvidesDoctorPassword() {
        String doctorPassword = "doctor";
        Driver.waitAndSendText(signInPage.password, doctorPassword);
    }

    @And("user clicks on the sign in button")
    public void userClicksOnTheSignInButton() {

        Driver.waitAndClick(signInPage.loginButton);
    }

    @And("Doctor navigates to My Pages segment")
    public void doctorNavigatesToMyPagesSegment() {

        Driver.waitAndClick(doctorPage.myPagesDropDown);
    }

    @And("Doctor clicks on My appointments")
    public void doctorClicksOnMyAppointments() {
        Driver.waitAndClick(doctorPage.myAppointments);
    }

    @And("Doctor clicks on Edit button")
    public void doctorClicksOnEditButton() {
        Driver.waitAndClick(doctorPage.edit1);
    }

    @And("Doctor verifies patient's info id, start and end date, status, physician and patient are present")
    public void doctorVerifiesPatientSInfoIdStartAndEndDateStatusPhysicianAndPatientArePresent() {

        /*
    ID 28371
    StartDateTime 03/15/2022 12:00 AM
    EndDateTime   03/16/2022 12:00 AM
    Status COMPLETED
    Physician  10512:doctor79 su :ALLERGY IMMUNOLOGY
    Patient :ali can
     */

//        Driver.wait(1);
        Assert.assertTrue(createEditAppointmentByDoctor.idField.isDisplayed());
//        Driver.wait(1);
        Assert.assertTrue(createEditAppointmentByDoctor.startDateTime.isDisplayed());
//        Driver.wait(1);
        Assert.assertTrue(createEditAppointmentByDoctor.endDateTime.isDisplayed());
//        Driver.wait(1);
        Assert.assertTrue(createEditAppointmentByDoctor.physicianField.isDisplayed());
//        Driver.wait(1);
        Assert.assertTrue(createEditAppointmentByDoctor.patientField.isDisplayed());

    }


    @And("Doctor fills in required fields, anemnesis, treatment, diagnosis")
    public void doctorFillsInRequiredFieldsAnemnesisTreatmentDiagnosis() {
        createEditAppointmentByDoctor.anamnesisField.clear();
        Driver.waitAndSendText(createEditAppointmentByDoctor.anamnesisField,"this is a test ");
        createEditAppointmentByDoctor.treatmentField.clear();
        Driver.waitAndSendText(createEditAppointmentByDoctor.treatmentField,"this is a test");
        createEditAppointmentByDoctor.diagnosisField.clear();
        Driver.waitAndSendText(createEditAppointmentByDoctor.diagnosisField,"this is a test");

    }

    @Then("Doctor clicks on Save button")
    public void doctorClicksOnSaveButton() {
        Driver.waitAndClick(createEditAppointmentByDoctor.saveButton);
    }

    @Then("Doctor verifies appointment saved successfully")
    public void doctorVerifiesAppointmentSavedSuccessfully() {
        Driver.wait(2);
        Assert.assertTrue(createEditAppointmentByDoctor.appointmentSavedMessage.isDisplayed());
    }

    @And("doctor selects appointment date from datefrom and dateto")
    public void doctorSelectsAppointmentDateFromDatefromAndDateto() {
        Driver.waitAndSendText(doctorPage.fromDate,"03-10-2022");
        Driver.waitAndSendText(doctorPage.toDate, "03-23-2022");

    }

    @And("Doctor fills in optional fields precription and description")
    public void doctorFillsInOptionalFieldsPrecriptionAndDescription() {
        doctorPage.prescriptionField.clear();
        Driver.waitAndSendText(doctorPage.prescriptionField,"this is a test");
        doctorPage.descriptionField.clear();
        Driver.waitAndSendText(doctorPage.descriptionField,"this is a test");
    }


    @And("Doctor verifies this field is required")
    public void doctorVerifiesThisFieldIsRequired() {
        Assert.assertTrue(doctorPage.fieldRequiredText.isDisplayed());
    }

    @And("Doctor leaves treatment field blank")
    public void doctorLeavesTreatmentFieldBlank() {
        Driver.waitAndClick(createEditAppointmentByDoctor.treatmentField);
        createEditAppointmentByDoctor.treatmentField.clear();
        Driver.wait(1);

    }

    @And("Doctor leaves anamnesis field blank")
    public void doctorLeavesAnamnesisFieldBlank() {
        Driver.waitAndClick(createEditAppointmentByDoctor.anamnesisField);
        createEditAppointmentByDoctor.anamnesisField.clear();
        createEditAppointmentByDoctor.anamnesisField.sendKeys(""+ Keys.TAB);
        Driver.waitAndClick(createEditAppointmentByDoctor.saveButton);

    }

    @And("Doctor leaves diagnosis field blank")
    public void doctorLeavesDiagnosisFieldBlank() {
        Driver.waitAndClick(createEditAppointmentByDoctor.diagnosisField);
        createEditAppointmentByDoctor.diagnosisField.clear();
        createEditAppointmentByDoctor.diagnosisField.sendKeys(""+Keys.TAB);
    }

    @Then("Doctor clicks on Sign out button")
    public void doctorClicksOnSignOutButton() {
        Driver.wait(2);
        Driver.waitAndClick(signInPage.loginDropdown);
        Driver.waitAndClick(doctorPage.signOut);
        Driver.wait(2);
    }


}
