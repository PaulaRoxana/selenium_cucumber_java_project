Feature: Shopping Cart tests

  Background: Login to Home Page
    Given The User is on "Login Page"
    And User enters username "standard_user" and password "secret_sauce" on "Login Page"
    Then Check User is navigated on "Home Page"

  Scenario: Validate that the checkout button is active only after adding at least 1 product to the shopping cart
    When Add one product to the shopping cart
    And Click on shopping cart button
    Then Validate that checkout button is active
#    Then Check you are redirected to Checkout page

  Scenario: Validate that the checkout button is NOT active when the shopping cart is empty
    When Click on shopping cart button
    And the shopping cart is empty
    Then Validate that checkout button is not active

  Scenario: Validate that when adding a number of products to the cart you find the exact same number of products into the cart
    When Add one product to the shopping cart
    And Add a second product to the shopping cart
    And Click on shopping cart button
    Then Validate that the cart contains the exact number of products added



