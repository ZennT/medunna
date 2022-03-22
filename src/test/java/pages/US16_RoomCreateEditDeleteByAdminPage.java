package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US16_RoomCreateEditDeleteByAdminPage {
    public US16_RoomCreateEditDeleteByAdminPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="(//a[@href='/room'])[2]" )
    public WebElement roomCta;

    @FindBy(xpath = "//*[text()='Create a new Room']")
    public WebElement createANewRoom;

    @FindBy(xpath = "//select[@id='room-roomType']")
    public WebElement roomTypeDropDown;

    @FindBy(xpath ="//input[@id='room-status']" )
    public WebElement statusCheck;

    @FindBy(xpath = "//input[@id='room-description']")
    public WebElement descriptionField;

    @FindBy(xpath = "//input[@id='room-createdDate']")
    public WebElement createdDate;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "(//*[text()='This field is required.'])[1]")
    public WebElement fieldRequiredRoom;

    @FindBy(xpath ="(//*[text()='This field is required.'])[2]" )
    public WebElement fieldRequiredPrice;

    @FindBy(xpath = "//input[@id='room-roomNumber']")
    public WebElement roomNumberTextBox;

    @FindBy(xpath = "//input[@id='room-price']")
    public WebElement priceTextBox;

    @FindBy(xpath = "//*[contains(text(), 'A new Room is created')]")
    public WebElement roomCreateSuccessMessage;

    @FindBy(xpath = "(//a[@class='page-link'])[9]")
    public WebElement lastPageArrow;

    @FindBy(xpath = "(//span[text()='Edit'])[last()]")
    public WebElement editButton;

    @FindBy(xpath = "(//span[text()='Delete'])[last()]")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[@id='jhi-confirm-delete-room']")
    public WebElement confirmDelete;

    @FindBy(xpath ="//*[contains(text(), 'deleted')]" )
    public WebElement roomDeleteSuccessMessage;
}
