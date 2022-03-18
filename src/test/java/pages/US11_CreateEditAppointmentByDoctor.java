package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US11_CreateEditAppointmentByDoctor {


    public US11_CreateEditAppointmentByDoctor() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//*[@id='appointment-id']")
    public WebElement idField;

    @FindBy(xpath = "(//input[@class='form-control is-untouched is-pristine av-valid form-control'])[1]")
    public WebElement startDateTime;

    @FindBy(xpath = "(//input[@class='form-control is-untouched is-pristine av-valid form-control'])[2]")
    public WebElement endDateTime;

    @FindBy(xpath = "//select[@id='appointment-status']")
    public WebElement statusDropDown;

    @FindBy(xpath = "//textarea[@name='anamnesis']")
    public WebElement anamnesisField;

    @FindBy(xpath = "//textarea[@name='treatment']")
    public WebElement treatmentField;

    @FindBy(xpath = "//textarea[@name='diagnosis']")
    public WebElement diagnosisField;

    @FindBy(xpath = "//textarea[@name='prescription']")
    public WebElement prescriptionField;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement descriptionField;

    @FindBy(xpath = "//select[@id='appointment-physician']/option[20]")
    public WebElement physicianField;

    @FindBy(xpath = "//select[@id='appointment-patient']/option[17]")
    public WebElement patientField;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[text()='Back']")
    public WebElement backButton;

    @FindBy(xpath = "//*[@id='root']/div/div/div[1]/div/div/div[1]")
    public WebElement appointmentSavedMessage;

}
