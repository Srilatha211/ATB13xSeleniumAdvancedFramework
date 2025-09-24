package org.example.Pages.PageOjectModel.VWO.Improved_POM;

import org.example.Base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.example.Driver.DriverManager.getDriver;
import org.example.Utilis.WaitHelpers;

public class DashboardPage  extends CommonToAllPage {



    WebDriver driver;

    public DashboardPage(WebDriver driver){//calling WebDriver
        this.driver = driver;
    }
    private By userNameOnDashboard = By.xpath("//h6");


    public String loggedInUserName() {
  WaitHelpers.visibilityOfElement(userNameOnDashboard);
        return  getText(userNameOnDashboard);
    }





}
