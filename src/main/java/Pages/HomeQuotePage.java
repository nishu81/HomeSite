package Pages;

import Utils.Helpers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
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

    @FindBy(xpath = "//input[@id='DateOfBirth']")
    WebElement dobField;

    @FindBy(xpath = "//div[@id='errorArea--PhoneNumber']")
    WebElement phoneError;

    @FindBy(xpath = "//input[@id='PhoneNumber']")
    WebElement phoneField;

    public Boolean homeInsQuoteTextDisplayed() {
        helpers.waitIsPresent(homeInsuranceQuoteText);
        if (homeInsuranceQuoteText.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    //Validation for Date of birth
    public Boolean isDobErrorDisplayed() {
        if (dobError.isDisplayed()) {
            return true;
        } else {
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

    //Method for Date validation
    public Boolean isDateValueCorrect(ArrayList<String> dates) {
        boolean errorShown = true;
        for (String invalidDates : dates) {
            dobField.sendKeys(invalidDates);
            if (!dobError.isDisplayed()) {
                errorShown = false;
                driver.navigate().refresh();
            }
        }
        return errorShown;
    }

    public String selectState(String stateValue){
        WebElement selState = driver.findElement(By.xpath("//select[@id='PropertyState']"));
        Select selectState = new Select(selState);
        selectState.selectByValue(stateValue);
        return stateValue;
    }

    /* public void validationOfInputData(WebElement element, String valueToBeTypes, String expectedErrorMessage)
     {
         element.sendKeys(valueToBeTypes);
         if(!expectedErrorMessage.equals(""))
             Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'"+expectedErrorMessage+"')]")).isDisplayed());

     }*/
    public void validationOfInputData(ArrayList<String> incorrectDates,ArrayList<String> incorrectPhones) throws InterruptedException {
        for (String invalidDate : incorrectDates) {
           dobField.sendKeys(invalidDate);
           Thread.sleep(3000);
           helpers.waitIsPresent(dobError);
           Assert.assertTrue(dobError.isDisplayed());
           dobField.clear();
        }
        for (String invalidPhone : incorrectPhones) {
            phoneField.sendKeys(invalidPhone);
            Thread.sleep(3000);
            helpers.waitIsPresent(phoneError);
            Assert.assertTrue(phoneError.isDisplayed());
            phoneField.clear();
        }

    }

}
