package step_definitions;

import Pages.ContactUsPage;
import Pages.DashboardPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.List;

public class Contact {
    DashboardPage dashboardPage=new DashboardPage();
    ContactUsPage contactUsPage=new ContactUsPage();
    @Given("the user is on the main page")
    public void the_user_is_on_the_main_page() throws InterruptedException {
       //WebDriver driver = Driver.get(); (Singleton pattern)
        String url=ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(3);
        dashboardPage.AcceptCookies.click();


    }



    @When("the user navigates to {string}")
    public void the_user_navigates_to(String string) {
        BrowserUtils.waitForClickablility(dashboardPage.ContactUs, 5);

        dashboardPage.ContactUs.click();

        BrowserUtils.waitFor(2);

    }



    @Then("the user should see the page title as {string}")
    public void the_user_should_see_the_page_title_as(String PageTitle) {

        String ActualPageTitle=Driver.get().getTitle();
       assertEquals(PageTitle,ActualPageTitle);

    }

    @Given("user is on the contact us page")
    public void user_is_on_the_contact_us_page() {
        String url=ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(3);
        dashboardPage.AcceptCookies.click();
        dashboardPage.ContactUs.click();
        BrowserUtils.waitFor(3);
    }



    @When("the user fills following areas")
    public void the_user_fills_following_areas(DataTable dataTable) {
        List<List<String>> datalist=dataTable.cells();
        datalist.get(0).get(1);//firstname data
        System.out.println( datalist.get(0).get(1));
        datalist.get(1).get(1);//lastame data
        datalist.get(2).get(1);//CompanyName
        datalist.get(3).get(1);//Jobtitle
        datalist.get(4).get(1);//Country

        BrowserUtils.waitFor(2);
        Driver.get().switchTo().frame(Driver.get().findElement(By.id("hs-form-iframe-0")));
        contactUsPage.countryName.sendKeys(datalist.get(4).get(1));
        contactUsPage.Firstname.sendKeys(datalist.get(0).get(1));
        contactUsPage.Lastname.sendKeys(datalist.get(1).get(1));
        contactUsPage.Companyname.sendKeys(datalist.get(2).get(1));
        contactUsPage.jobTitle.sendKeys(datalist.get(3).get(1));




    }
    @When("the user able to click {string}")
    public void the_user_able_to_click(String string) {
        contactUsPage.SubmitButton.click();
        BrowserUtils.waitFor(2);

    }


    @Then("the user should see {string} as error message")
    public void the_user_should_see_as_error_message(String Expected) {

        String ActualMessage=contactUsPage.ErrorMessage.getText();
        assertEquals(Expected,ActualMessage);

        Driver.get().switchTo().parentFrame();


    }

}
