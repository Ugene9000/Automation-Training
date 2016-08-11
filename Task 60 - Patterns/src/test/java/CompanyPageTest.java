import base.TestBase;
import org.testng.annotations.Test;
import pages.CompanyPage;

/**
 * Created by eugene_z on 8/11/16.
 */
public class CompanyPageTest extends TestBase {

    @Test
    public void checkElementsCompanyPage() {
        CompanyPage companyPage = new CompanyPage(getDriver());
        companyPage.loadPage();
        checkElements(companyPage.getListOfElements());
    }
}
