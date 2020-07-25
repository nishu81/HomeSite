package Test;

import java.util.ArrayList;
import java.util.HashMap;

public class TestData {

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

        return cust;
    }
}
