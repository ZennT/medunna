package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class StaffPage {
    public StaffPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="(//*[text()='MY PAGES'])[1]")
    public WebElement mypages;
    @FindBy(xpath = "(//*[text()='Search Patient'])[1]")
    public WebElement searchpatient;
    @FindBy(xpath="//*[@name='ssn']")
    public WebElement ssntextbox;
    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div[2]/div/table/tbody")
    public WebElement firstpatientinfo;
    @FindBy(xpath = "(//*[text()='Show Appointments'])[1]")
    public WebElement showappointment;
    @FindBy(xpath ="//*[text()='Show Tests']" )
    public WebElement showtest;
    @FindBy (xpath = "//span[text()='View Results']")
    public WebElement viewResultsButton;
    @FindBy(xpath = "//*[text()='Edit']")
    public WebElement editButton;
    @FindBy(xpath = "//*[contains(text(),'A Test Result is updated with identifier')]")
    public WebElement editSuccessToastContainer;
    @FindBy(id = "c-test-result-result")
    public WebElement resultTextBox;
    @FindBy(id="c-test-result-description")
    public WebElement descriptionTextBox;
    @FindBy(xpath = "//*[.='Save']")
    public WebElement editSaveButton;
    @FindBy(id="c-test-result-heading")
    public WebElement testresultheading;
    @FindBy(xpath = "//thead//tr//th")
    public List<WebElement> testresultlist;

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement accountMenu;
    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement signOutButton;




}