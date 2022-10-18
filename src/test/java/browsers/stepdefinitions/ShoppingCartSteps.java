package browsers.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page_objects.CartPage;
import page_objects.CheckoutPage;
import page_objects.SauceLabPage;
import page_objects.HomePage;

import static browsers.stepdefinitions.Hooks.driver;

public class ShoppingCartSteps {

    HomePage homePage = new HomePage(driver);
    SauceLabPage errorPageAfterAbout = new SauceLabPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @When("Add one product to the shopping cart")
    public void addOneProductToTheShoppingCart() {
        homePage.addOneProductToCart();
    }
    @And("Click on checkout button")
    public void clickOnCheckoutButton() {
        cartPage.clickTheCheckoutButton();
    }
    @Then("Check you are redirected to Checkout page")
    public void checkYouAreRedirectedToCheckoutPage() {
        Assert.assertEquals(checkoutPage.getCheckoutPageURL(), driver.getCurrentUrl());
    }
    @And("Add a second product to the shopping cart")
    public void addASecondProductToTheShoppingCart() {
        homePage.addASecondProductToCart();
    }
    @Then("Validate that the cart contains the exact number of products added")
    public void validateThatTheCartContainsTheExactNumberOfProductsAdded() {
        Assert.assertEquals(2, cartPage.cartContainsTheNumberOfProductsAdded());
    }
    @And("the shopping cart is empty")
    public void theShoppingCartIsEmpty() {
        Assert.assertEquals(0, cartPage.cartContainsTheNumberOfProductsAdded());
    }
    @Then("Validate that checkout button is not active")
    public void validateThatCheckoutButtonIsNotActive() {
        cartPage.checkoutButtonNotActiveWhenIsEmptyCart();
    }
}
