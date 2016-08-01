package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by eugene_z on 7/27/16.
 */
public class TestBase {
    private static final String RMSYS_URL = "https://192.168.100.26/";
    private static final String USERNAME = "eugenzubritsky";
    private static final String PASSWORD = "aaa";

    private static WebDriver driver = null;

    public static String getRmsysUrl() {
        return RMSYS_URL;
    }

    public static String getUSERNAME() {
        return USERNAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void init() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void end() {
        driver.quit();
    }
}
