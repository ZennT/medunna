package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class    SignInPage {

    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "account-menu")
    public WebElement loginDropdown;

    @FindBy(xpath = "//*[contains(text(),'Sign in')]")
    public WebElement signDropdown;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(id = "rememberMe")
    public WebElement rememberMe;




}
