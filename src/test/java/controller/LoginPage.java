package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By inputTextUsername = By.xpath("//input[@data-test='username']");
    By inputTextPassword = By.xpath("//input[@data-test='password']");
    By btnLogin = By.xpath("//input[@data-test='login-button']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        System.out.println(driver);
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
        driver.get("https://www.saucedemo.com/");
        inputUsername(username);
        inputPassword(password);
        pressLogin();
    }
}

