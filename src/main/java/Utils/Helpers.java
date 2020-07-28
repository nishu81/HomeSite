package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {

    private WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public Helpers(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean waitIsPresent(By element) {
        // wait.until(ExpectedConditions.visibilityOf(element));
//        try {
//            wait.until(ExpectedConditions.visibilityOf(element));
//            return true;
//        } catch (NoSuchElementException | TimeoutException e) {
//            return false;
//        }

        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return true;
    }


    public Boolean waitIsPresent(WebElement element) {
        // wait.until(ExpectedConditions.visibilityOf(element));
//        try {
//            wait.until(ExpectedConditions.visibilityOf(element));
//            return true;
//        } catch (NoSuchElementException | TimeoutException e) {
//            return false;
//        }

        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }

    public Boolean waitIsClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean waitTillInvisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void waitForPageToLoad() {
        for (int i = 0; i < 11; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }

    public void closeSession(){
        driver.quit();
    }
}
