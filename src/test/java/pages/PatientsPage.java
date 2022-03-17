package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientsPage {
    public PatientsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Signing in from the homepage
    @FindBy(id="account-menu")
    public WebElement loginDropdown;

    @FindBy(xpath = "//*[contains(text(),'Sign in')]")
    public WebElement signInButton;

    @FindBy(xpath = "(//*[contains(text(),'Sign in')])[3]")
    public WebElement signInStaffButton;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;


    @FindBy(xpath = "//*[contains(text(),'Items&Titles')]")
    public WebElement itemsTitlesDrowdown;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement patientButton;

    @FindBy (xpath = "//*[text()='Patients']")
    public WebElement patientsInfoPageVisiblity;

    @FindBy(xpath = "//span[normalize-space()='admin admin']")    //ADMIN ADMIN DROPDOWN
    public WebElement adminAdminDropdown;

    @FindBy(xpath = "//span[normalize-space()='Sign out']")
    public WebElement signOutFromAdmin;

    @FindBy(xpath = "//*[contains(text(),'staff')]")       //STAFF DROPDOWN
    public WebElement staffDropdown;

    @FindBy(xpath = "//span[normalize-space()='Sign out']")
    public WebElement signOutStaff;






    //From the Patients page

    @FindBy (xpath = "(//*[contains(text(),'Edit')])[1]")
    public WebElement editButton;

    @FindBy(id = "app-view-container")   // Create or Edit a Patient page
    public WebElement createEditPatientPage;

    //Update the info on Create or edit a Patient section

    @FindBy (id="patient-firstName")
    public WebElement firstNameBox;

    @FindBy (id="patient-lastName")
    public WebElement lastNameBox;

    @FindBy (id = "patient-birthDate")
    public WebElement patientBirthDateBox;


    @FindBy (id="email")
    public WebElement emailBox;

    @FindBy (id="patient-phone")
    public WebElement phoneBox;

    @FindBy(id= "patient-gender")
    public WebElement genderDropdown;

    @FindBy(id = "patient-bloodGroup")
    public  WebElement bloodGroupBox;

    @FindBy (id = "patient-adress")
    public WebElement addressBox;

    @FindBy(id= "patient-description")
    public WebElement descriptionBox;

    @FindBy(id = "patient-user")
    public WebElement userBox;

    @FindBy(xpath = "//*[@id='patient-country']")
    public WebElement countryDropDown;

    @FindBy(name = "cstate.id")
    public WebElement stateCityDropDown;

    @FindBy(xpath = "//*[@id='save-entity']")
    public WebElement saveButton;

    @FindBy (xpath = "//*[contains(text(),'A Patient is updated')]")
    public WebElement toastMessage;

    // SEARCH PATIENT STAFF

    @FindBy (xpath = "//li[@id='entity-menu']")
    public WebElement myPagesDropdown;

    @FindBy (xpath = "//*[contains(text(),'Search Patient')]")
    public WebElement searchPatientButton;

    @FindBy (xpath = "//input[@name=\"ssn\"]")
    public WebElement patientSsnBox;


    // DELETE PATIENT ADMIN

    @FindBy (xpath = "(//*[contains(text(),'Delete')])[1]")
    public WebElement deletePatientButton;

    @FindBy (xpath = "//*[contains(text(),'Cancel')]")
    public WebElement cancelPopUpButton;

    @FindBy (id = "jhi-confirm-delete-patient")
    public WebElement confirmDeletePatientButton;

    @FindBy (xpath = "//*[contains(text(),'A Patient is deleted with identifier')]")
    public WebElement toastDeleteMessage;






}
