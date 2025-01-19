package StepDef;

import config.BaseTest;
import controller.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeStepDef extends BaseTest {
    LoginPage loginHelper;

    @Before
    public void beforeTest() {
        loginHelper = new LoginPage(driver);
        loginHelper.loginUser("standard_user", "secret_sauce");
    }

    @Then("check if this product exists {string}")
    public void userClickOnProduct(String title) {
        Boolean product = driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and contains(text(), '" + title + "')]")).isDisplayed();

        assertEquals(true, product);
    }

    @Then("user click on the product {string}")
    public void userClickOnTheProduct(String title) {
        driver.findElement(By.xpath("//div[@data-test='inventory-item-name' and contains(text(), '" + title + "')]")).click();
    }

    @Then("user is at product detail page")
    public void userIsAtProductDetailPage() {
        Boolean productDetail = driver.findElement(By.id("inventory_item_container")).isDisplayed();

        assertEquals(true, productDetail);
    }

    @Then("user change the inventory item id url to {int}")
    public void userChangeTheInventoryItemIdUrlTo(int productId) {
        driver.navigate().to("https://www.saucedemo.com/inventory-item.html?id=" + productId);
    }

    @Then("user will see item not found page")
    public void userWillSeeItemNotFoundPage() {
        String notFound = driver.findElement(By.xpath("//div[@data-test='inventory-item-name']")).getText();

        assertEquals("ITEM NOT FOUND", notFound);
    }
}