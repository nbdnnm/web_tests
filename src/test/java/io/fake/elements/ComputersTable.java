package io.fake.elements;

import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.Table;

public class ComputersTable extends Table {
    /**
     * Specifies {@link WebElement} representing table tag.
     *
     * @param wrappedElement {@code WebElement} to wrap.
     */
    public ComputersTable(WebElement wrappedElement) {
        super(wrappedElement);
    }

}
