package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.StaffPage;
import pages.US06_UserSettingPage;
import utilities.ConfigurationReader;
import utilities.Driver;
public class US22_PatientTestResultsbyStaffStepDefs {
        StaffPage staffPage=new StaffPage();
        US06_UserSettingPage userSettingPage=new US06_UserSettingPage();
        @Given("staff is on the Medunna Sign in  Page")
        public void staff_is_on_the_medunna_sign_in_page() {
            Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
            Driver.waitAndClick(userSettingPage.accountMenu);
            Driver.waitAndClick(userSettingPage.signIn);
        }
        @Given("staff enters username {string}")
        public void staff_enters_username(String username) {
            Driver.waitAndSendText(userSettingPage.username, username);
            Driver.wait(2);
        }
        @Given("staff enters password  {string}")
        public void staff_enters_password(String password) {
            Driver.waitAndSendText(userSettingPage.password, password);
            Driver.wait(2);
        }
        @Given("staff clicks sign in button")
        public void staff_clicks_sign_in_button() {
            Driver.waitAndClick(userSettingPage.signInButton);
            Driver.wait(2);
        }
        @Given("staff clicks MY PAGES dropdown")
        public void staff_clicks_my_pages_dropdown() {
            Driver.waitAndClick(staffPage.mypages);
            Driver.wait(2);
        }
        @Given("staff clicks on Search Patient")
        public void staff_clicks_on_search_patient() {
            Driver.waitAndClick(staffPage.searchpatient);
            Driver.wait(2);
        }
        @Given("staff clicks on Patient SSN text box")
        public void staff_clicks_on_patient_ssn_text_box() {
            Driver.waitAndClick(staffPage.ssntextbox);
        }
        @And("staff enters patient SSN")
        public void staffEntersPatientSSN() {
            Driver.wait(5);
            staffPage.ssntextbox.sendKeys("199-59-9895");
            Driver.wait(5);
        }
        @And("staff verifies visibility of patients information")
        public void staffVerifiesVisibilityOfPatientsInformation() {
            Driver.wait(3);
            Assert.assertTrue(Driver.waitForVisibility(staffPage.firstpatientinfo,2).isDisplayed());
            Driver.wait(5);
        }
        @And("staff  navigates to Show Appointments")
        public void staffNavigatesToShowAppointments() {
            Driver.wait(9);
            Driver.waitAndClick(staffPage.showappointment);
        }
        @And("staff clicks on Show Test and views result test")
        public void staffClicksOnShowTestAndViewsResultTest() {
            Driver.wait(5);
            Driver.waitAndClick(staffPage.showtest);
            Driver.waitAndClick(staffPage.viewResultsButton);
            Driver.wait(6);
        }
        @And("staff edit patients test result and test description")
        public void staffEditPatientsTestResultAndTestDescription() {
            Driver.wait(6);
            Driver.waitAndClick(staffPage.editButton);
            Driver.wait(2);
            staffPage.resultTextBox.clear();
            Driver.waitAndSendText(staffPage.resultTextBox,"70");
            Driver.wait(2);
            staffPage.descriptionTextBox.clear();
            Driver.waitAndSendText(staffPage.descriptionTextBox,"NORMAL");
        }
        @Then("staff saves the changes")
        public void staffSavesTheChanges() {
            Driver.waitAndClick(staffPage.editSaveButton);
        }
        @Then("staff verifies success message")
        public void staffVerifiesSuccessMessage() {
            Driver.wait(3);
            Assert.assertTrue(staffPage.editSuccessToastContainer.isDisplayed());
        }
        @Then("staff should view or update the test  in Test Result page")
        public void staffShouldViewOrUpdateTheTestInTestResultPage()  {
            Assert.assertTrue(staffPage.testresultheading.isDisplayed());
            for (WebElement x : staffPage.testresultlist) {
                System.out.println(x.getText());
                Assert.assertTrue(x.isDisplayed());
            }
        }
        @Then("staff clicks on sign out button")
        public void staffClicksOnSignOutButton() {
            Driver.wait(4);
            Driver.waitAndClick(staffPage.accountMenu);
            Driver.waitAndClick(staffPage.signOutButton);

        }
}
