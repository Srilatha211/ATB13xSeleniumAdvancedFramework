package org.example.Pages.PageOjectModel.VWO;


import org.example.Utilis.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FreeTrial {

    WebDriver driver;

    public FreeTrial(WebDriver driver) {//calling WebDriver
        this.driver = driver;
    }


    private By userName = By.id("page-v1-step1-email");
    private By checkBox = By.id("page-free-trial-step1-cu-gdpr-consent-checkbox");
    private By Submitbutton = By.xpath("//button[text()=\"Create a Free Trial Account\"]");
    private By err_msg = By.xpath("//div[contains(@class,\" invalid-reason\")]");

    public String INValidfreetrial(String User) {

        driver.get("https://vwo.com/free-trial/");
        driver.findElement(userName).sendKeys("@123");
        driver.findElement(checkBox).click();
        driver.findElement(Submitbutton).click();


        WaitHelpers.checkVisibility(driver,err_msg);
        String errortext = driver.findElement(err_msg).getText();
        return errortext;
    }

//    public String Validfreetrial(String User) {
//
//        driver.get("https://vwo.com/free-trial/");
//        driver.findElement(userName).sendKeys("@123");
//        driver.findElement(checkBox).click();
//        driver.findElement(Submitbutton).click();
//
//
//    }

}