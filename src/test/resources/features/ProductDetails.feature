Feature: user can verify the product detail on the product detail page
  AC: user can click the product on product name
      user can click the product on product image

  Background: For all scenario, user is on the product page
    Given user is on the product page


  Scenario: user be able to click on the product on product name
    When user click on the product name and should see the product details on product details page

  @NotDone
  Scenario: user be able to click on the product on product image
    When user click on the product image and should see the product details on product details page