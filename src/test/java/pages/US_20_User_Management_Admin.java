package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pojos.Registrant;
import utilities.Driver;

public class US_20_User_Management_Admin {
public US_20_User_Management_Admin(){
    PageFactory.initElements(Driver.getDriver(),this);
}

    @FindBy(id = "admin-menu")
    public WebElement administrationDropdownButton;

    @FindBy(xpath = "//span[normalize-space()='User management']")
    public WebElement userManagementButton;

    @FindBy(xpath = "(//span[normalize-space()='View'])[1]")
    public WebElement viewButton;

    @FindBy (xpath = "//span[normalize-space()='Email']")
    public WebElement userInfoVisibility;

    @FindBy(xpath = "//span[normalize-space()='Create a new user']")
    public WebElement createAnewUserButton;

    @FindBy(name = "login")
    public WebElement loginUserNameBox;

    @FindBy(name="firstName")
    public WebElement firstNameBox;

    @FindBy (name="lastName")
    public WebElement lastNameBox;

    @FindBy (id = "email")
    public WebElement emailBox;

    @FindBy(id="ssn")
    public  WebElement ssnBox;

    @FindBy(id = "langKey")
    public WebElement languageDropDown;

    @FindBy(id= "authorities")
    public WebElement profiles;

    @FindBy (xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/button[1]/span[1]")
    public WebElement saveButton;

    @FindBy (xpath = "//*[contains(text(), 'A new user is created')]")
    public WebElement createdToastMessaga;

    @FindBy(xpath = "//a[normalize-space()='»»']")
    public WebElement goToLastPageButton;




    @FindBy(xpath = "(//*[contains(text(),'Delete')])[last()]")
    public WebElement deleteLastCreated;




    @FindBy (xpath = "//button[@type='button']//span[contains(text(),'Delete')]")
    public WebElement deleteConfirm;

    @FindBy(xpath = "//*[@class='Toastify__toast-body']")
    public WebElement deleteToastMessage;




















}
