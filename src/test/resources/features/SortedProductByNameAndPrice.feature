
Feature: As a user should be able to sorted the product
  AC: Sorted product by name in ascending order and descending order
  Sorted product by price in ascending order and descending order

  Background: For all scenario, user is on the product page
    Given user is on the product page
    When user click sorted button

  Scenario: user be able to sorted product by name in ascending order
    When user select sorted by name "Name (A to Z)" and click
    Then items should sorted in ascending order
      | Sauce Labs Backpack               |
      | Sauce Labs Bike Light             |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Onesie                 |
      | Test.allTheThings() T-Shirt (Red) |

  Scenario: user be able to sorted product by name in descending order
    When user select sorted by "Name (Z to A)" and click
    Then items should sorted in descending order
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Onesie                 |
      | Sauce Labs Fleece Jacket          |
      | Sauce Labs Bolt T-Shirt           |
      | Sauce Labs Bike Light             |
      | Sauce Labs Backpack               |

  Scenario: user be able to sorted product by price in ascending order
    When user select sorted by price "Price (low to high)" and click
    Then items should sorted by price in ascending order
      | 7.99  |
      | 9.99  |
      | 15.99 |
      | 15.99 |
      | 29.99 |
      | 49.99 |

  Scenario: user be able to sorted product by price in descending order
    When user select sorted "Price (high to low)" and click
    Then items should sorted price in descending order
      | 49.99 |
      | 29.99 |
      | 15.99 |
      | 15.99 |
      | 9.99  |
      | 7.99  |



