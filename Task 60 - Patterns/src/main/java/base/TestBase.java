package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by eugene_z on 8/5/16.
 */
public class TestBase {

    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        return driver;
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
}
