
Feature: On the Checkout: Complete! page, verify to confirm order checkout can be complete.
  AC: user should be able to see the confirm message "Thank you for your order!" abd details

  Background: For all scenario, user is on the Checkout: Complete! page
    Given user is on the product page
    When user randomly add 5 items and click add to cart
    And user click on the shopping cart top right icon
    And user should be able to click checkout button
    When user enter "Jhon" as first name and "Cena" as last name
    And user enter valid zip code 94564
    And user should be able to click continue button and landing to "Checkout: Overview" page
    And user click to finish button and landing on the "Checkout: Complete!" page

  Scenario:
    Then verify text "Thank you for your order!" show and user can click on Back Home button
    Then verify product title page "Products"
    And user click on the shopping cart top right icon
    Then the shopping cart should empty no items

