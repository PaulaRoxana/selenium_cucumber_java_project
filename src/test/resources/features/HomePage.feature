Feature: Home page tests

  Background: Login to Home Page
    Given The User is on "Login Page"
    And User enters username "standard_user" and password "secret_sauce" on "Login Page"
    Then Check User is navigated on "Home Page"

  # POSITIVE TESTS
  Scenario: Click on the menu button and validate the number and the names of the options unfolded
    When Click on the menu button
    Then Validate that there are four options unfolded
    And Validate the names of the four options unfolded

  Scenario: Validate that when clicking on ALL ITEMS option the USER remains on the same page
    When Click on the menu button
    And Click on ALL ITEMS option
    Then Check User remains on Home Page

  Scenario: Validate that the LOGOUT option is displayed
    When Click on the menu button
    Then Validate that the LOGOUT option is displayed

  Scenario: Validate that when clicking on LOGOUT option the USER is redirected to LOGIN page
    When Click on the menu button
    And Click on LOGOUT option
    Then Validate User is redirected to Login Page

  Scenario: Validate that when clicking on RESET APP STATE option the USER remains on Home Page
    When Click on the menu button
    And Click on RESET APP STATE option
    Then Check User remains on Home Page

  Scenario: Validate that when clicking on ABOUT option the USER is redirected to "https://saucelabs.com/"
    When Click on the menu button
    And Click on ABOUT option
    Then Check the USER is redirected to "https://saucelabs.com/"

