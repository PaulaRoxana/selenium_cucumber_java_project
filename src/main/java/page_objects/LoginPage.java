package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private final WebDriver driver;
    @FindBy(id = "user-name")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id ="login-button")
    private WebElement loginBtn;

    @FindBy(css ="h3[data-test='error']")
    private WebElement errorMessageElement;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return driver;
    }

    public String getErrorMessageForIncorrectUsernameAndOrPassword() {
        return "Epic sadface: Username and password do not match any user in this service";
    }
    public String getErrorMessageForMissingUsername() {
        return "Epic sadface: Username is required";
    }
    public String getErrorMessageForMissingPassword() {
        return "Epic sadface: Password is required";
    }
    public void fillUsername(String username) {
        usernameInput.sendKeys(username);
    }
    public void fillPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public HomePage submit() {
        loginBtn.click();
        return new HomePage(driver);
    }

    public LoginPage open() {
        driver.get("https://www.saucedemo.com/");
        return this;
    }
    public HomePage loginWithCorrectUsernameAndPassword(String username, String password){
        fillUsername(username);
        fillPassword(password);
        submit();
        return new HomePage(driver);
    }

    public void fillIncorrectData(String username, String password) {
        fillUsername(username);
        fillPassword(password);
        submit();
    }
}
