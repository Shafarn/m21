package StepDef;

import config.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHook extends BaseTest {

    @Before
    public void beforeTest() {
        System.out.println("Driver Init");
        getDriver();
    }

    @After
    public void afterTest() {
        System.out.println("Driver Close");
        driver.quit();
    }
}
