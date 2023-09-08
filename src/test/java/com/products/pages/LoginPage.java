package com.products.pages;

import com.products.utilities.ConfigurationReader;
import com.products.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user-name")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessage;

    @FindBy (xpath = "//span[@class='title']")
    public WebElement title;

    public void VerifyErrorMessage (String expectedMessage){
        Assert.assertEquals(expectedMessage,errorMessage.getText());
    }

    public void UserLogin(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        username.sendKeys(ConfigurationReader.getProperty("username1"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }

}
