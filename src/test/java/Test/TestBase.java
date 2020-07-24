package Test;

import Browser.LaunchBrowser;
import Pages.HomePage;
import Pages.PersonalLoginPage;
import Utils.Helpers;

public class TestBase {

    protected LaunchBrowser launchBrowser;
    protected  TestData testData;
    protected Helpers helpers;
    protected HomePage homePage;
    protected PersonalLoginPage personalLoginPage;
}
