@wip
Feature: user can can remove the item on the Cart page

  Background: For all scenario, user is on the Cart page
    Given user is on the product page
    When user click items Add to cart button
    And user click on the shopping cart top right icon

  Scenario: user can can remove all of the item from the cart
    When user click remove items button
    Then the shopping cart should empty no items


  Scenario: user can can remove some item from the cart
    When user click remove 3 items from remove button
    Then the shopping cart should have 3 items left