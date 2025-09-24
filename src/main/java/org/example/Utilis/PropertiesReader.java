package org.example.Utilis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    // Read the data.properties and give to anyone who wants with key.
    // url ->

    //We create the static function so that we dont need to
    // create the object every time


    public static String readKey(String key){
        //String key --Give me the key i will give the value from data.properties
        // we use the properties which is legacy class
        Properties P ;
        String user_dir = System.getProperty("user.dir");
        //user directory-->
        //  C:\Users\ashok\IdeaProjects\ATB13xSeleniumAdvancedFramework\
        String file_path = user_dir+ "\\src\\main\\Resources\\data.properties";
        //the path of the data.proerties

        // to read the data need to use File Input stream
        //This is a checked expection before reading the file they can be any issue
        try {
            FileInputStream fileInputStream = new FileInputStream(file_path);
           P = new Properties();
            P.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return P.getProperty(key);//will return the key from data.properties

    }

//The advantage of static is we can directly use
// the property reader to get the URl,Username etc...
    //In your pages

}