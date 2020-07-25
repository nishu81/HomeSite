package Test;

import Browser.LaunchBrowser;
import Pages.HomePage;
import Pages.HomeQuotePage;
import Pages.PersonalLoginPage;
import Utils.Helpers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class HomePageTest extends TestBase {

    public WebDriver driver;

    public ArrayList<String> expected2LoginValues() {
        ArrayList<String> ar = new ArrayList<String>();
        ar.add("Personal Insurance");
        ar.add("Commercial Insurance");
        return ar;
    }

    @BeforeMethod
    public void setup(){
        launchBrowser = new LaunchBrowser();
        driver = launchBrowser.launchSite("Chrome");
        driver.get("https://go.homesite.com/");
    }

    //There should be 7 choices for customer
    @Test
    public void insuranceOptionsDisplayed() throws InterruptedException {
        testData = new TestData();
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.iconsAreDisplayed(testData.getHomePageOptions7()));
    }

    //Upon clicking on Login- users should get 2 login choices
    @Test
    public void loginAsCommercialOrPerson() throws InterruptedException {
        testData = new TestData();
        homePage = new HomePage(driver);
        Assert.assertTrue(testData.get2Logins().equals(expected2LoginValues()));
    }

    //An user can access to personal login page through home page
    @Test
    public void navigateToPersonalLoginPage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.loginPersonalInsurance();
       personalLoginPage = new PersonalLoginPage(driver);
        Assert.assertTrue(personalLoginPage.isLoginButtonDisplayed());
    }

    //Start a new quote by valid zip code, user selects an area for Insurance such as Condo
    @Test
    public void startQuoteForCondo() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.startAQuoteByZipForAnArea("condo","98012");
    }

    //Start a new quote by valid zip code, user doesn't select an option , by default Home is selected
    @Test
    public void startQuoteForDefault() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.startAQuoteByZip("98012");
        homeQuotePage = new HomeQuotePage(driver);
        Assert.assertTrue(homeQuotePage.homeInsQuoteTextDisplayed());
    }
    @AfterMethod
    public void tearDown(){
        helpers = new Helpers(driver);
        helpers.closeSession();
    }
}
