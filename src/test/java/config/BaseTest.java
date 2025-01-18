package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected static WebDriver driver;

    protected void getDriver() {
        WebDriverManager.chromedriver().setup();
        // Configure Chrome to run in headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Enable headless mode
        options.addArguments("--no-sandbox");  // Disable sandbox for Linux
        options.addArguments("--disable-dev-shm-usage");  // Solve limited resource problems in Docker

        // Instantiate the WebDriver with the options
        driver = new ChromeDriver(options);
    }

}
