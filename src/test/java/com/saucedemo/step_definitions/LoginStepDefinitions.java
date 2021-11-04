package com.saucedemo.step_definitions;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.BrowserUtils;
import com.saucedemo.utils.ConfigurationReader;
import com.saucedemo.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get("https://www.saucedemo.com");
    }

    @When("user logs in")
    public void user_logs_in() {
        loginPage.login();
    }

    @Then("user should see first backpack")
    public void user_should_see_first_backpack() {
        String expected = "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg";
        String actual = loginPage.getPictureTitleText();

        Assert.assertEquals("Title is not correct!", expected, actual);
        System.out.println("I successfully see the picture of the first backpack !");
        Driver.closeDriver();
    }

    @When("user waits a while and should see first backpack")
    public void user_waits_a_while_and_should_see_first_backpack() {


        String expected = "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.34e7aa42.jpg";
        BrowserUtils.clickOnElement(loginPage.logo);


        String actual = loginPage.getPictureTitleText();

        Assert.assertEquals("Title is not correct!", expected, actual);
        System.out.println("I successfully see the picture of the first backpack !");
        Driver.closeDriver();
    }


    @Then("user should see {string} page")
    public void user_should_see_page(String string) {
        String actual = loginPage.getPictureTitleText().trim();
        Assert.assertEquals("Page title is not correct!", string, actual);
    }

    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String string) {
        loginPage.login(string);
    }


    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {
        loginPage.login(string, string2);
    }


    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String expected) {
        String actualResult = loginPage.getWarningMessageText();
        Assert.assertEquals(expected, actualResult);
    }

    @Then("user should see dog picture")
    public void user_should_see_dog_picture() {
        String expected = "https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg";
        String actual = loginPage.getPictureTitleText();

        Assert.assertEquals("Title is correct!", expected, actual);
        System.out.println("I successfully see the picture of the dog !");
        Driver.closeDriver();
    }

    @Then("user should get warning message")
    public void user_should_get_warning_message() {
        String expected = "Epic sadface: Sorry, this user has been locked out.";
        String actual = loginPage.getWarningMessageText();

        Assert.assertEquals("Title is correct!", expected, actual);
        System.out.println("I successfully get the warning message !");
        Driver.closeDriver();
    }




    @When("do not type the password")
    public void do_not_type_the(String userName) {
    loginPage.loginWithOnlyUsername(userName);

    }

    @Then("user should get a message")
    public void user_should_get_a_message() {
        String expected = "Epic sadface: Password is required";
        String actual = loginPage.getWarningMessageText();

        Assert.assertEquals("Title is not correct!", expected, actual);
        System.out.println("I successfully get the warning message !");
        Driver.closeDriver();

    }

    @When("user logs in with {string} username and no password")
    public void user_logs_in_with_username_and_no_password(String string) {
        loginPage.loginWithOnlyUsername(string);
    }

    @When("user logs in with no username but valid password")
    public void user_logs_in_with_no_username_but_valid_password() {
     loginPage.loginWithOnlyPassword(ConfigurationReader.getProperty("password"));
    }



}