package pages;

import base.PageBase;
import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

/**
 * Created by eugene_z on 8/9/16.
 */
public class VacationPage extends PageBase {

    @FindBy(css = "div#thirdContainer>span.question")
    private WebElement spanNotificationTo;

    @FindBy(css = "div#fourthContainer>span.question")
    private WebElement spanNotificationCC;

    private static final String PAGE_TITLE = "RMSys - Vacation";

    public WebElement getSpanNotificationTo() {
        return spanNotificationTo;
    }

    public WebElement getSpanNotificationCC() {
        return spanNotificationCC;
    }

    public static String getPageTitle() {
        return PAGE_TITLE;
    }

    public VacationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public List<WebElement> getListOfElements() {
        return Arrays.asList(
                spanNotificationTo,
                spanNotificationCC
        );
    }

    public void loadPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.loadPage();
        homePage.getVacationTabLink().click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.titleIs(VacationPage.getPageTitle()));
    }
}
