package com.products.stepDefinitions;

import com.products.pages.LogoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Logout {

    LogoutPage logoutPage = new LogoutPage();

    @When("user click on the top left menu bar")
    public void user_click_on_the_top_left_menu_bar() {
        logoutPage.menuButton.click();
    }

    @When("user should be able to click on logout button")
    public void user_should_be_able_to_click_on_logout_button() {
        logoutPage.logoutLink.click();
    }

    @Then("verify user should landing on the login page and see {string}")
    public void verify_user_should_landing_on_the_login_page_and_see(String expectedLogo) {
        Assert.assertEquals(expectedLogo, logoutPage.logoutLogo.getText());
    }
}
