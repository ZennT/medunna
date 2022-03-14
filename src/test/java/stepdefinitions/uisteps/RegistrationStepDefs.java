package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.RegistrationPage;
import pojos.Registrant;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;

import static utilities.ReadTxt.getSSNIDs;
import static utilities.WriteToTxt.saveRegistrantData;

public class RegistrationStepDefs {
    Registrant registrant = new Registrant();
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();


    @Given("user clicks sign in register dropdown button")
    public void userClicksSignInRegisterDropdownButton() {
        Driver.waitAndClick(registrationPage.signinRegisterDropdown);
    }

    @And("user clicks register button")
    public void userClicksRegisterButton() {
        Driver.waitAndClick(registrationPage.registerHomeButton);
    }

     @And("user provides ssn id {string}")
    public void userEntersSsnNumber(String ssn) {
       ssn= faker.idNumber().ssnValid();
        registrant.setSsn(ssn);
        Driver.waitAndSendText(registrationPage.ssnTextbox, ssn);
    }

    @And("user provides firstname and lastname {string} and {string}")
    public void userEntersFirstnameAsAndLastnameAs(String firstname, String lastname) {
        firstname=faker.name().firstName();
        registrant.setFirstName(firstname);
        lastname = faker.name().lastName();
        registrant.setLastName(lastname);
        Driver.waitAndSendText(registrationPage.firstNameTextBox, firstname);
        Driver.waitAndSendText(registrationPage.lastNameTextBox, lastname);
    }

    @And("user provides username {string}")
    public void userProvidesUsername(String username) {
        username= registrant.getFirstName()+registrant.getLastName();
        registrant.setLogin(username);
        Driver.waitAndSendText(registrationPage.usernameTextBox, username);
    }

    @And("user provides email {string}")
    public void userProvidesEmail(String email) {
       email = faker.internet().emailAddress();
       registrant.setEmail(email);
        Driver.waitAndSendText(registrationPage.emailTextBox, email);
    }

    @And("user provides the password {string}")
    public void userProvidesTheFirstPasswordAsAndSecondPasswordAs(String password) {
        password= faker.internet().password(8,20,true,true);
        registrant.setPassword(password);
        Driver.waitAndSendText(registrationPage.newPasswordTextBox, password);
        Driver.waitAndSendText(registrationPage.newPasswordConfirmTextBox, password);
    }

    @Then("user registers and validates data generation")
    public void userRegistersAndValidatesDataGeneration() {
        Driver.waitAndClick(registrationPage.registerButton);
        Driver.wait(1);
        Assert.assertTrue(registrationPage.successMessageToastContainer.isDisplayed());
    }

    @And("user enters invalid ssn number {string} and clicks enter")
    public void userEntersInvalidSsnNumberAndClicksEnter(String ssn) {
        Driver.waitAndSendText(registrationPage.ssnTextbox, ssn);
        registrationPage.ssnTextbox.sendKeys(Keys.ENTER);

    }

    @And("verify your ssn is invalid text visible")
    public void verifyYourSsnIsInvalidTextVisible() {
        Assert.assertTrue(registrationPage.ssnInvalidText.isDisplayed());

    }

    @And("verify your ssn is required visible")
    public void verifyYourSsnIsRequiredVisible() {
        Assert.assertTrue(registrationPage.ssnRequiredText.isDisplayed());

    }

    @Given("user leaves ssn textbox blank")
    public void userLeavesSsnTextboxBlank() {
        registrationPage.ssnTextbox.sendKeys(" ");
        registrationPage.ssnTextbox.sendKeys(Keys.ENTER);

    }

    @Then("user sets the data in correspondent files")
    public void userSetsTheDataInCorrespondentFiles() {
        saveRegistrantData(registrant);
    }


    @And("user close the application")
    public void userCloseTheApplication() {
        Driver.getDriver().close();
    }

    @Given("user leaves firstname textbox blank and press enter")
    public void userLeavesFirstnameTextboxBlankAndPressEnter() {
        registrationPage.firstNameTextBox.sendKeys(" ");
        registrationPage.firstNameTextBox.sendKeys(Keys.ENTER);
    }

    @And("verify your name is required visible")
    public void verifyYourNameIsRequiredVisible() {
        Assert.assertTrue(registrationPage.firstNameRequiredText.isDisplayed());

    }

    @Given("user leaves lastname textbox blank and press enter")
    public void userLeavesLastnameTextboxBlankAndPressEnter() {
        registrationPage.lastNameTextBox.sendKeys("");
        registrationPage.lastNameTextBox.sendKeys(Keys.ENTER);

    }

    @And("verify your lastname is required visible")
    public void verifyYourLastnameIsRequiredVisible() {
        Assert.assertTrue(registrationPage.lastNameRequiredText.isDisplayed());
    }

    @And("user provides the new password {string}")
    public void userProvidesTheNewPassword(String password) {
         Driver.waitAndSendText(registrationPage.newPasswordTextBox,password);

     }
    @And("verify password length less than the specified range in password")
    public void verifyPasswordLengthLessThanTheSpecifiedRangeInPassword() {
        String password = registrationPage.newPasswordTextBox.getText();
        if (password.length()<4) {
            Assert.assertTrue(registrationPage.newPasswordCharCheckText.isDisplayed());
        }

    }


    @And("verify user cannot enter the characters more than the specified range")
    public void verifyUserCannotEnterTheCharactersMoreThanTheSpecifiedRangeIn() {
        String password1 = registrationPage.newPasswordTextBox.getText();
        boolean flag = true;
        if (password1.length() > 20) {
            flag = false;
        }
    }

    @Then("user validate the password strength {string}")
    public void userValidateThePasswordStrength(String level) {
    if (1== Integer.parseInt(level)){
        Assert.assertTrue(registrationPage.passwordStrength1.isDisplayed());

    } else if(2 ==Integer.parseInt(level)){
        Assert.assertTrue(registrationPage.passwordStrength2.isDisplayed());


    }else if(3==Integer.parseInt(level)){
        Assert.assertTrue(registrationPage.passwordStrength3.isDisplayed());
    }

    else if(4==Integer.parseInt(level))
        Assert.assertTrue(registrationPage.passwordStrength4.isDisplayed());
    }


    @And("user provides the password confirmation {string}")
    public void userProvidesThePasswordConfirmation(String passwordConfirmation) {
        Driver.waitAndSendText(registrationPage.newPasswordConfirmTextBox,passwordConfirmation);
        registrationPage.newPasswordTextBox.sendKeys(Keys.ENTER);
    }

    @And("verify the password and its confirmation do not match message")
    public void verifyThePasswordAndItsConfirmationDoNotMatch() {
        Assert.assertTrue(registrationPage.newPasswordConfirmMatchText.isDisplayed());
    }


    @And("verify your password is required visible")
    public void verifyYourPasswordIsRequiredVisible() {
        Assert.assertTrue(registrationPage.newPasswordRequiredText.isDisplayed());
    }

    @Given("user leaves password blank and press enter")
    public void userLeavesPasswordBlankAndPressEnter() {
        registrationPage.newPasswordTextBox.sendKeys(" ");
        registrationPage.newPasswordTextBox.sendKeys(Keys.ENTER);
    }

    @And("verify your confirmation password is required visible")
    public void verifyYourConfirmationPasswordIsRequiredVisible() {
        Assert.assertTrue(registrationPage.newPasswordConfirmRequiredText.isDisplayed());
    }

    @Given("user leaves  confirmation password blank and press enter")
    public void userLeavesConfirmationPasswordBlankAndPressEnter() {
        registrationPage.newPasswordConfirmTextBox.sendKeys(" ");
        registrationPage.newPasswordConfirmTextBox.sendKeys(Keys.ENTER);
    }


    @Then("user clicks register button and validate ssn id already registered")
    public void userClicksRegisterButtonAndValidateSsnIdAlreadyRegistered() {
        Driver.waitAndClick(registrationPage.registerButton);
        Driver.wait(3);
        Assert.assertTrue(registrationPage.sSNAlreadyUsedToastContainer.isDisplayed());

    }

    @Then("user clicks register button and validate username already registered")
    public void userClicksRegisterButtonAndValidateUsernameAlreadyRegistered() {
        Driver.waitAndClick(registrationPage.registerButton);
        Driver.wait(3);
        Assert.assertTrue(registrationPage.loginAlreadyUsedToastContainer.isDisplayed());

    }

    @Then("user clicks register button and validate email already registered")
    public void userClicksRegisterButtonAndValidateEmailAlreadyRegistered() {
        Driver.waitAndClick(registrationPage.registerButton);
        Driver.wait(3);
        Assert.assertTrue(registrationPage.emailAlreadyUsedToastContainer.isDisplayed());

    }

    @Given("verify land on registration page")
    public void verifyLandOnRegistrationPage() {
         Assert.assertTrue(registrationPage.registrationText.isDisplayed());
    }

    @Then("capture the screenshot")
    public void captureTheScreenshot() throws IOException {
      ReusableMethods.getScreenshot("register");

    }


    @And("verify password confirmation length less than the specified range in password")
    public void verifyPasswordConfirmationLengthLessThanTheSpecifiedRangeInPassword() {
        String password = registrationPage.newPasswordConfirmTextBox.getText();
        if (password.length()<4) {
            Assert.assertTrue(registrationPage.NewPasswordConfirmCharCheckText.isDisplayed());
        }
    }

    @And("user enters already used ssn number {string}")
    public void userEntersAlreadyUsedSsnNumber(String ssn) {
        Driver.waitAndSendText(registrationPage.ssnTextbox, ssn);
    }

    @Given("user verifies on home page")
    public void userVerifiesOnHomePage() {
        String homePageTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("MEDUNNA", homePageTitle);
    }

    @Then("user gets DB records and validates the ssn")
    public void userGetsDBRecordsAndValidatesTheSsn() {
   registrant.getSsn();
   List<String> actualSSNIDs = getSSNIDs();

   Assert.assertTrue(actualSSNIDs.contains(registrant.getSsn()));

    }
}