import base.TestBase;
import org.testng.annotations.Test;
import pages.OfficePage;

/**
 * Created by eugene_z on 8/11/16.
 */
public class OfficePageTest extends TestBase {

    @Test
    public void checkElementsOfficePage() {
        OfficePage officePage = new OfficePage(getDriver());
        officePage.loadPage();
        checkElements(officePage.getListOfElements());
    }

    @Test
    public void checkSearchByOfficeInput() {
        OfficePage officePage = new OfficePage(getDriver());
        officePage.loadPage();
        waitWithPollingFrequency(2700, 15, officePage.getSearchByOffice());
    }
}
