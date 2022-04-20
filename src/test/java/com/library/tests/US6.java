package com.library.tests;


import com.library.pages.BookPage;
import com.library.pages.CommonAreaPage;
import com.library.pages.LoginPage;
import com.library.tests.base.TestBase;

import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class US6 extends TestBase {

    @Test
    public void us6test1() {
        //Given I am in the homepage of library app
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        //    When I navigate to "Books" page
        new CommonAreaPage().navigateModule("Books");

        //    And I take all book categories in webpage
        WebElement elementOfDropdown = new BookPage().mainCategoryElement;
        List<String> actualBookCategories = BrowserUtil.getAllSelectOptions(elementOfDropdown);
        System.out.println("actualBookCategories from UI = " + actualBookCategories);
        actualBookCategories.remove(0);//remove all

        //    And I execute query to get book categories
        DB_Util.runQuery ( "SELECT name\n" +
                          "FROM book_categories");
        List<String> expectedBookCategories = DB_Util.getColumnDataAsList(1);
        System.out.println("expectedBookCategories from DB = " + expectedBookCategories);

        //    Then verify book categories must match book_categories table from db
        Assert.assertEquals(actualBookCategories, expectedBookCategories);

    }
}
