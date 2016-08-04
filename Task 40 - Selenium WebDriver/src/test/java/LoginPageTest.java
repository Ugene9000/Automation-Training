import base.DataSetProvider;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * Created by eugene_z on 7/25/16.
 */
public class LoginPageTest extends TestBase {

    private static final By USERNAME_INPUT = By.id("Username");
    private static final By PASSWORD_INPUT = By.id("Password");
    private static final By LOGIN_BUTTON = By.id("SubmitButton");
    private static final By SIGN_OUT_LINK = By.cssSelector("a[title = \"Sign out\"]");
    private static final By OFFICE_TAB_LINK = By.id("officeMenu");
    private static final String SIGN_IN_PAGE_TITLE = "RMSys - Sign In";
    private static final String HOME_PAGE_TITLE = "RMSys - Home";
    private static final By SEARCH_BY_OFFICE_INPUT = By.id("input-search");
    private static final String USERNAME_VALIDATION_MESSAGE_TEXT = ">Username is required<";
    private static final String PASSWORD_VALIDATION_MESSAGE_TEXT = ">Password is required<";

    @Test
    public void login() throws InterruptedException {
        getDriver().get(getRmSysUrl());
        Thread.sleep(5000);
        WebElement usernameInput = getDriver().findElement(USERNAME_INPUT);
        WebElement passwordInput = getDriver().findElement(PASSWORD_INPUT);
        WebElement loginButton = getDriver().findElement(LOGIN_BUTTON);
        usernameInput.sendKeys(getUsername());
        passwordInput.sendKeys(getPassword());
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        loginButton.click();
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(SIGN_OUT_LINK));
        Assert.assertTrue(getDriver().findElement(SIGN_OUT_LINK).isDisplayed());
    }

    @Test
    public void loginTestWithExplicitWaiters() {
        getDriver().get(getRmSysUrl());
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.titleIs(SIGN_IN_PAGE_TITLE));
        WebElement usernameInput = getDriver().findElement(USERNAME_INPUT);
        WebElement passwordInput = getDriver().findElement(PASSWORD_INPUT);
        WebElement loginButton = getDriver().findElement(LOGIN_BUTTON);
        usernameInput.sendKeys(getUsername());
        passwordInput.sendKeys(getPassword());
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        loginButton.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.titleIs(HOME_PAGE_TITLE));
        WebElement officeTabLink = getDriver().findElement(OFFICE_TAB_LINK);
        officeTabLink.click();

        new FluentWait(getDriver()).withTimeout(15, TimeUnit.SECONDS).pollingEvery(2700, TimeUnit.MILLISECONDS).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(SEARCH_BY_OFFICE_INPUT).isDisplayed();
            }
        });
    }

    @DataProvider(name = "provideNegativeLoginTestData")
    public Iterator<Object[]> createDataSetForNegativeTest() throws FileNotFoundException {
        return DataSetProvider.retrieveDataForNegativeLoginTest().iterator();
    }

    @DataProvider(name = "providePositiveLoginTestData")
    public Iterator<Object[]> createDataSetForPositiveTest() throws FileNotFoundException {
        return DataSetProvider.retrieveDataForPositiveLoginTest().iterator();
    }

    @Test(dataProvider = "provideNegativeLoginTestData")
    public static void testLoginNegative(String username, String password, String usernameValidationIsDisplayed, String passwordValidationIsDisplayed, String pageTitle) {
        getDriver().get(getRmSysUrl());
        WebElement usernameInput = getDriver().findElement(USERNAME_INPUT);
        WebElement passwordInput = getDriver().findElement(PASSWORD_INPUT);
        WebElement loginButton = getDriver().findElement(LOGIN_BUTTON);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        loginButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue((getDriver().getPageSource().contains(USERNAME_VALIDATION_MESSAGE_TEXT)) == (Boolean.valueOf(usernameValidationIsDisplayed)));
        Assert.assertTrue((getDriver().getPageSource().contains(PASSWORD_VALIDATION_MESSAGE_TEXT)) == (Boolean.valueOf(passwordValidationIsDisplayed)));
        Assert.assertTrue(getDriver().getTitle().equals(pageTitle));
    }

    @Test(dataProvider = "providePositiveLoginTestData")
    public void testLoginPositive(String username, String password, String pageTitle) {
        getDriver().get(getRmSysUrl());
        WebElement usernameInput = getDriver().findElement(USERNAME_INPUT);
        WebElement passwordInput = getDriver().findElement(PASSWORD_INPUT);
        WebElement loginButton = getDriver().findElement(LOGIN_BUTTON);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        loginButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(getDriver().getTitle().equals(pageTitle));
    }
}