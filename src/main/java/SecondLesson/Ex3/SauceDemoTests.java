package SecondLesson.Ex3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class SauceDemoTests {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static InventoryPage inventoryPage;

    @BeforeClass
    public static void setUp() {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");



        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @Test
    public void loginWithValidCredentials() {
        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");
        assert inventoryPage.isOnPage();
    }

    @Test
    public void loginWithInvalidCredentials() {
        loginPage.navigateTo();
        loginPage.login("invalid_user", "invalid_password");
        assert loginPage.hasErrorMessage();
    }

    @Test
    public void addItemToCart() {
        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart("Sauce Labs Backpack");
        assert inventoryPage.getCartItemCount() == 1;
    }

    @Test
    public void removeItemFromCart() {
        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.addToCart("Sauce Labs Backpack");
        inventoryPage.removeFromCart("Sauce Labs Backpack");
        assert inventoryPage.getCartItemCount() == 0;
    }

    @Test
    public void sortItemsByPrice() {
        loginPage.navigateTo();
        loginPage.login("standard_user", "secret_sauce");
        inventoryPage.sortByPriceLowToHigh();
        List<Double> prices = inventoryPage.getProductPrices();
        for (int i = 0; i < prices.size() - 1; i++) {
            assert prices.get(i) <= prices.get(i+1);
        }
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        SauceDemoTests tests = new SauceDemoTests();
        tests.setUp();
        tests.loginWithValidCredentials();
        tests.loginWithInvalidCredentials();
        tests.addItemToCart();
        tests.removeItemFromCart();
        tests.sortItemsByPrice();
        tests.tearDown();
    }
}
