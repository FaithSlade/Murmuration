package com.products.stepDefinitions;

import com.products.pages.LoginPage;
import com.products.utilities.ConfigurationReader;
import com.products.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginSwagLabs {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page of the Swag Labs")
    public void user_is_on_the_login_page_of_the_swag_labs() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("users enter username valid username {string}")
    public void users_enter_username_valid_username(String userName) {
        loginPage.username.sendKeys(userName);
    }

    @When("user enter valid password {string}")
    public void user_enter_valid_password(String password) {
        loginPage.password.sendKeys(password);
    }

    @When("user click log in button")
    public void user_click_log_in_button() {
        loginPage.loginButton.click();
    }

    @Then("user should see {string} message locked out")
    public void user_should_see_message_locked_out(String expectedMessage) {
        loginPage.VerifyErrorMessage(expectedMessage);
    }
    @Then("user should see {string} message")
    public void user_should_see_message(String expectedMessage) {
        loginPage.VerifyErrorMessage(expectedMessage);
    }

    @Then("user should see {string} password error message")
    public void user_should_see_error_message(String expectedMessage) {
        loginPage.VerifyErrorMessage(expectedMessage);
    }

    @Then("user should see {string} username error message")
    public void user_should_see_username_error_message(String expectedMessage) {
        loginPage.VerifyErrorMessage(expectedMessage);
    }

    @When("users enter username invalid username")
    public void users_enter_username_invalid_username(List<String> invalidUsername) {
        for (String each : invalidUsername) {
            loginPage.username.sendKeys(each);
        }
    }

    @When("user enter invalid password")
    public void user_enter_invalid_password(List<String> invalidPassword) {
        for (String each : invalidPassword) {
            loginPage.password.sendKeys(each);
        }
    }

    @Then("user should see the products inventory {string} page title")
    public void user_should_see_the_products_inventory_page_title(String title) {
        Assert.assertEquals(title,loginPage.title.getText());
    }
}
