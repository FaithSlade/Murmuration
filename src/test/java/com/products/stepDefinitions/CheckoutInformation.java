package com.products.stepDefinitions;

import com.products.pages.Checkout_infoPage;
import com.products.pages.ProductPage;
import com.products.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformation {
    Checkout_infoPage checkout_infoPage = new Checkout_infoPage();
    ProductPage productPage = new ProductPage();

    @When("user click add random any item to cart button")
    public void user_click_add_random_any_item_to_cart_button() {
 checkout_infoPage.addRandomElement(checkout_infoPage.addToCartButton,4);

    }

    @When("user enter {string} as a first Name")
    public void user_enter_as_a_first_name(String firstName) {
        checkout_infoPage.firstName.sendKeys(firstName);
        BrowserUtil.waitFor(2); //just to see it click
    }

    @When("user enter {string} as a last Name")
    public void user_enter_as_a_last_name(String lastName) {
        checkout_infoPage.lastName.sendKeys(lastName);
        BrowserUtil.waitFor(1);
    }

    @When("user enter {int} as a zip code")
    public void user_enter_as_a_zip_code(Integer zipCode) {
        checkout_infoPage.zipCode.sendKeys(zipCode.toString());
        BrowserUtil.waitFor(1);
    }

    @When("user click continue button")
    public void user_click_continue_button() {
        checkout_infoPage.continueButton.click();
    }

    @Then("user should see {string} title page")
    public void user_should_see_title_page(String expectTitle) {
        Assert.assertEquals(expectTitle,checkout_infoPage.title.getText());
        BrowserUtil.waitFor(1);
    }

}
