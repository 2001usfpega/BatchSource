---1.0 Oracle Chinook conneciton established

---2.0 SQL QUERIES
---2.1 SQL SELECT
---SELECT ALL FROM table employee
SELECT * FROM employee;
---SELECT ALL FROM table employee WHERE lastname column is equal to "King"
SELECT * FROM employee WHERE lastname='King';
---SELECT ALL FROM table employee WHERE firstname column is equal to "Andrew" and the reportsto column is null
SELECT * FROM employee WHERE firstname='Andrew' AND reportsto IS NULL;

---2.2 ORDER BY
---SELECT ALL FROM table album
SELECT * FROM album;
---SELECT ALL FROM table album and ORDER the entries by the title column in descending order
SELECT * FROM album ORDER BY title DESC;
---SELECT firstname and city columns from the customer table and order the entries by City
SELECT firstname, city FROM customer ORDER BY city;

---2.3 INSERT INTO
---SELECT all from the genre table
SELECT * FROM genre;
---INSERT "Country" and "EMO" into the genre table
INSERT INTO genre VALUES (26, 'Country');
INSERT INTO genre VALUES (27, 'EMO');


---SELECT ALL FROM employee table
SELECT * FROM employee;
---INSERT the two new entries into the employee table
INSERT INTO employee VALUES (9, 'Torres', 'Eric', 'Assistant General Manager', 1, '26-SEP-79', '13-JAN-20', '14511 Prism Circle, Unit 208', 'Tampa Bay', 'FL', 'USA', '33613', '+1 (504) 722-0278', '+1 (504) 324-0179', 'etorresnotary@gmail.com');
INSERT INTO employee VALUES (10, 'Thornton', 'Parker', 'IT Consultant', 6, '06-APR-20', '13-JAN-20', '14511 Prism Circle, Unit 208', 'Tampa Bay', 'FL', 'USA', '33613', '+1 (321) 314-2172', '+1 (321) 654-8927', 'parkerkt77@gmail.com');

---SELECT ALL FROM customer table
SELECT * FROM customer;
---INSERT two new entries into the customer table
INSERT INTO customer VALUES (60, 'Donna', 'Torres', 'Louisiana State University', '25 Dalrymple Drive', 'Baton Rouge', 'LA', 'USA', '70808', '+1 (225) 578-1623', 'null', 'dtorres@lsu.edu', 2);
INSERT INTO customer VALUES (61, 'Thomas', 'Robichaux', 'null', '18654 Milan Avenue', 'New Orleans', 'LA', 'United States', '70118', '+1 (504) 682-8672', 'null', 'trobichaux@gmail.com', 2);

---2.4 UPDATE
---SELECT ALL FROM the customer table
SELECT * FROM customer;
---UPDATE the customer table WHERE customer id = 32 and change firstname to "Robert" and lastname to "Walter
UPDATE customer SET firstname='Robert', lastname='Walter' WHERE customerid = 32;

---SELECT ALL FROM the artist table
SELECT * FROM artist;
---UPDATE artist table at artistid = 75 and set name to "CCR" from Creedence Clearwater Revival
UPDATE artist SET name='CCR' WHERE artistid = 75;

---2.5 LIKE
---SELECT ALL FROM the invoice table 
SELECT * FROM invoice;
---SELECT ALL FROM the invoice table and pull the entries with "T" in billingaddress
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

---2.6 BETWEEN
---SELECT ALL FROM invoice table
SELECT * FROM invoice;
---SELECT ALL FROM invoice table and return total between 15 and 50 (inclusive)
SELECT * FROM invoice WHERE total BETWEEN 15 and 50;
---SELECT ALL FROM employee table
SELECT * FROM employee;
---SELECT ALL FROM employee table and return entries where hiredate is between June 1, 2003 and March 1, 2004
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' and '01-MAR-04';

---2.7 DELETE 
---SELECT ALL FROM customer table
SELECT * FROM customer;
---SELECT ALL FROM USER_CONSTRAINTS to see where the constraint exists
SELECT * FROM USER_CONSTRAINTS;
---ALTER the TABLE to disable the constraint on the customerid foreign key
ALTER TABLE invoice DISABLE CONSTRAINT FK_INVOICECUSTOMERID;
---now that the constraint is removed, DELETE the customerid indicated in the problem
DELETE FROM customer WHERE customerid=32;


---3.0 SQL FUNCTIONS
---3.1 SYSTEM DEFINED FUNCTION
---function to display the current time
SELECT TO_CHAR(CURRENT_DATE, 'HH:MI') FROM dual;

---SELECT ALL FROM the mediatype table
SELECT * FROM mediatype;
---SELECT NAME and length function based on name FROM the mediatype table and order by the length of the name
SELECT name, length(name) FROM mediatype ORDER BY LENGTH(name) ASC;

---3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS
---SELECT ALL FROM table invoice
SELECT * FROM invoice;
---use the aggregate function AVG() to get the average of the total from the invoice table(truncate to 2 decimal places)
SELECT TRUNC(AVG(total),2) FROM invoice;

---SELECT ALL FROM track table
SELECT * FROM track;
---SELECT the MAX from unit price column FROM the track table
SELECT MAX(unitprice) FROM track;

---3.3 USER DEFINED SCALAR FUNCTIONS
---SELECT ALL FROM invoiceline table
SELECT * FROM invoiceline;
---using aggregate function to find the average unit price (truncated to 2 decimal places) FROM the invoiceline table
SELECT TRUNC(AVG(unitprice),2) FROM invoiceline;

--- 3.4 USER DEFINED TABLE VALUE FUNCTIONS
---SELECT ALL FROM employee table
SELECT * FROM employee;
---using EXTRACT() to get the year from birthdate in the employee table and ORDERBY birthdate or the remaining entries
SELECT * FROM employee WHERE EXTRACT(YEAR FROM TO_DATE(birthdate))>1968 ORDER BY birthdate ASC;

---4.0 STORED PROCEDURES
---4.1 BASIC STORED PROCEDURE
---4.2 STORED PROCEDURE INPUT PARAMETERS
---4.3 STORED PROCEDURE OUTPUT PARAMETERS
---5.0 TRANSACTIONS
---6.0 TRIGGERS
---6.1 AFTER/FOR

---7.0 JOINS
---7.1 INNER
SELECT a.firstname, a.lastname, b.invoiceid FROM customer a INNER JOIN invoice b ON a.customerid=b.customerid;
---7.2 OUTER
SELECT a.customerid, a.firstname, a.lastname, b.invoiceid, b.total FROM customer a FULL OUTER JOIN invoice b ON a.customerid=b.customerid;
---7.3 RIGHT
SELECT b.name, a.title FROM album a RIGHT JOIN artist b ON a.artistid=b.artistid;
---7.4 CROSS
SELECT * FROM album CROSS JOIN artist ORDER BY name;
---7.5 SELF
SELECT * FROM employee a INNER JOIN employee b ON a.employeeid=b.reportsto;