-------QUERY BASICS!!!

DESC employee;
SELECT * FROM employee;
--SELECT [column1, column2, etc] FROM [table name]
SELECT lastname, firstname, FROM employee;
SELECT firstname, lastname, FROM employee;
--ALIAS (using the "AS" keyword) changes the title of the attribute in a result set.

SELECT lastname AS muffin, firstname AS button FROM employee;

-- a result set is a temporary table in memory that stores the results of your queries
---run any query and a result set table appears temporarily.


----DIFFERENT SELECTS
SELECT * FROM employee;
-- WHERE clause is essentially a filter clause
SELECT * FROM employee WHERE title='Sales Support Agent';
SELECT * FROM employee WHERE title='Sales Support Agent' AND firstname='Jane';
SELECT * FROM employee WHERE firstname='Steve' OR firstname='Jane' OR firstname='Nancy';

--NULL references
SELECT * FROM employee WHERE reportsto IS NULL;
SELECT * FROM employee WHERE reportsto IS NOT NULL;

--ALSO, you can use >,<, <=, >= in the where clause
SELECT * FROM employee WHERE reportsto>1;

--Different ways to say "not equals"
SELECT * FROM employee WHERE firstname != 'Jane';
SELECT * FROM employee WHERE firstname ^= 'Jane';
SELECT * FROM employee WHERE firstname <> 'Jane';
SELECT * FROM employee WHERE NOT firstname = 'Jane';

--
DESC album;
SELECT * FROM album;
--LIKE keyword, finds patterns in the attribute
--'%' is like a wildcard that is a stand-in for 0 or more characters
--'_' is like a wildcard that is a stand-in for EXACTLY ONE character
SELECT * FROM album WHERE title LIKE 'B%';
SELECT * FROM album WHERE title LIKE 'Bi%';
SELECT * FROM album WHERE title LIKE '%ig%O%s';
SELECT * FROM album WHERE title LIKE '%Big O_es';--1 result
SELECT * FROM album WHERE title LIKE '%Big O_nes';--0 results

DESC employee;
SELECT * FROM employee;
----ORDER BY example ----- aka sorting
------DEFAULT to ascending
SELECT * FROM employee ORDER BY firstname;
SELECT * FROM employee ORDER BY firstname ASC;
SELECT * FROM employee ORDER BY firstname DESC;
---
SELECT * FROM employee ORDER BY title, firstname, lastname;

SELECT * FROM employee;
--BETWEEN keyword
----inclusive range
SELECT * FROM employee WHERE employeeid BETWEEN 5 and 7;
SELECT * FROM employee WHERE employeeid BETWEEN 5 and 7 AND title='IT Staff';

--IN keyword
SELECT * FROM employee WHERE firstname='Steve' OR firstname='Jane' OR firstname='Nancy';

SELECT * FROM employee WHERE firstname IN('Nancy', 'Jane', 'Steve');

----SUBQUERY example
SELECT * FROM customer;
SELECT * FROM invoice;

SELECT * FROM customer A WHERE A.customerid IN(
    SELECT customerid FROM invoice B WHERE B.total>16.0);
    
SELECT customerid, total, invoiceid FROM (SELECT * FROM invoice WHERE total>16.00)
    WHERE invoiceid>200;
    
-------AGGREGATE functions-------
--what is an aggregate function?
-- a calculation operating on a group of records/entries
----there are different types of aggregate functions:
-------COUNT, MAX, AVG, SUM, DISTINCT
---------there are more...but I want to highlight these
SELECT * FROM album;
SELECT COUNT(*) FROM album;
SELECT * FROM employee;
SELECT COUNT(*) FROM employee WHERE title='Sales Support Agent';
--how do we get unique titles?
SELECT COUNT(DISTINCT(title)) FROM employee;

SELECT * FROM invoice;
---OTHER aggregate examples
SELECT invoiceid, customerid, total FROM invoice;
SELECT MAX(total) FROM invoice;
SELECT MIN(total) FROM invoice;
SELECT AVG(total) FROM invoice;
SELECT SUM(total) FROM invoice;
SELECT MEDIAN(total) FROM invoice;

SELECT * FROM invoice;
SELECT billingcountry, total FROM invoice;
--GROUP BY
--group by allows aggregate functions to operate on smaller pockets of data
SELECT billingcountry, COUNT(*) AS sales FROM invoice GROUP BY billingcountry;

--HAVING example
-----when group by is NOT used HAVING behaves like WHERE
-----WHERE filters BEFORE aggregate functions, HAVING filters after the line below will not work
--SELECT billingcountry, SUM(total) FROM invoice WHERE total>50 GROUP BY billingcountry;
SELECT billingcountry, SUM(total) FROM invoice GROUP BY billingcountry HAVING SUM(total)>50;
--NOTE: WHERE goes before GROUP BY goes before HAVING

------SCALAR functions------
/*what is an aggregate function?
    a calculation operating on a single record/entrie
    
THE FOLLOWING IS MY OWN TERMINOLOGY, OTHERS MAY NOT KNOW WHAT YOU'RE TALKING ABOUT IF YOU MENTION IT
CATEGORIES OF Scalar functions:
    numeric, character, date, conversion
*/

--FIRST, what it dual?
--dual is a dummy table. It simply echoes a value back to you
--We'll use it like a sysout
SELECT 'hello world' FROM dual;
SELECT 5*7 FROM dual;
SELECT * FROM dual; ---the default value of dual is 'X'

--NUMERIC functions
----abs(x), ceil(x), floor(x), trunc(x,y), round(x,y), and more...
SELECT abs(-99) FROM dual; --abs finds the absolute value
SELECT floor(88.77) FROM dual; -- floor finds the round down whole number
SELECT ceil(88.77) FROM dual; -- ceil finds the round up whole number
SELECT trunc(888888.7211237, 4) FROM dual; --trunc prints the number of decimal points you want 
SELECT round(888888.7989837, -2) FROM dual; --round prints the rounded number of the decimal place given

--Character or Text functions
----lower(x), upper(x), length(x), and more...
SELECT 'hello world' FROM dual;
SELECT upper('hello world') FROM dual;
SELECT lower('hello world') FROM dual;
SELECT length('hello world') FROM dual;

--DATE there are lots of 
--  next_day(x, 'week_day'), last_day(x), sysdate and more...
SELECT sysdate FROM dual;
SELECT last_day(sysdate) FROM dual;
SELECT next_day(sysdate, 'Thursday') FROM dual;

----Conversion convert data types
--- to_char(), to_date(), and more...
-----we'll ignore these examples for now

SELECT * FROM invoice;
SELECT billingcountry, billingcity FROM invoice;
SELECT billingcountry, upper(billingcity) FROM invoice;

















