package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SignInPage;
import pages.US17_CreateUpdateDeleteTestItemPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US17_CreateUpdateDeleteTestItemStepDefs {


    US17_CreateUpdateDeleteTestItemPage testItemPage= new US17_CreateUpdateDeleteTestItemPage();
    Faker faker = new Faker();
    SignInPage signInPage=new SignInPage();


    @When("User navigates to the home page")
    public void user_navigates_to_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));

    }

//    @When("user clicks sign in button at the home page and navigates to sign in page")
//    public void user_clicks_sign_in_button_at_the_home_page_and_navigates_to_sign_in_page() {
//        Driver.waitAndClick(testItemPage.accountMenu);
//        Driver.waitAndClick(testItemPage.signDropdown);

   // }

    @Then("user verifies that sign in page header is visible")
    public void user_verifies_that_sign_in_page_header_is_visible() {
        Driver.waitForVisibility(testItemPage.singinPageHeader, 5);
        Assert.assertTrue(testItemPage.singinPageHeader.isDisplayed());
    }

    @Then("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        signInPage.loginDropdown.click();
        signInPage.signDropdown.click();

        signInPage.username.sendKeys(username);
        signInPage.password.sendKeys(password);
    }

//    @Then("user clicks sign in button")
//    public void user_clicks_sign_in_button() {
//
//        testItemPage.singInButton.click();
//        Driver.wait(3);
//
//    }

    @Then("user verifies that sign in is successful")
    public void user_verifies_that_sign_in_is_successful() throws IOException {
        Driver.wait(3);
        Assert.assertTrue(testItemPage.homeText.isDisplayed());
        ReusableMethods.getScreenshot("successful Message");

    }

    @When("user clicks on the ItemTitles dropdown")
    public void user_clicks_on_the_item_titles_dropdown() {
        Driver.wait(2);
        testItemPage.itemsTitles.click();

    }

    @When("user clicks on the testItem dropdown")
    public void user_clicks_on_the_test_item_dropdown() {
        Driver.wait(3);
        testItemPage.testItem.click();

    }

    @When("user clicks on the createNewTestItem dropdown")
    public void user_clicks_on_the_create_new_test_item_dropdown() {
        Driver.wait(2);
        Driver.clickElementByJS(testItemPage.CreateTestItem);
    }

    @Then("user provides a  test name {string}")
    public void user_provides_a_test_name(String testName) {
//        testItemPage.testName.sendKeys("dihanlin");
        testName =faker.name().firstName();
        Driver.waitAndSendText(testItemPage.testNameBox,testName);

    }

    @Then("user enters a description {string}")
    public void user_enters_a_description(String descriptionNote) {
        testItemPage.description.sendKeys("mg/ml");

    }

    @Then("user enters  a price {string}")
    public void user_enters_a_price(String currentPrice) {
        testItemPage.price.sendKeys("130");

    }

    @Then("user enter a min value {string}")
    public void user_enter_a_min_value(String minValue) {
        testItemPage.minValue.sendKeys("80");

    }

    @Then("User enters a max value {string}")
    public void user_enters_a_max_value(String maxValue) {
        testItemPage.maxValue.sendKeys("130");

    }


    @Then("user clicks on save button")
    public void user_clicks_on_save_button() {
        Driver.waitAndClick(testItemPage.saveButton);
    }

    @Then("user verifies that saving is successful")
    public void user_verifies_that_saving_is_successful() {
        Driver.wait(3);
        Assert.assertTrue(testItemPage.savingSuccessMessage.isDisplayed());

    }

    @Then("user clicks last arrow button")
    public void user_clicks_last_arrow_button() {
        Driver.waitAndClick(testItemPage.arrowLastItem);

    }

    @Then("user clicks last itemNumber")
    public void user_clicks_last_item_number() {
        testItemPage.lastFigureItem.click();

    }

    @Then("user clicks delete button")
    public void user_clicks_delete_button() {
        testItemPage.deleteTestItem.click();

    }


    @Then("user clicks confirmDelete button")
    public void user_clicks_confirm_delete_button() {
        Driver.wait(3);
        testItemPage.confirmDeleteButton.click();

    }

    @Then("user verifies itemDeleteMessage")
    public void user_verifies_item_delete_message() {
        Assert.assertTrue(testItemPage.deleteSuccessMessage.isDisplayed());
    }

}

