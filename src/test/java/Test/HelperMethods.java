package Test;

import Browser.LaunchBrowser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperMethods extends TestBase {

    public WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public HelperMethods(WebDriver driver){
        this.driver = driver;
        //wait = new WebDriverWait(driver, 15);
        //js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver,this);
    }

    //Method to get to home page
    public void getHomePage(){
        launchBrowser = new LaunchBrowser();
        driver = launchBrowser.launchSite("Chrome");
        driver.get("https://go.homesite.com/");
    }
}
