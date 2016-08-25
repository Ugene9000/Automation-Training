package pages;

import base.PageBase;
import base.TestBase;
import com.gargoylesoftware.htmlunit.WebClient;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

/**
 * Created by eugene_z on 8/5/16.
 */
public class HomePage extends PageBase {

    private static final String PAGE_TITLE = "RMSys - Home";

    @FindBy(css = "a[title=\"Sign out\"]")
    private WebElement signOutLink;

    @FindBy(css = "#officeWidgetContent a")
    private WebElement linkWhichGrabsAllOffices;

    @FindBy(xpath = "//a[@href=\"#Office-Chapaeva 118\"]")
    private WebElement linkToChapaeva118Office;

    @FindBy(css = "div.resource-link-container.lunchvoting")
    private WebElement linkToLunchVouting;

    @FindBy(id = "companyMenu")
    private WebElement companyTabLink;

    @FindBy(id = "vacationMenu")
    private WebElement vacationTabLink;

    @FindBy(id = "officeMenu")
    private WebElement officeTabLink;

    public String getPageTitle() {
        return PAGE_TITLE;
    }

    public WebElement getSignOutLink() {
        return signOutLink;
    }

    public WebElement getLinkWhichGrabsAllOffices() {
        return linkWhichGrabsAllOffices;
    }

    public WebElement getLinkToChapaeva118Office() {
        return linkToChapaeva118Office;
    }

    public WebElement getLinkToLunchVouting() {
        return linkToLunchVouting;
    }

    public WebElement getCompanyTabLink() {
        return companyTabLink;
    }

    public WebElement getVacationTabLink() {
        return vacationTabLink;
    }

    public WebElement getOfficeTabLink() {
        return officeTabLink;
    }

    protected void checkElements() {

    }

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public List<WebElement> getListOfElements() {
        return Arrays.asList(
                signOutLink,
                linkWhichGrabsAllOffices,
                linkToChapaeva118Office,
                linkToLunchVouting
        );
    }

    public void loadPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.loadPage();
        loginPage.login(TestBase.getUSERNAME(), TestBase.getPASSWORD());
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.titleIs(HomePage.PAGE_TITLE));
    }

}
