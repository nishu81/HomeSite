package Pages;

import Utils.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalLoginPage {

    private WebDriver driver;
    Helpers helpers;

    public PersonalLoginPage(WebDriver driver) {
        this.driver = driver;
        helpers = new Helpers(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@id='customerLogInBtn']")
    WebElement loginButton;

    public Boolean isLoginButtonDisplayed(){
        helpers.waitIsClickable(loginButton);
        if(loginButton.isDisplayed()){
            return true;
        }
        else{
            return false;
        }
    }
}
