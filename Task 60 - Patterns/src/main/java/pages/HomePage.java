package pages;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by eugene_z on 8/5/16.
 */
public class HomePage extends TestBase {

    private static final String PAGE_TITLE = "RMSys - Home";

    public String getPageTitle() {
        return PAGE_TITLE;
    }

    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

}
