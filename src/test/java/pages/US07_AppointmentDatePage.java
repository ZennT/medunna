package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US07_AppointmentDatePage {

    public US07_AppointmentDatePage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

//    @FindBy(xpath = "//span[@class='d-none d-md-inline']")
//    public WebElement appointmentButton;

    @FindBy(xpath = "(//span[contains(text(),'Appointment DateTime')])[1]")
    public WebElement date_time_text;

    @FindBy(xpath = "//input[@id='appoDate']")
    public WebElement dateTextbox;

    @FindBy(xpath = "//span[normalize-space()='Appointment date can not be past date!']")
    public WebElement pastDateText;


}
