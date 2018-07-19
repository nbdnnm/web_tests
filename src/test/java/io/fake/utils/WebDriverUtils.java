package io.fake.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverUtils {

    private Logger logger = LoggerFactory.getLogger(WebDriverUtils.class);

    public WebDriver getDriver() {
        WebDriver driver = null;
        String driverType = System.getProperty("driverType", "chrome");
        String hubAddress = System.getProperty("hubAddress", "http://localhost:4444/wd/hub");
        switch (driverType) {
            case "chrome":
                try {
                    driver = new RemoteWebDriver(new URL(hubAddress), DesiredCapabilities.chrome());
                } catch (MalformedURLException e) {
                    logger.error("Error during remote webdriver initialization");
                }
                break;

            case "firefox":
                try {
                    driver = new RemoteWebDriver(new URL(hubAddress), DesiredCapabilities.firefox());
                } catch (MalformedURLException e) {
                    logger.error("Error during remote webdriver initialization");
                }
                break;

            default:
                logger.error("Wrong driver type " + driverType);
                logger.error("Using chrome as default");
                driver = new ChromeDriver();
        }
        return driver;
    }
}
