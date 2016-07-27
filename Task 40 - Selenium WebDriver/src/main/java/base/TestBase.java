package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by eugene_z on 7/25/16.
 */
public class TestBase {

    private static final String RM_SYS_URL = "https://192.168.100.26/";
    private static final String username = "eugenzubritsky";
    private static final String password = "3#edc2wsx";
    private static WebDriver driver = null;

    public static String getRmSysUrl() {
        return RM_SYS_URL;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void openBrowser() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
