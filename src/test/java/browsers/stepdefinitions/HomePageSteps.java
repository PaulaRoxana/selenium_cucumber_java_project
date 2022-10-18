package browsers.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page_objects.SauceLabPage;
import page_objects.HomePage;
import page_objects.LoginPage;

import java.time.Duration;

import static browsers.stepdefinitions.BaseSteps.driver;

public class HomePageSteps {
    HomePage homePage = new HomePage(driver);
    SauceLabPage sauceLabPage = new SauceLabPage(driver);


    @When("Click on the menu button")
    public void clickOnTheMenuButton() {
        homePage.clickOnMenuButton();
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
    public HomePage clickOnALLITEMSOptionFromMENU() {
        homePage.clickALLITEMSOptionFromMenu();
        return new HomePage(driver);
    }
    @And("Click on ABOUT option")
    public void clickOnABOUTOption() {
        homePage.clickABOUTOption();
    }
    @Then("Validate that the LOGOUT option is displayed")
    public void validateThatTheLOGOUTOptionIsDisplayed() {
        Assert.assertTrue(homePage.isTheLOGOUTOptionIsDisplayed());
    }
    @And("Click on LOGOUT option")
    public void clickOnLOGOUTOption() {
        homePage.clickLOGOUTOption();
    }
//    @Then("Check you are on an error page")
//    public void checkYouAreOnAnErrorPage() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Assert.assertEquals(errorPageAfterAbout.getCurrentURL(), driver.getCurrentUrl());
//    }
    @And("Click on RESET APP STATE option")
    public void clickOnRESETAPPSTATEOption() {
        homePage.clickRESETAPPSTATEOption();
    }
    @And("Click on shopping cart button")
    public void clickOnShoppingCartButton() {
        homePage.clickTheShoppingCartButton();
    }
    @Then("Check User is navigated on {string}")
    public void checkUserIsNavigatedOnHomePage(String pageName) {
        Assert.assertEquals(homePage.getCurrentURL(), driver.getCurrentUrl());
    }

    @Then("Check User remains on Home Page")
    public void checkUserRemainsOnHomePage() {
        Assert.assertEquals(homePage.getCurrentURL(), driver.getCurrentUrl());
    }

    @Then("Validate User is redirected to Login Page")
    public LoginPage validateUserIsRedirectedToLoginPage() {
        return new LoginPage(driver);
    }


    @Then("Check the USER is redirected to {string}")
    public void checkTheUSERIsRedirectedToSauceLabPage(String currentURL) {
        Assert.assertEquals(sauceLabPage.getCurrentURL(), currentURL);
    }
}
