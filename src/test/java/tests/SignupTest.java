package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ZohoSignupPage;

public class SignupTest extends BaseTest {
	
	@Test
	public void testSignupPage() throws InterruptedException
	{
		driver.get("https://www.zoho.com/signup.html");
		
		ZohoSignupPage signup = new ZohoSignupPage(driver);
		signup.enterEmail("sajkashr37@gmail.com");
		signup.enterPassword("12345");
		signup.enterMobileNumber("7934567890");
		signup.acceptTerms();
		signup.clickSignUp();
		
		System.out.println("Registration success.");
	}

}
