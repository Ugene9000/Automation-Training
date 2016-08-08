import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

/**
 * Created by eugene_z on 8/5/16.
 */
public class LoginPageTest extends TestBase {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loadPage();
        HomePage homePage = loginPage.login("eugenzubritsky", "a");
        Assert.assertTrue(getDriver().getTitle().equals(homePage.getPageTitle()));
    }




}
