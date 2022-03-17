package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
// deneme

public class RegistrationPage {
        public RegistrationPage() {

                PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
        public WebElement signinRegisterDropdown;

        @FindBy(xpath = "//*[text()='Register']")
        public WebElement registerHomeButton;

        @FindBy(xpath = "//*[text()='Registration']")
        public WebElement registrationText;

        @FindBy(id ="ssn")
        public WebElement ssnTextbox;

        @FindBy(xpath = "//div[text()='Your SSN is required.']")
        public WebElement ssnRequiredText;

        @FindBy(xpath = "//div[text()='Your SSN is invalid']")
        public WebElement ssnInvalidText;

        @FindBy(id = "firstName")
        public WebElement firstNameTextBox;

        @FindBy(xpath = "//*[text()='Your FirstName is required.']")
        public WebElement firstNameRequiredText;

        @FindBy(id = "lastName")
        public WebElement lastNameTextBox;

        @FindBy(xpath = "//*[text()='Your LastName is required.']")
        public WebElement lastNameRequiredText;

        @FindBy(id = "username")
        public WebElement usernameTextBox;

        @FindBy(xpath = "//*[contains(text(), 'Your username is required.')]")
        public WebElement requiredUserNameText;

        @FindBy(xpath = "//*[contains(text(), 'This field is invalid')]")
        public WebElement invalidThisFieldIsText;

        @FindBy(id = "email")
        public WebElement emailTextBox;

        @FindBy(id = "firstPassword")
        public WebElement newPasswordTextBox;

        @FindBy(xpath = "//*[text()='Your password is required to be at least 4 characters.']")
        public WebElement newPasswordCharCheckText;

        @FindBy(id = "secondPassword")
        public WebElement newPasswordConfirmTextBox;

        @FindBy(xpath = "//*[text()='Your password is required.']")
        public WebElement newPasswordRequiredText;

        @FindBy(xpath = "//*[text()='Your confirmation password is required.']")
        public WebElement newPasswordConfirmRequiredText;

        @FindBy(xpath = "//*[text()='Your confirmation password is required to be at least 4 characters.']")
        public WebElement NewPasswordConfirmCharCheckText;

        @FindBy(xpath = "//*[text()='The password and its confirmation do not match!']")
        public WebElement newPasswordConfirmMatchText;

        @FindBy(id="register-submit")
        public WebElement registerButton;

        @FindBy(xpath = "//*[text()='Login name already used!']")
        public WebElement loginAlreadyUsedToastContainer;

        @FindBy(xpath = "//*[text()='This SSN has been registered for another user!']")
        public WebElement sSNAlreadyUsedToastContainer;

        @FindBy(xpath = "//*[text()='Email is already in use!']")
        public WebElement emailAlreadyUsedToastContainer;

        @FindBy(xpath = "//*[contains(text(),'Registration Saved')]")
        public WebElement successMessageToastContainer;

        @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(255, 0, 0)')]")
        public WebElement passwordStrength1;

        @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(255, 153, 0)')]")
        public WebElement passwordStrength2;

        @FindBy(xpath= "//*[@id='strengthBar']/li[contains(@style,'rgb(153, 255, 0)')]")
        public  WebElement passwordStrength3;

        @FindBy(xpath= "//*[@id='strengthBar']/li[contains(@style,'rgb(0, 255, 0)')]")
        public  WebElement passwordStrength4;

        @FindBy(xpath = "//*[contains(text(), 'Your email is required.')]")
        public WebElement requiredEmailText;






}









