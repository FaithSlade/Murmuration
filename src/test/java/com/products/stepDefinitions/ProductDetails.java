package com.products.stepDefinitions;

import com.products.pages.ProductPage;
import com.products.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ProductDetails {
    ProductPage productPage = new ProductPage();

    @Then("user click on the product name then verify product details on product details page")
    public void user_click_on_the_product_name_then_verify_product_details_on_product_details_page() {
        productPage.eachItemClickByName();
    }

    @Then("user click on the product image then verify product details on product details page")
    public void user_click_on_the_product_image_then_verify_product_details_on_product_details_page() {
        productPage.eachItemClickByImage();
    }
}
