package stepdefinitions.uisteps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;
import pages.SignInPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.IOException;


public class LoginStepDefs {


    LoginPage loginPage = new LoginPage();
    SignInPage signinpage=new SignInPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
    }
    @Given("user clicks on login dropdown icon")
    public void user_clicks_on_login_dropdown_icon() {
        signinpage.loginDropdown.click();
    }
    @Given("user clicks on sign in dropdown")
    public void user_clicks_on_sign_in_dropdown() {
        signinpage.signDropdown.click();
    }

    @Given("user sends username {string}")
    public void user_sends_username(String dropdown) {
        signinpage.username.sendKeys(dropdown);
    }

    @Given("user sends password {string}")
    public void user_sends_password(String string) {
        signinpage.password.sendKeys(string);
    }

    @Then("user clicks on the sign in dropdown")
    public void user_clicks_on_the_sign_in_dropdown() {
        signinpage.loginButton.click();
    }

    @Then("verify the login is successful")
    public void verify_the_login_is_successful() throws IOException {
        Driver.wait(1);
        Assert.assertTrue(loginPage.homeText.isDisplayed());
        ReusableMethods.getScreenshot("successful Message");
    }

    @Then("user clicks on sign out")
    public void user_clicks_on_sign_out() {
        loginPage.signOutButton.click();
    }

    @Given("user sends invalid password {string} or invalid username {string}")
    public void user_sends_invalid_password_or_invalid_username(String string, String string2) {
        signinpage.password.sendKeys(string2);
    }

    @Then("verify the error message")
    public void verify_the_error_message() {
        Driver.wait(1);
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }
    @Then("user clicks on the cancelButton")
    public void user_clicks_on_the_cancel_button() {
        loginPage.cancelButton.click();
    }
    @Given("user sends invalid password {string}")
    public void user_sends_invalid_password(String string) {
        signinpage.password.clear();
        signinpage.password.sendKeys(string);

    }
    @Given("user clicks on the didYouForgetPassword button")
    public void user_clicks_on_the_did_you_forget_password_button() {
        loginPage.didYouForgetPassword.click();
    }

    @Then("verify enter the email address  message")
    public void verify_enter_the_email_address_message() {
        Driver.wait(1);
        Assert.assertTrue(loginPage.verifyingMessage.isDisplayed());
    }

    @Then("user enters newEmail {string}")
    public void user_enters_new_email(String string) {
        loginPage.newEmail.sendKeys(string);
    }
    @Then("user clicks on the resetPassword button")
    public void user_clicks_on_the_reset_password_button() {
        loginPage.resetPassword.click();

    }
    @Then("user should see the newMessage")
    public void user_should_see_the_new_message() {
        Driver.wait(1);
        Assert.assertTrue(loginPage.checkMailMessage.isDisplayed());
    }
    @Given("User  enter before rememberMe button")
    public void user_enter_before_remember_me_button() {
        loginPage.rememberMeButton.click();
    }
    @Then("user see registerNewAccount button")
    public void user_see_register_new_account_button() {
        Driver.wait(1);
        Assert.assertTrue(loginPage.registerNewAccount.isDisplayed());

    }

}
