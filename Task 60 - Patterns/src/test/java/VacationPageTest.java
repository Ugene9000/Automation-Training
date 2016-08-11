import base.TestBase;
import org.testng.annotations.Test;
import pages.VacationPage;

/**
 * Created by eugene_z on 8/11/16.
 */
public class VacationPageTest extends TestBase {

    @Test
    public void checkElementsVacationPage() {
        VacationPage vacationPage = new VacationPage(getDriver());
        vacationPage.loadPage();
        checkElements(vacationPage.getListOfElements());
    }
}
