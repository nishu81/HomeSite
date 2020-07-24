import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://go.homesite.com/");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@class='button-login' and contains(text(),'Log In') ]")).click();
        Thread.sleep(3000);

        List<WebElement> lst = driver.findElements(By.xpath("//div[@class='button-login' and contains(text(),'Log In') ]/..//div[@id='divbio']/ul/li"));
        for (WebElement ele : lst) {
            System.out.println(ele.getText());
        }
    }
}
