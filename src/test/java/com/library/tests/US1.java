package com.library.tests;

import com.library.tests.base.TestBase;

import com.library.utility.DB_Util;
import org.apache.hc.core5.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;


public class US1 extends TestBase {

    @Test
    public void us1test1(){
        List<String > actualIDs = new ArrayList<>();
        Set<String> expectedIDs = new LinkedHashSet<>();
        //When Execute query to get all IDs from users
        String query = "SELECT id\n" +
                       "FROM users";
        DB_Util.runQuery(query);
        actualIDs = DB_Util.getColumnDataAsList(1);
        //get column by index as List -> actual
        System.out.println("actualIDs from DB = " + actualIDs);

        expectedIDs.addAll(actualIDs);
        //expected from user
        System.out.println("expectedIDs from user = " + expectedIDs);

         //Then verify all users has unique ID
        Assert.assertEquals(actualIDs, expectedIDs);




    }

    @Test
    public void us1test2(){
       // When Execute query to get all columns
        String query = "SELECT FROM users";
        DB_Util.runQuery(query);

        //from DB
        List<String> actualColumns = DB_Util.getAllColumnNamesAsList();
        System.out.println("actualColumns from DB = " + actualColumns);

        //expected from user
        List<String> expectedColumns=new ArrayList<>(Arrays.asList(
                "id",
                "full_name",
                "email",
                "password",
                "user_group_id",
                "image",
                "extra_data",
                "status",
                "is_admin",
                "start_date",
                "end_date",
                "address"));

        System.out.println("expectedColumns from user = " + expectedColumns);
        //    Then verify the below columns are listed in result
        Assert.assertEquals(actualColumns, expectedColumns);
    }

}
