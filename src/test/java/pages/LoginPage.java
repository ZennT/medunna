package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//h1[text()='Welcome to MEDUNNA']")
    public WebElement homeText;

    @FindBy(xpath ="// *[contains(text(),'Sign out')]")
    public WebElement signOutButton;

    @FindBy(xpath = "//*[contains(text(),' Please check your credentials and try again.')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[text()='Cancel']")
    public WebElement cancelButton;

    @FindBy(id = "rememberMe")
    public WebElement rememberMeButton;

    @FindBy(xpath = "//*[contains(text(),'Did you forget')]")
    public WebElement didYouForgetPassword;

    @FindBy(xpath = "//*[contains(text(),'Enter the email address')]")
    public WebElement verifyingMessage;

    @FindBy(id = "email")
    public WebElement newEmail;

    @FindBy(xpath = "//*[contains(text(),'Reset password')]")
    public WebElement resetPassword;

    @FindBy(xpath = "//*[contains(text(),'Check your emails ')]")
    public WebElement checkMailMessage;

    @FindBy(id = "app-header")
    public WebElement registerNewAccount;



}

