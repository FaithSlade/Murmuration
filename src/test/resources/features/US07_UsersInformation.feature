
Feature: On the Checkout: Your Information page, verify that all fields are required.
  AC: user should be able to enter First name, Last name, and Zipcode as required

  Background: For all scenario, user is on the Checkout: Your Information page
    Given user is on the product page
    When user randomly add 4 items and click add to cart
    And user click on the shopping cart top right icon
    And user should be able to click checkout button

  #positive
  Scenario: user enter all information details as required
    When user enter "Jhon" as first name and "Cena" as last name
    And user enter valid zip code 94566
    Then user should be able to click continue button and landing to "Checkout: Overview" page

  Scenario: user not enter first name or all information as required
    And user should be able to click continue button
    When user should see the err message show "Error: First Name is required"
    And click close error message and re-enter more information
    When user enter "Chris" as first name and "Hemsworth" as last name
    And user enter valid zip code 94987
    Then user should be able to click continue button and landing to "Checkout: Overview" page

  #negative
  Scenario: user enter only first name but not enter last name and zip code
    When user enter "Jhon" as first name and click continue button
    Then user should be able to click continue button
    Then user should see last name err message show "Error: Last Name is required"
    And click close error message and re-enter more information

  Scenario: user enter only first name and last name but not enter zip code
    When user enter "Jhon" as first name and "Cena" as last name
    And user should be able to click continue button
    Then user should see zipcode err message show "Error: Postal Code is required"
    And user should be able to click cancel button and go back to cart page "Your Cart" title

