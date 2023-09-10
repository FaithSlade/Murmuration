package com.products.stepDefinitions;

import com.products.pages.UserInfoPage;
import com.products.utilities.BrowserUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserInfo {

    UserInfoPage userInfoPage = new UserInfoPage();

    @When("user enter {string} as first name and {string} as last name")
    public void user_enter_as_first_name_and_as_last_name(String firstName, String lastName) {
        userInfoPage.firstName.sendKeys(firstName);
        userInfoPage.lastName.sendKeys(lastName);
    }

    @When("user enter valid zip code {int}")
    public void user_enter_valid_zip_code(Integer zipCode) {
        userInfoPage.zipCode.sendKeys(zipCode.toString());
    }

    @Then("user should be able to click continue button and landing to {string} page")
    public void user_should_be_able_to_click_continue_button_and_landing_to_page(String expectedTitle) {
        userInfoPage.continueButton.click();
        Assert.assertEquals(expectedTitle, userInfoPage.title.getText());
    }

    @When("user should be able to click continue button")
    public void user_should_be_able_to_click_continue_button() {
        userInfoPage.continueButton.click();
    }

    @When("user should see the err message show {string}")
    public void user_should_see_the_err_message_show(String expectedError) {
        Assert.assertEquals(expectedError,userInfoPage.firstErrorMessage.getText());
    }

    @When("click close error message and re-enter more information")
    public void click_close_error_message_and_re_enter_more_information() {
        userInfoPage.closeErrorButton.click();
    }

    @When("user enter {string} as first name and click continue button")
    public void user_enter_as_first_name_and_click_continue_button(String firstName) {
        BrowserUtil.waitForVisibility(userInfoPage.firstName,2);
        userInfoPage.firstName.sendKeys(firstName);
    }

    @Then("user should see last name err message show {string}")
    public void user_should_see_last_name_err_message_show(String expectedError) {
        Assert.assertEquals(expectedError,userInfoPage.lastNameErrorMessage.getText());
    }

    @Then("user should see zipcode err message show {string}")
    public void user_should_see_zipcode_err_message_show(String expectedError) {
        Assert.assertEquals(expectedError,userInfoPage.zipCodeErrorMessage.getText());
    }

    @Then("user should be able to click cancel button and go back to cart page {string} title")
    public void user_should_be_able_to_click_cancel_button_and_go_back_to_cart_page_title(String expectedTitle) {
        userInfoPage.cancelButton.click();
        Assert.assertEquals(expectedTitle, userInfoPage.title.getText());
    }
}
