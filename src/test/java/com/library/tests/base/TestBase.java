package com.library.tests.base;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void setupDriver() {
        // Given Establish the database connection


    }


    @AfterMethod
    public void dbTearDown() {
      //destroy  the database connection

        //close the browser

    }

}
