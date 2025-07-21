package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.Signin;

public class SigninTest extends BaseTest {

    @Test
    public void signinPageTest() throws InterruptedException {
        driver.get("https://accounts.zoho.in/signin?servicename=ZohoRecruit&signupurl=https://www.zoho.com/recruit/signup.html");
        Signin signin = new Signin(driver);

        signin.enterEmailID("sajkashr37@gmail.com");
        signin.clickNext();
        signin.printErrorMessageIfAny();   // prints error if shown
        Thread.sleep(2000);                // optional: for visual confirmation
        signin.printSuccessTextIfAny();    // prints info/success message if any
    }
}
