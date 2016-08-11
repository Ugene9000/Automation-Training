package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by eugene_z on 8/5/16.
 */
public class TestBase {

    private static WebDriver driver = null;
    private Assertion softAssert = new SoftAssert();
    private static final String USERNAME = "eugenzubritsky";
    private static final String PASSWORD = "a";

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public Assertion getSoftAssert() {
        return softAssert;
    }

    @BeforeMethod
    public void init() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void end() {
        driver.quit();
    }

    protected void checkElements(List<WebElement> list) {
        for (WebElement webElement : list) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }

    protected void waitWithPollingFrequency(long milliseconds, long timeout, WebElement element) {
        new FluentWait<WebDriver>(getDriver()).pollingEvery(milliseconds, TimeUnit.MILLISECONDS).withTimeout(timeout, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOf(element));
    }

}
