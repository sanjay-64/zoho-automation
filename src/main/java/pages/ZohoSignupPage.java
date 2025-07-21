package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZohoSignupPage {
	
	WebDriver driver;
	
	private By emailField = By.xpath("//input[@name='email']");
	private By passwordField = By.xpath("//input[@name='password']");
	private By mobileField = By.id("rmobile");
	private By checkBoxField = By.id("signup-termservice");
	private By signupButton = By.id("signupbtn");
	
	public ZohoSignupPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterEmail(String email)
	{
		driver.findElement(emailField).sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void enterMobileNumber(String phone)
	{
		driver.findElement(mobileField).sendKeys(phone);
	}
	
	public void acceptTerms()
	{
		driver.findElement(checkBoxField).click();
	}
	
	public void clickSignUp()
	{
		driver.findElement(signupButton).click();
	}
	

}
