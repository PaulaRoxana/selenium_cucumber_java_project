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
    private WebDriver driver;
    private final By menuButton = By.cssSelector("#react-burger-menu-btn");
    private final By unwrappedMenu = By.cssSelector(".bm-item.menu-item");
    private final By allItemsOption = By.cssSelector("#inventory_sidebar_link");
    private final By logoutOption = By.cssSelector("#logout_sidebar_link");
    private final By aboutOption = By.cssSelector("#about_sidebar_link");
    private final By resetAppStateOption = By.cssSelector("#reset_sidebar_link");
     private final By shoppingCartButton =  By.cssSelector("#shopping_cart_container");
     private final By addBackpackToCart= By.cssSelector("#add-to-cart-sauce-labs-backpack");
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
    public By getMenuButton() {
        return menuButton;
    }
    public By getUnwrappedMenu() {
        return unwrappedMenu;
    }
    public By getAllItemsOption() {
        return allItemsOption;
    }
    public By getLogoutOption() {
        return logoutOption;
    }
    public By getAboutOption() {
        return aboutOption;
    }
    public By getResetAppStateOption() {
        return resetAppStateOption;
    }
    public By getShoppingCartButton() {
        return shoppingCartButton;
    }
    public By getAddBackpackToCart() {
        return addBackpackToCart;
    }

    public void clickOnMenuButon() {
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.findElement(menuButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement finish = wait.until(ExpectedConditions.visibilityOf(driver.findElement(menuButton)));
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(menuButton)).click().build().perform();
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
    public void clickALLITEMSOption() {
        Actions builder = new Actions(driver);
        // builder.moveToElement(driver.findElement(menuButton)).click().build().perform();

        driver.findElement(allItemsOption).click();
    }

    public void clickABOUTOption() {
        driver.findElement(aboutOption).click();
    }

    public boolean isTheLOGOUTOptionIsDiplayed() {
        return driver.findElement(logoutOption).isDisplayed();
    }

    public void clickLOGOUTOption() {
        driver.findElement(logoutOption).click();
    }
    public void clickRESETAPPSTATEOption() {
        driver.findElement(resetAppStateOption).click();
    }
    public void clickTheShoppingCartButton(){
        driver.findElement(shoppingCartButton).click();
    }
    public void addOneProductToCart(){
         driver.findElement(addBackpackToCart).click();
    }
    public void addASecondProductToCart(){
        driver.findElement(addBikeLight).click();
    }
}
