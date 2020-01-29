---1.0 Oracle Chinook conneciton established

---2.0 SQL Queries
---2.1 SQL SELECT
SELECT * FROM employee;
SELECT * FROM employee WHERE lastname='King';
SELECT * FROM employee WHERE firstname='Andrew' AND reportsto IS NULL;

---2.2 ORDER BY
SELECT * FROM album;
SELECT * FROM album ORDER BY title DESC;
SELECT firstname, city FROM customer ORDER BY city;

---2.3 INSERT INTO
SELECT * FROM genre;
INSERT INTO genre VALUES (26, 'Country');
INSERT INTO genre VALUES (27, 'EMO');

SELECT * FROM employee;
INSERT INTO employee VALUES (9, 'Torres', 'Eric', 'Assistant General Manager', 1, '26-SEP-79', '13-JAN-20', '14511 Prism Circle, Unit 208', 'Tampa Bay', 'FL', 'USA', '33613', '+1 (504) 722-0278', '+1 (504) 324-0179', 'etorresnotary@gmail.com');
INSERT INTO employee VALUES (10, 'Thornton', 'Parker', 'IT Consultant', 6, '06-APR-20', '13-JAN-20', '14511 Prism Circle, Unit 208', 'Tampa Bay', 'FL', 'USA', '33613', '+1 (321) 314-2172', '+1 (321) 654-8927', 'parkerkt77@gmail.com');

SELECT * FROM customer;
INSERT INTO customer VALUES (60, 'Donna', 'Torres', 'Louisiana State University', '25 Dalrymple Drive', 'Baton Rouge', 'LA', 'USA', '70808', '+1 (225) 578-1623', 'null', 'dtorres@lsu.edu', 2);
INSERT INTO customer VALUES (61, 'Thomas', 'Robichaux', 'null', '18654 Milan Avenue', 'New Orleans', 'LA', 'United States', '70118', '+1 (504) 682-8672', 'null', 'trobichaux@gmail.com', 2);

---2.4 UPDATE
SELECT * FROM customer;
UPDATE customer SET firstname='Robert', lastname='Walter' WHERE customerid = 32;

SELECT * FROM artist;
UPDATE artist SET name='CCR' WHERE artistid = 75;

---2.5 LIKE
SELECT * FROM invoice;
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

---2.6 BETWEEN
SELECT * FROM invoice;
SELECT * FROM invoice WHERE total BETWEEN 15 and 50;
SELECT * FROM employee;
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' and '01-MAR-04';

---2.7 DELETE 
SELECT * FROM customer;
SELECT * FROM USER_CONSTRAINTS;
ALTER TABLE invoice DISABLE CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM customer WHERE customerid=32;

---3.0 SQL Functions
---3.1 System Defined Function
SELECT CURRENT_TIMESTAMP from dual;

SELECT * FROM mediatype;
SELECT name, length(name) FROM mediatype ORDER BY LENGTH(name) ASC;

---3.2 System Defined Aggregate Functions
SELECT * FROM invoice;
SELECT AVG(total) FROM invoice;

SELECT * FROM track;
SELECT MAX(unitprice) from track;

---3.3 User Defined Scalar Functions
SELECT * FROM invoiceline;
SELECT AVG(unitprice) FROM invoiceline;

--- 3.4 User Defined Table Valued Functions
SELECT * FROM employee;
SELECT * FROM employee WHERE EXTRACT(YEAR FROM TO_DATE(birthdate))>1968 ORDER BY birthdate ASC;

---4.0 Stored Procedures
---4.1 Basic Stored Procedures
