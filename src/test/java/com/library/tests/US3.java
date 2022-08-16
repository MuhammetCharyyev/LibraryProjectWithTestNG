package com.library.tests;

import com.library.tests.base.TestBase;

import com.library.utility.DB_Util;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US3 extends TestBase {
    @Test
    public void us3test1() {
        //When I execute query to find most popular book genre
        String query = "SELECT book_categories.name, COUNT(*) AS countofbookcategories\n" +
                        "FROM book_borrow\n" +
                        "INNER JOIN books\n" +
                        "ON book_borrow.book_id = books.id\n" +
                        "INNER JOIN book_categories\n" +
                        "ON books.book_category_id = book_categories.id\n" +
                        "GROUP BY book_categories.name\n" +
                        "ORDER BY 2 DESC";
        //"ORDER BY countofbookcategories DESC";

        DB_Util.runQuery(query);
        String actualPopularCategory = DB_Util.getFirstRowFirstColumn();
        // String actualPopularCategory = DB_Util.getCellValue(1, 1);
        System.out.println("actualPopularCategory = " + actualPopularCategory);

        //    Then verify "Classic" is the most popular book genre.
        String expectedPopularCategory = "Classic";
        System.out.println("expectedPopularCategory = " + expectedPopularCategory);
        Assert.assertEquals(actualPopularCategory, expectedPopularCategory);


    }
}
