package org.example.Driver;

import org.example.Utilis.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

//Who is going to use this Driver class -- from CommonTOAllTest  to --TestLogin class

public class DriverManager  {
//This is used to optimize the data for drivers,
// closing browser by using data properties and property reader

    //here we use the static function so that it will be shared within the testcases


    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    //Starting of browser
    public static void init(){
        //1.Will get the value from propwerty reader which is firefox
        //2.add ignore case toavoid small and capital letters
        //add switch case so that which briwser u want to strt

        String browser = PropertiesReader.readKey("browser");
        browser =browser.toLowerCase();
        switch (browser) {
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");
                driver = new EdgeDriver(edgeOptions);
                break;
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                System.out.println("Not browser Supported!!!");
        }


    }


    //Closing of browser

        public static void down() {
            if (getDriver() != null) {
                driver.quit();
                driver = null;
                //If my get driver is not equal to null quit and driver=null
            }

        }

    }

