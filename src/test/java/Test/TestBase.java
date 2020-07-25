package Test;

import Browser.LaunchBrowser;
import Pages.HomePage;
import Pages.HomeQuotePage;
import Pages.PersonalLoginPage;
import Utils.Helpers;

public class TestBase {

    protected LaunchBrowser launchBrowser;
    protected  TestData testData;
    protected Helpers helpers;
    protected HelperMethods helperMethods;
    protected HomePage homePage;
    protected PersonalLoginPage personalLoginPage;
    protected HomeQuotePage homeQuotePage;
    protected HomePageTest homePageTest;
    protected HomeQuotePageTest homeQuotePageTest;
}
