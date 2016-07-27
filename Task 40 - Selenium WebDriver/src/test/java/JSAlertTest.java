import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by eugene_z on 7/27/16.
 */
public class JSAlertTest extends TestBase {
    private static final String JS_ALERT_PAGE_URL = "https://the-internet.herokuapp.com/javascript_alerts";
    private static final String JS_ALERT_PAGE_TITLE = "The Internet";
    private static final By JS_ALERT_BUTTON = By.cssSelector("button[onclick=\"jsAlert()\"]");
    private static final By JS_CONFIRM_BUTTON = By.cssSelector("button[onclick=\"jsConfirm()\"]");
    private static final By JS_PROMPT_BUTTON = By.cssSelector("button[onclick=\"jsPrompt()\"]");
    private static final String PROMPT_TEXT_INPUT = "HelloWorld";

    @Test
    public void testJSAlert() throws InterruptedException {
        getDriver().get(JS_ALERT_PAGE_URL);
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.titleIs(JS_ALERT_PAGE_TITLE));
        WebElement JsAlertButton = getDriver().findElement(JS_ALERT_BUTTON);
        JsAlertButton.click();
        try {
            Alert alert = getDriver().switchTo().alert();
            Assert.assertEquals(alert.getText(), "I am a JS Alert");
            Thread.sleep(3000);
            alert.accept();
        } catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJSConfirmAccept() throws InterruptedException {
        getDriver().get(JS_ALERT_PAGE_URL);
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.titleIs(JS_ALERT_PAGE_TITLE));
        WebElement JsConfirmButton = getDriver().findElement(JS_CONFIRM_BUTTON);
        JsConfirmButton.click();
        try {
            Alert alert = getDriver().switchTo().alert();
            Assert.assertEquals(alert.getText(), "I am a JS Confirm");
            Thread.sleep(3000);
            alert.accept();
        }
        catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJSConfirmDismiss() throws InterruptedException {
        getDriver().get(JS_ALERT_PAGE_URL);
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.titleIs(JS_ALERT_PAGE_TITLE));
        WebElement JsConfirmButton = getDriver().findElement(JS_CONFIRM_BUTTON);
        JsConfirmButton.click();
        try {
            Alert alert = getDriver().switchTo().alert();
            Thread.sleep(3000);
            alert.dismiss();
        }
        catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJSPrompt() throws InterruptedException {
        getDriver().get(JS_ALERT_PAGE_URL);
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.titleIs(JS_ALERT_PAGE_TITLE));
        WebElement jsPromptButton = getDriver().findElement(JS_PROMPT_BUTTON);
        jsPromptButton.click();
        try {
            Alert alert = getDriver().switchTo().alert();
            Assert.assertEquals(alert.getText(), "I am a JS prompt");
            alert.sendKeys(PROMPT_TEXT_INPUT);
            Thread.sleep(3000);
            alert.accept();
        }
        catch (NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

}
