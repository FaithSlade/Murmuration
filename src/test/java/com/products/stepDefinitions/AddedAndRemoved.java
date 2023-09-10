package com.products.stepDefinitions;

import com.products.pages.CartPage;
import com.products.pages.LoginPage;
import com.products.pages.ProductPage;
import com.products.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddedAndRemoved {

    ProductPage productPage = new ProductPage();
    LoginPage loginPage = new LoginPage();
    CartPage cartPage = new CartPage();

    @Given("user is on the product page")
    public void user_is_on_the_product_page() {
        loginPage.UserLogin();
    }

    @When("user randomly add {int} items and click add to cart")
    public void user_randomly_add_items_and_click_add_to_cart(Integer expectedAddNum) {
        cartPage.addRandomElement(cartPage.addToCartButton, expectedAddNum);
    }

    @When("user click all items Add to cart button")
    public void user_click_all_items_add_to_cart_button() {
        for (WebElement eachItem : productPage.addToCartButton) {
            eachItem.click();
        }
    }

    @When("user click on the shopping cart top right icon")
    public void user_click_on_the_shopping_cart_top_right_icon() {
        productPage.shoppingCartLink.click();
    }

    @Then("the shopping cart should show all added items {int} in the cart")
    public void the_shopping_cart_should_show_all_added_items_in_the_cart(Integer number) {
        String expectedNum = Integer.toString(number);
        Assert.assertEquals(expectedNum, productPage.shoppingCartBadge.getText());
    }

    @When("user click remove items button")
    public void user_click_remove_items_button() {
        user_click_all_items_add_to_cart_button();
        for (WebElement eachItem : productPage.removeButton) {
            eachItem.click();
        }
    }

    @Then("the shopping cart should empty no items")
    public void the_shopping_cart_should_empty_no_items() {
        Assert.assertTrue(productPage.shoppingCartBadgeEmpty.getText().isEmpty());
    }
}
