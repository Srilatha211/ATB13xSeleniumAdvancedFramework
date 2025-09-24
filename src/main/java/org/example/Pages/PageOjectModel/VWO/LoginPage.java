package org.example.Pages.PageOjectModel.VWO;

import org.example.Utilis.PropertiesReader;
import org.example.Utilis.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage  {

    //Driver Instances
WebDriver driver;

    // Page Class

    // Step 0 -  Param Constructor
    public LoginPage(WebDriver driver){//calling WebDriver
        this.driver = driver;
    }

//Step 1- Page Locators -- By -- is a locator

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");


    //  If you are not using it , don't keep.
    //private By signBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']");


    // Step 2 - Page Actions
    public String  loginToVWOLoginInvalidCreds(String user, String pwd) {

//driver.get("https://app.vwo.com/");
// Insted of this is can use the staic function from property reader and
// get the data from data.properties , no need of harcode values
// and can do the smae in Logintest
driver.get(PropertiesReader.readKey("url"));
driver.findElement(username).sendKeys(user);
driver.findElement(password).sendKeys(pwd);
driver.findElement(signButton).click();

        WaitHelpers.checkVisibility(driver,error_message);

       String err_msg =  driver.findElement(error_message).getText();
       return err_msg;


    }

    public void loginToVWOLoginValidCreds(String user, String pwd) {
        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        // Wait - Thread sleep
        WaitHelpers.waitJVM(5000);
    }



}
