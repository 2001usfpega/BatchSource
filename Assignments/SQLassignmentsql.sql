---2.0 SQL Queries
---2.1 SELECT
--- Select all records from the Employee table.
SELECT * FROM employee;
--- Select all records from the Employee table.
SELECT * FROM employee WHERE lastname = 'King';
--- Select all records from the Employee table where first
--- name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS null;
---2.2 ORDER BY
--- Select all albums in Album table and sort result set in
--- descending order by title.
SELECT * FROM album ORDER BY title DESC;
--- Select first name from Customer and sort result set in
--- ascending order by city
SELECT * FROM customer ORDER BY city ASC; -- ORDER BY defaults to ascending
---2.3 INSERT INTO
DESC genre;
SELECT * FROM genre;
--- Insert two new records into Genre table
INSERT INTO genre VALUES(26,'LoFi');
INSERT INTO genre VALUES(27,'Trap and Bass');
--- Insert two new records into Employee table
SELECT * FROM employee;

INSERT INTO employee(employeeid, lastname, firstname) VALUES(9,'Dickerson','Kaelin');
INSERT INTO employee(employeeid, lastname, firstname) VALUES(10,'Dickerson','William');
--INSERT INTO employee VALUES();
--- Insert two new records into Customer table
DESC customer;
SELECT * FROM customer;
INSERT INTO customer(customerid, firstname, lastname, company, address, city, st, country, postal, phone, fax,email)
    VALUES(60, 'That','Guy',NULL,'Espada 0','Hueco Mundo',NULL,'The Void','12345','we use smoke siginals', null 'none');
INSERT INTO customer(customerid, firstname, lastname, company, address, city, st, country, postal, phone, fax,email)    
	VALUES(61, 'Cloud','Strife','Midgar','turmoil','Gaia',7,'Ask Tifa',NULL,'exSoldier@shinra.com', 'Colby.Agar@gmail.com');
UPDATE customer SET st='Turmoil'WHERE customerid=61; 
--2.4 UPDATE
--- Update Aaron Mitchell in Customer table to Robert Walter
DESC customer;
SELECT * FROM customer;
UPDATE customer SET firstname = 'Robert', lastname = 'Walter'
        WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
--- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
SELECT * FROM artist;
DESC artist;
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';
--2.5 LIKE
---Select all invoices with a billing address like “T%”
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';
--2.6 BETWEEN
--- Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE total BETWEEN 15 and 50;
--- Select all employees hired between 1st of June 2003 and 1st of March 2004
DESC employee;
SELECT * FROM employee WHERE hiredate BETWEEN trunc(TO_DATE('06-01-2003','MM-DD-YYYY'))
        and trunc(TO_DATE('03-01-2004','MM-DD-YYYY'));
--2.7 DELETE
--- Delete a record in Customer table where the name is Robert Walter
--- (There may be constraints that rely on this, find out how to resolve them).
SELECT * FROM customer WHERE lastname = 'Walter';
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';
-------FIGURE THIS OUT!!!----------
---3 SQL Functions---
--3.1 System Defined Functions
--- Create a function that returns the current time.
SELECT localtimestamp FROM dual;
--- create a function that returns the length of name in MEDIATYPE table
SELECT * FROM mediatype;
SELECT length(name) FROM mediatype;
--3.2 System Define Aggregate Functions
--- Create a function that returns the average total of all invoices
SELECT AVG(total) FROM invoice;
SELECT Max(total) FROM invoice;
SELECT length('name') FROM mediatype;
----3.3
SELECT AVG(unitprice) FROM invoiceline;
----3.4 User Defined Table Valued Functions
----Task – Create a function that returns all employees who are born after 1968.
SELECT * FROM employee;
SELECT * FROM employee WHERE birthdate > TO_DATE('01-JAN-68');
---4.0 Stored Procedures
----In this section you will be creating and executing stored proceduresIn this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
---4.1
--CREATE a stored PROCEDURE that selects the FIRST AND LAST names OF ALL the employees
SELECT * FROM employee;

CREATE OR REPLACE PROCEDURE first_last(employee_details OUT SYS_Refcursor)
AS 
BEGIN
OPEN employee_details FOR 
	SELECT firstname, lastname FROM employee;
END;
/
DECLARE
    f_name employee.firstname%TYPE;
    l_name employee.lastname%TYPE;
    employee_details SYS_REFCURSOR;
BEGIN
    first_last(employee_details);
    LOOP
    FETCH employee_details into f_name, l_name;
        EXIT WHEN employee_details%notfound;
        DBMS_OUTPUT.PUT_LINE('Full name: ' || f_name || ' ' || l_name);
    END LOOP;
    CLOSE employee_details;
END;
/

-----4.2
-----Task – Create a stored procedure that updates the personal information of an employee.

SELECT * FROM employee;

CREATE OR REPLACE PROCEDURE updated(e_title IN employee.title%TYPE , e_fname IN employee.firstname%Type, e_lname IN employee.lastname%type)
IS
BEGIN 
	
	UPDATE employee SET title=e_title, firstname=e_fname, lastname=e_lname WHERE title=e_title; 
COMMIT;	
END;
/

BEGIN 
	updated('Shadow Boss','Dickerson','Kaelin');
	DBMS_OUTPUT.PUT_LINE('Welcome Shadow Boss: ' || 'Kaelin');
END;
/
-----CREATE stored PROCEDURE that RETURNS the managers OF an employee
SELECT * FROM employee;

CREATE OR REPLACE PROCEDURE manager(e_id IN NUMBER, b_id OUT number)
IS 
BEGIN
SELECT reportsto INTO b_id FROM employee 	
WHERE employeeid=e_id;

END;
/

DECLARE 
b_id NUMBER (3);
BEGIN
	manager(3,B_ID);
	DBMS_OUTPUT.PUT_LINE('Your manager is: '|| B_ID );
END;
/
----4.3
----Created a stored PROCEDURE that RETURNS 
SELECT * FROM customer;
CREATE OR REPLACE PROCEDURE name_company(c_id IN NUMBER, fname OUT varchar2, lname OUT varchar2, company OUT varchar2)
IS
BEGIN
SELECT firstname,lastname,company INTO fname,lname,company FROM customer 	
WHERE customerid=c_id;

END;
/

DECLARE 
fname varchar2 (500);
lname varchar2 (500);
company varchar2 (500);
BEGIN
	name_company( 1,fname,lname,company);
	DBMS_OUTPUT.PUT_LINE('Customer: '|| fname || lname || company );
END;
/
----5.0 Transactions
----Create a transaction that given a invoiceId will delete that invoice 
----Can't figure out child record integrity constraint
SELECT * FROM invoice;
SELECT * FROM customer;

CREATE OR REPLACE PROCEDURE r_customer(i_id IN NUMBER)
IS 
BEGIN 
IF i_id IS NOT NULL THEN 	
DELETE FROM invoice WHERE invoiceid=i_id;
--ALTER TABLE invoice DROP costraint FK_INVOICELINEINVOICEID;
END IF;	
END;
/

BEGIN
	r_customer(216);
	DBMS_OUTPUT.PUT_LINE('Customer removed.');
END;
/

