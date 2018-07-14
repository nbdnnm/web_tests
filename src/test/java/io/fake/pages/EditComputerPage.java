package io.fake.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class EditComputerPage extends BaseWebPage{

    @FindBy(id = "name")
    private TextInput computerName;

    @FindBy(id = "introduced")
    private TextInput introducedDate;

    @FindBy(id = "discontinued")
    private TextInput discontinuedDate;

    @FindBy(id = "company")
    private Select company;

    @FindBy(xpath = "//input[@value='Save this computer']")
    private Button saveComputer;

    @FindBy(xpath = "//input[@value='Delete this computer']")
    private Button deleteComputer;

    public EditComputerPage(WebDriver driver) {
        super(driver);
    }

    public EditComputerPage setComputerName(String computerName) {
        this.computerName.clear();
        this.computerName.sendKeys(computerName);
        return this;
    }

    public EditComputerPage setIntroducedDate(String introducedDate) {
        this.introducedDate.clear();
        this.introducedDate.sendKeys(introducedDate);
        return this;
    }

    public EditComputerPage setDiscontinuedDate(String discontinuedDate) {
        this.discontinuedDate.clear();
        this.discontinuedDate.sendKeys(discontinuedDate);
        return this;
    }

    public EditComputerPage setCompany(String companyName) {
        company.selectByVisibleText(companyName);
        return this;
    }

    public ComputersPage saveComputer() {
        this.saveComputer.click();
        return new ComputersPage(driver);
    }

    public ComputersPage deleteComputer() {
        deleteComputer.click();
        return new ComputersPage(driver);
    }
}
