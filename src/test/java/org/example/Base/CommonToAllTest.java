package org.example.Base;

import org.example.Driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//Now this will be used bt all tests

public class CommonToAllTest {
//Before running anything we need to set up the brower

    @BeforeMethod
    public void setUp(){
        DriverManager.init();
    }
//After running anything we need to set up the brower

    @AfterMethod
    public void tearDown(){
        DriverManager.down();
    }


}