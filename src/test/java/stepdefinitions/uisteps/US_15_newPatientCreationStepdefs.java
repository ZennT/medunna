package stepdefinitions.uisteps;


import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.PasswordSegmentPage;
import pages.RegistrationPage;
import pages.SignInPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US_15_newPatientCreationStepdefs {


    SignInPage signInPage = new SignInPage();
    Faker faker = new Faker();
    RegistrationPage rp = new RegistrationPage();//INITIALIZED WEBELEMENTS
    PasswordSegmentPage passwordSegmentPage = new PasswordSegmentPage();



    @Given("system is on the main page")
    public void system_is_on_the_log_in_page() {

        Driver.getDriver().get("https://medunna.com");

    }

    @Given("system clicks the logIn dropdown")
    public void system_clicks_the_log_in_dropdown() {
        Driver.wait(1);
        signInPage.logInDropdown.click();

    }

    @Given("system clicks on the first signInButton")
    public void system_clicks_on_the_first_sign_in_button() {
        Driver.wait(1);
        signInPage.sigIn.click();
    }

    @Given("system provides the userName as {string}")
    public void system_provides_the_user_name_as(String string) {
        Driver.wait(1);
        signInPage.username.sendKeys(string);

    }

    @Given("system provides the passWord as {string}")
    public void system_provides_the_pass_word_as(String string) {
        Driver.wait(1);
        signInPage.password.sendKeys(string);

    }

    @Given("system clicks on remember button")
    public void system_clicks_on_remember_button() {
        Driver.wait(1);
        signInPage.rememberMe.click();

    }

    @Given("system clicks on the second signInButton")
    public void system_clicks_on_the_second_sign_in_button() {
        Driver.wait(1);
        signInPage.signinButton.click();
//        ReusableMethods.getScreenshot("password changed");

    }

    @Given("system clicks on items&title button")
    public void system_clicks_on_items_title_button() {
        Driver.wait(1);
        signInPage.itemsTitleButton.click();

    }

    @Given("system clicks on patients")
    public void system_clicks_on_patients() {
        Driver.wait(2);
        signInPage.patients.click();


    }

    @Given("system clicks on create a new patient button")
    public void system_clicks_on_create_a_new_patient_button() {
        Driver.wait(2);
        signInPage.newpatientbutton.click();

    }

    @Given("system provides the new patient creation as {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void system_provides_the_new_patient_creation_as_and_and_and_and_and_and_and_and_and_and(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11) {
        signInPage.firstname.sendKeys("jisi");
        signInPage.lastname.sendKeys("jisi");
        signInPage.birthdate.sendKeys("05-27-1981");
        signInPage.email.sendKeys(faker.internet().emailAddress());
        signInPage.phone.sendKeys("1234567810");
        signInPage.gender.sendKeys("female");
        signInPage.blood.sendKeys("0-");
        signInPage.address.sendKeys("tall grass cres");
        signInPage.description.sendKeys("doon");
        signInPage.user.sendKeys("system");
        signInPage.country.sendKeys("canada");

    }

    @Given("system clicks on the save button")
    public void system_clicks_on_the_save_button() {
        Driver.wait(2);
        Driver.waitAndClick(signInPage.savebutton);
        Driver.wait(2);

    }


    @Given("system clicks on editLastCreated")
    public void system_clicks_on_edit_button() {
        Driver.wait(2);
        Driver.waitAndClick(signInPage.editLastCreated);

    }

    @Given("system finds on goToLastPageButton")
    public void system_clicks_on_go_to_last_page_button() {
        Driver.wait(2);
        Driver.waitAndClick(signInPage.goToLastPageButton);

    }

    @Given("system clicks the lastname for change")
    public void system_clicks_the_lastname_for_change() {
        Driver.wait(2);
        signInPage.lastname.click();
    }

    @Given("system changes the last name as {string}")
    public void system_changes_the_last_name_as(String lastname) {
        Driver.wait(2);
        Driver.waitAndSendText(signInPage.changelastname, "cikli");
    }

    @Given("system clicks on saveButton")
    public void system_clicks_on_save_button() {

        Driver.waitAndClick(signInPage.savebutton);
    }

    @Given("system clicking on lastPatient")
    public void system_clicking_on_found_patient() {
        Driver.waitAndClick(signInPage.foundPatient);


    }

    @Given("system clicks on deleteLastCreated")
    public void system_clicks_on_found_patient() throws IOException {
        Driver.wait(5);
        Driver.clickElementByJS(signInPage.deleteLastCreated);
        Driver.wait(5);
        signInPage.confirmDelete.click();
        Driver.wait(3);
        Assert.assertTrue(signInPage.deleteMessage.isDisplayed());
        Driver.wait(3);
       ReusableMethods.getScreenshot("patient deleted");
    }
}



