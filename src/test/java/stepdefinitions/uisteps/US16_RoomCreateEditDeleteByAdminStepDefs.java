package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SignInPage;
import pages.US16_RoomCreateEditDeleteByAdminPage;
import utilities.Driver;

public class US16_RoomCreateEditDeleteByAdminStepDefs {

    SignInPage signInPage = new SignInPage();
    US16_RoomCreateEditDeleteByAdminPage roomCreate = new US16_RoomCreateEditDeleteByAdminPage();
    Faker faker = new Faker();

    @When("User signs in as admin")
    public void userSignsInAsAdmin() {
        Driver.waitAndClick(signInPage.loginDropdown);
        Driver.waitAndClick(signInPage.signDropdown);
        Driver.waitAndSendText(signInPage.username,"admin79");
        Driver.waitAndSendText(signInPage.password,"admin");
        Driver.waitAndClick(signInPage.loginButton);
    }

    @And("User clicks on Room cta under My Links")
    public void userClicksOnRoomCtaUnderMyLinks() {
        Driver.waitAndClick(roomCreate.roomCta);

    }

    @And("User clicks on Create a new room")
    public void userClicksOnCreateANewRoom() {
        Driver.waitAndClick(roomCreate.createANewRoom);
    }

    @And("User leaves room number field blank")
    public void userLeavesRoomNumberFieldBlank() {
    }

    @And("User chooses TWIN on Room Type dropdown")
    public void userChoosesTWINOnRoomTypeDropdown() {
        Driver.selectAnItemFromDropdown(roomCreate.roomTypeDropDown,"TWIN");
        Driver.selectAnItemFromDropdown(roomCreate.roomTypeDropDown,"DELUXE");
        Driver.selectAnItemFromDropdown(roomCreate.roomTypeDropDown,"TWIN");
    }

    @And("User sets current status by clicking on Status checkbox")
    public void userSetsCurrentStatusByClickingOnStatusCheckbox() {
        Driver.waitAndClick(roomCreate.statusCheck);
    }

    @And("User leaves price field blank")
    public void userLeavesPriceFieldBlank() {
        roomCreate.priceTextBox.clear();
    }

    @And("User enters description")
    public void userEntersDescription() {
        roomCreate.descriptionField.clear();
        Driver.waitAndSendText(roomCreate.descriptionField,"This is a test room creation");
    }

    @And("User enters created date")
    public void userEntersCreatedDate() {
        Driver.waitAndSendText(roomCreate.createdDate,"05/12/2022T03:35 PM");
    }

    @And("User clicks on Save button")
    public void userClicksOnSaveButton() {
        Driver.waitAndClick(roomCreate.saveButton);
    }

    @Then("This field is required message appears under required field textbox")
    public void thisFieldIsRequiredMessageAppearsUnderRequiredFieldTextbox() {
        Assert.assertTrue(roomCreate.fieldRequiredRoom.isDisplayed());
        Assert.assertTrue(roomCreate.fieldRequiredPrice.isDisplayed());
    }

    @Given("User enters room number")
    public void userEntersRoomNumber() {
        Driver.wait(5);

       // roomCreate.roomNumberTextBox.clear();
        roomCreate.roomNumberTextBox.sendKeys(faker.number().digits(4));
    }

    @And("User enters price")
    public void userEntersPrice() {
        Driver.wait(3);
        //Driver.waitAndSendText(roomCreate.priceTextBox,"500");
        roomCreate.priceTextBox.sendKeys(faker.number().digits(3));
    }

    @Then("User verifies the room is created successfully")
    public void userVerifiesTheRoomIsCreatedSuccessfully() {
        Driver.wait(5);
        Assert.assertTrue(roomCreate.roomCreateSuccessMessage.isDisplayed());
    }

    @Given("User clicks on last page button")
    public void userClicksOnLastPageButton() {
        Driver.waitAndClick(roomCreate.lastPageArrow);
    }

    @When("User clicks on Edit button")
    public void userClicksOnEditButton() {
        Driver.waitAndClick(roomCreate.editButton);
    }

    @And("User updates room number")
    public void userUpdatesRoomNumber() {
        Driver.wait(3);
        roomCreate.roomNumberTextBox.clear();
        roomCreate.roomNumberTextBox.sendKeys(faker.number().digits(4));

    }

    @And("User chooses DELUXE as room type")
    public void userChoosesDELUXEAsRoomType() {
        Driver.selectAnItemFromDropdown(roomCreate.roomTypeDropDown,"DELUXE");
    }

    @And("User updates price")
    public void userUpdatesPrice() {
        roomCreate.priceTextBox.clear();
        roomCreate.priceTextBox.sendKeys(faker.number().digits(3));
    }

    @And("User updates description")
    public void userUpdatesDescription() {
        roomCreate.descriptionField.clear();
        Driver.waitAndSendText(roomCreate.descriptionField,"this is another test");
    }

    @And("User clicks on delete button")
    public void userClicksOnDeleteButton() {
        Driver.waitAndClick(roomCreate.deleteButton);
    }

    @And("User confirms delete on pop up message")
    public void userConfirmsDeleteOnPopUpMessage() {
        Driver.wait(5);
        roomCreate.confirmDelete.click();
    }

    @Then("User verifies room is deleted successfully")
    public void userVerifiesRoomIsDeletedSuccessfully() {
        Driver.wait(5);
       // Driver.waitForVisibility(roomCreate.roomDeleteSuccessMessage,5);
        Assert.assertTrue(roomCreate.roomDeleteSuccessMessage.isDisplayed());
        Driver.wait(5);
    }
}
