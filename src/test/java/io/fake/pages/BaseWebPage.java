package io.fake.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

abstract public class BaseWebPage {

    protected WebDriver driver;
    protected String url;

    public BaseWebPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator
                (new HtmlElementLocatorFactory(driver)), this);
        this.driver = driver;
    }

    public BaseWebPage openPage() {
        driver.get(System.getProperty("applicationAddress", "http://computer-database.herokuapp.com/") + url);
        return this;
    }
}
