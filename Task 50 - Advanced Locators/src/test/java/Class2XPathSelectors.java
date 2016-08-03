import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by eugene_z on 7/27/16.
 */
public class Class2XPathSelectors extends TestBase {
    private static final By USERNAME_INPUT = By.id("Username");
    private static final By PASSWORD_INPUT = By.id("Password");
    private static final By LOGIN_BUTTON = By.id("SubmitButton");
    private static final String HOME_PAGE_TITLE = "RMSys - Home";
    private static final By ALL_LINKS_AND_INPUTS = By.xpath("//a | //input");
    private static final By ALL_ELEMENTS = By.xpath("//*");
    private static final By ALL_ELEMENTS_NEAR_USER_NAME = By.xpath("//div[@id = \"info\"]/a/following-sibling::div");
    private static final By OFFICE_051_LINK = By.xpath("//div[@id = \"officeWidgetContent\"]//li[1]/a");
    private static final By OFFICE_424_LINK = By.xpath("//div[@id = \"officeWidgetContent\"]//li[last()]/a");
    private static final By OFFICE_118_LINK = By.xpath("//div[@id = \"officeWidgetContent\"]//li[4]/a");
    private static final By MULTIPLE_OFFICES = By.xpath("//div[@id = \"officeWidgetContent\"]//li[position() mod 5 = 3]/a");
    private static final By ELEMENTS_WITH_CSS_CLASS = By.xpath("//*[@class]");
    private static final By ELEMENTS_WITH_CSS_CLASS_STARTS_WITH = By.xpath("//*[starts-with(@class, \"widget\")]");
    private static final By ELEMENTS_WITH_ID_ENDS_WITH = By.xpath("//*[substring(@id, string-length(@id) - string-length(\"wrapper\")+1) = \"wrapper\"]");
    private static final By ELEMENTS_WITH_ATTR_CONTAINING_TEXT = By.xpath("//*[contains(@data-officeid, \"b\")]");
    private static final By ELEMENT_CONTAINING_TEXT_EXACT_MATCH = By.xpath("//*[.=\"Management Belarus\"]");
    private static final By MODIFIED_XPATH_POINTING_TO_COMPANY_LINK = By.xpath("//span[text()=\"2\"]/../../a");

    @Test
    public void testElementsByXPath() {
        getDriver().get(getRmsysUrl());
        WebElement usernameInput = getDriver().findElement(USERNAME_INPUT);
        WebElement passwordInput = getDriver().findElement(PASSWORD_INPUT);
        WebElement loginButton = getDriver().findElement(LOGIN_BUTTON);
        usernameInput.sendKeys(getUSERNAME());
        passwordInput.sendKeys(getPASSWORD());
        loginButton.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.titleIs(HOME_PAGE_TITLE));
        WebElement allLinksAndInputs = getDriver().findElement(ALL_LINKS_AND_INPUTS);
        WebElement allElements = getDriver().findElement(ALL_ELEMENTS);
        WebElement allElementsNearUserName = getDriver().findElement(ALL_ELEMENTS_NEAR_USER_NAME);
        WebElement office051Link = getDriver().findElement(OFFICE_051_LINK);
        WebElement office424Link = getDriver().findElement(OFFICE_424_LINK);
        WebElement office118Link = getDriver().findElement(OFFICE_118_LINK);
        WebElement multipleOffices = getDriver().findElement(MULTIPLE_OFFICES);
        WebElement elementsWithCssClass = getDriver().findElement(ELEMENTS_WITH_CSS_CLASS);
        WebElement elementsWithCssClassStartsWith = getDriver().findElement(ELEMENTS_WITH_CSS_CLASS_STARTS_WITH);
        WebElement elementsWithCssClassEndsWith = getDriver().findElement(ELEMENTS_WITH_ID_ENDS_WITH);
        WebElement elementsWithAttrContainingText = getDriver().findElement(ELEMENTS_WITH_ATTR_CONTAINING_TEXT);
        WebElement elementContainingTextExactMatch = getDriver().findElement(ELEMENT_CONTAINING_TEXT_EXACT_MATCH);
        WebElement modifiedXPathPointingToCompanyLink = getDriver().findElement(MODIFIED_XPATH_POINTING_TO_COMPANY_LINK);
    }
}
