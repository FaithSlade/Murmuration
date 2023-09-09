
Feature: user can should be able to enter their information is on the Checkout Information page
  AC: first name, last name, and zip code are required to all user before continue checkout items

  Background: For all scenario, user is on the Checkout Information page
    Given user is on the product page
    When user click add random any item to cart button
    And user click on the shopping cart top right icon
    And user should be able to click checkout button

    #possitive scenario
  Scenario: user enter all field that are required
    When user enter "John" as a first Name
    And user enter "Cena" as a last Name
    And user enter 94568 as a zip code
    When user click continue button
    Then user should see "Checkout: Overview" title page

      #negative scenario
  Scenario: user not enter any field
    When user not enter first name, last name, and zip code
    And user can not click continue button
    Then user should will see "Error: First Name is required message

  Scenario: user not enter zip code
    When user enter "John" as a first Name
    And user enter "Cena" as a last Name
    And user not enter zip code
    And user can not click continue button
    Then user should will see "Error: Postal Code is required" message

  Scenario: user enter only user name
    When user enter "John" as a first Name
    And user not last Name, and not enter zip code
    And user can not click continue button
    Then user should will see "Error: Last Name is required" message
