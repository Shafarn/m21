package StepDef;

import config.BaseTest;
import controller.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepDef extends BaseTest {
    protected LoginPage loginPage = new LoginPage(driver);

    @Given("^user is on login page$")
    public void userIsOnLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("user input username with {string}")
    public void userInputCorrectUsername(String username) {
        loginPage.inputUsername(username);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        loginPage.inputPassword(password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        loginPage.pressLogin();
    }

    @Then("user is at the homepage")
    public void userWillBeOnHomepage() {
        Boolean inventoryList = driver.findElement(By.className("inventory_list")).isDisplayed();

        assertEquals(inventoryList, true);
    }

    @Then("user will show error message {string}")
    public void userWillShowErrorMessage(String errorMessage) {
        String error = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();

        assertEquals(error, errorMessage);
    }
}
