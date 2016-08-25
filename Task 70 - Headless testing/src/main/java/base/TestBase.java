package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by eugene_z on 8/17/16.
 */
public class TestBase {


    private static WebDriver driver = null;
    private static final String USERNAME = "eugenzubritsky";
    private static final String PASSWORD = "a";

    public static WebDriver getDriver() {
         return driver;
     }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    protected void checkElements(List<WebElement> list) {
        for (WebElement webElement : list) {
            Assert.assertTrue(webElement.isDisplayed());
        }
    }
    /*protected void waitWithPollingFrequency(long milliseconds, long timeout, WebElement element) {
        new FluentWait<WebDriver>(getDriver()).pollingEvery(milliseconds, TimeUnit.MILLISECONDS).withTimeout(timeout, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOf(element));
    }*/
}
