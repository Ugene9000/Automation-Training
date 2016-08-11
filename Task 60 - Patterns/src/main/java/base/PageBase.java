package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

/**
 * Created by eugene_z on 8/8/16.
 */
public abstract class PageBase {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public void setElementInput(WebElement element, String inputText) {
        element.sendKeys(inputText);
    }


}
