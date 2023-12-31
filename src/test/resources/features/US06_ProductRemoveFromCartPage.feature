
Feature: On the your cart page, verify that products can be removed from the cart

  Background: For all scenario, user is on the Cart page
    Given user is on the product page
    When user click all items Add to cart button
    And user click on the shopping cart top right icon

  Scenario: user can can remove all of the item from the cart
    When user click remove items button
    Then the shopping cart should empty no items
    And user should be able to click continue shopping button

  Scenario: user can can remove random item from the cart
    When user click remove 3 items from remove button
    Then the shopping cart should have 3 items left
    And user should be able to click checkout button