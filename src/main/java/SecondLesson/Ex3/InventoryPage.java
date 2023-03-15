package SecondLesson.Ex3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

class InventoryPage {
    private WebDriver driver;
    private By sortDropdown = By.className("product_sort_container");
    private By addToCartButton = By.xpath("//div[contains(text(), '%s')]/ancestor::div[@class='inventory_item_description']/following-sibling::div[@class='pricebar']/button");
    private By cartIcon = By.className("shopping_cart_link");
    private By cartItemCount = By.className("shopping_cart_badge");
    private By removeButton = By.xpath("//div[contains(text(), '%s')]/ancestor::div[@class='inventory_item_description']/following-sibling::div[@class='pricebar']/button[text()='REMOVE']");
    private By productPrice = By.xpath("//div[contains(text(), '%s')]/ancestor::div[@class='inventory_item_description']/following-sibling::div[@class='pricebar']/div");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnPage() {
        return driver.getTitle().equals("Swag Labs");
    }

    public void sortByPriceLowToHigh() {
        Select sortDropdownSelect = new Select(driver.findElement(sortDropdown));
        sortDropdownSelect.selectByValue("lohi");
    }

    public void addToCart(String productName) {
        driver.findElement(By.xpath(String.format(productName, addToCartButton))).click();
    }

    public void removeFromCart(String productName) {
        driver.findElement(By.xpath(String.format(productName, removeButton))).click();
    }

    public int getCartItemCount() {
        String itemCountString = driver.findElement(cartItemCount).getText();
        return itemCountString.isEmpty() ? 0 : Integer.parseInt(itemCountString);
    }

    public List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        List<WebElement> priceElements = driver.findElements(productPrice);
        for (WebElement priceElement : priceElements) {
            String priceString = priceElement.getText().substring(1);
            prices.add(Double.parseDouble(priceString));
        }
        return prices;
    }
}
