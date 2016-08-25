import base.TestBase;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;

/**
 * Created by eugene_z on 8/5/16.
 */
public class LoginPageTest extends TestBase {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loadPage();
        HomePage homePage = loginPage.login(getUSERNAME(), getPASSWORD());
        Assert.assertTrue(getDriver().getTitle().equals(homePage.getPageTitle()));
    }

    @Test
    public void testLoginInvalidUsername() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loadPage();
        HomePage homePage = loginPage.login(getUSERNAME()+"a", "a");
        getSoftAssert().assertTrue(loginPage.getInvalidCredentialsError().isDisplayed());
        Assert.assertTrue(getDriver().getTitle().equals(loginPage.getPageTitle()));
    }

    @Test
    public void testLoginWithNoUsernameProvided() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loadPage();
        HomePage homePage = loginPage.login("", "a");
        getSoftAssert().assertTrue(loginPage.getUsernameValidationError().isDisplayed());
        Assert.assertTrue(getDriver().getTitle().equals(loginPage.getPageTitle()));

    }

    @Test
    public void testLoginWithNoPasswordProvided() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loadPage();
        HomePage homePage = loginPage.login(getUSERNAME(), "");
        getSoftAssert().assertTrue(loginPage.getPasswordValidationError().isDisplayed());
        Assert.assertTrue(getDriver().getTitle().equals(loginPage.getPageTitle()));
    }

    @Test
    public void testLoginWithNoCredentialsProvided() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loadPage();
        HomePage homePage = loginPage.login("", "");
        getSoftAssert().assertTrue(loginPage.getUsernameValidationError().isDisplayed());
        getSoftAssert().assertTrue(loginPage.getPasswordValidationError().isDisplayed());
        Assert.assertTrue(getDriver().getTitle().equals(loginPage.getPageTitle()));
    }

    @Test
    public void checkElementsLoginPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loadPage();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.titleIs(loginPage.getPageTitle()));
        checkElements(loginPage.getListOfElements());
    }

}
