package com.library.tests;

import com.library.tests.base.TestBase;

import com.library.utility.DB_Util;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US4 extends TestBase {

    @Test
    public void us4test1() {
        // When I execute query to find most popular user
        String query = "SELECT u.full_name, COUNT(*) AS countofreadbooks\n" +
                        "FROM users u\n" +
                        "INNER JOIN book_borrow bb ON u.id = bb.user_id\n" +
                        "GROUP BY full_name\n" +
                        "ORDER BY 2 DESC";
        //get actual name
        DB_Util.runQuery(query);
        String actualName = DB_Util.getCellValue(1,1);
        System.out.println("actualName from DB = " + actualName);

        //expected from user
        String expectedName = "Test Student 1";
        System.out.println("expectedName from user = " + expectedName);

        //    Then verify "Test Student 1" is the user who reads the most
        Assert.assertEquals(actualName, expectedName);


    }
}
