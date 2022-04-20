package com.library.tests;


import com.library.pages.BookPage;
import com.library.pages.CommonAreaPage;
import com.library.pages.LoginPage;
import com.library.tests.base.TestBase;

import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;


public class US5 extends TestBase {


    @Test
    public void us5test1() {
        LoginPage loginPage = new LoginPage();
        // Given I am in the homepage of library app
        loginPage.login();

        //    When I navigate to "Books" page
        CommonAreaPage commonAreaPage = new CommonAreaPage();
        commonAreaPage.navigateModule("Books");

//    And I open a book called "Chordeiles minor"
        String bookName = "Chordeiles minor";
        BookPage bookPage = new BookPage();
        bookPage.search.sendKeys(bookName);
        BrowserUtil.waitFor(3);

        //    And I execute query to get the book information from books table
        String query = "SELECT name, author, year\n" +
                       "FROM books\n" +
                       "WHERE name = 'Chordeiles minor'";
        DB_Util.runQuery(query);

        //    Then verify book DB and UI information must match

        // DB Data
        Map <String,String> expectedRow = DB_Util.getRowMap(1);
       String expectedBookName =  expectedRow.get("name");
       String expectedBookAuthor =  expectedRow.get("author");
       String expectedBookYear =  expectedRow.get("year");

        // UI Data
        String actualBookName = bookPage.bookName.getText(); //from Dashboard page
        String actualBookAuthor = bookPage.authorName.getText();//from Dashboard page
        String actualBookYear = bookPage.year.getText();//from Dashboard page

        // Verify
        Assert.assertEquals(actualBookName, expectedBookName);
        Assert.assertEquals(actualBookAuthor, expectedBookAuthor);
        Assert.assertEquals(actualBookYear, expectedBookYear);

    }
}
