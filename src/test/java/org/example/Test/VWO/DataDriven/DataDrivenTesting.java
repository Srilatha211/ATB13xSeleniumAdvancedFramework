package org.example.Test.VWO.DataDriven;
import org.example.Base.CommonToAllTest;
import org.example.Driver.DriverManager;
import org.example.Pages.PageOjectModel.VWO.Improved_POM.LoginPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.UtilExcel.utilExcel;
import org.example.Utilis.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DataDrivenTesting extends CommonToAllTest {


    private static final Logger logger = LogManager.getLogger(DataDrivenTesting.class);



    @Test(dataProvider = "getData")
    public void test_vwo_login(String email, String password) {

        // Page Class Code (POM Code) - 2 - L
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(email,password);

        // Assertions - 3 - V

        logger.info("Asserting the Invalid credentials");

        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));



    }




    @DataProvider
    public Object[][] getData(){
        // READ THE DATA FROM THE EXCEL FILE
        // GIVE THEM IN THE 2D ARRAY
        return utilExcel.getTestDataFromExcel("sheet1");

    }
}