---------QUERY BASICS!!!!!!

DESC employee;
--SELECT * <---------- the '*' means all columns
SELECT * FROM employee;
--SELECT [column1, column2, etc] FROM [table name]
SELECT lastname, firstname FROM employee;
SELECT firstname, lastname FROM employee;
--ALIAS (using the "AS" keyword) changes the title of the attribute in a result
--set
SELECT lastname AS muffin, firstname AS button FROM employee;

-- a result set is a temporary table in memor y that stores the results of your
-- queries
--- run any query and a result set table appear temporarily.

----DIFFERENT SELECTS
SELECT * FROM employee;
--WHERE clause is essentially a filter clause
SELECT * FROM employee WHERE title='Sales Support Agent';
SELECT * FROM employee WHERE title='Sales Support Agent' AND firstname='Jane';
SELECT * FROM employee WHERE firstname='Nancy' OR firstname='Steve' 
    OR firstname='Jane';
--ALSO, you can use >,<,<=,>= in the where clause;
SELECT * FROM employee WHERE reportsto>1;

-- different ways you can say "not equals"
SELECT * FROM employee WHERE firstname != 'Jane';
SELECT * FROM employee WHERE firstname ^= 'Jane';
SELECT * FROM employee WHERE firstname <> 'Jane';
SELECT * FROM employee WHERE NOT firstname = 'Jane';

--NULL References
SELECT * FROM employee WHERE reportsto=null;--Incorrect
SELECT * FROM employee WHERE reportsto=(null);--Incorrect
SELECT * FROM employee WHERE reportsto IS NULL;--Correct
SELECT * FROM employee WHERE reportsto IS NOT NULL;

DESC album;
SELECT * FROM album;

--LIKE keyword, finds patterns in the attribute 
--'%' is like a wildcard that is a stand-in for 0 or more characters
--'_' is like a wildcard that is a stand-in for EXACTLY ONE character
SELECT * FROM album WHERE title LIKE 'B%';
SELECT * FROM album WHERE title LIKE 'Bi%';
SELECT * FROM album WHERE title LIKE '%Big Ones';--1 result
SELECT * FROM album WHERE title LIKE '%Big O_nes';--0 results

DESC employee;
SELECT * FROM employee;
--ORDER BY example ----- aka sorting
-----DEFAULTS to ascending
SELECT * FROM employee ORDER BY firstname;
SELECT * FROM employee ORDER BY firstname ASC;
SELECT * FROM employee ORDER BY firstname DESC;

SELECT * FROM employee ORDER BY title, firstname, lastname;

SELECT * FROM employee;
--BETWEEN keyword
----inclusive range
SELECT * FROM employee WHERE employeeid BETWEEN 5 and 7;
SELECT * FROM employee WHERE employeeid BETWEEN 5 and 7 AND title='IT Staff';


---IN keyword
----IN creates a set of possibilities
SELECT * FROM employee WHERE firstname='Nancy' OR firstname='Steve' 
    OR firstname='Jane';
SELECT * FROM employee WHERE firstname IN('Nancy','Jane','Steve');

-----SUBQUERY example
SELECT * FROM customer;
SELECT * FROM invoice;

SELECT * FROM customer A WHERE A.customerid IN
    (SELECT customerid FROM invoice B WHERE B.total>16.0);
    
SELECT customerid, total, invoiceid FROM (SELECT * FROM invoice WHERE total>16.00)
    WHERE invoiceid>200;
    
---------AGGREGATE functions-------
--What is an aggreagate function?
-- a calculation operating on a group of records/entries
----there are different types of aggregate functions:
----COUNT, MAX, MIN, AVG, DISTINCT
------there are more...
SELECT * FROM album;
SELECT COUNT(*) FROM album;
SELECT * FROM employee;
SELECT COUNT(*) FROM employee WHERE title = 'Sales Support Agent';
--how do we get unique titles?
SELECT COUNT(DISTINCT(title)) FROM employee;     

SELECT * FROM invoice;
---OTHER aggreagte functions
SELECT invoiceid, customerid, total FROM invoice;
SELECT MAX(total) FROM invoice;
SELECT MIN(total) FROM invoice;
SELECT AVG(total) FROM invoice;
SELECT SUM(total) FROM invoice;
SELECT MEDIAN(total) FROM invoice;

--GROUP BY 
--group by allows aggregate functions to operate on smaller pockets of data
SELECT billingcountry, COUNT(*) AS sales FROM invoice GROUP BY billingcountry;


--HAVING example
----when group by is not used having behaves like a where
----where filters BEFORE aggregate functions, Having filters after
---This will not work
--SELECT billingcountry,SUM(total) FROM invoice WHERE total > 50 GROUP BY billingcountry;
SELECT billingcountry,SUM(total) FROM invoice GROUP BY billingcountry 
        HAVING SUM(total) > 50;
--NOTE: WHERE goes before BROUP BY goes before HAVING

----SCALAR functions
/*What is an scalar function?
a calculation operating on a single record/entrie ata a time

THE FOLLOWING IS TREVIN'S TERMINOLOGY, OTHERS MAY NOT KNOW ABOUT IT
IF WE MENTION IT
CATEGORIES OF scalar functions:
    numeric, character, date, conversion
*/

--What is dual?
--dual is a dummy table. It simply echos a value back to you.
--We'll use it like a sysout

SELECT 'hello world' FROM dual;
SELECT 5*7 FROM dual;
SELECT * FROM dual; ---the default value of dual is 'X'

---NUMERIC
----abs(x), ceil(x), floor(x), trunc(x,y), round(x,y), and more...
SELECT abs(-99) FROM dual;
SELECT floor(88.77) FROM dual;
SELECT ceil(88.77) FROM dual;
SELECT trunc(8886.68651687651687951687, 4) FROM dual;
SELECT trunc(8886.68651687651687951687, -2) FROM dual;
SELECT round(8888.65498746216876516876, 2) FROM dual;

-----CHARACTER there are lots of these INCLUDING:
---- upper(x), lower(x), length(x), and more...
SELECT 'Hello World' FROM dual;
SELECT upper('Hello World') FROM dual;
SELECT lower('Hello World') FROM dual;
SELECT length('Hello World') FROM dual;
 
---DATE there are lots of these
---- next_day(x, 'week_day'), last_day(x), sysdate, and more...
SELECT sysdate FROM dual;
SELECT last_day(sysdate) FROM dual;
SELECT next_day(sysdate, 'Friday') FROM dual;

---CONVERSION convert data types
---to_char(), to_date(), and more
----we'll ignore these examples for now

SELECT * FROM invoice;
SELECT billingcountry, billingcity FROM invoice;
SELECT billingcountry, upper(billingcity) FROM invoice;

commit;
rollback;



