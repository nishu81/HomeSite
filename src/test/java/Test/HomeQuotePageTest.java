package Test;

import Browser.LaunchBrowser;
import Pages.HomePage;
import Pages.HomeQuotePage;
import Utils.Helpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeQuotePageTest extends TestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        launchBrowser = new LaunchBrowser();
        driver = launchBrowser.launchSite("Chrome");
        driver.get("https://go.homesite.com/");
        /*helperMethods = new HelperMethods(driver);  ToDO How to use Test Method here
        helperMethods.getHomePage();*/
    }

    @Test
    public void successfulRegisterACustomer() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.startAQuoteByZip("98012");
        homeQuotePage = new HomeQuotePage(driver);
        Thread.sleep(8000); // ToDo How to use the spinner here
        testData = new TestData();
        homeQuotePage.registerForHomeQuote(testData.custMap());
        Thread.sleep(8000);
    }

    @AfterMethod
    public void tearDown() {
        helpers = new Helpers(driver);
        helpers.closeSession();
    }
}
