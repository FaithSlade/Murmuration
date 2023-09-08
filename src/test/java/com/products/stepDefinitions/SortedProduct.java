package com.products.stepDefinitions;

import com.products.pages.LoginPage;
import com.products.pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SortedProduct {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    Select sortedBtn = new Select(productPage.sortedButton);

    @When("user click sorted button")
    public void user_click_sorted_button() {
        loginPage.UserLogin();
    }

    @When("user select sorted by name {string} and click")
    public void user_select_sorted_by_name_and_click(String textAtoZ) {
        sortedBtn.selectByVisibleText(textAtoZ);
    }

    @Then("items should sorted in ascending order")
    public void items_should_sorted_in_ascending_order(List<String> expectedItemSorted) {
        Assert.assertEquals(expectedItemSorted, productPage.SortedItems());
    }

    @When("user select sorted by {string} and click")
    public void user_select_sorted_by_and_click(String textZtoA) {
        sortedBtn.selectByVisibleText(textZtoA);
    }

    @Then("items should sorted in descending order")
    public void items_should_sorted_in_descending_order(List<String> expectedItemSorted) {
        Assert.assertEquals(expectedItemSorted, productPage.SortedItems());
    }

    @When("user select sorted by price {string} and click")
    public void user_select_sorted_by_price_and_click(String textPrice) {
        sortedBtn.selectByVisibleText(textPrice);
    }

    @Then("items should sorted by price in ascending order")
    public void items_should_sorted_in_by_price(List<Double> expectedPriceSorted) {
        Assert.assertEquals(expectedPriceSorted, productPage.SortedItemsByPrice());
    }

    @When("user select sorted {string} and click")
    public void user_select_sorted_and_click(String textPrice) {
        sortedBtn.selectByVisibleText(textPrice);
    }

    @Then("items should sorted price in descending order")
    public void items_should_sorted_price_in_descending_order(List<Double> expectedPriceSorted) {
        Assert.assertEquals(expectedPriceSorted,productPage.SortedItemsByPrice());
    }
}
