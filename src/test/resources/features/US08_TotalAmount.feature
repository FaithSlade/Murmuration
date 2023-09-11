
Feature: On the Checkout: Overview page, verify that the Item Total amount is correct for the products selected.
  AC: The price total amount of items in the cart should correct

  Background: For all scenario, user is on the Checkout: Overview page
    Given user is on the product page
    When user randomly add 4 items and click add to cart
    And user click on the shopping cart top right icon
    And user should be able to click checkout button
    When user enter "Jhon" as first name and "Cena" as last name
    And user enter valid zip code 94564
    And user should be able to click continue button and landing to "Checkout: Overview" page

  Scenario:
    Then verify calculate 4 items price in cart equal to total price before tax
    Then add tex and verify the total pay base on 4 items
    Then user click to finish button and landing on the "Checkout: Complete!" page

