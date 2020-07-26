import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Main {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://go.homesite.com/");
        Thread.sleep(3000);


        driver.findElement(By.xpath("//input[@value='renters']/..//label")).click();
        driver.findElement(By.xpath("(//input[@id='zip'])[1]")).sendKeys("98012");
        // Thread.sleep(10000);
        driver.findElement(By.xpath("(//input[@id='submitGo'])[1]")).click();
        String urlValue=driver.getCurrentUrl();
        //Assert.assertTrue(urlValue.equals());

    }
}
