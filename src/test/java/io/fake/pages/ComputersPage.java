package io.fake.pages;

import io.fake.elements.ComputersTable;
import io.fake.utils.JSUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class ComputersPage extends BaseWebPage {

    @FindBy(id = "searchbox")
    private TextInput searchField;

    @FindBy(id = "searchsubmit")
    private TextInput searchButton;

    @FindBy(className = "computers")
    private ComputersTable computersTable;


    public ComputersPage(WebDriver driver) {
        super(driver);
    }

    public ComputersPage setSearchField(String searchText) {
        searchField.sendKeys(searchText);
        return this;
    }

    public ComputersPage clickSearchButton() {
        searchButton.click();
        JSUtils.waitPageToBeReady(driver);
        return this;
    }

    public ComputersTable getComputersTable() {
        return computersTable;
    }

    public EditComputerPage openComputer(String computerName){
        this.driver.findElement(By.xpath("//*[text() = '"+computerName+"']")).click();
        return new EditComputerPage(driver);
    }

    public boolean resultTableExist() {
        return computersTable.exists();
    }
}
