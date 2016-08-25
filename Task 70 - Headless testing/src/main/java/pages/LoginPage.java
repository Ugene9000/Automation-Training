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
 * Created by eugene_z on 8/17/16.
 */
public class LoginPage extends PageBase {
    private static final String PAGE_TITLE = "RMSys - Sign In";
    private static final String PAGE_URL = "https://192.168.100.26/"; //"http://www.tut.by/" "https://192.168.100.26/"

    @FindBy(css = "div.logo-container")
    private WebElement logoContainer;

    @FindBy(xpath = ".//input[@id='Username']")
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

    @FindBy(css = "div.validation-summary-errors li")
    private WebElement invalidCredentialsError;

    @FindBy(id = "user-box-validation")
    private WebElement usernameValidationError;

    @FindBy(id = "password-box-validation")
    private WebElement passwordValidationError;

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

    public String getPageUrl() {
        return PAGE_URL;
    }

    public String getPageTitle() {
        return PAGE_TITLE;
    }

    public WebElement getInvalidCredentialsError() {
        return invalidCredentialsError;
    }

    public WebElement getUsernameValidationError() {
        return usernameValidationError;
    }

    public WebElement getPasswordValidationError() {
        return passwordValidationError;
    }

    public List<WebElement> getListOfElements() {
        return Arrays.asList(
                logoContainer,
                usernameInputField,
                passwordInputField,
                signInButton,
                rememberMeCheckBox,
                rememberMeLabelText
        );
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String username, String password) {
        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        return new HomePage(getDriver());
    }

    public void loadPage() {
        getDriver().get(getPageUrl());
    }

}
