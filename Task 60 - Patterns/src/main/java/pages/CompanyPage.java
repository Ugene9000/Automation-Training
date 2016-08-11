package pages;

import base.PageBase;
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
public class CompanyPage extends PageBase {

    @FindBy(css = "#list-items-container>ul>li")
    private WebElement allContainersForCompanies;

    @FindBy(xpath = "//a/span[.=\"Contact\"]")
    private WebElement contactTabSelectorForEveryCompany;

    private static final String PAGE_TITLE = "RMSys - Company";

    public WebElement getAllContainersForCompanies() {
        return allContainersForCompanies;
    }

    public WebElement getContactTabSelectorForEveryCompany() {
        return contactTabSelectorForEveryCompany;
    }

    public static String getPageTitle() {
        return PAGE_TITLE;
    }

    public CompanyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public List<WebElement> getListOfElements() {
        return Arrays.asList(
                allContainersForCompanies,
                contactTabSelectorForEveryCompany
        );
    }

    public void loadPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.loadPage();
        homePage.getCompanyTabLink().click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.titleIs(CompanyPage.getPageTitle()));
    }
}
