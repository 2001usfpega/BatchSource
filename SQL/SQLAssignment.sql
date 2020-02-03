---SQLAssignment.sql

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
INSERT INTO genre VALUES(26,'Emo Rap');
INSERT INTO genre VALUES(27,'Trap');

--- Insert two new records into Employee table
SELECT * FROM employee;
DESC employee;
INSERT INTO employee(employeeid, lastname, firstname) VALUES(9,'Lail','Jacob');
INSERT INTO employee(employeeid, lastname, firstname) VALUES(10,'Dickerson','Kaelin');

--INSERT INTO employee VALUES();
--- Insert two new records into Customer table
DESC customer;
SELECT * FROM customer; 
INSERT INTO customer(customerid, firstname, lastname, email)
    VALUES(5000, 'Jacob','Lail', 'mjlail719@gmail.com');
INSERT INTO customer(customerid, firstname, lastname, email)
    VALUES(5001, 'Colby','Agar', 'Colby.Agar@gmail.com');

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

--- Create a function that returns the most expensive track
SELECT * FROM track;
SELECT MAX(unitprice) FROM track;

--3.3 User Defined Scalar Functions
--- Create a function that returns the average price of invoiceline items in 
--- the invoiceline table
SELECT * FROM invoiceline;
SELECT AVG(unitprice) FROM invoiceline;
-------MAYBE??-------

--3.4 User Defined Table Valued Functions
--- Create a function that returns all employees who are born after 1968.
SELECT * FROM employee;
SELECT * FROM employee WHERE birthdate > TO_DATE('01-JAN-1969','DD-MON-YYYY');

--4.0 Stored Procedures
--4.1 Basic Stored Procedures
---Create a stored procedure that selects the first and 
---last names of all the employees.
CREATE OR REPLACE PROCEDURE show_all_employees(employee_details OUT SYS_REFCURSOR)
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
    show_all_employees(employee_details);
    LOOP 
    FETCH employee_details into f_name, l_name; 
        EXIT WHEN employee_details%notfound; 
        DBMS_OUTPUT.PUT_LINE('Full name: ' || f_name || ' ' || l_name);
    END LOOP; 
    CLOSE employee_details; 
END;
/

--4.2 Stored Procedure Input Parameters
--- Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee(emp_id IN NUMBER, emp_title IN VARCHAR2, emp_address IN VARCHAR2
    , emp_city IN VARCHAR2,emp_phone IN VARCHAR2,emp_email IN VARCHAR2)
IS
BEGIN
    UPDATE employee SET address = emp_address, city = emp_city,
        phone = emp_phone, email = emp_email, title = emp_title WHERE employeeid = emp_id; 
END;
/

BEGIN 
    update_employee(9,'Software Developer','2741 Judea Dr', 'Conover','(828) 455-8294', 'mjlail719@gmail.com');
END;
/

--- Create a stored procedure that returns the managers of an employee.

CREATE OR REPLACE PROCEDURE get_managers(emp_id IN NUMBER,
    employee_details OUT SYS_REFCURSOR)
IS
    manager_id NUMBER;
BEGIN
    SELECT reportsto INTO manager_id FROM employee WHERE employeeID = emp_id;
    OPEN employee_details FOR
        SELECT firstname, lastname FROM employee WHERE employeeID = manager_id;
END;
/



DECLARE 
    f_name VARCHAR2(1000);
    l_name VARCHAR2(1000);
    employee_details SYS_REFCURSOR;    
BEGIN 
    get_managers(2, employee_details); 
    FETCH employee_details into f_name, l_name; 
    DBMS_OUTPUT.PUT_LINE('Full name: ' || f_name || ' ' || l_name);
    CLOSE employee_details; 
END;
/

SELECT * FROM employee;

---4.3 Stored Procedure Output Parameters
--Create a stored procedure that returns the name and company of a customer.



---Question 6.1
CREATE OR REPLACE TRIGGER employee_insertb
AFTER INSERT
ON employee
FOR EACH ROW
BEGIN
    dbms_output.put_line('NEW EMPLOYEE');
END;
/
CREATE OR REPLACE TRIGGER album_update
AFTER UPDATE
ON album
FOR EACH ROW
BEGIN
    dbms_output.put_line('ALBUM UPDATED');
END;
/
CREATE OR REPLACE TRIGGER delete_cust
AFTER DELETE
ON customer
FOR EACH ROW
BEGIN
    dbms_output.put_line('CUSTOMER REMOVED');
END;
/
---Question 7.1
SELECT * FROM customer a INNER JOIN invoice b ON a.customerid = b.invoiceid;
---Question 7.2
SELECT * FROM customer a LEFT OUTER JOIN invoice b ON b.invoiceid = a.customerid;
---Question 7.3
SELECT * FROM artist a RIGHT OUTER JOIN album b ON b.artistid = A.ARTISTID;
---Question 7.4
SELECT * FROM artist CROSS JOIN album;


COMMIT;
ROLLBACK;