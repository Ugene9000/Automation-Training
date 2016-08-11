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
 * Created by eugene_z on 8/11/16.
 */
public class OfficePage extends PageBase {

    private static final String PAGE_TITLE = "RMSys - Office";

    @FindBy(id = "input-search")
    private WebElement searchByOffice;

    public static String getPageTitle() {
        return PAGE_TITLE;
    }

    public WebElement getSearchByOffice() {
        return searchByOffice;
    }

    public OfficePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public List<WebElement> getListOfElements() {
        return Arrays.asList(searchByOffice);
    }

    public void loadPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.loadPage();
        homePage.getOfficeTabLink().click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.titleIs(OfficePage.getPageTitle()));
    }
}
