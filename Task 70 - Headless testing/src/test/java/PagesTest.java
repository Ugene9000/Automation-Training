import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.CompanyPage;
import pages.HomePage;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by eugene_z on 8/17/16.
 */
public class PagesTest extends TestBase {

    @Test
    public void loginPageTestUsingHtmlUnit() throws Exception {
        WebDriver driver = new HtmlUnitDriver(false);
        LoginPage loginPage = new LoginPage(driver);
        driver.get(loginPage.getPageUrl());
        new FluentWait<>(driver).until(ExpectedConditions.titleIs(loginPage.getPageTitle()));
        checkElements(loginPage.getListOfElements());
        driver.close();
    }

    @Test
    public void loginPageTestUsingWebDriver() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        driver.get(loginPage.getPageUrl());
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs(loginPage.getPageTitle()));
        loginPage.login(TestBase.getUSERNAME(), TestBase.getPASSWORD());
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs(homePage.getPageTitle()));
        File printScr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(printScr, new File("./src/main/resources/screenshotChromeDriver.png"));
        driver.close();
    }

    @Test
    public void loginPageTestUsingPhantomJS() throws IOException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setJavascriptEnabled(true);
        desiredCapabilities.setCapability("takesScreenshot", true);
        desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "./src/main/resources/phantomjs-2.1.1-macosx/bin/phantomjs");
        WebDriver driver = new PhantomJSDriver(desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://192.168.0.100");
        Thread.sleep(10000);
        //LoginPage loginPage = new LoginPage(driver);
        //loginPage.loadPage();
        File printScr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(printScr, new File("./src/main/resources/screenshotPhantomJSDriver.png"));

        //loginPage.login(TestBase.getUSERNAME(),TestBase.getPASSWORD());
        HomePage homePage = new HomePage(driver);
        homePage.getCompanyTabLink().click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs(new CompanyPage(driver).getPageTitle()));
        //File printScr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(printScr, new File("./src/main/resources/screenshotPhantomJSDriver.png"));
        driver.close();
    }





}
