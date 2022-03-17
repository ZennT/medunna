package stepdefinitions.uisteps;



import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.PatientsPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class PatientsStepDefs {

    Faker faker = new Faker();

    PatientsPage patientsPage = new PatientsPage();


    @Given("user in on the medunna home page")
    public void user_in_on_the_medunna_home_page() {
        Driver.wait(3);
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_login_url"));
    }
    @Given("user clicks on login dropdown")
    public void user_clicks_on_login_dropdown() {
        Driver.waitAndClick(patientsPage.loginDropdown);
        Driver.waitAndClick(patientsPage.signInButton);
    }

    @Given("user signs in as admin user name {string} and password as {string}")
    public void user_signs_in_as_admin_user_name_and_password_as(String username, String password) {
        patientsPage.username.sendKeys(username);
        patientsPage.password.sendKeys(password);
        Driver.waitAndClick(patientsPage.loginButton);
    }

    @Given("navigates to item_title and clicks")
    public void navigates_to_item_title_and_clicks() {
        Driver.waitAndClick(patientsPage.itemsTitlesDrowdown);

    }

    @Given("selects patient from dropdown menu")
    public void selects_patient_from_dropdown_menu() {
        Driver.waitAndClick(patientsPage.patientButton);

    }

    @Then("the patient informaions are visible")
    public void the_patient_informaions_are_visible() {
        Assert.assertTrue(patientsPage.patientsInfoPageVisiblity.isDisplayed());
    }

    //US009 /TC002 begins from here*************
    @Then("user clics edit button")
    public void user_clics_edit_button() {
        Driver.waitAndClick(patientsPage.editButton);
    }
    @Then("user verifies create or edit patient page is on")
    public void user_verifies_create_or_edit_patient_page_is_on() {
        Assert.assertTrue(patientsPage.createEditPatientPage.isDisplayed());
    }
    @Then("user cleans first name box and sends the first name")
    public void user_cleans_first_name_box_and_sends_the_first_name()  {
       Driver.waitAndClick(patientsPage.firstNameBox);
        patientsPage.firstNameBox.sendKeys(faker.name().firstName());

    }
    @Then("user cleans the last name box and sends the last name")
    public void user_cleans_the_last_name_box_and_sends_the_last_name() {
        patientsPage.lastNameBox.clear();
        Driver.waitAndClick(patientsPage.lastNameBox);
        patientsPage.lastNameBox.sendKeys(faker.name().lastName());
    }

    @Then("birth date sends the birth date")             //BIRTH DATE
    public void birth_date_sends_the_birth_date() {
        Driver.waitAndClick(patientsPage.patientBirthDateBox);
        patientsPage.patientBirthDateBox.clear();
        patientsPage.patientBirthDateBox.sendKeys(Keys.ARROW_RIGHT);
        patientsPage.patientBirthDateBox.clear();
        patientsPage.patientBirthDateBox.sendKeys(Keys.ARROW_RIGHT);
        patientsPage.patientBirthDateBox.clear();
        patientsPage.patientBirthDateBox.sendKeys(Keys.ARROW_RIGHT);
        patientsPage.patientBirthDateBox.sendKeys(Keys.ARROW_LEFT);
        patientsPage.patientBirthDateBox.sendKeys(Keys.ARROW_LEFT);
        patientsPage.patientBirthDateBox.sendKeys(Keys.ARROW_LEFT);
        Driver.waitAndSendText(patientsPage.patientBirthDateBox, "01.01.0020001212A");

    }


    @Then("user cleans the email box and sends the email")
    public void user_cleans_the_email_box_and_sends_the_email() {
        patientsPage.emailBox.clear();
        Driver.waitAndClick(patientsPage.emailBox);
        patientsPage.emailBox.sendKeys(faker.internet().emailAddress());

    }
    @Then("user cleans the phone box and sends the phone number")
    public void user_cleans_the_phone_box_and_sends_the_phone_number() {
        patientsPage.phoneBox.clear();
        Driver.waitAndClick(patientsPage.phoneBox);
        patientsPage.phoneBox.sendKeys("4387221874");
    }

    @Then("user clicks gender box and selects the gender from dropdown")
    public void user_clicks_gender_box_and_selects_the_gender_from_dropdown() {
        Select selectGender = new Select(patientsPage.genderDropdown);
        selectGender.selectByIndex(1);
    }
    @Then("user clicks bood group box and selects the blood group")
    public void user_clicks_bood_group_box_and_selects_the_blood_group() {
        Select selectBloodGroup = new Select(patientsPage.bloodGroupBox);
        selectBloodGroup.selectByIndex(3);

    }
    @Then("user cleans the address box and provides the address")
    public void user_cleans_the_address_box_and_provides_the_address() {
        patientsPage.addressBox.clear();
        Driver.waitAndClick(patientsPage.addressBox);
        patientsPage.addressBox.sendKeys("Fettek");

    }
    @Then("user cleans and updates the description")
    public void user_cleans_and_updates_the_description() {
        patientsPage.descriptionBox.clear();
        Driver.waitAndSendText(patientsPage.descriptionBox,"We are conducting Medunna");

    }
    @Then("user clicks the user box and selects the second one from the dropdown")
    public void user_clicks_the_user_box_and_selects_the_second_one_from_the_dropdown() {
        Driver.waitAndClick(patientsPage.userBox);
        Select selectUser = new Select(patientsPage.userBox);
        selectUser.selectByIndex(4);

    }
    @Then("user clicks the country and selects turkey from the dropdown")
    public void user_clicks_the_country_and_selects_turkey_from_the_dropdown() {
        Driver.waitAndClick(patientsPage.countryDropDown);
        Select selectCountry = new Select(patientsPage.countryDropDown);
        selectCountry.selectByIndex(1);
    }
//    SELECTING CITY FROM DROPDOWN DOES NOT WORK
//    @Then("user clicks state city and selects istanbul from the dropdown")
//    public void user_clicks_state_city_and_selects_istanbul_from_the_dropdown() throws InterruptedException {
//        Driver.wait(3);
//        patientsPage.stateCityDropDown.click();
//        Driver.wait(3);
//        Select selectStateCity = new Select(patientsPage.stateCityDropDown);
//        Driver.wait(3);
//        selectStateCity.selectByIndex(1);
//}

    @Then("user clicks the save button")
    public void user_clicks_the_save_button() {
        Driver.waitAndClick(patientsPage.saveButton);


    }

    @Then("verity the saved data as A Patient is updated with identifier ID")
    public void verity_the_saved_data_as_a_patient_is_updated_with_identifier_id() {
        Driver.wait(1);
        Assert.assertTrue(patientsPage.toastMessage.isDisplayed());
        Driver.wait(1);
    }

    @Then("user signs out")
    public void user_signs_out() {                      // ADMIN ADMIN DROPDOWN
        Driver.waitAndClick(patientsPage.adminAdminDropdown);
        Driver.waitAndClick(patientsPage.signOutFromAdmin);  //SIGN OUT ADMIN
    }



    //TEST CASE 003
    //  User can search for a new applicant by their SSN and see all their registration info populated

    @Given("user sign in as staff user name {string} and password as {string}")
    public void user_sign_in_as_staff_user_name_and_password_as(String username, String password) {
        patientsPage.username.click();
        Driver.waitAndSendText(patientsPage.username,username);
        patientsPage.password.click();
        Driver.waitAndSendText(patientsPage.password,password);
        patientsPage.signInStaffButton.click();


    }

    @Given("navigates to my pages and clicks")
    public void navigates_to_my_pages_and_clicks() {

        Driver.waitAndClick(patientsPage.myPagesDropdown);

    }

    @Given("selects search patient from dropdown menu")
    public void selects_search_patient_from_dropdown_menu() {
        Driver.wait(1);
        patientsPage.searchPatientButton.click();
    }

    @Given("clicks patient ssn box in the search patient page")
    public void clicks_patient_ssn_box_in_the_search_patient_page() {
        Driver.waitAndClick(patientsPage.patientSsnBox);
        //input an SSN number:111-33-1999
        Driver.waitAndSendText(patientsPage.patientSsnBox,"111-33-1999",1);

    }

    //THE STAFF SIGNS OUT OF THE PAGE
    @Then("the staff signs out")
    public void the_staff_signs_out() {
        Driver.wait(8);
        patientsPage.staffDropdown.click();
        Driver.waitAndClick(patientsPage.signOutStaff,3);
    }


    @Then("click delete and confirm delete operation by reclicking on the popup window")
    public void click_delete_and_confirm_delete_operation_by_reclicking_on_the_popup_window() {
        Driver.waitAndClick(patientsPage.deletePatientButton,1);
        // Driver.waitAndClick(patientsPage.confirmDeletePatientButton,2);
        Driver.waitAndClick(patientsPage.cancelPopUpButton,1);

    }

    //DELETE FUNCTION WORKS ONLY IF IT IS CREATED BY THE USER HIMSELF
    @Then("verify the record is deleted message")
    public void verify_the_record_is_deleted_message() {
        Assert.assertTrue(patientsPage.toastDeleteMessage.isDisplayed());
    }


    //TC 008 ADMIN CAN NOT SEARCH SSN
    @Then("verifies that the patient ssn search box does not exist")
    public void verifies_that_the_patient_ssn_search_box_does_not_exist() {


        Assert.assertFalse(patientsPage.patientSsnBox.isDisplayed());


    }


}


