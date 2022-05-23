package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public  class ContactUsPage extends BasePage {


    @FindBy(xpath = "//input[@type='submit']")
    public WebElement SubmitButton;

    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement Firstname;

    @FindBy(name = "lastname")
    public WebElement Lastname;

    @FindBy(xpath = "//input[@name='company']")
    public WebElement Companyname;

    @FindBy(xpath = "//input[@name='country']")
    public WebElement countryName;

    @FindBy(xpath = "//input[@name='jobtitle']")
    public WebElement jobTitle;

    @FindBy(xpath = "//label[normalize-space(text())='Please complete all required fields.']")
    public WebElement ErrorMessage;





    }
