package com.products.stepDefinitions;

import com.products.pages.LoginPage;
import com.products.pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedProduct {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    Select select = new Select(productPage.sortedButton);

    @When("user click sorted button")
    public void user_click_sorted_button() {
        loginPage.UserLogin();
    }

    @When("user select sorted by name {string} and click")
    public void user_select_sorted_by_name_and_click(String AtoZText) {
        select.selectByVisibleText(AtoZText);
    }

    @When("user select sorted by {string} and click")
    public void user_select_sorted_by_and_click(String textZtoA) {
        select.selectByVisibleText(textZtoA);
    }

    @When("user select sorted by price {string} and click")
    public void user_select_sorted_by_price_and_click(String textPrice) {
        select.selectByVisibleText(textPrice);
    }

    @When("user select sorted {string} and click")
    public void user_select_sorted_and_click(String textPrice) {
        select.selectByVisibleText(textPrice);
    }

    String [] expectedSortByNameAsc = new String[productPage.itemsName.size()];
    String [] expectedSortByNameDesc = new String[productPage.itemsName.size()];
    /**
     * count => will keep track of any elements that are not in ascending order.
     * If the elements of arr are same count will not increase,
     * If count still be 0 at the end of loop => arrays element are same order.
     */
    @Then("items should sorted in ascending order")
    public void items_should_sorted_in_ascending_order() {
        expectedSortByNameAsc = productPage.expectedSortedItemsByNameAscendingOrder();
        int count = 0;
        for (int i = 0; i < expectedSortByNameAsc.length; i++) {
            if (expectedSortByNameAsc[i].equals(productPage.actualSortedItemsByName()[i])){
            }else{
                count++;
            }
        }
        Assert.assertEquals(0,count);
    }
    /**
     * count => will keep track of any elements that are not in ascending order.
     * If the elements of arr are same count will not increase,
     * If count still be 0 at the end of loop => arrays element are same order.
     */
    @Then("items should sorted in descending order")
    public void items_should_sorted_in_descending_order() {
        expectedSortByNameDesc = productPage.expectedSortedItemsByNameDescendingOrder();
        int count = 0;
        for (int i = 0; i < expectedSortByNameDesc.length; i++) {
            if (expectedSortByNameDesc[i].equals(productPage.actualSortedItemsByName()[i])){
            }else{
                count++;
            }
        }
        Assert.assertEquals(0,count);
    }

    double[] expectedSortByPriceAsc = new double[productPage.itemsPrices.size()];
    double[] expectedSortByPriceDesc = new double[productPage.itemsPrices.size()];
    /**
     * count => will keep track of any elements that are not in ascending order.
     * If the elements of arr are same count will not increase,
     * If count still be 0 at the end of loop => arrays element are same order.
     */
    @Then("items should sorted by price in ascending order")
    public void items_should_sorted_in_by_price() {
        expectedSortByPriceAsc = productPage.expectedSortedItemsByPriceAscendingOrder();
        int count = 0;
        for (int i = 0; i < expectedSortByPriceAsc.length; i++) {
            if (expectedSortByPriceAsc[i] == productPage.actualSortedItemsByPrice()[i]){
            }else{
                count++;
            }
        }
        Assert.assertEquals(0,count);
    }
    /**
     * count => will keep track of any elements that are not in ascending order.
     * If the elements of arr are same count will not increase,
     * If count still be 0 at the end of loop => arrays element are same order.
     */
    @Then("items should sorted price in descending order")
    public void items_should_sorted_price_in_descending_order() {
        expectedSortByPriceDesc = productPage.expectedSortedItemsByPriceDescendingOrder();
        int count = 0;
        for (int i = 0; i < expectedSortByPriceDesc.length; i++) {
            if (expectedSortByPriceDesc[i] == productPage.actualSortedItemsByPrice()[i]){
            }else{
                count++;
            }
        }
        Assert.assertEquals(0,count);
    }
}
