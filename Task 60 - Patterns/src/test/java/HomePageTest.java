import base.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;

/**
 * Created by eugene_z on 8/11/16.
 */
public class HomePageTest extends TestBase {

    @Test
    public void checkElementsHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.loadPage();
        checkElements(homePage.getListOfElements());
    }
}
