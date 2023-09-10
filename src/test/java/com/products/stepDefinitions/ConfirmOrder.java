package com.products.stepDefinitions;

import com.products.pages.ConfirmOrderPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ConfirmOrder {

    ConfirmOrderPage confirmOrderPage = new ConfirmOrderPage();

    @Then("verify text {string} show and user can click on Back Home button")
    public void verify_text_show_and_user_can_click_on_back_home_button(String expectedMessage) {
        Assert.assertEquals(expectedMessage,confirmOrderPage.thankYouText.getText());
        confirmOrderPage.backHomeButton.click();
    }

    @Then("verify product title page {string}")
    public void verify_product_title_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle,confirmOrderPage.title.getText());


    }
}
