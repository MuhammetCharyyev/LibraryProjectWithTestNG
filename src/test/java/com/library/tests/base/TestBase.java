package com.library.tests.base;


import com.library.utility.ConfigReader;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void setupDriver() {
        // Given Establish the database connection
        String url = ConfigReader.read("library2.db.url");
        String username = ConfigReader.read("library2.db.username");
        String passoword = ConfigReader.read("library2.db.password");
        DB_Util.createConnection(url, username, passoword);
        /*
        DB_Util.createConnection(ConfigReader.read("library2.db.url"),
        ConfigReader.read("library2.db.username"),
        ConfigReader.read("library2.db.password") );
         */
    }


    @AfterMethod
    public void dbTearDown() {
        //destroy  the database connection
        DB_Util.destroy();
        //close the browser
        Driver.closeBrowser();

    }

}