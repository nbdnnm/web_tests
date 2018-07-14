package io.fake;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSUtils {

    public static void waitPageToBeReady(WebDriver driver) {
        (new WebDriverWait(driver, 5000)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                JavascriptExecutor js = (JavascriptExecutor) d;
                return (Boolean) js.executeScript("return document.readyState").equals("complete");
            }
        });
    }
}
