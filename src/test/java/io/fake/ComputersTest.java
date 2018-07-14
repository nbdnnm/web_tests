package io.fake;

import io.fake.pages.ComputersPage;
import io.fake.pages.NewComputerPage;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputersTest extends BaseTest {

    String introducedDateInCreate = "2012-12-12";
    String discontinuedDateInCreate = "2012-12-13";
    String introducedDateInTable = "12 Dec 2012";
    String discontinuedDateInTable = "13 Dec 2012";
    String companyName = "IBM";

    @Test
    public void createAndReadComputer() {
        String computerName = String.valueOf(UUID.randomUUID());
        ComputersPage computersPage = createNewComputer(computerName);

        List<String> foundNewComputer = computersPage
                .setSearchField(computerName)
                .clickSearchButton()
                .getComputersTable()
                .getRowsAsString()
                .get(0);

        assertThat(foundNewComputer)
                .contains(computerName, introducedDateInTable, discontinuedDateInTable, companyName);
    }

    @Test
    public void updateComputer() {
        String newIntroducedDateInCreate = "2014-12-12";
        String newDiscontinuedDateInCreate = "2014-12-13";
        String newIntroducedDateInTable = "12 Dec 2014";
        String newDiscontinuedDateInTable = "13 Dec 2014";
        String newCompanyName = "Atari";

        String oldComputerName = String.valueOf(UUID.randomUUID());
        String newComputerName = String.valueOf(UUID.randomUUID());
        List<String> computerAfterChanges = createNewComputer(oldComputerName)

                //find new computer
                .setSearchField(oldComputerName)
                .clickSearchButton()
                .openComputer(oldComputerName)

                //edit this computer
                .setComputerName(newComputerName)
                .setIntroducedDate(newIntroducedDateInCreate)
                .setDiscontinuedDate(newDiscontinuedDateInCreate)
                .setCompany(newCompanyName)
                .saveComputer()

                //get updated computer
                .setSearchField(newComputerName)
                .clickSearchButton()
                .getComputersTable()
                .getRowsAsString()
                .get(0);

        assertThat(computerAfterChanges)
                .contains(newComputerName, newIntroducedDateInTable, newDiscontinuedDateInTable, newCompanyName);
    }

    @Test
    public void deleteComputer(){
        String computerName = String.valueOf(UUID.randomUUID());
        boolean deletedComputerCanBeFound = createNewComputer(computerName)
                .setSearchField(computerName)
                .clickSearchButton()
                .openComputer(computerName)
                .deleteComputer()
                .setSearchField(computerName)
                .clickSearchButton()
                .resultTableExist();

        assertThat(deletedComputerCanBeFound).isFalse();
    }

    private ComputersPage createNewComputer(String computerName) {
        NewComputerPage newComputerPage = new NewComputerPage(driver);
        newComputerPage.openPage();
        return newComputerPage
                .setComputerName(computerName)
                .setIntroducedDate(introducedDateInCreate)
                .setDiscontinuedDate(discontinuedDateInCreate)
                .setCompany(companyName)
                .createComputer();
    }
}
