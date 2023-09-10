Feature: On the Checkout: Overview page, verify that the Item Total amount is correct for the products selected.
  AC: The price total amount of items in the cart should correct

  Background: For all scenario, user is on the Checkout: Overview page
    Given user is on the product page
    When user click all items Add to cart button
    And user click on the shopping cart top right icon
    And user should be able to click checkout button
    When user enter "Jhon" as first name and "Cena" as last name
    And user enter valid zip code 94564
    And user should be able to click continue button and landing to "Checkout: Overview" page

  Scenario Outline:
    When "<item name>" and item price "<price>" should correct for each item
    Then verify 6 items should be in cart as expected and net price before tax should be 129.94
    Then add tex 10.40 and verify the total pay 140.34

    Examples:
      | item name                         | price |
      | Sauce Labs Bike Light             | 9.99  |
      | Sauce Labs Backpack               | 29.99 |
      | Sauce Labs Bolt T-Shirt           | 15.99 |
      | Test.allTheThings() T-Shirt (Red) | 15.99 |
      | Sauce Labs Onesie                 | 7.99  |
      | Sauce Labs Fleece Jacket          | 49.99 |

