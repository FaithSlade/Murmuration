
Feature: As a user can added and removed the product to the cart

  Background: For all scenario, user is on the product page
    Given user is on the product page

  Scenario: user be able to add all six product to the cart
    When user click all items Add to cart button
    And user click on the shopping cart top right icon
    Then the shopping cart should show all added items 6 in the cart

  Scenario: user be able to remove all six product off the cart
    When user click remove items button
    And user click on the shopping cart top right icon
    Then the shopping cart should empty no items

  Scenario: user be able to randomly add and remove product off the cart
    When user randomly add 3 items and click add to cart
    When user click remove 5 items from remove button
    And user click on the shopping cart top right icon
    Then the shopping cart should empty no items

  Scenario: user be able to randomly add and remove product off the cart
    When user randomly add 5 items and click add to cart
    When user click remove 2 items from remove button
    And user click on the shopping cart top right icon
    Then the shopping cart should show all added items 3 in the cart