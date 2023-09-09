package com.products.stepDefinitions;

import com.products.pages.CartPage;
import com.products.pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RemoveProductFromCartPage {
    CartPage cartPage = new CartPage();
    ProductPage productPage = new ProductPage();

    @When("user click remove {int} items from remove button")
    public void user_click_remove_items_from_remove_button(Integer removeNumItems) {
        for (int i = 0; i < removeNumItems; i++) {
            cartPage.removeRandomElement(cartPage.removeItemsButton).click();
        }
    }
    @Then("the shopping cart should have {int} items left")
    public void the_shopping_cart_should_have_items_left(Integer expectNumOfItems) {
        String expectedNum = Integer.toString(expectNumOfItems);
        Assert.assertEquals(expectedNum,productPage.shoppingCartBadge.getText());
    }
}
