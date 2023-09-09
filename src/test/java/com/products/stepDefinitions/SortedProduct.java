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
    Select sortedBtn = new Select(productPage.sortedButton);

    @When("user click sorted button")
    public void user_click_sorted_button() {
        loginPage.UserLogin();
    }


    String [] ascArrByName = new String[productPage.itemsName.size()];
    @When("user select sorted by name {string} and click")
    public void user_select_sorted_by_name_and_click(String textAtoZ) {
        ascArrByName = productPage.expectedSortedItemsByNameAscendingOrder();
        sortedBtn.selectByVisibleText(textAtoZ);
    }

    @Then("items should sorted in ascending order")
    public void items_should_sorted_in_ascending_order() {
        int count = 0;
        for (int i = 0; i < ascArrByName.length; i++) {
            if (ascArrByName[i].equals(productPage.actualSortedItemsByName()[i])){
                //If the elements of arr are same count will not increase, and if count will be 0 at the end of loop it means arr<ys are same order.
            }else{
                count++;
            }
        }
        Assert.assertEquals(0,count);
    }

    String [] descArrByName = new String[productPage.itemsName.size()];
    @When("user select sorted by {string} and click")
    public void user_select_sorted_by_and_click(String textZtoA) {
        descArrByName = productPage.expectedSortedItemsByNameDescendingOrder();
        sortedBtn.selectByVisibleText(textZtoA);
    }

    @Then("items should sorted in descending order")
    public void items_should_sorted_in_descending_order() {
        int count = 0;
        for (int i = 0; i < descArrByName.length; i++) {
            if (descArrByName[i].equals(productPage.actualSortedItemsByName()[i])){
                //If the elements of arr are same count will not increase, and if count will be 0 at the end of loop it means arr<ys are same order.
            }else{
                count++;
            }
        }
        Assert.assertEquals(0,count);
    }

    double[] expectedAscendingOrder = new double[productPage.itemsPrices.size()];

    @When("user select sorted by price {string} and click")
    public void user_select_sorted_by_price_and_click(String textPrice) {
        expectedAscendingOrder = productPage.expectedSortedItemsByPriceAscendingOrder();
        sortedBtn.selectByVisibleText(textPrice);
    }

    @Then("items should sorted by price in ascending order")
    public void items_should_sorted_in_by_price() {
        int count = 0;
        for (int i = 0; i < expectedAscendingOrder.length; i++) {
            if (expectedAscendingOrder[i] == productPage.actualSortedItemsByPrice()[i]){
                //If the elements of arr are same count will not increase, and if count will be 0 at the end of loop it means arr<ys are same order.
            }else{
                count++;
            }
        }
        Assert.assertEquals(0,count);
    }

    double [] expectedDescendingOrder = new double[productPage.itemsPrices.size()];
    @When("user select sorted {string} and click")
    public void user_select_sorted_and_click(String textPrice) {
        expectedDescendingOrder = productPage.expectedSortedItemsByPriceDescendingOrder();
        sortedBtn.selectByVisibleText(textPrice);
    }

    @Then("items should sorted price in descending order")
    public void items_should_sorted_price_in_descending_order() {
        int count = 0;
        for (int i = 0; i < expectedDescendingOrder.length; i++) {
            System.out.println(expectedDescendingOrder[i]);
            if (expectedDescendingOrder[i] == productPage.actualSortedItemsByPrice()[i]){
                //If the elements of arr are same count will not increase, and if count will be 0 at the end of loop it means arr<ys are same order.
            }else{
                count++;
            }
        }
        Assert.assertEquals(0,count);
    }
}
