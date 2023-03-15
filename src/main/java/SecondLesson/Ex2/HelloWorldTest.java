package SecondLesson.Ex2;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HelloWorldTest {
    static final String BASE_URL = "https://demoqa.com/automation-practice-form";
    static private WebDriver driver;

    @BeforeClass
    static public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void helloWorldTest() throws InterruptedException {
        System.out.println("Start helloWorldTest");
        driver.get(BASE_URL);
        Thread.sleep(2000);

        WebElement firstName = driver.findElement(By.xpath("//*[@id='firstName']"));
        firstName.clear();
        firstName.sendKeys("Marcel");

        System.out.println("Finish helloWorldTest");
    }

    @AfterClass
    static public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}