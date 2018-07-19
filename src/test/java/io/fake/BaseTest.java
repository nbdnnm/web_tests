package io.fake;

import io.fake.utils.WebDriverUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

abstract public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        driver = new WebDriverUtils().getDriver();
//        driver.manage().window().maximize();
    }

    @Before
    public void setupTest() {
        driver.get("about:blank");
    }

    @AfterClass
    public static void teardownTest() {
        driver.close();
    }
}
