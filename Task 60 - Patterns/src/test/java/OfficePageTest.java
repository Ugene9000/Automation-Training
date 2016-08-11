import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;
import pages.OfficePage;

import java.util.concurrent.TimeUnit;

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
    public void checkSearchByOfficeInput2() {
        OfficePage officePage = new OfficePage(getDriver());
        officePage.loadPage();
        waitWithPollingFrequency(2700, 15, officePage.getSearchByOffice());
    }
}
