import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by eugene_z on 7/27/16.
 */
public class IFrameTest extends TestBase{
    private static final String URL_TO_TEST_IFRAME = "https://the-internet.herokuapp.com/iframe";
    private static final String PAGE_TITLE = "The Internet";
    private static final String IFRAME_ID = "mce_0_ifr";
    private static final By FRAME_BODY = By.id("tinymce");

    @Test
    public void testIFrame() {
        getDriver().get(URL_TO_TEST_IFRAME);
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.titleIs(PAGE_TITLE));
        getDriver().switchTo().frame(IFRAME_ID);
        WebElement frameBody = getDriver().findElement(FRAME_BODY);
        frameBody.clear();
        frameBody.click();
        frameBody.sendKeys("Hello world!");
        Assert.assertTrue(frameBody.getText().equals("Hello world!"));
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
