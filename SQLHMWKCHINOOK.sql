--2.1 SELECT
/*
Task – Select all records from the Employee table. 
Task – Select all records from the Employee table where last name is King.
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*/

SELECT * FROM employee;

SELECT * FROM employee 
WHERE employee.lastname = 'King';

SELECT * FROM employee 
WHERE employee.firstname = 'Andrew'
AND employee.reportsto IS null;

--2.2 ORDER BY 
/*
Task – Select all albums in Album table and sort result set in descending order by title.
Task – Select first name from Customer and sort result set in ascending order by city
*/
SELECT * FROM album ORDER BY album.title DESC;

SELECT customer.firstname FROM customer ORDER BY customer.city ASC;

--2.3 INSERT INTO
/*
Task – Insert two new records into Genre table 
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
*/

SELECT * FROM genre;

INSERT INTO genre VALUES (26,'Frequency Fusion');
INSERT INTO genre VALUES (27,'Healing');

SELECT * FROM employee;

INSERT INTO employee(employeeid,lastname,firstname,title,birthdate,hiredate,address,city,state,country,postalcode,phone,fax,email)
VALUES(9, 'YHWH','CZR','President','13-FEB-89','01-JAN-01','111 Bonair St SW','Atlanta','GA','USA','30314-3701','+1 (404) 777-9999','+1 (404) 777-9988','czr@chinookcorp.com');

INSERT INTO employee(employeeid,lastname,firstname,title,birthdate,hiredate,address,city,state,country,postalcode,phone,fax,email)
VALUES(10, 'English','Stenson','Vice President','13-FEB-89','01-JAN-01','12702 Bruce B. Downs Boulevard','Tampa','FL','USA','33612-1804','+1 (404) 777-9989','+1 (404) 777-9989','stenson@chinookcorp.com');

SELECT * FROM customer;

INSERT INTO customer(customerid,firstname,lastname,country,email)
VALUES (60,'Stenson','English','Wakanda','stenson.english@gmail.com');

INSERT INTO Customer(Customerid,Firstname,Lastname,Country,Email)
VALUES (61,'CZR','YHWH','Israel','czryhwh@gmail.com');

--2.4 UPDATE
/*
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
*/

UPDATE Customer
SET
lastname = 'Walter',
firstname = 'Robert'
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';

UPDATE artist
SET
NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”

SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
/*
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
*/

SELECT * FROM invoice WHERE total>15 AND total<50;


SELECT * FROM employee WHERE hiredate > '01-JUN-03' 
AND hiredate < '01-MAR-04';

--2.7 DELETE
/*
Task – Delete a record in Customer table where the name is Robert Walter 
(There may be constraints that rely on this, find out how to resolve them).
*/

ALTER TABLE invoice
DROP CONSTRAINT fk_invoicecustomerid;
DELETE FROM customer WHERE firstname = 'Robert' AND lastname = 'Walter';

--3.1 System Defined Functions
/*
Task - Create a function that returns the current time.
Task - Create a function that returns the length of name in MEDIATYPE table
*/

SELECT sysdate FROM dual;

SELECT
    *
FROM mediatype;

SELECT LENGTH(name) FROM mediatype;

--3.2 System Defined Aggregate Functions
/*
Task - Create a function that returns the average total of all invoices 
Task – Create a function that returns the most expensive track
*/

SELECT
    *
FROM invoice;

SELECT AVG(total) FROM invoice;

SELECT
    *
FROM track;

SELECT MAX(unitprice) FROM track;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table

SELECT
    *
FROM invoiceline;

CREATE OR REPLACE FUNCTION line_item_avg_price_func
RETURN NUMBER
IS 
    line_item_avg_price NUMBER;
BEGIN 
    SELECT AVG(unitprice)
    INTO line_item_avg_price
    FROM invoiceline;
    RETURN line_item_avg_price;
    
END; 
/

SELECT line_item_avg_price_func from dual;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

SELECT
    *
FROM employee;

CREATE OR REPLACE TYPE emp_obj AS OBJECT(
firstname VARCHAR2(20),
lastname VARCHAR2(20),
birthdate DATE
);
/

CREATE OR REPLACE TYPE emp_table AS TABLE OF emp_obj;
/

CREATE OR REPLACE FUNCTION emp_born_after_68 RETURN emp_table AS
    born_after_68_emp_table emp_table;
BEGIN
    SELECT
        emp_obj(a.firstname, a.lastname, a.birthdate)
    BULK COLLECT
    INTO born_after_68_emp_table
    FROM
        (
            SELECT
                firstname,
                lastname,
                birthdate
            FROM
                employee
            WHERE
                birthdate >= ( '01-Jan-1968' )
        ) a;

    RETURN born_after_68_emp_table;
END;
/

SELECT
    *
FROM
    TABLE ( emp_born_after_68 );

--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.

SELECT
    *
FROM employee;

CREATE OR REPLACE PROCEDURE get_all_emp_names(first_name IN employee.firstname%TYPE, last_name IN employee.lastname%TYPE)

IS
BEGIN
    SELECT firstname INTO first_name FROM employee;
    SELECT lastname INTO last_name FROM employee;
END;
/

--execution block
DECLARE
    first_name employee.firstname%TYPE;
    last_name employee.lastname%TYPE;
    
BEGIN
    get_all_emp_names(first_name,last_name);
    DBMS_OUTPUT.PUT_LINE(first_name ,last_name);
END;
/



--4.2 Stored Procedure Input Parameters
/*
Task – Create a stored procedure that updates the personal information of an employee.
Task – Create a stored procedure that returns the managers of an employee.
*/



--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.

--5.0 Transactions
/*
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table.
*/

SELECT
    *
FROM invoice;

CREATE OR REPLACE PROCEDURE delete_invoice(temp_invoiceId IN invoice.invoiceid%TYPE) IS
BEGIN
DELETE FROM invoiceline WHERE invoiceid = temp_invoiceid;
DELETE FROM invoice WHERE invoiceid = temp_invoiceid;
COMMIT;
END;
/

BEGIN 
delete_invoice(100);
END;
/

CREATE PROCEDURE new_customer_record
IS
BEGIN
    INSERT INTO customer VALUES(0, "Frank", "Tisdale", "The Tisdale Company", "123 Tisdale Lane", "San Jose", "CA", "USA", "94088", "(669) 408-2139", "(669) 408-2147", "frank@tisdale.com", 0);
END;
/
SELECT * FROM customer;

CREATE OR REPLACE PROCEDURE new_customer
(
temp_customerid IN customer.customerid%TYPE,
temp_firstname IN customer.firstname%TYPE,
temp_lastname IN customer.lastname%TYPE,
temp_company IN customer.company%TYPE,
temp_email IN customer.email%TYPE
)
IS
BEGIN 
INSERT INTO customer (customerid, firstname, lastname, company,email)
VALUES (temp_customerid, temp_firstname,temp_lastname,temp_company,temp_email);
COMMIT;
END;
/



BEGIN
new_customer(62,'Sonny','Money','The Money Factory','sonny@tmf.com');
END;
/

SELECT * FROM customer;

--6.0 Triggers

--6.1 AFTER/FOR
/*
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
Task – Create an after update trigger on the album table that fires after a row is inserted in the table.
Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
*/
CREATE OR REPLACE TRIGGER insert_employee_trigger
AFTER INSERT ON employee
BEGIN 
DBMS_OUTPUT.PUT_LINE('New employee added.');
END;
/

CREATE OR REPLACE TRIGGER update_album_trigger
AFTER INSERT ON album
BEGIN 
DBMS_OUTPUT.PUT_LINE('Album updated.');
END;
/

CREATE OR REPLACE TRIGGER delete_customer_trigger
AFTER DELETE ON customer
BEGIN 
DBMS_OUTPUT.PUT_LINE('Customer deleted.');
END;
/

--7.0 JOINS

--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT customer.firstname, customer.lastname,invoice.invoiceid
FROM customer
INNER JOIN invoice
ON customer.customerid = invoice.customerid;


--7.2 OUTER
/*Task – Create an outer join that joins the customer and invoice table, specifying the 
CustomerId, firstname, lastname, invoiceId, and total.
*/
SELECT customer.customerid,customer.firstname,customer.lastname,invoice.invoiceid,invoice.total
FROM customer
FULL OUTER JOIN invoice 
ON customer.customerid = invoice.customerid;


--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.

SELECT artist.name,album.title
FROM album 
RIGHT JOIN artist ON artist.artistid = album.artistid;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

SELECT *
FROM album
CROSS JOIN artist 
ORDER BY artist.name ASC;


--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.

SELECT a.firstName, a.lastName,b.firstName || ' ' || b.lastName AS "Manager"
FROM employee a, employee b WHERE a.reportsto = b.employeeid;



COMMIT;