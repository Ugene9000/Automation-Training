package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by eugene_z on 8/17/16.
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
