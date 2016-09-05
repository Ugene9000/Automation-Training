package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by eugene_z on 8/31/16.
 */
public class TutByPage {

    @FindBy(id = "search_from_str")
    private WebElement search;

    public WebElement getSearch() {
        return search;
    }

    public TutByPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
