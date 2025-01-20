package StepDef;

import config.BaseTest;
import controller.HomePOM;
import controller.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeStepDef extends BaseTest {
    LoginPage loginHelper;
    HomePOM homeHelper;

    @Before
    public void beforeTest() {
        loginHelper = new LoginPage(driver);
        loginHelper.loginUser("standard_user", "secret_sauce");
    }

    @Then("check if this product exists {string}")
    public void userClickOnProduct(String title) {
        Boolean product = homeHelper.isProductExist(title);

        assertEquals(true, product);
    }

    @Then("user click on the product {string}")
    public void userClickOnTheProduct(String title) {
        homeHelper.clickProduct(title);
    }

    @Then("user is at product detail page")
    public void userIsAtProductDetailPage() {
        homeHelper.isOnProductDetailPage();
    }

    @Then("user change the inventory item id url to {int}")
    public void userChangeTheInventoryItemIdUrlTo(int productId) {
        homeHelper.navigatoToItemId(productId);
    }

    @Then("user will see item not found page")
    public void userWillSeeItemNotFoundPage() {
        homeHelper.isProductNotFound();
    }
}