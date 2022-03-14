package stepdefinitions.uisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.SignInPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class SignInStepDefs {

    SignInPage signInPage = new SignInPage();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }

    @Given("user clicks on login dropdown icon")
    public void user_clicks_on_login_dropdown() {

        signInPage.loginDropdown.click();
    }

    @Given("user clicks on sign in dropdown")
    public void user_clicks_on_sign_in_button() {
        signInPage.signDropdown.click();

    }
    @Then("user clicks on the sign in button")
    public void user_clicks_on_the_sign_in_button() {
        signInPage.loginButton.click();
    }

}
