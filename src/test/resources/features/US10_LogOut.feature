@wip
Feature: Logout of site.
  AC: As a user should be able to logout of site from any page

  Background: For all scenario, user is on the product page
    Given user is on the product page

  Scenario: user is on the "product" page
    When user click on the top left menu bar
    And user should be able to click on logout button
    Then verify user should landing on the login page and see "Swag Labs"

  Scenario: user is on the "Your Cart" page
    And user click on the shopping cart top right icon
    When user click on the top left menu bar
    And user should be able to click on logout button
    Then verify user should landing on the login page and see "Swag Labs"

  Scenario: user is on the "Checkout: Your Information" page
    And user click on the shopping cart top right icon
    And user should be able to click checkout button
    When user click on the top left menu bar
    And user should be able to click on logout button
    Then verify user should landing on the login page and see "Swag Labs"

  Scenario: user is on the "Checkout: Overview" page
    And user click on the shopping cart top right icon
    And user should be able to click checkout button
    When user enter "Jhon" as first name and "Cena" as last name
    And user enter valid zip code 94566
    Then user should be able to click continue button and landing to "Checkout: Overview" page
    When user click on the top left menu bar
    And user should be able to click on logout button
    Then verify user should landing on the login page and see "Swag Labs"

  Scenario: user is on the "Checkout: Complete!" page
    And user click on the shopping cart top right icon
    And user should be able to click checkout button
    When user enter "Jhon" as first name and "Cena" as last name
    And user enter valid zip code 94566
    Then user should be able to click continue button and landing to "Checkout: Overview" page
    And user click to finish button and landing on the "Checkout: Complete!" page
    When user click on the top left menu bar
    And user should be able to click on logout button
    Then verify user should landing on the login page and see "Swag Labs"