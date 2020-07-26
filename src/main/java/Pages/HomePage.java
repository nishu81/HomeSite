package Pages;

import Utils.Helpers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    private WebDriver driver;
    Helpers helpers;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='button-login' and contains(text(),'Log In') ]")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='button-login' and contains(text(),'Log In') ]/..//div[@id='divbio']/ul/li[1]/a")
    WebElement linkPersonalInsurance;

    @FindBy(xpath = "//div[@class='button-login' and contains(text(),'Log In') ]/..//div[@id='divbio']/ul/li[2]/a")
    WebElement linkCommercialInsurance;

    @FindBy(xpath = "(//input[@id='zip'])[1]")
    WebElement zipCodeText;

    @FindBy(xpath = "(//input[@id='submitGo'])[1]")
    WebElement buttonSubmit;

    @FindBy(xpath = "//div[@class='spinner spinner--processing']")
    WebElement spinner;



    //Expect 7 icons to be shown
    public Boolean iconsAreDisplayed(ArrayList<String> menuOptions) throws InterruptedException {
        boolean optionShown = true;
        Thread.sleep(3000);
        for (String value : menuOptions) {
            if (driver.findElement(By.xpath("//span[@class='" + value + "']")).isDisplayed()) {
                optionShown = true;
            } else {
                optionShown = false;
            }
        }
        return optionShown;
    }

    //Login Menu displayed
    public Boolean isLoginDisplayed() {
        if (loginButton.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    //2 Login choices displayed
    public ArrayList<String> differentrRoleTypes() throws InterruptedException {
        ArrayList<String> ar = new ArrayList<String>();
        driver.findElement(By.xpath("//div[@class='button-login' and contains(text(),'Log In') ]")).click();
        Thread.sleep(3000);

        List<WebElement> lst = driver.findElements(By.xpath("//div[@class='button-login' and contains(text(),'Log In') ]/..//div[@id='divbio']/ul/li"));
        for (WebElement ele : lst) {
            ar.add(ele.getText());
        }
        return ar;
    }

    //Login Link for Personal Ins
    public void loginPersonalInsurance() {
        helpers.waitIsClickable(loginButton);
        loginButton.click();
        helpers.waitIsClickable(linkPersonalInsurance);
        linkPersonalInsurance.click();
    }

    //Start quote by option by Zip - Zip code should be 5 digit
    public void startAQuoteByZipForAnArea(String insuranceArea, String code) {
        driver.findElement(By.xpath("//input[@value='" + insuranceArea + "']/../label")).click();
        zipCodeText.sendKeys(code);
        String codeStr = zipCodeText.getAttribute("value");
        int codeLen = codeStr.length();
        Assert.assertEquals(codeLen, 5);
        buttonSubmit.click();
        helpers.waitTillInvisible(spinner);
    }

    //Start quote default selection by Zip - Zip code should be 5 digit
    public void startAQuoteByZip(String code) {
        zipCodeText.sendKeys(code);
        String codeStr = zipCodeText.getAttribute("value");
        int codeLen = codeStr.length();
        Assert.assertEquals(codeLen, 5);
        buttonSubmit.click();
        helpers.waitTillInvisible(spinner);
    }

    // Test
    public void doTest(ArrayList<String> insOptions, String code) throws InterruptedException {
        for (String insuranceChoice : insOptions) {
            helpers.waitIsPresent(driver.findElement(By.xpath("//input[@value='" + insuranceChoice + "']/..//label")));
            driver.findElement(By.xpath("//input[@value='" + insuranceChoice + "']/..//label")).click();
            driver.findElement(By.xpath("(//input[@id='zip'])[1]")).sendKeys("98012");
            // Thread.sleep(10000);
            driver.findElement(By.xpath("(//input[@id='submitGo'])[1]")).click();
            String urlValue = driver.getCurrentUrl();
            Assert.assertTrue(urlValue.contains(insuranceChoice));
            driver.navigate().back();
        }
    }
}
