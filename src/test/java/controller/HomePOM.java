package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePOM {
    WebDriver driver;

    public HomePOM(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean isProductExist(String productName) {
        return driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and contains(text(), '" + productName + "')]")).isDisplayed();
    }

    public void clickProduct(String productName) {
        driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and contains(text(), '" + productName + "')]")).click();
    }

    public void isOnProductDetailPage() {
        Boolean productDetail = driver.findElement(By.id("inventory_item_container")).isDisplayed();

        assertEquals(true, productDetail);
    }

    public void navigatoToItemId(Number productId) {
        driver.navigate().to("https://www.saucedemo.com/inventory-item.html?id=" + productId);
    }

    public void isProductNotFound() {
        String notFound = driver.findElement(By.xpath("//div[@data-test='inventory-item-name']")).getText();

        assertEquals("ITEM NOT FOUND", notFound);
    }
}
