package com.saucedemo.pages;

import com.saucedemo.utils.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(className = "app_logo")
    public WebElement logo;


    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "[class='error-message-container error']")
    private WebElement warningMessage;

    public String getWarningMessageText() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return warningMessage.getText().trim();
    }

    public void login(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }
    public void loginWithOnlyUsername(String usernameValue) {
        username.sendKeys(usernameValue, Keys.ENTER);
         }

    public void loginWithOnlyPassword(String key) {
        password.sendKeys(key, Keys.ENTER);
    }

    public void login() {
        String usernameValue = ConfigurationReader.getProperty("standard.username");
        String passwordValue = ConfigurationReader.getProperty("password");

        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }


    public void login(String role) {
        String usernameValue = "";
        String passwordValue = ConfigurationReader.getProperty("password");

        if (role.equals("locked_out_user")) {
            usernameValue = ConfigurationReader.getProperty("locked.username");
        } else if (role.equals("standard_user")) {
            usernameValue = ConfigurationReader.getProperty("standard.username");
        }
        else if (role.equals("problem_user")) {
            usernameValue = ConfigurationReader.getProperty("problem.username");
        } else {
            usernameValue = ConfigurationReader.getProperty("performance.username");
        }

        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }
}