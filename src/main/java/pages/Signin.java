package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signin {

    WebDriver driver;

    private By userEmail = By.id("login_id");
    private By nextButton = By.id("nextbtn");
    private By errorMsg = By.xpath("//div[text()='This account cannot be found. Please use a different account or ']");

    public Signin(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmailID(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userEmail));
        driver.findElement(userEmail).clear();
        driver.findElement(userEmail).sendKeys(email);
    }

    public void clickNext() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        driver.findElement(nextButton).click();
    }

    public void printErrorMessageIfAny() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
            String message = driver.findElement(errorMsg).getText();
            if (message != null && !message.trim().isEmpty()) {
                System.out.println("Zoho Sign-in Error: " + message);
            } else {
                System.out.println("No error message, most likely sign in page progressed.");
            }
        } catch (Exception e) {
            System.out.println("No visible error element found after sign-in attempt.");
        }
    }

    public void printSuccessTextIfAny() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By infoText = By.id("portaldomain");
            wait.until(ExpectedConditions.visibilityOfElementLocated(infoText));
            String msg = driver.findElement(infoText).getText();
            if (msg != null && !msg.trim().isEmpty())
                System.out.println("Success/info: " + msg);
        } catch (Exception e) {
            // ignore if not present
        }
    }
}
