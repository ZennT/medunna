package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DoctorPage {

    public DoctorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "entity-menu")
    public WebElement myPagesDropDown;

    @FindBy(xpath =  "(//*[contains(text(),'My Appointments')])[1]")
    public WebElement myAppointments;

    @FindBy(xpath = "//*[contains(text(),'Request Inpatient')]")
    public WebElement requestInpatient;

    @FindBy(id = "fromDate")
    public WebElement fromDate;

    @FindBy(id = "toDate")
    public WebElement toDate;

    @FindBy(xpath = "//div[@class='btn-group flex-btn-group-container']")
    public List<WebElement> editList;

    @FindBy(xpath = "(//div[@class='btn-group flex-btn-group-container'])[3]")
    public WebElement  edit1;

    @FindBy(xpath = "//textarea[@name='prescription']")
    public WebElement prescriptionField;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement descriptionField;

    @FindBy(xpath = "//*[contains(text(), 'This field is required.')]")
    public WebElement fieldRequiredText;

    @FindBy (xpath = "//a[@href='/logout']")
    public WebElement signOut;
    @FindBy(xpath = "(//div[@class='btn-group flex-btn-group-container'])[2]")
    public WebElement  edit2;

    @FindBy(xpath = "//*[contains(text(),'Show Test Results')]")
    public WebElement showTestResult;

    @FindBy(xpath = "(//div[@class='btn-group flex-btn-group-container'])[1]")
    public WebElement viewResult1;

    @FindBy(xpath = "//table/thead/tr")
    public List<WebElement> viewTestResultHeaderList;

    @FindBy(xpath = "//*[text()='InPatient request already done for this appointment']")
    public WebElement requestAlreadyDoneMessageToastContainer;











}
