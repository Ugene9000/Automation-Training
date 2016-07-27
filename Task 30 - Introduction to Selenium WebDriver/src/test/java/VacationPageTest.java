import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by eugene_z on 7/19/16.
 */
public class VacationPageTest extends TestBase {

    private static final By VACATION_TAB_LINK = By.cssSelector("a[id=\"vacationMenu\"]");
    private static final By INFO_SPAN_NOTIFICATION_TO_CSS = By.cssSelector("div[id=\"thirdContainer\"]>span[class=\"question\"]");
    private static final By INFO_SPAN_NOTIFICATION_TO_XPATH = By.xpath("//div[@id=\"thirdContainer\"]/span[@class=\"question\"]");
    private static final By INFO_SPAN_NOTIFICATION_CC_CSS = By.cssSelector("div[class=\"altenates-approvers-container\"]>div>span[class=\"question\"]");
    private static final By INFO_SPAN_NOTIFICATION_CC_XPATH = By.xpath("//div[@class=\"altenates-approvers-container\"]/div/span[@class=\"question\"]");
    private static final By SPAN_NOTIFICATION_TO_POPUP_XPATH = By.xpath("//p[contains(text(), \"Notifications List.\")]");
    private static final By SPAN_NOTIFICATION_CC_POPUP_XPATH = By.xpath("//p[.=\"Add people you want to send notification to CC by entering the first and last name into the field.The notification will be sent after the request has been approved.\"]");

    @Test()
    public void findWebElementsByLocatorsVacationPage() throws InterruptedException {
        WebElement vacationTabLink = getDriver().findElement(VACATION_TAB_LINK);
        vacationTabLink.click();
        WebElement infoSpanNotificationToCss = getDriver().findElement(INFO_SPAN_NOTIFICATION_TO_CSS);
        WebElement infoSpanNotificationToXPath = getDriver().findElement(INFO_SPAN_NOTIFICATION_TO_XPATH);
        WebElement infoSpanNotificationCCCss = getDriver().findElement(INFO_SPAN_NOTIFICATION_CC_CSS);
        WebElement infoSpanNotificationCCXPath = getDriver().findElement(INFO_SPAN_NOTIFICATION_CC_XPATH);
        infoSpanNotificationToCss.click();
        WebElement SpanNotificationToPopupXPath = getDriver().findElement(SPAN_NOTIFICATION_TO_POPUP_XPATH);
        infoSpanNotificationCCCss.click();
        WebElement SpanNotificationCCPopupXPath = getDriver().findElement(SPAN_NOTIFICATION_CC_POPUP_XPATH);
    }
}
