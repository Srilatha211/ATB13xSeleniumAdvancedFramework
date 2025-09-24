package org.example.Test.VWO.PageObjectModel;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.example.Base.CommonToAllTest;
import org.example.Driver.DriverManager;
import org.example.Pages.PageOjectModel.VWO.DashboardPage;
import org.example.Pages.PageOjectModel.VWO.LoginPage;
import org.example.Utilis.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_02_Properties_POM  extends CommonToAllTest {


    private static final Logger logger = LogManager.getLogger(TestVWOLogin_02_Properties_POM.class);

    @Owner("Srilatha")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")    @Test
    public void loginToVWOLoginInvalidCreds(){

        logger.info("Starting the Testcases Page Object Model");


        // Driver Manager Code - 1 - D // calling from CommontoallTest



        // Page Class Code (POM Code) - 2 - L

        LoginPage loginpage = new LoginPage(DriverManager.getDriver());
        String err_msg= loginpage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        // Assertions - 3 - V
        logger.info("Asserting the invalid credentials");

        assertThat(err_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(err_msg,PropertiesReader.readKey("error_message"));



    }

    @Owner("Srilatha")
   @Description ("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {
        logger.info("Starting the Testcases Page Object Model");


        // Driver Manager Code - 1 - D // calling from CommontoallTest



        // Page Class Code (POM Code) - 2 - L

        LoginPage loginpage = new LoginPage(DriverManager.getDriver());
        loginpage.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        //after valid credentials Dashboard page is loaded
        //So, we call Dashbaord Instances

        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        //Now will get the username directly

        String Username = dashboardPage.loggedInUserName();
        //Now willl verify that should be equal to "Amcret"

        assertThat(Username).isNotBlank().isNotNull().isNotEmpty();
        logger.info("Done the Test cases");

        Assert.assertEquals(Username,PropertiesReader.readKey("expected_username"));



        //To run the file will create testNg file by
        //Go to folder on top (ATB13X..) > Right click > Create TestNG >
    }
}
