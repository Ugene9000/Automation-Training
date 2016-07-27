package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by eugene_z on 7/19/16.
 */
public abstract class TestBase {

    private static final String RM_SYS_URL = "https://192.168.100.26/";
    private static final String username = "eugenzubritsky";
    private static final String password = "3#edc2wsx";
    private static WebDriver driver = null;
    private static WebDriver wait = null;

    public static String getRmSysUrl() {
        return RM_SYS_URL;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static WebDriver getWait() {
        return wait;
    }

    @BeforeTest
    public void init() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(RM_SYS_URL);
    }

    @AfterTest
    public void end() {
        driver.quit();
    }


}
