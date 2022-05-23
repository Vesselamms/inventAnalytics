package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;




public abstract class BasePage {
    @FindBy(xpath = "//ul[@class='uk-navbar-nav uk-visible@l']//a[@href='/contact-us/']")
    public WebElement ContactUs;

    @FindBy(id = "hs-eu-confirmation-button")
    public WebElement AcceptCookies;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

}
