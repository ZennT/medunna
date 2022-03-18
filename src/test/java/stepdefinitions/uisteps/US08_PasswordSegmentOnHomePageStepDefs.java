package stepdefinitions.uisteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.PasswordSegmentPage;
import pages.SignInPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US08_PasswordSegmentOnHomePageStepDefs {



    SignInPage signInPage = new SignInPage();
    PasswordSegmentPage passwordSegmentPage = new PasswordSegmentPage();


    @Given("user is on the logIn page")
    public void user_is_on_the_log_in_page() {

        Driver.getDriver().get("https://medunna.com");
    }
    @Given("user clicks the logIn dropdown")
    public void user_clicks_the_log_in_dropdown() {
        signInPage.loginDropdown.click();

    }
    @Given("user clicks on the signIn button")
    public void user_clicks_on_the_sign_in_button() {
        signInPage.signDropdown.click();

    }
    @Given("user provides the userName as {string}")
    public void user_provides_the_user_name_as(String string) {
        Driver.wait(2);
        signInPage.username.sendKeys(string);
    }
    @Given("user provides the passWord as {string}")
    public void user_provides_the_pass_word_as(String string) {
        signInPage.password.sendKeys(string);

    }
    @Given("user clicks on remember button")
    public void user_clicks_on_remember_button() {
        Driver.wait(1);
        signInPage.rememberMe.click();

    }
    @Given("user clicks on the signInButton")
    public void user_clicks_on_the_sign_inbutton() throws IOException {
        signInPage.loginButton.click();
        ReusableMethods.getScreenshot("password changed");
        Driver.wait(2);

    }

    @Given("user clicks on user segment")
    public void user_clicks_on_user_segment() {
        passwordSegmentPage.userSegment.click();
    }

    @Given("user clicks on Password")
    public void user_clicks_on_password() {
        Driver.wait(1);
        passwordSegmentPage.password.click();

    }

    @Given("user provides the currentPassword as {string}")
    public void user_provides_the_current_password_as(String string) {
        Driver.wait(2);
        passwordSegmentPage.currentPassword.sendKeys(string);

    }


    @Given("user provides the newPassword as {string}")
    public void user_provides_the_new_password_as(String newpassword) {
        Driver.wait(2);
        passwordSegmentPage.newPassword.sendKeys(newpassword);
    }

    @Given("user provides the newPasswordConfirmation as {string}")
    public void user_provides_the_new_password_confirmation_as(String newpasswordconfirmation) {
        Driver.wait(2);
        passwordSegmentPage.confirmPassword.sendKeys(newpasswordconfirmation);

    }
    @Given("user clicks on the save button")
    public void user_clicks_on_the_save_button() throws IOException {
        Driver.wait(2);
        passwordSegmentPage.saveButton.click();
        ReusableMethods.getScreenshot("password changed");

    }

    @Then("user verifies password changed successfully")
    public void user_verifies_password_changed_successfully(){
        Driver.wait(2);
        Assert.assertTrue(passwordSegmentPage.verifiesPasswordSuccessfully.isDisplayed());

    }
    @Given("user provides the invalid two letters one digit newPassword as {string}")
    public void user_provides_the_invalid_two_letters_one_digit_new_password_as(String string) {
        Driver.wait(2);
        passwordSegmentPage.newPassword.sendKeys(string);
    }

    @Given("user provides the invalid two letters one digit newPasswordConfirmation as {string}")
    public void user_provides_the_invalid_two_letters_one_digit_new_password_confirmation_as(String string) {
        Driver.wait(2);
        passwordSegmentPage.confirmPassword.sendKeys(string);
    }

    @Given("user provides the invalid one capital letter one small letter one digit newPassword as {string}")
    public void user_provides_the_invalid_one_capital_letter_one_small_letter_one_digit_new_password_as(String string) {
        Driver.wait(2);
        passwordSegmentPage.newPassword.sendKeys(string);
    }

    @Given("user provides the invalid one capital letter one small letter one digit newPasswordConfirmation as {string}")
    public void user_provides_the_invalid_one_capital_letter_one_small_letter_one_digit_new_password_confirmation_as(String string) {
        Driver.wait(2);
        passwordSegmentPage.confirmPassword.sendKeys(string);
    }

    @Given("user provides the invalid one capital letter one small letter one special char newPassword as {string}")
    public void user_provides_the_invalid_one_capital_letter_one_small_letter_one_special_char_new_password_as(String string) {
        Driver.wait(2);
        passwordSegmentPage.newPassword.sendKeys(string);
    }

    @Given("user provides the invalid one capital letter one small letter one special char newPasswordConfirmation as {string}")
    public void user_provides_the_invalid_one_capital_letter_one_small_letter_one_special_char_new_password_confirmation_as(String string) {
        Driver.wait(2);
        passwordSegmentPage.confirmPassword.sendKeys(string);
    }

    @Given("user provides the all capital letters as newPassword as {string}")
    public void user_provides_the_all_capital_letters_as_new_password_as(String string) {
        Driver.wait(2);
        passwordSegmentPage.newPassword.sendKeys(string);
    }

    @Given("user provides the all capital letters as newPasswordConfirmation as {string}")
    public void user_provides_the_all_capital_letters_as_new_password_confirmation_as(String string) {
        Driver.wait(2);
        passwordSegmentPage.confirmPassword.sendKeys(string);
    }

    @Then("there should be displayed Password changed.")
    public void there_should_be_displayed_password_changed() {
        Driver.wait(2);
        passwordSegmentPage.saveButton.isDisplayed();
    }

    @Given("user provides the all digits as newPassword as {string}")
    public void user_provides_the_all_digits_as_new_password_as(String string) {
        Driver.wait(2);
        passwordSegmentPage.newPassword.sendKeys(string);
    }

    @Given("user provides the all digits as newPasswordConfirmation as {string}")
    public void user_provides_the_all_digits_as_new_password_confirmation_as(String string) {
        passwordSegmentPage.confirmPassword.sendKeys(string);
    }

    @Then("there should be displayed Your password is required to be at least four characters.")
    public void thereShouldBeDisplayedYourPasswordIsRequiredToBeAtLeastFourCharacters() {
        passwordSegmentPage.saveButton.isDisplayed();
    }
}