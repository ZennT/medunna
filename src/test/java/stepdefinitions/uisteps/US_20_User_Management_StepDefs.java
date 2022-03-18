package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import io.cucumber.java.en.Given;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.RegistrationPage;
import pages.US_20_User_Management_Admin;
import pojos.Registrant;
import utilities.Driver;

import java.nio.file.Watchable;
import java.util.Dictionary;


public class US_20_User_Management_StepDefs {

    US_20_User_Management_Admin user_management_admin = new US_20_User_Management_Admin();
   Registrant registrant = new Registrant();
    Faker faker = new Faker();



    @Given("navigates and clicks administration dropdown")
    public void navigates_and_clicks_administration_dropdown() {
        Driver.wait(3);
       user_management_admin.administrationDropdownButton.click();
    }
    @Given("clicks user management")
    public void clicks_user_management() {
       Driver.wait(2);
       user_management_admin.userManagementButton.click();

    }
    @Given("navigates and clicks the view button of the first user")
    public void navigates_and_clicks_the_view_button_of_the_first_user() {
       Driver.waitAndClick(user_management_admin.viewButton);

    }
    @Given("verifies that the registered user info is visible")
    public void verifies_that_the_registered_user_info_is_visible() {
        Driver.wait(2);
        Assert.assertTrue(user_management_admin.userInfoVisibility.isDisplayed());

    }


    @Given("navigates and clicks on the create a new user button")
    public void navigates_and_clicks_on_the_create_a_new_user_button() {
        Driver.wait(2);
    user_management_admin.createAnewUserButton.click();
        Driver.wait(2);
    }

    @Given("clicks login box and provides a login")
    public void clicks_login_box_and_provides_a_login() {
       String login = faker.name().username();
        Driver.waitAndSendText(user_management_admin.loginUserNameBox,login);
        Driver.wait(2);
    }

    @Given("clicks the first name box and provides the first name")
    public void clicks_the_first_name_box_and_provides_the_first_name() {
       Driver.waitAndClick(user_management_admin.firstNameBox);
      String firstName = faker.name().firstName();
      registrant.setFirstName(firstName);
        Driver.wait(1);
        Driver.waitAndSendText(user_management_admin.firstNameBox,firstName);

    }
    @Given("clicks the last name box and provides the last name")
    public void clicks_the_last_name_box_and_provides_the_last_name() {
        Driver.waitAndClick(user_management_admin.lastNameBox);
        String lastName = faker.name().lastName();
        registrant.setLastName(lastName);
        Driver.wait(1);
        Driver.waitAndSendText(user_management_admin.lastNameBox,lastName);

    }
    @Given("clicks the email box and provides the email")
    public void clicks_the_email_box_and_provides_the_email() {
        Driver.waitAndClick(user_management_admin.emailBox);
        String email = faker.internet().emailAddress();
        Driver.wait(1);
        Driver.waitAndSendText(user_management_admin.emailBox, email);


    }
    @Given("clicks on the SSN box and provides a valid SSN")
    public void clicks_on_the_ssn_box_and_provides_a_valid_ssn() {
        Driver.waitAndClick(user_management_admin.ssnBox);
        String ssn = ("232-65-"+ faker.number().digits(4));
        Driver.wait(1);
        Driver.waitAndSendText(user_management_admin.ssnBox, ssn);
        Driver.wait(2);


    }
    @Given("clicks on the language dropdown and selects english")
    public void clicks_on_the_language_dropdown_and_selects_english() {
        Driver.waitAndClick(user_management_admin.languageDropDown);
        Select select = new Select(user_management_admin.languageDropDown);
        Driver.wait(1);
        select.selectByIndex(1);
        Driver.wait(1);


    }
    @Given("selects Role_Staff in profiles")
    public void selects_role_staff_in_profiles() {
        Driver.waitAndClick(user_management_admin.profiles);
        Select select = new Select(user_management_admin.profiles);
        select.selectByIndex(1);
        select.selectByIndex(0);
        Driver.wait(2);


    }
    @Given("clicks save button then click last page button")
    public void clicks_save_button_then_click_last_page_button() {
        Driver.waitAndClick(user_management_admin.saveButton);
        Driver.wait(3);
        Assert.assertTrue(user_management_admin.createdToastMessaga.isDisplayed());
        Driver.wait(3);

    }
    @Given("on the last page edits the last user as a patient role and saves")
    public void on_the_last_page_edits_the_last_user_as_a_patient_role_and_saves() {

        Driver.wait(2);
        Driver.waitAndClick(user_management_admin.goToLastPageButton);
        Driver.wait(1);

    }
    @Given("deletes the patient that has just been edited")
    public void deletes_the_patient_that_has_just_been_edited() {
     Driver.wait(2);
     Driver.waitAndClick(user_management_admin.deleteLastCreated);
     Driver.wait(2);

     Driver.waitAndClick(user_management_admin.deleteConfirm);
     Driver.wait(1);
     Assert.assertTrue(user_management_admin.deleteToastMessage.isDisplayed());
     Driver.wait(4);



    }




}
