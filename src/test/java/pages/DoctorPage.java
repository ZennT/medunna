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
    public WebElement MyPagesDropDown;

    @FindBy(xpath =  "(//*[contains(text(),'My Appointments')])[1]")
    public WebElement MyAppointments;

    @FindBy(xpath = "//*[contains(text(),'Request Inpatient')]")
    public WebElement RequestInpatient;

    @FindBy(id = "fromDate")
    public WebElement fromDateBox;

    @FindBy(id = "toDate")
    public WebElement toDateBox;

    @FindBy(xpath = "//div[@class='btn-group flex-btn-group-container']")
    public List<WebElement> editList;

    @FindBy(xpath = "(//div[@class='btn-group flex-btn-group-container'])[1]")
    public WebElement  edit1;

}
