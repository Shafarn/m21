package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage {
    WebDriver driver;

    By inputTextUsername = By.xpath("//input[@data-test='username']");
    By inputTextPassword = By.xpath("//input[@data-test='password']");
    By btnLogin = By.xpath("//input[@data-test='login-button']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUsername(String username) {
        driver.findElement(inputTextUsername).sendKeys(username);
    }

    public void inputPassword(String password) {
        driver.findElement(inputTextPassword).sendKeys(password);
    }

    public void pressLogin() {
        driver.findElement(btnLogin).click();
    }

    public void loginUser(String username, String password) {
        this.driver.get("https://www.saucedemo.com/");
        this.inputUsername(username);
        this.inputPassword(password);
        this.pressLogin();
    }

    public void isOnHomepage() {
        Boolean inventoryList = driver.findElement(By.className("inventory_list")).isDisplayed();

        assertEquals(inventoryList, true);
    }

    public void isShowingErrorMessage(String errorMsg) {
        String error = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();

        assertEquals(error, errorMsg);
    }

    public void goToLoginPage() {
        this.driver.get("https://www.saucedemo.com/");
    }
}

