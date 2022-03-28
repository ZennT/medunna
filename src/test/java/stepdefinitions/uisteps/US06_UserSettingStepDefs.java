package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.RegistrationPage;
import pages.US06_UserSettingPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US06_UserSettingStepDefs {
    US06_UserSettingPage userSettingPage=new US06_UserSettingPage();
    RegistrationPage registrationPage=new RegistrationPage();

    @Given("user on the Medunna Sign in  Page")
    public void user_on_the_medunna_sign_in_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
        Driver.waitAndClick(userSettingPage.accountMenu);
        Driver.waitAndClick(userSettingPage.signIn);
    }
    @Given("user enters username {string}")
    public void user_enters_username(String string) {
        Driver.waitAndSendText(userSettingPage.username, string);
        Driver.wait(2);
    }
    @Given("user enters password  {string}")
    public void user_enters_password(String string) {
        Driver.waitAndSendText(userSettingPage.password, string);
        Driver.wait(2);
    }
    @Given("user clicks sign in button")
    public void user_clicks_sign_in_button() {
        Driver.waitAndClick(userSettingPage.signInButton);
        Driver.wait(2);
    }
    @Given("user click on setting page")
    public void user_click_on_setting_page() {
        Driver.waitAndClick(userSettingPage.userIcon);
        Driver.waitAndClick(userSettingPage.settingbutton);
    }
    @Given("user verify Name")
    public void user_verify_name() {
        Driver.wait(3);
        Assert.assertTrue(userSettingPage.firstName.isDisplayed());
        userSettingPage.firstName.clear();
        Driver.waitAndSendText(userSettingPage.firstName,"Drago");
        userSettingPage.saveButton.click();
        Driver.wait(3);
        assertTrue(userSettingPage.successfulMessage.isDisplayed());
        Driver.wait(3);

    }
    @Given("user verify Lastname")
    public void user_verify_lastname() {
        Assert.assertTrue(userSettingPage.lastName.isDisplayed());
        userSettingPage.lastName.clear();
        Driver.waitAndSendText(userSettingPage.lastName,"mixy");
        userSettingPage.saveButton.click();
        Driver.wait(3);
        assertTrue(userSettingPage.successfulMessage.isDisplayed());
        Driver.wait(3);
    }
    @Given("user verify Email")
    public void user_verify_email() {
        Assert.assertTrue(userSettingPage.email.isDisplayed());
        userSettingPage.email.clear();
        Driver.waitAndSendText( userSettingPage.email,"drago123@gmail.com");
        userSettingPage.saveButton.click();
        Driver.wait(3);
        assertTrue(userSettingPage.successfulMessage.isDisplayed());
        Driver.wait(3);
    }
    @Given("firstname should not be blank")
    public void firstname_should_not_be_blank() {
        userSettingPage.firstName.clear();
        userSettingPage.firstName.sendKeys(""+ Keys.ENTER);
        //userSettingPage.saveButton.click();
        //String firstNameMessage=Driver.waitAndGetText(userSettingPage.firstnameFeedBack,1);
        //assertEquals(firstNameMessage,"Your first name is required.");
        assertTrue(userSettingPage.firstnameFeedBack.isDisplayed());

    }

    @Given("lastname should not be blank")
    public void lastname_should_not_be_blank() {
        userSettingPage.lastName.clear();
        userSettingPage.lastName.sendKeys(""+ Keys.ENTER);
        //userSettingPage.saveButton.click();
        //String firstNameMessage=Driver.waitAndGetText(userSettingPage.firstnameFeedBack,1);
        //assertEquals(firstNameMessage,"Your first name is required.");
        assertTrue(userSettingPage.lastnameFeedBack.isDisplayed());
    }

    @Given("e-mail should not be created without @ sign and . extension")
    public void e_mail_should_not_be_created_without_sign_and_extension() {
        userSettingPage.email.clear();
        userSettingPage.email.sendKeys("edagmail.com");
        userSettingPage.email.sendKeys("eda@gmailcom");
        //userSettingPage.saveButton.click();
        assertTrue(registrationPage.invalidThisFieldIsText.isDisplayed());
        //assertTrue(userSettingPage.emailFeedBack.isDisplayed());

    }


    @And("email should not be blank")
    public void emailShouldNotBeBlank() {
        userSettingPage.email.clear();
        userSettingPage.email.sendKeys(" "+Keys.ENTER);

        assertTrue(userSettingPage.emailFeedBack.isDisplayed());


    }

}