package browsers.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page_objects.LoginPage;
import page_objects.HomePage;

import static browsers.stepdefinitions.BaseSteps.PAGES_STORAGE;
import static browsers.stepdefinitions.BaseSteps.driver;
//import static browsers.stepdefinitions.Hooks.driver;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(driver);

    @Given("The User is on {string}")
    public void theUserIsOnLoginPage(String pageName) {
        LoginPage loginPage = new LoginPage(driver);
        PAGES_STORAGE.put(pageName, loginPage);
        loginPage.open();
    }
    @When("User enters {string} and {string} on {string}")
    public void userEntersCorrectUsernameAndPasswordOn(String username, String password, String pageName) {
        PAGES_STORAGE.put("Home Page", ((LoginPage) PAGES_STORAGE.get(pageName))
                .loginWithCorrectUsernameAndPassword(username, password));
    }
    @Then("User is navigated on {string}")
    public HomePage userIsNavigatedOn(String pageName) {
        return new HomePage(driver);
    }
    @When("User enters incorrect {string} and-or incorrect {string} on {string}")
    public void userEntersIncorrectUsernameOrIncorrectPasswordOn(String username, String password, String pageName) {
        ((LoginPage) PAGES_STORAGE.get(pageName)).fillIncorrectData(username, password);
    }
    @Then("Validate the error message for incorrect Username and-or incorrect Password")
    public void validateTheErrorMessageForIncorrectUsernameAndOrIncorrectPassword() {
        Assert.assertTrue(loginPage.getErrorMessageForIncorrectUsernameAndOrPassword()
                .contains("Epic sadface: Username and password do not match any user in this service"));
    }
    @When("User enters no {string} and {string} on {string}")
    public void userEntersNoUsernameOrNoPasswordOn(String username, String password, String pageName) {
        ((LoginPage) PAGES_STORAGE.get(pageName)).fillIncorrectData(username, password);
    }
    @When("User enters {string} and no {string} on {string}")
    public void userEntersAndNoOn(String username, String password, String pageName) {
        ((LoginPage) PAGES_STORAGE.get(pageName)).fillIncorrectData(username, password);
    }
    @Then("Validate the error message for missing Username is correct")
    public void validateTheErrorMessageForMissingUsernameIsCorrect() {

        Assert.assertTrue(loginPage.getErrorMessageForMissingUsername().contains("Epic sadface: Username is required"));
    }
    @Then("Validate the error message for missing Password is correct")
    public void validateTheErrorMessageForMissingPasswordIsCorrect() {
        Assert.assertTrue(loginPage.getErrorMessageForMissingPassword().contains("Epic sadface: Password is required"));
    }
    @And("User enters username {string} and password {string} on {string}")
    public void userEntersUsernameAndPasswordOnLoginPage(String username, String password, String pageName) {
        PAGES_STORAGE.put("Home Page", ((LoginPage) PAGES_STORAGE.get(pageName))
                .loginWithCorrectUsernameAndPassword(username, password));
    }
}