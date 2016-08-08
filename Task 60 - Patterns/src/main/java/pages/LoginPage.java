package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by eugene_z on 8/5/16.
 */

public class LoginPage extends PageBase {

    private static final String PAGE_TITLE = "RMSys - Sign In";
    private static final String PAGE_URL = "https://192.168.100.26/";

    @FindBy(css = "div.logo-container")
    private WebElement logoContainer;

    @FindBy(id = "Username")
    private WebElement usernameInputField;

    @FindBy(id = "Password")
    private WebElement passwordInputField;

    @FindBy(id = "SubmitButton")
    private WebElement signInButton;

    @FindBy(id = "user-domain")
    private WebElement userDomain;

    @FindBy(css = "div.remember-chBox")
    private WebElement rememberMeCheckBox;

    @FindBy(xpath = "//span[.=\"Remember me \"]")
    private WebElement rememberMeLabelText;

    public WebElement getLogoContainer() {
        return logoContainer;
    }

    public WebElement getUsernameInputField() {
        return usernameInputField;
    }

    public WebElement getPasswordInputField() {
        return passwordInputField;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getUserDomain() {
        return userDomain;
    }

    public WebElement getRememberMeCheckBox() {
        return rememberMeCheckBox;
    }

    public WebElement getRememberMeLabelText() {
        return rememberMeLabelText;
    }

    public static String getPageUrl() {
        return PAGE_URL;
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static String getPageTitle() {
        return PAGE_TITLE;
    }

    public HomePage login(String username, String password) {
        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        return new HomePage();
    }

    public void loadPage() {
        getDriver().get(getPageUrl());
    }

    protected void checkElements() {
        getDriver().findElements()
    }
}
