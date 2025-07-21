package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void teardown() {
		if(driver!=null) {
			driver.quit();
			System.out.println("Driver closed successfully.");
		}
		
		else {
			
			System.out.println("There is no browser instance, Nothing to quit.");
			
		}
	}

}
