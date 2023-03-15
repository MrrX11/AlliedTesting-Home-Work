package ThirdLesson.Ex2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        SauceDemoTests tests = new SauceDemoTests(driver);

        tests.testLoginWithValidCredentials();
        tests.testLoginWithInvalidCredentials();
        tests.addItemToCart();
        tests.removeItemFromCart();
        tests.sortItemsByPrice();

        driver.quit();
    }
}