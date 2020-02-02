    select * from artist;
    select * from invoice;
    select * from customer;

-------2.0 SQL Queries

--2.1 SELECT
    --Task – Select all records from the Employee table. 
SELECT * FROM employee;

    --Task – Select all records from the Employee table where last name is King.
SELECT * FROM employee WHERE lastname = 'King';

	--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee WHERE firstname='Andrew' AND reportsto IS NULL;

--2.2SQL ORDER BY
	--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album ORDER BY title;

	--Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM customer ORDER BY city;

--2.3 INSERT INTO
	--Task – Insert two new records into Genre table 
INSERT INTO genre VALUES(26,'Dubstep');
INSERT INTO genre VALUES(27,'Chill Beats');

	--Task – Insert two new records into Employee table
INSERT INTO employee VALUES(9, 'Re',   'Jeff','IT Temp',8,'14-FEB-1968','28-JAN-2020','123 Park LN','Calgary','AB','Canada','T2P 6D4', '+1 (403)) 262-6353','+1 (403)) 262-3689','jeff@chinookcorp.com');
INSERT INTO employee VALUES(10,'Emert','Todd','IT Temp',8,'25-JAN-1988','28-JAN-2020','555 Rail RD','Calgary','AB','Canada','T3B 3F3', '+1 (403)) 262-5355','+1 (403)) 262-2525','todd@chinookcorp.com');

	--Task – Insert two new records into Customer table
INSERT INTO customer VALUES(60,'Re',   'Jeff','Chinook Corp','123 Park LN','Calgary','AB','Canada','T2P 6D4', '+1 (403)) 262-6353','+1 (403)) 262-3689','jeff@chinookcorp.com',5);
INSERT INTO customer VALUES(61,'Emert','Todd','Chinook Corp','555 Rail RD','Calgary','AB','Canada','T3B 3F3', '+1 (403)) 262-5355','+1 (403)) 262-2525','todd@chinookcorp.com',3);
	
--2.4 UPDATE	
	--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer SET firstname='Robert', lastname='Walter' WHERE firstname='Aaron' AND lastname='Mitchell';
	
	--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
UPDATE artist SET name='CCR' WHERE name='Creedence Clearwater Revival';

--2.5 LIKE
	--Task – Select all invoices with a billing address like “T%” 
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
	--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
	
	--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee WHERE hiredate BETWEEN '1-JUN-2003' and '1-MAR-2004';
    
--2.7 DELETE
	--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).	--
ALTER TABLE invoice  
DISABLE CONSTRAINT FK_INVOICECUSTOMERID;  
DELETE FROM customer WHERE firstname='Robert' AND lastname='Walter';

-------3.0 SQL Functions

--3.1 System Defined Functions
	--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_time
RETURN VARCHAR2
IS
BEGIN
    RETURN TO_CHAR(CURRENT_DATE, 'HH:MI');
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE(get_time());
END;
/

	--Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION name_length(m_id NUMBER)
RETURN NUMBER
IS
    len NUMBER(10);
BEGIN
    SELECT length(name) INTO len FROM mediatype WHERE mediatypeid=m_id;
    RETURN len;
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE(name_length(3));
END;
/

--3.2 System Defined Aggregate Functions
    --Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION avg_total
RETURN NUMBER
IS
    avgt NUMBER(30);
BEGIN
    SELECT AVG(total) INTO avgt FROM invoice;
    RETURN avgt;
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE(avg_total());
END;
/
	
	--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION expensive_track
RETURN NUMBER
IS
    maxt NUMBER(30);
BEGIN
    SELECT 
        MAX(unitprice) INTO maxt FROM track;
    RETURN maxt;
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE(expensive_track());
END;
/
	
--3.3 User Defined Scalar Functions	
	--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avg_inv_price
RETURN NUMBER
IS
    avgi NUMBER(30);
BEGIN
    SELECT AVG(unitprice) INTO avgi FROM invoiceline;
    RETURN avgi;
END;
/

BEGIN
    DBMS_OUTPUT.PUT_LINE(avg_inv_price());
END;
/
	
--3.4 User Defined Table Valued Functionsa
	--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION print_youngsters
RETURN SYS_REFCURSOR
IS
    c SYS_REFCURSOR;
BEGIN
    OPEN c FOR
    SELECT firstname,lastname FROM employee WHERE birthdate >= '1-JAN-1968';
    RETURN c;
END;
/

DECLARE
    curse SYS_REFCURSOR;
    ffname VARCHAR2(50);
    llname VARCHAR2(50);
BEGIN
    curse := print_youngsters();
    --FOR r IN curse
    LOOP FETCH curse INTO ffname,llname;
    EXIT WHEN curse%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(ffname || ' ' || llname);
    END LOOP;
    CLOSE curse;
END;
/

-------4.0 Stored Procedures
	
--4.1 Basic Stored Procedure	
	--Task – Create a stored procedure that selects the first and last names of all the employees.
    
--SOLUTION 1 selects with a view
CREATE OR REPLACE VIEW sel_names AS
    SELECT firstname, lastname FROM employee;
SELECT * FROM sel_names;

--SOLUTION 2 prints with a procedure
CREATE OR REPLACE PROCEDURE print_names
IS
    CURSOR c IS SELECT firstname,lastname FROM employee; 
BEGIN
    FOR r IN c
    LOOP
        DBMS_OUTPUT.PUT_LINE(r.firstname || ' ' || r.lastname);
    END LOOP;
END;
/

BEGIN
    print_names();
END;
/

--4.2 Stored Procedure Input Parameters
	--Task – Create a stored procedure that updates the personal information of an employee.

SELECT * FROM employee;
    
--pass in the id of the user you want to change
--the name of the column you want to change
--and the new value
CREATE OR REPLACE PROCEDURE edit_emp (emp_id IN NUMBER, col_name IN VARCHAR2, col_val IN VARCHAR2)
IS
    v_sql VARCHAR2(1024);
BEGIN
    v_sql := 'UPDATE employee SET ' || col_name || '=''' || col_val || ''' WHERE employeeid=' || emp_id ;
    EXECUTE IMMEDIATE v_sql; 
END;
/

BEGIN
    edit_emp(2,'city','Tampa');
END;
/

SELECT * FROM employee;
	
	--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE get_boss(my_id IN NUMBER, boss_id OUT NUMBER)
IS
BEGIN
    SELECT reportsto INTO boss_id FROM employee WHERE employeeid=my_id;
END;
/

DECLARE
    sout NUMBER(8);
BEGIN
    get_boss(6,sout);
    DBMS_OUTPUT.PUT_LINE(sout);
END;
/
	
--4.3 Stored Procedure Output Parameters
	--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_cust_deets(my_id IN NUMBER, my_fname OUT VARCHAR2, my_lname OUT VARCHAR2, my_company OUT VARCHAR2)
IS
BEGIN
    SELECT firstname,lastname,company INTO my_fname,my_lname,my_company FROM customer WHERE customerid=my_id;
END;
/

DECLARE
    o_fname VARCHAR2(16);
    o_lname VARCHAR2(16);
    o_company VARCHAR2(100);
BEGIN
    get_cust_deets(5,o_fname,o_lname,o_company);
    DBMS_OUTPUT.PUT_LINE(o_fname || ' ' || o_lname || ' from ' || o_company);
END;
/   
	
-------5.0 Transactions
	--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE kill_invoice(my_id IN NUMBER)
IS
BEGIN
    DELETE FROM invoiceline WHERE invoiceid=my_id;
    DELETE FROM invoice WHERE invoiceid=my_id;
    --COMMIT;
END;
/

BEGIN
    kill_invoice(1);
END;
/

select * from invoice;
	
	--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE new_cust(nid IN NUMBER, nfname IN VARCHAR2, nlname IN VARCHAR2,emal IN VARCHAR2)
IS
BEGIN
    INSERT INTO customer(customerid, firstname, lastname,email) 
    VALUES(nid, nfname, nlname,emal);--to lazy for others
END;
/

BEGIN
    new_cust(64,'jerry2','stringer','stuff@go.com');
END;
/
select * from customer;

    
-------6.0 Triggers

--6.1 AFTER/FOR
	--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER emp_inserted
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('new employee inserted');
END;
/
	
	--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER album_inserted
AFTER INSERT ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('new album inserted');
END;
/
	
	--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER cust_deleted
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('customer deleted');
END;
/

-------7.0 JOINS
	
--7.1 INNER
	--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT a.firstname, a.lastname, b.invoiceid FROM customer a INNER JOIN invoice b ON a.customerid=b.customerid;	

--7.2 OUTER
	--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT a.customerid, a.firstname, a.lastname, b.invoiceid, b.total FROM customer a FULL OUTER JOIN invoice b ON a.customerid=b.customerid;	

--7.3 RIGHT	
	--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT b.name, a.title FROM album a RIGHT JOIN artist b ON a.artistid=b.artistid;
    
--7.4 CROSS
	--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT b.name, a.title FROM album a CROSS JOIN artist b ORDER BY b.name;

--7.5 SELF
	--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT a.employeeid, a.firstname,a.lastname,a.reportsto,b.firstname,b.lastname FROM employee a INNER JOIN employee b ON b.employeeid=a.reportsto;
