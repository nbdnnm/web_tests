package io.fake.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class NewComputerPage extends BaseWebPage {

    @FindBy(id = "name")
    private TextInput computerName;

    @FindBy(id = "introduced")
    private TextInput introducedDate;

    @FindBy(id = "discontinued")
    private TextInput discontinuedDate;

    @FindBy(id = "company")
    private Select company;

    @FindBy(xpath = "//input[@value='Create this computer']")
    private Button createComputer;

    public NewComputerPage(WebDriver driver) {
        super(driver);
        url = "computers/new";
    }

    public NewComputerPage setComputerName(String computerName) {
        this.computerName.sendKeys(computerName);
        return this;
    }

    public NewComputerPage setIntroducedDate(String introducedDate) {
        this.introducedDate.sendKeys(introducedDate);
        return this;
    }

    public NewComputerPage setDiscontinuedDate(String discontinuedDate) {
        this.discontinuedDate.sendKeys(discontinuedDate);
        return this;
    }

    public NewComputerPage setCompany(String companyName) {
        company.selectByVisibleText(companyName);
        return this;
    }

    public ComputersPage createComputer() {
        this.createComputer.click();
        return new ComputersPage(driver);
    }
}
