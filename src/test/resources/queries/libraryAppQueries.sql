-- us 01 query to get all columns

SELECT id
FROM users;

SELECT * FROM users;

-- us02 borrowed books number information must match with DB

SELECT *
FROM book_borrow;

SELECT COUNT(*)
FROM book_borrow
WHERE is_returned = 0;


-- us 03 -- query to find most popular book genre

SELECT bc.name, COUNT(*) AS countofbookcategories
FROM book_borrow bb
         INNER JOIN books b
             ON bb.book_id = b.id
         INNER JOIN book_categories bc
             ON b.book_category_id = bc.id
GROUP BY bc.name
ORDER BY 2 DESC;


-- us 04 query to find most popular user

SELECT full_name, COUNT(*) AS countofreadbooks
FROM users u
         INNER JOIN book_borrow bb ON u.id = bb.user_id
GROUP BY full_name
ORDER BY 2 DESC;
;


-- us05  query to get the book  "Chordeiles minor" information from books table
SELECT name, author, year
FROM books
WHERE name = 'Chordeiles minor';


-- us 06 query to get book categories
SELECT name
FROM book_categories;

