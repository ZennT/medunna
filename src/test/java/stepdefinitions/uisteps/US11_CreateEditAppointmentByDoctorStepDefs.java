package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DoctorPage;
import pages.SignInPage;
import pages.US11_CreateEditAppointmentByDoctor;
import utilities.Driver;

public class US11_CreateEditAppointmentByDoctorStepDefs {
    SignInPage signInPage = new SignInPage();
    DoctorPage doctorPage = new DoctorPage();
    US11_CreateEditAppointmentByDoctor createEditAppointmentByDoctor = new US11_CreateEditAppointmentByDoctor();

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

        Assert.assertTrue(createEditAppointmentByDoctor.idField.isDisplayed());

    }

    @And("Doctor selects status as Pending from dropdown")
    public void doctorSelectsStatusAsPendingFromDropdown() {
    }

    @And("Doctor fills in required fields, anemnesis, treatment, diagnosis")
    public void doctorFillsInRequiredFieldsAnemnesisTreatmentDiagnosis() {
    }

    @Then("Doctor clicks on Save button")
    public void doctorClicksOnSaveButton() {
    }
}
