package pages;

/**
 * Created by eugene_z on 8/29/16.
 */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by eugene_z on 8/29/16.
 */
public class HerokuappPage {

    private final String PAGE_URL = "https://the-internet.herokuapp.com/upload";
    private final String PAGE_TITLE = "The Internet";

    @FindBy(id = "file-upload")
    private WebElement browseButton;

    @FindBy(id = "file-submit")
    private WebElement uploadButton;

    @FindBy(id = "uploaded-files")
    private WebElement nameOfUploadedFile;

    public String getPageUrl() {
        return PAGE_URL;
    }

    public WebElement getNameOfUploadedFile() {
        return nameOfUploadedFile;
    }

    public  String getPageTitle() {
        return PAGE_TITLE;
    }

    public WebElement getBrowseButton() {
        return browseButton;
    }

    public WebElement getUploadButton() {
        return uploadButton;
    }

    public HerokuappPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loadPage(WebDriver driver) {
        driver.get(PAGE_URL);
    }



}

