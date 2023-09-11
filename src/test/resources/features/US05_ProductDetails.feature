
Feature: On the Products page, verify that the products detail page
         can be reached by clicking on either the product name pr product image
  AC: user can click the product on product name
      user can click the product on product image

  Background: For all scenario, user is on the product page
    Given user is on the product page

  Scenario: user be able to click on the product on product name
    Then user click on the product name then verify product details on product details page

  Scenario: user be able to click on the product on product image
    Then user click on the product image then verify product details on product details page