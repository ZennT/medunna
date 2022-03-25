package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class StaffPage {
<<<<<<< HEAD
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
=======
    public StaffPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[normalize-space()='MY PAGES']")
    public WebElement myPagesDropdownButton;

    @FindBy(xpath = "//*[.='Search Patient']")
    public WebElement searchPatientButton;

    @FindBy(xpath = "//*[@name='ssn']")
    public WebElement searchSSNButton;

    @FindBy(xpath = "//*[text()='Show Appointments']")
    public WebElement showAppointments;

    @FindBy(xpath = "//div/div/div/div/div/table/tbody/tr/td/div/a[3]")
    public WebElement paymentInvoice;

    @FindBy(xpath = "//span[text()='COMPLETED']")
    public WebElement statusCompleted;

    @FindBy(xpath = "//*[text()='CANCELLED']")
    public WebElement statusCancelled;

    @FindBy(xpath = "//*[text()='UNAPPROVED']")
    public WebElement statusUnapproved;

    @FindBy(xpath = "(//*[text()='PENDING'])[1]")
    public WebElement statusPending;

    @FindBy(xpath = "//*[text()=' Create Invoice']")
    public WebElement createInvoice;

    @FindBy(xpath = "//*[text()=' Show Invoice']")
    public WebElement showInvoice;

    @FindBy(xpath = "//*[text()='INVOICE']")
    public WebElement invoiceText;

    @FindBy(xpath = "//*[.='Save']")
    public WebElement createBillSaveButton;

    @FindBy(xpath = "//tr[5]")
    public WebElement examFeeText;

    @FindBy(xpath = "//span[text()='Show Tests']")
    public WebElement showTestsButton;

    @FindBy (xpath = "//span[text()='View Results']")
    public WebElement viewResultsButton;

    @FindBy(xpath = "//*[text()='Edit']")
    public WebElement editButton;

    @FindBy(id = "c-test-result-result")
    public WebElement resultTextBox;

    @FindBy(id="c-test-result-description")
    public WebElement descriptionTextBox;

    @FindBy (xpath="//table")
    public WebElement testItemTable;

 @FindBy(xpath = "//*[contains(text(),'A Bill is updated with identifier')]")
    public WebElement paymentSuccessToastContainer;

 @FindBy(xpath = "//*[text()='No Patients found']")
    public WebElement noPatientsFoundMessage;

    @FindBy(xpath = "//span[text()='Sign out']")
    public WebElement signOutStaff;

    @FindBy(xpath = "//*[contains(text(),'staff')]")       //STAFF DROPDOWN
    public WebElement staffDropdown;

    @FindBy(xpath = "//*[@id='appointment-status']")
    public WebElement editStatusDropdown;

    @FindBy(xpath = "//*[@id='c-test-result-heading']")
    public WebElement testResultText;

    @FindBy(id="appointment-physician")
    public WebElement physicianDropdown;

    @FindBy(xpath = "//*[contains(text(),'Appointment is ')]")
    public WebElement patientSuccessToastContainer;

    @FindBy(xpath = "//div/div/div/div/div/table/tbody/tr/td[4]/span")
    public List<WebElement> statusList;

    @FindBy( xpath = "//textarea[1]")
    public WebElement anamnesisText;

    @FindBy( id="appointment-treatment")
    public WebElement treatmentText;

    @FindBy( id="appointment-diagnosis")
    public WebElement diagnosisText;



}
>>>>>>> master
