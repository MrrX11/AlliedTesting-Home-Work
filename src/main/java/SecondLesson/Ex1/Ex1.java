package SecondLesson.Ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ex1 {
    public static void main(String[] args) {
        // Set the path to the geckodriver executable
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        // Create a new Firefox driver instance
        WebDriver driver = new FirefoxDriver();

        // Navigate to the demoqa.com text box page
        driver.get("https://demoqa.com/text-box");

        // Find the full name input element and enter a value
        WebElement fullNameInput = driver.findElement(By.id("userName"));
        fullNameInput.sendKeys("Bors Marcel");

        // Find the email input element and enter a value
        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("marcel123@example.com");

        // Find the current address input element and enter a value
        WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
        currentAddressInput.sendKeys("str. Dacia 7");

        // Find the permanent address input element and enter a value
        WebElement permanentAddressInput = driver.findElement(By.id("permanentAddress"));
        permanentAddressInput.sendKeys("str. Teilor 5");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        submitButton.click();

        // Close the browser
        driver.quit();
    }
}
