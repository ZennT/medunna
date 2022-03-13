package pages;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ValidateAppointmentPage {
    public ValidateAppointmentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "username")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;
    @FindBy(xpath ="//*[@id='entity-menu']/a/span")
    public WebElement mypages;
    @FindBy(xpath = "//*[@id='entity-menu']/div/a[1]/span")
    public WebElement myappointments;
    @FindBy(id="appointment-heading")
    public WebElement Heading;
    @FindBy(id="fromDate")
    public WebElement fromDate;
    @FindBy(id="toDate")


    public WebElement toDate;
    @FindBy(xpath = "(//*[tr])[1]")
    public WebElement AppointmentsTable;
    @FindBy(xpath = "(//*[tr])[2]")
    public WebElement InfoAppointmentsTable;

    @FindBy(xpath = "//thead//tr//th")
    public List<WebElement> appoinmentlist;





}
