package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AppointmentPatientPage {

    public AppointmentPatientPage(){ PageFactory.initElements(Driver.getDriver(), this);  }

    @FindBy(xpath = "//*[text()='Make an']")
    public WebElement MakeAnAppointmentButton;

    @FindBy(id = "firstName")
    public WebElement firstnameTextbox;

    @FindBy(id = "lastName")
    public WebElement lastnameTextbox;

    @FindBy(id = "ssn")
    public WebElement ssnTextbox;

    @FindBy(id = "email")
    public WebElement emailTextbox;

    @FindBy(id = "phone")
    public WebElement phoneTextbox;

    @FindBy(id = "appoDate")
    public WebElement dateTextbox;

    @FindBy(xpath = "//*[text()='Send an Appointment Request']")
    public WebElement requestButton;


    @FindBy(xpath = "//*[text()='Appointment registration saved!']")
    public WebElement successMessageToastContainer;



    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement signinDropdown;

    @FindBy(xpath = "//*[text()='Register']")
    public WebElement registerButton;

    @FindBy(id = "username")
    public WebElement usernameTextbox;

    @FindBy(id = "firstPassword")
    public WebElement newPasswordTextbox;

    @FindBy(id = "secondPassword")
    public WebElement confirmPasswordTextbox;

    @FindBy(id = "register-submit")
    public WebElement register2Button;

    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement signin2Dropdown;

    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement sign_inButton;


    @FindBy(id = "password")
    public WebElement passwordTextbox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signin2Button;

    @FindBy(xpath = "//*[contains(text(),'PATIENT')]")
    public WebElement signInConfirmation;

    @FindBy(xpath = "//*[contains(text(),'Your SSN is invalid')]")
    public WebElement invalidSsnMessage;

    @FindBy(xpath = "//*[contains(text(),'This field is invalid')]")
    public WebElement invalidEmailMessage;

    @FindBy(xpath = "//*[contains(text(),'Phone number is invalid')]")
    public WebElement invalidPhoneNumberMessage;

    @FindBy(xpath = "//*[contains(text(),'Your FirstName is required.')]")
    public WebElement blankFirstnameMessage;

    @FindBy(xpath = "//*[contains(text(),'Your LastName is required.')]")
    public WebElement blankLastnameMessage;

    @FindBy(xpath = "//*[contains(text(),'Your SSN is required.')]")
    public WebElement blankSsnMessage;

    @FindBy(xpath = "//*[contains(text(),'Your email is required.')]")
    public WebElement blankEmailMessage;

    @FindBy(xpath = "//*[contains(text(),'Phone number is required.')]")
    public WebElement blankPhoneNumberMessage;

}