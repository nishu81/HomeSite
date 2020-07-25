package Pages;

import Utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Set;

public class HomeQuotePage {

    private WebDriver driver;
    Helpers helpers;

    public HomeQuotePage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='banner__text']/span[contains(text(),'Your Personalized Home Insurance')]")
    WebElement homeInsuranceQuoteText;

    @FindBy(xpath = "//div[contains(text(),'This question is required for a quote.')]")
    WebElement blankFieldWarning;

    @FindBy(xpath = "//div[@id='errorArea--DateOfBirth']")
    WebElement dobError;


    public Boolean homeInsQuoteTextDisplayed() {
        helpers.waitIsPresent(homeInsuranceQuoteText);
        if (homeInsuranceQuoteText.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    //Validation for Date of birth
    public Boolean isDobErrorDisplayed(){
        if(dobError.isDisplayed()){
            return true;
        }
        else{
            return false;
        }
    }

    //Method to Register new user for Home Quote with data
    public void registerForHomeQuote(HashMap<String, String> userData) {
        Set<String> userKeys = userData.keySet();
        for (String values : userKeys) {
            helpers.waitIsPresent(driver.findElement(By.xpath("//input[@id='" + values + "']")));
            driver.findElement(By.xpath("//input[@id='" + values + "']")).sendKeys(userData.get(values));
        }
    }

    //Method to show warning for blank fields
    public Boolean requiredFieldsBlankWarning(HashMap<String, String> userDataBlank) {
        boolean isShown = false;
        Set<String> userKeys = userDataBlank.keySet();
        for (String values : userKeys) {
            driver.findElement(By.xpath("//input[@id='" + values + "']")).sendKeys(Keys.TAB);
            if (blankFieldWarning.isDisplayed()) {
                isShown = true;
            } else {
                isShown = false;
            }
        }
        return isShown;
    }
}
