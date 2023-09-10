Feature: Logout of site.
  AC: As a user should be able to logout of site from any page

  Background: For all scenario, user is on the product page
    Given user is on the product page

  Scenario user is on the "product" page
    When user click on the top left menu bar
    And user should be able to click on logout button
    Then verify user should landing on the login page and see "login_logo"


  Scenario user is on the "Your Cart" page

  Scenario user is on the "Checkout: Your Information" page

  Scenario user is on the "Checkout: Overview" page

  Scenario user is on the "Checkout: Complete!" page