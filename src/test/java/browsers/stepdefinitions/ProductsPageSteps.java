package browsers.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page_objects.ErrorPageAfterAbout;
import page_objects.HomePage;

import java.time.Duration;

import static browsers.stepdefinitions.Hooks.driver;

public class ProductsPageSteps {
    HomePage homePage = new HomePage(driver);
    ErrorPageAfterAbout errorPageAfterAbout = new ErrorPageAfterAbout(driver);

    @Then("Check you are on Products Page")
    public void checkYouAreOnProductsPage() {
        Assert.assertEquals(homePage.getCurrentURL(), driver.getCurrentUrl());
    }
    @When("Click on the menu button")
    public void clickOnTheMenuButton() {
        homePage.clickOnMenuButon();
    }
    @Then("Validate that there are four options unfolded")
    public void validateThatThereAreFourOptionsUnfolded() {
        Assert.assertEquals(4, homePage.numberOfOptionsUnfolded());
    }
    @And("Validate the names of the four options unfolded")
    public void validateTheNamesOfTheFourOptionsUnfolded() {
        homePage.checkTheNamesOfTheFourOptionsUnfolded();

        Assert.assertEquals("ALL ITEMS", homePage.getUnfoldedOptions().get(0).getText());
        Assert.assertEquals("ABOUT", homePage.getUnfoldedOptions().get(1).getText());
        Assert.assertEquals("LOGOUT", homePage.getUnfoldedOptions().get(2).getText());
        Assert.assertEquals("RESET APP STATE", homePage.getUnfoldedOptions().get(3).getText());
    }
    @And("Click on ALL ITEMS option")
    public void clickOnALLITEMSOption() {
        homePage.clickALLITEMSOption();
    }
    @And("Click on ABOUT option")
    public void clickOnABOUTOption() {
        homePage.clickABOUTOption();
    }
    @Then("Validate that the LOGOUT option is diplayed")
    public void validateThatTheLOGOUTOptionIsDiplayed() {
        Assert.assertTrue(homePage.isTheLOGOUTOptionIsDiplayed());
    }
    @And("Click on LOGOUT option")
    public void clickOnLOGOUTOption() {
        homePage.clickLOGOUTOption();
    }
    @Then("Check you are on an error page")
    public void checkYouAreOnAnErrorPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(errorPageAfterAbout.getCurrentURL(), driver.getCurrentUrl());
    }
    @And("Click on RESET APP STATE option")
    public void clickOnRESETAPPSTATEOption() {
        homePage.clickRESETAPPSTATEOption();
    }
    @And("Click on shopping cart button")
    public void clickOnShoppingCartButton() {
        homePage.clickTheShoppingCartButton();
    }

}
