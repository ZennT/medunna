package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US06_UserSettingPage {
    public US06_UserSettingPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    @FindBy(xpath="//*[@id='account-menu']/a/span")
    public WebElement userIcon;
    @FindBy(xpath = "//*[@id='account-menu']/div/a[1]/span")
    public WebElement settingbutton;

    @FindBy(id="firstName")
    public WebElement firstName;
    @FindBy(id="lastName")
    public WebElement lastName;
    @FindBy(id="email")
    public WebElement email;

    @FindBy(xpath = "//*[text()='Your FirstName is required.']")
    public WebElement firstnameFeedBack;
    @FindBy(xpath = "//*[text()='Your LastName is required.']")
    public WebElement lastnameFeedBack;
    @FindBy(xpath="//*[text()='Your email is required.']")
    public WebElement emailFeedBack;

    @FindBy(xpath = "//*[@id='root']/div/div/div[1]/div/div/div[1]/span/strong")
    public WebElement successfulMessage;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

}
