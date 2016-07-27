import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by eugene_z on 7/19/16.
 */
public class CompanyTestPage extends TestBase {
    private static final By COMPANY_TAB_LINK = By.cssSelector("a[id=\"companyMenu\"]");
    private static final By ALL_COMPANIES_CONTAINERS_CSS = By.cssSelector("ul[id=\"list-items\"]>li");
    private static final By ALL_COMPANIES_CONTAINERS_XPATH = By.xpath("//ul[@id=\"list-items\"]/li");
    private static final By COMPANIES_CONTACT_TAB_CSS = By.cssSelector("a[class=\"tab-link tab-link-contact ui-tabs-anchor\"]");
    private static final By COMPANIES_CONTACT_TAB_XPATH = By.xpath("//a[contains(@class, \"tab-link-contact\")]");

    @Test
    public void findWebElementsByLocatorsCompanyPage() {
        WebElement companyTabLink = getDriver().findElement(COMPANY_TAB_LINK);
        companyTabLink.click();
        WebElement grabAllCompaniesCss = getDriver().findElement(ALL_COMPANIES_CONTAINERS_CSS);
        WebElement grabAllCompaniesXPath = getDriver().findElement(ALL_COMPANIES_CONTAINERS_XPATH);
        WebElement companiesContactTabCss = getDriver().findElement(COMPANIES_CONTACT_TAB_CSS);
        WebElement companiesContactTabXPath = getDriver().findElement(COMPANIES_CONTACT_TAB_XPATH);
    }


}
