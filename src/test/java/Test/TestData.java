package Test;

import Pages.HomeQuotePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;

public class TestData {
    private WebDriver driver;
    HomeQuotePage hmq;

    public TestData(WebDriver driver) {
        this.driver = driver;
        hmq = new HomeQuotePage(driver);
    }

    public ArrayList<String> getHomePageOptions7() {
        ArrayList<String> ar = new ArrayList<String>();
        ar.add("icon-home");
        ar.add("icon-renters");
        ar.add("icon-condo");
        ar.add("icon-flood");
        ar.add("icon-condo");
        ar.add("icon-commercial");
        ar.add("icon-auto");
        return ar;
    }

    public ArrayList<String> get2Logins() {
        ArrayList<String> ar = new ArrayList<String>();
        ar.add("Personal Insurance");
        ar.add("Commercial Insurance");
        return ar;
    }

    //Data for New Customer Registration
    public HashMap<String, String> custMap() {
        HashMap<String, String> cust = new HashMap<String, String>();
        cust.put("FirstName", "James");
        cust.put("LastName", "Roy");
        cust.put("DateOfBirth", "04/13/1982");
        cust.put("Email", "James1981@go.com");
        cust.put("PhoneNumber", "888-888-8888");
        cust.put("PropertyAddressLine1", "12111 kames road");
        cust.put("PropertyCity", "Mill Creek");
        cust.put("PropertyState", "WA");
        return cust;
    }

    //Validate by insurance area choice
    public ArrayList<String> getTitleByChoice() {
        ArrayList<String> ar = new ArrayList<String>();
        ar.add("home");
        ar.add("renters");
        ar.add("condo");
        return ar;
    }

    //Validate by invalid Date of Birth
    public ArrayList<String> getinvalidData() {
        ArrayList<String> ar = new ArrayList<String>();
        ar.add("23/05");
        ar.add("07/12");
        ar.add("07/12/20");
        return ar;
    }

    //Validate by invalid Phone number
    public ArrayList<String> getinvalidPhone() {
        ArrayList<String> ar = new ArrayList<String>();
        ar.add("abc");
        ar.add("#44");
        ar.add("952");
        return ar;
    }

    //HashMap for Error validation of Date
    public HashMap<String, String> valueErrorMapForDOBField() {
        HashMap<String, String> wrongData = new HashMap<String, String>();
        wrongData.put("23/05", "Please enter a date between");
        wrongData.put("01/01/2002", "No error message");
        return wrongData;
    }

    //HashMap for Error validation  Phone
    public HashMap<String, String> valueErrorMapForPhoneField() {
        HashMap<String, String> wrongData = new HashMap<String, String>();
        wrongData.put("abc", "Please enter a valid phone number.");
        wrongData.put("#12", "Please enter a valid phone number.");
        return wrongData;
    }

}
