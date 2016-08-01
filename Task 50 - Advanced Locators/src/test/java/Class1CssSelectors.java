import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by eugene_z on 7/27/16.
 */
public class Class1CssSelectors extends TestBase {

    private static final By USERNAME_INPUT = By.id("Username");
    private static final By PASSWORD_INPUT = By.id("Password");
    private static final By LOGIN_BUTTON = By.id("SubmitButton");
    private static final String HOME_PAGE_TITLE = "RMSys - Home";
    private static final String VACATION_PAGE_TITLE = "RMSys - Vacation";
    private static final By ALL_LINKS_AND_INPUTS_HOME_PAGE = By.cssSelector("a,input");
    private static final By ALL_ELEMENTS_HOME_PAGE = By.cssSelector("*");
    private static final By ALL_ELEMENTS_NEAR_USER_NAME = By.cssSelector("#info > div");
    private static final By OFFICE_051_LINK = By.cssSelector("#officeWidgetContent li:first-child");
    private static final By OFFICE_424_LINK = By.cssSelector("#officeWidgetContent li:last-child");
    private static final By OFFICE_118_LINK = By.cssSelector("#officeWidgetContent li:nth-child(4)");
    private static final By MULTIPLE_OFFICES = By.cssSelector("#officeWidgetContent li:nth-child(5n-2)");
    private static final By VACATION_LINK = By.cssSelector("#vacationMenu");
    private static final By VAC_PAGE_ALL_INPUTS_EXCEPT_START_DATE = By.cssSelector("#commentsTextArea, input[type = \"text\"]:not(#EditVacationRequestStartDate)");

    @Test
    public void testElementsByCssSelectors() {
        getDriver().get(getRmsysUrl());
        WebElement usernameInput = getDriver().findElement(USERNAME_INPUT);
        WebElement passwordInput = getDriver().findElement(PASSWORD_INPUT);
        WebElement loginButton = getDriver().findElement(LOGIN_BUTTON);
        usernameInput.sendKeys(getUSERNAME());
        passwordInput.sendKeys(getPASSWORD());
        loginButton.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.titleIs(HOME_PAGE_TITLE));
        WebElement allLinksAndInputsHomePage = getDriver().findElement(ALL_LINKS_AND_INPUTS_HOME_PAGE);
        WebElement allElementsHomePage = getDriver().findElement(ALL_ELEMENTS_HOME_PAGE);
        WebElement allElementsNearUserName = getDriver().findElement(ALL_ELEMENTS_NEAR_USER_NAME);
        WebElement office051Link = getDriver().findElement(OFFICE_051_LINK);
        WebElement office424Link = getDriver().findElement(OFFICE_424_LINK);
        WebElement office118Link = getDriver().findElement(OFFICE_118_LINK);
        WebElement multipleOffices = getDriver().findElement(MULTIPLE_OFFICES);
        WebElement vacationLink = getDriver().findElement(VACATION_LINK);
        vacationLink.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.titleIs(VACATION_PAGE_TITLE));
        WebElement allInputsExceptStartDateOnVacationPage = getDriver().findElement(VAC_PAGE_ALL_INPUTS_EXCEPT_START_DATE);

    }

}
