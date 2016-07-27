import base.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by eugene_z on 7/19/16.
 */
public class HomePageTest extends TestBase {


    private static final By SIGN_OUT_BUTTON_CSS = By.cssSelector("a[title=\"Sign out\"]");
    private static final By SIGN_OUT_BUTTON_XPATH = By.xpath("//a[@title=\"Sign out\"]");
    private static final By LINK_WHICH_GRABS_ALL_OFFICES_CSS = By.cssSelector("a[data-officeid]");
    private static final By LINK_WHICH_GRABS_ALL_OFFICES_XPATH = By.xpath("//a[@data-officeid]");
    private static final By LINK_TO_CHAPAEVA_118_OFFICE_CSS = By.cssSelector("a[href = \"#Office-Chapaeva 118\"]");
    private static final By LINK_TO_CHAPAEVA_118_OFFICE_XPATH = By.xpath("//a[@href = \"#Office-Chapaeva 118\"]");
    private static final By LINK_TO_LUNCH_VOTING_CSS = By.cssSelector("a[href=\"https://lunchvoting.issoft.by/\"]");
    private static final By LINK_TO_LUNCH_VOTING_XPATH = By.xpath("//a[@href=\"https://lunchvoting.issoft.by/\"]");

    @Test
    public void findWebElementsByLocatorsHomePage() {
        WebElement signOutButtonCss = getDriver().findElement(SIGN_OUT_BUTTON_CSS);
        WebElement signOutButtonXPath = getDriver().findElement(SIGN_OUT_BUTTON_XPATH);
        WebElement linkWhichGrabsAllOfficesCss = getDriver().findElement(LINK_WHICH_GRABS_ALL_OFFICES_CSS);
        WebElement linkWhichGrabsAllOfficesXPath = getDriver().findElement(LINK_WHICH_GRABS_ALL_OFFICES_XPATH);
        WebElement linkToChapaeva118OfficeCss = getDriver().findElement(LINK_TO_CHAPAEVA_118_OFFICE_CSS);
        WebElement linkToChapaeva118OfficeXPath = getDriver().findElement(LINK_TO_CHAPAEVA_118_OFFICE_XPATH);
        WebElement linkToLunchVotingCss = getDriver().findElement(LINK_TO_LUNCH_VOTING_CSS);
        WebElement linkToLunchVotingXPath = getDriver().findElement(LINK_TO_LUNCH_VOTING_XPATH);
    }
}
