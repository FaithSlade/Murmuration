
Feature: As a user can added and removed the product to the cart

  Background: For all scenario, user is on the product page
    Given user is on the product page

  Scenario: user be able to add the product to the cart
    When user click items Add to cart button
    And user click on the shopping cart top right icon
    Then the shopping cart should show all added items 6 in the cart

  Scenario: user be able to remove the product off the cart
    When user click remove items button
    And user click on the shopping cart top right icon
    Then the shopping cart should empty no items
