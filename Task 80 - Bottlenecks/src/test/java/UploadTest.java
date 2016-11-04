import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HerokuappPageDownload;
import pages.HerokuappPageUpload;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class UploadTest {

    @Test
    public void testUpload() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        HerokuappPageUpload page = new HerokuappPageUpload(driver);
        page.loadPage(driver);
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs(page.getPageTitle()));
        this.getClass().getClassLoader().getResource("/FileToUpload.jpg");
        File uploadFile = new File("./src/main/resources/FileToUpload.jpg");
        page.getBrowseButton().sendKeys(uploadFile.getAbsolutePath());
        page.getUploadButton().click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElement(page.getNameOfUploadedFile(), uploadFile.getName()));
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void testUploadWithRobotLibrary() throws InterruptedException, AWTException {
        WebDriver driver = new FirefoxDriver();
        HerokuappPageUpload page = new HerokuappPageUpload(driver);
        Thread.sleep(5000);
        page.loadPage(driver);
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs(page.getPageTitle()));
        page.getBrowseButton().click();
        Thread.sleep(2000);

        File uploadFile = new File("./src/main/resources/FileToUpload.jpg");

        StringSelection ss = new StringSelection(uploadFile.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000);
        page.getUploadButton().click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElement(page.getNameOfUploadedFile(), uploadFile.getName()));
        Thread.sleep(3000);
        driver.quit();
    }

        @Test
            public void testDownloadFileChrome() throws InterruptedException {
          //  System.setProperty("webdriver.chrome.driver","D:\\Automation\\Automation-Training\\Task 80 - Bottlenecks\\src\\main\\resources\\Drivers\\chromedriver.exe");

            Map<String,Object> prefs = new HashMap<String, Object>();
            prefs.put("download.default_directory", "D:\\Automation\\Automation-Training\\Task 80 - Bottlenecks\\src\\main\\resources\\DownloadedFiles\\Chrome");
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            WebDriver driver = new ChromeDriver(capabilities);
            HerokuappPageDownload page = new HerokuappPageDownload(driver);
            page.loadPage(driver);
            new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs(page.getPAGE_TITLE()));

            page.getTxtFileDownloadLink().click();

        }


    @Test
    public void testDownloadFileIE() throws InterruptedException {
        WindowsUtils.writeStringRegistryValue("HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\Download Directory", "D:\\Automation\\Automation-Training\\Task 80 - Bottlenecks\\src\\main\\resources\\DownloadedFiles\\IE");
        WindowsUtils.writeStringRegistryValue("HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\Main\\Default Download Directory", "D:\\Automation\\Automation-Training\\Task 80 - Bottlenecks\\src\\main\\resources\\DownloadedFiles\\IE");

        System.setProperty("webdriver.ie.driver", "C:\\Program Files\\IEDriver\\IEDriverServer.exe");

        WebDriver driver = new InternetExplorerDriver();
        HerokuappPageDownload page = new HerokuappPageDownload(driver);

        page.loadPage(driver);
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs(page.getPAGE_TITLE()));
        page.getTxtFileDownloadLink().click();

        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void testDownloadFileFirefox() throws InterruptedException {

        FirefoxProfile profile = new FirefoxProfile();

        profile.setPreference("browser.download.folderList",2);
        profile.setPreference("browser.download.dir", "..\\src\\main\\resources\\DownloadedFiles\\Firefox"); //.src/main/resources/DownloadedFiles/Firefox
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");

        WebDriver driver = new FirefoxDriver(profile);

        HerokuappPageDownload page = new HerokuappPageDownload(driver);

        page.loadPage(driver);
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs(page.getPAGE_TITLE()));
        page.getTxtFileDownloadLink().click();
    }

}
