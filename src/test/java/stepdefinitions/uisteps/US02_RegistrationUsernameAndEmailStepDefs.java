package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.RegistrationPage;
import pages.SignInPage;
import pojos.Registrant;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import static utilities.WriteToTxt.saveRegistrantData;

public class US02_RegistrationUsernameAndEmailStepDefs {

    Registrant registrant = new Registrant();
    Faker faker = new Faker();
    RegistrationPage registrationPage = new RegistrationPage();
    SignInPage signInPage = new SignInPage();



    @Given("user is on homepage")
    public void userIsOnHomepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }


    @And("user clicks on sign in register dropdown")
    public void userClicksOnSignInRegisterDropdown() {
       Driver.waitAndClick(signInPage.loginDropdown);
    }

    @And("user clicks on Register button")
    public void userClicksOnRegisterButton() {
        Driver.waitAndClick(signInPage.registerButton);

    }

    @And("user is on registration page and verifies")
    public void userIsOnRegistrationPageAndVerifies() {
        registrationPage.registrationText.isDisplayed();

    }


    @Given("user provides ssn {string}")
    public void user_provides_ssn_id(String ssn) {
        ssn = faker.idNumber().ssnValid();
        registrant.setSsn(ssn);
        Driver.waitAndSendText(registrationPage.ssnTextbox,ssn);

    }
    @Then("user provides firstname and lastname {string} and {string}")
    public void user_provides_firstname_and_lastname_and(String firstname, String lastname) {
        firstname =faker.name().firstName();
        lastname = faker.name().lastName();

        registrant.setFirstName(firstname);
        registrant.setLastName(lastname);
        Driver.waitAndSendText(registrationPage.firstNameTextBox,firstname);
        Driver.waitAndSendText(registrationPage.lastNameTextBox,lastname);

    }
    @Then("user provides username {string}")
    public void user_creates_username(String username) {
        username=faker.name().username();
        registrant.setUserName(username);
        Driver.waitAndSendText(registrationPage.usernameTextBox,username);
    }
    @Then("user provides email {string}")
    public void user_provides_also_email(String email) {
        email =faker.internet().emailAddress();
        registrant.setUserName(email);
        Driver.waitAndSendText(registrationPage.emailTextBox,email);


    }
    @Then("user provides {string}")
    public void user_generates_the_password(String password) {
      password =faker.internet().password(8,20,true,true);
        registrant.setPassword(password);

      Driver.waitAndSendText(registrationPage.newPasswordTextBox, password);
      Driver.waitAndSendText(registrationPage.newPasswordConfirmRequiredText,password);
    }
    @Then("user registers and validates")
    public void user_registers_and_validates() {
        Driver.waitAndClick(registrationPage.registerButton);
        Assert.assertTrue(Driver.waitForVisibility(registrationPage.successMessageToastContainer,2).isDisplayed());
    }

    @Then("user creates the records to a correspondent file")
    public void user_creates_the_records_to_a_correspondent_file() {

        saveRegistrantData(registrant);
    }







    @Given("user provides space in username")
    public void userProvidesSpaceInUsername() {
        registrationPage.usernameTextBox.sendKeys("molly-19 me");
        registrationPage.usernameTextBox.sendKeys(Keys.ENTER);
}

    @And("user should see Your username is invalid. text visible and verifies")
    public void userShouldSeeYourUsernameIsInvalidTextVisibleAndVerifies() {
        Assert.assertTrue(registrationPage.invalidUserNametext.isDisplayed());
    }



    @Then("capture the screenshot")
    public void capture_the_screenshot() throws IOException {
        ReusableMethods.getScreenshot("ScreenShoots");
    }

    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }


    @When("user provides characters in username {string}")
    public void userProvidesInvalidCharactersInUsername(String username) {
        Driver.waitAndSendText(registrationPage.usernameTextBox, username);
        registrationPage.usernameTextBox.sendKeys(Keys.ENTER);
    }



    @And("user leaves blank for username of the applicant")
    public void userLeavesBlankForUsernameOfTheApplicant() {
        registrationPage.usernameTextBox.sendKeys(" ");
        registrationPage.usernameTextBox.sendKeys(Keys.ENTER);
    }

    @And("verifies Your username is required. text visible")
    public void verifiesYourUsernameIsRequiredTextVisible() {
        Assert.assertTrue(registrationPage.requiredUserNameText.isDisplayed());

    }

    @Given("user provides invalid {string} and click enter")
    public void userProvidesInvalidAndClickEnter(String emailAddress) throws IOException {
        registrant.setEmail(emailAddress);
        Driver.waitAndSendText(registrationPage.emailTextBox, emailAddress);
        //   registrationPage.emailTextbox.sendKeys(emailAddress);
        registrationPage.emailTextBox.sendKeys(Keys.ENTER);
        ReusableMethods.getScreenshot("Wrong email Address");


    }

    @And("verifies This field is invalid text visible")
    public void verifiesThisFieldIsInvalidTextVisible() throws IOException {
        Assert.assertTrue(registrationPage.invalidThisFieldIsText.isDisplayed());
        registrationPage.emailTextBox.clear();    // ayni senaryoda oldugu icin clear yapmali
        ReusableMethods.getScreenshot("invalid text visibility");
    }

    @And("user leaves blank for emailAddress of the applicant")
    public void userLeavesBlankForEmailAddressOfTheApplicant() {
        registrationPage.emailTextBox.sendKeys(" ");
        registrationPage.emailTextBox.sendKeys(Keys.ENTER);

    }
    @And("verifies Your email is required. text visible")
    public void verifiesYourEmailIsRequiredTextVisible() {
        Assert.assertTrue(registrationPage.requiredEmailText.isDisplayed());
    }




    @And("user provides already used email {string}")
    public void userProvidesAlreadyUsedEmail(String usedEmail) {
        Driver.waitAndSendText(registrationPage.emailTextBox,usedEmail);
    }

    @And("user verifies that email already used")
    public void userVerifiesThatEmailAlreadyUsed() {
        Driver.waitAndClick(registrationPage.registerButton);
        //   Assert.assertTrue(registrationPage.emailAlreadyUsedToastContainer.isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(registrationPage.emailAlreadyUsedToastContainer,2).isDisplayed());

    }

    @And("user provides username that already used {string}")
    public void userProvidesUsernameThatAlreadyUsed(String usedUsername) {
        Driver.waitAndSendText(registrationPage.usernameTextBox,usedUsername);
    }

    @And("user verifies that username already used")
    public void userVerifiesThatUsernameAlreadyUsed() {
        Driver.waitAndClick(registrationPage.registerButton);
        Assert.assertTrue(Driver.waitForVisibility(registrationPage.loginAlreadyUsedToastContainer,2).isDisplayed());
    }

    }




