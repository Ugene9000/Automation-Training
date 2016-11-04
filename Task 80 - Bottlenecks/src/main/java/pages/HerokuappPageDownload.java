package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by EugenZubritsky on 9/6/2016.
 */
public class HerokuappPageDownload {
    private final String PAGE_URL = "https://the-internet.herokuapp.com/download";
    private final String PAGE_TITLE = "The Internet";

    public HerokuappPageDownload(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loadPage(WebDriver driver) {
        driver.get(PAGE_URL);
    }


    public String getPAGE_URL() {
        return PAGE_URL;
    }

    public String getPAGE_TITLE() {
        return PAGE_TITLE;
    }

    @FindBy(css = "a[href=\"download/some-file.txt\"]")
    WebElement txtFileDownloadLink;

    public WebElement getTxtFileDownloadLink() {
        return txtFileDownloadLink;
    }
}
