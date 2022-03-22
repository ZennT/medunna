package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US17_CreateUpdateDeleteTestItemPage {


        public US17_CreateUpdateDeleteTestItemPage(){
                PageFactory.initElements(Driver.getDriver(),this);
        }


        @FindBy(xpath = "//li[@id='account-menu']")
        public WebElement accountMenu;

        @FindBy(xpath = "//*[contains(text(),'Sign in')]")
        public WebElement signDropdown;

        @FindBy(xpath = "(//span)[16]")
        public WebElement singinPageHeader;

//        @FindBy(id = "username")
//        public WebElement username;
//
//        @FindBy(id = "password")
//        public WebElement password;
//
//        @FindBy(xpath = "//*[@type='submit']")
//        public WebElement singInButton;

        @FindBy(xpath = "//h1[text()='Welcome to MEDUNNA']")
        public WebElement homeText;

        @FindBy(xpath = "(//li[@id='entity-menu'])[1]")
        public WebElement itemsTitles;

        @FindBy(xpath = "(//a[@role='menuitem'])[5]")
        public WebElement testItem;

        @FindBy(xpath = "//a[@id='jh-create-entity']")
        public WebElement CreateTestItem;

        @FindBy(xpath = "//input[@id='c-test-item-name']")
        public WebElement testNameBox;

        @FindBy(xpath = "//input[@id='c-test-item-description']")
        public WebElement description;

        @FindBy(xpath = "//input[@id='c-test-item-price']")
        public WebElement price;

        @FindBy(xpath = "//input[@id='c-test-item-defaultValMin']")
        public WebElement minValue;

        @FindBy(xpath = "//input[@id='c-test-item-defaultValMax']")
        public WebElement maxValue;

        @FindBy(xpath = "//input[@id='c-test-item-createdDate']")
        public WebElement createDate;

        @FindBy(id = "save-entity")
        public WebElement saveButton;

        @FindBy(xpath = "//div[@id='app-view-container']")
        public WebElement savingSuccessMessage;

        @FindBy(xpath = "//div[@class='jh-card card']//li[7]")
        public WebElement arrowLastItem;

        @FindBy(xpath = "(//li[@class='page-item'])[5]")
        public WebElement lastFigureItem;

        @FindBy(xpath = "(//span[@class='d-none d-md-inline'])[45]")
        public WebElement deleteTestItem;

        @FindBy(xpath = "//button[@id='jhi-confirm-delete-cTestItem']")
        public WebElement confirmDeleteButton;

        @FindBy(xpath = "(//span[contains(text(),'Delete')])[17]")
        public WebElement deleteSuccessMessage;


}



