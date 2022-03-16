package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US12_DoctorRequestTestPage {

    public US12_DoctorRequestTestPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    //main page
    @FindBy(id ="account-menu")
    public WebElement loginButton;

    //first sign in button
    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    public WebElement signInButton1;

    @FindBy(xpath = "(//input[@id='username'])[1]")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    //second sign in button
    @FindBy(xpath = " //button[@type='submit']")
    public WebElement signInButton2;

    @FindBy(xpath = "//span[normalize-space()='MY PAGES']")
    public WebElement myPages;

    @FindBy(xpath = "//span[normalize-space()='My Appointments']")
    public WebElement myAppointments;

    @FindBy(xpath = "(//span[contains(text(),'Edit')])[1]")
    public WebElement editButton;

    @FindBy(xpath = "//a[normalize-space()='Request A Test']")
    public WebElement requestTestButton;

    @FindBy(id = "c-test-item-heading")
    public WebElement textOfTestItems;

    @FindBy(id = "1402")
    public WebElement urea;

    @FindBy(id = "1403")
    public WebElement creatinine;

    @FindBy(id = "1404")
    public WebElement sodium;

    @FindBy(id = "1405")
    public WebElement potassium;

    @FindBy(id = "1406")
    public WebElement totalProtein;

    @FindBy(id = "1407")
    public WebElement albumin;

    @FindBy(id = "1408")
    public WebElement hemoglobin;

}
