package org.example.Pages.PageOjectModel.VWO.Normal_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage{

    //Driver Instances
    WebDriver driver;

    // Page Class

    // Step 0 -  Param Constructor
    public DashboardPage(WebDriver driver){//calling WebDriver
        this.driver = driver;
    }

    private By userNameOnDashboard = By.xpath("//h6");
    // Page Actions
    public String loggedInUserName() {
//  WaitHelpers.visibilityOfElement(userNameOnDashboard);
        driver.get("https://app.vwo.com/#/dashboard");
        return  driver.findElement(userNameOnDashboard).getText();
    }

}
