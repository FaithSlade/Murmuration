package com.products.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserInfo {

    @When("user enter {string} as first name and {string} as last name")
    public void user_enter_as_first_name_and_as_last_name(String firstName, String LastName) {

    }
    @When("user enter valid zip code {int}")
    public void user_enter_valid_zip_code(Integer zipCode) {

    }
    @Then("user should be able to click continue button and landing to checkout overview page")
    public void user_should_be_able_to_click_continue_button_and_landing_to_checkout_overview_page() {

    }

    @When("user should not be able to click continue button")
    public void user_should_not_be_able_to_click_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("user should see the err message show {string}")
    public void user_should_see_the_err_message_show(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("click close error message and re-enter more information")
    public void click_close_error_message_and_re_enter_more_information() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user enter {string} as first name and click continue button")
    public void user_enter_as_first_name_and_click_continue_button(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user should be able to click cancel button and go back to cart page")
    public void user_should_be_able_to_click_cancel_button_and_go_back_to_cart_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
