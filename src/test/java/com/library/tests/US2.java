package com.library.tests;


import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.tests.base.TestBase;

import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US2 extends TestBase {

    @Test
    public void us2test1() {

        LoginPage loginPage = new LoginPage();
        // Given I am in the homepage of library app
        loginPage.login();
        BrowserUtil.waitFor(2);

        // When I take borrowed books number (actual)
        DashBoardPage dashBoardPage=new DashBoardPage();
        String actualBorrowBooksNumber = dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("actualBorrowBooksNumber from UI= " + actualBorrowBooksNumber);
        // When I take borrowed books number from DB  (expected)
        DB_Util.runQuery("SELECT COUNT(*)\n" +
                "FROM book_borrow\n" +
                "WHERE is_returned = 0");
        String expectedBorrowBooksNumber = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedBorrowBooksNumber from DB = " + expectedBorrowBooksNumber);
        //    Then borrowed books number information from UI must match with DB
        Assert.assertEquals(actualBorrowBooksNumber, expectedBorrowBooksNumber);


        //    Then borrowed books number information must match with DB


    }
}
