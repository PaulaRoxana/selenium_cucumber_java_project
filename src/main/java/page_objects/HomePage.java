package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage extends BasePage {
    private final WebDriver driver;
    private final By menuButton = By.cssSelector("#react-burger-menu-btn");
    private final By unwrappedMenu = By.cssSelector(".bm-item.menu-item");
    private final By allItemsOption = By.cssSelector("#inventory_sidebar_link");
    private final By logoutOption = By.cssSelector("#logout_sidebar_link");
    private final By aboutOption = By.cssSelector("#about_sidebar_link");
    private final By resetAppStateOption = By.cssSelector("#reset_sidebar_link");
    private final By shoppingCartButton = By.cssSelector("#shopping_cart_container");
    private final By addBackpackToCart = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    private final By addBikeLight = By.cssSelector("#add-to-cart-sauce-labs-bike-light");


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getCurrentURL() {
        return "https://www.saucedemo.com/inventory.html";
    }

    public void clickOnMenuButton() {
        getCurrentURL();
        WebElement menu = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(driver.findElement(menuButton)));
        Actions builder = new Actions(driver);
        builder.moveToElement(menu).click().build().perform();
    }

    public List<WebElement> getUnfoldedOptions() {
        return driver.findElements(unwrappedMenu);
    }

    public int numberOfOptionsUnfolded() {
        return getUnfoldedOptions().size();
    }

    public void checkTheNamesOfTheFourOptionsUnfolded() {
        for (int i = 0; i < numberOfOptionsUnfolded(); i++) {
            System.out.println(getUnfoldedOptions().get(i).getText());
        }
    }

    public void clickALLITEMSOptionFromMenu() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(driver.findElement(allItemsOption))).click();
    }

    public void clickABOUTOption() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(driver.findElement(aboutOption))).click();
    }

    public WebElement theLOGOUTOption() {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(driver.findElement(logoutOption)));
    }

    public boolean isTheLOGOUTOptionIsDisplayed() {
        return theLOGOUTOption().isDisplayed();
    }

    public void clickLOGOUTOption() {
        theLOGOUTOption().click();
    }

    public void clickRESETAPPSTATEOption() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(driver.findElement(resetAppStateOption))).click();
    }

    public void clickTheShoppingCartButton() {
        driver.findElement(shoppingCartButton).click();
    }

    public void addOneProductToCart() {
        driver.findElement(addBackpackToCart).click();
    }

    public void addASecondProductToCart() {
        driver.findElement(addBikeLight).click();
    }


}
