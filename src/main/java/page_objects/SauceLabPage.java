package page_objects;

import org.openqa.selenium.WebDriver;

public class SauceLabPage extends BasePage {
    private final WebDriver driver;


    public SauceLabPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return driver;
    }
    public String getCurrentURL() {
        return "https://saucelabs.com/";
        //https://saucelabs.com/error/404
    }
}
