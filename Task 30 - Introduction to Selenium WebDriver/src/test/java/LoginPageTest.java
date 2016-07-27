import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by eugene_z on 7/19/16.
 */
public class LoginPageTest extends TestBase {

    //LOGIN PAGE WEBELEMENTS
    private static final By USERNAME_INPUT_CSS = By.cssSelector("input[id=\"Username\"]");
    private static final By USERNAME_INPUT_XPATH = By.xpath("//input[@id=\"Username\"]");
    private static final By PASSWORD_INPUT_CSS = By.cssSelector("input[id=\"Password\"]");
    private static final By PASSWORD_INPUT_XPATH = By.xpath("//input[@id=\"Password\"]");
    private static final By REMEMBER_ME_LABEL_XPATH = By.xpath("//*[.=\"Remember me \"]");
    private static final By REMEMBER_ME_CHECKBOX_CSS = By.cssSelector("label[for=\"Remember\"]>span");
    private static final By REMEMBER_ME_CHECKBOX_XPATH = By.xpath("//label[@for=\"Remember\"]/span");
    private static final By LOGIN_BUTTON_CSS = By.cssSelector("button[id = \"SubmitButton\"]");
    private static final By LOGIN_BUTTON_XPATH = By.xpath("//button[@id = \"SubmitButton\"]");
    private static final By MY_PROFILE_LINK = By.xpath("//*[@id=\"username-settings\"]/a");


    @Test()
    public void findWebElementsByLocatorsLoginPage() {
        WebElement usernameInputCss = getDriver().findElement(USERNAME_INPUT_CSS);
        WebElement usernameInputXpath = getDriver().findElement(USERNAME_INPUT_XPATH);
        WebElement passwordInputCss = getDriver().findElement(PASSWORD_INPUT_CSS);
        WebElement passwordInputXpath = getDriver().findElement(PASSWORD_INPUT_XPATH);
        WebElement rememberMeLabelXPath = getDriver().findElement(REMEMBER_ME_LABEL_XPATH);
        WebElement rememberMeCheckboxCss = getDriver().findElement(REMEMBER_ME_CHECKBOX_CSS);
        WebElement rememberMeCheckboxXpath = getDriver().findElement(REMEMBER_ME_CHECKBOX_XPATH);
        WebElement loginButtonCss = getDriver().findElement(LOGIN_BUTTON_CSS);
        WebElement loginButtonXPath = getDriver().findElement(LOGIN_BUTTON_XPATH);
        Assert.assertTrue(rememberMeCheckboxCss.isDisplayed());
    }

    @Test
    public void login() {
        WebElement usernameInputXpath = getDriver().findElement(USERNAME_INPUT_XPATH);
        WebElement passwordInputCss = getDriver().findElement(PASSWORD_INPUT_CSS);
        WebElement loginButtonCss = getDriver().findElement(LOGIN_BUTTON_CSS);
        usernameInputXpath.sendKeys(getUsername());
        passwordInputCss.sendKeys(getPassword());
        loginButtonCss.click();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement myProfileLink = getDriver().findElement(MY_PROFILE_LINK);
        Assert.assertTrue(myProfileLink.isDisplayed());
    }
}