import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HerokuappPage;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;




public class UploadTest implements KeyListener{

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

    @Test
    public void testUpload() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        HerokuappPage page = new HerokuappPage(driver);
        page.loadPage(driver);
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs(page.getPageTitle()));
        File uploadFile = new File("./src/main/resources/FileToUpload.jpg");
        page.getBrowseButton().sendKeys(uploadFile.getAbsolutePath());
        page.getUploadButton().click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElement(page.getNameOfUploadedFile(), uploadFile.getName()));
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void testUploadWithLibrary() throws InterruptedException, AWTException {
        WebDriver driver = new FirefoxDriver();
        HerokuappPage page = new HerokuappPage(driver);
        page.loadPage(driver);
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs(page.getPageTitle()));
        page.getBrowseButton().click();
        Thread.sleep(2000);

        File uploadFile = new File("/Users/eugene_z/Automation/Automation-Training/Task 80 - Bottlenecks/src/main/resources/FileToUpload.jpg");

        StringSelection ss = new StringSelection(uploadFile.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyRelease(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_META);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_SHIFT);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_G);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_META);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        Thread.sleep(500);
        robot.keyRelease(KeyEvent.VK_G);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000);
        page.getUploadButton().click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElement(page.getNameOfUploadedFile(), uploadFile.getName()));
        Thread.sleep(3000);
        driver.quit();
        Thread.sleep(4000);
        driver.quit();
    }

/*    @Test
    public void tutByTest() throws AWTException, InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://tut.by");
        TutByPage page = new TutByPage(driver);
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs("Белорусский портал TUT.BY"));

        StringSelection ss = new StringSelection("ololo");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        JTextField component = new JTextField();
        component.addKeyListener(new MyKeyListener());

        page.getSearch().click();


        Thread.sleep(2000);

        MyKeyListener listener = new MyKeyListener();
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_META);
        listener.setKeyCode(KeyEvent.VK_META);
        listener.keyPressed(KeyEvent e);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);

        Thread.sleep(2000);

        driver.quit();
    }*/
}
