package SecondLesson.Ex3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class LoginPage {
    private WebDriver driver;
    private String url = "https://www.saucedemo.com/";
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateTo() {
        driver.get(url);
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean hasErrorMessage() {
        return driver.findElements(errorMessage).size() > 0;
    }
}