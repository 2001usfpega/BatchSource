--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM employee;
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM employee WHERE lastname='King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee WHERE firstname='Andrew' AND reportsto IS NULL;

--2.2 SQL ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM album ORDER BY title DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname FROM customer ORDER BY city;

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO genre VALUES (26, 'Anime');
INSERT INTO genre VALUES (27, 'Low-Fi');

--Task – Insert two new records into Employee table
desc employee;
select * from employee;
INSERT INTO employee VALUES (
    9,
    'Thornton',
    'Parker',
    'Head of Technology',
    1,
    TO_DATE('06/04/1997', 'DD/MM/YYYY'),
    TO_DATE('13/01/2020', 'DD/MM/YYYY'),
    '6225 W Amelia St.',
    'Orlando',
    'FL',
    'United States',
    '32835',
    '321-314-2172',
    NULL,
    'parkerkt77@gmail.com'
);
INSERT INTO employee VALUES (
    10,
    'Knighten',
    'Matt',
    'PEGA Developer',
    9,
    TO_DATE('06/04/1997', 'DD/MM/YYYY'),
    TO_DATE('13/01/2020', 'DD/MM/YYYY'),
    '',
    '',
    'FL',
    'United States',
    '',
    '',
    NULL,
    ''
);
--Task – Insert two new records into Customer table
desc customer;
select * from customer;
INSERT INTO employee VALUES (
    10,
    'Knighten',
    'Matt',
    'PEGA Developer',
    9,
    TO_DATE('06/04/1997', 'DD/MM/YYYY'),
    TO_DATE('13/01/2020', 'DD/MM/YYYY'),
    '',
    '',
    'FL',
    'United States',
    '',
    '',
    NULL,
    ''
);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer SET firstname='Robert', lastname='Walter' WHERE firstname='Aaron' AND lastname='Mitchell';

--Task – Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"
UPDATE artist SET name='CCR' WHERE name='Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like "T%"
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee WHERE hiredate BETWEEN TO_DATE('01/05/2003', 'DD/MM/YYYY') AND TO_DATE('01/03/2004', 'DD/MM/YYYY');

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE invoice DROP CONSTRAINT fk_invoicecustomerid;
ALTER TABLE invoice ADD CONSTRAINT fk_invoicecustomerid FOREIGN KEY (customerid) REFERENCES customer (customerid) ON DELETE CASCADE;
ALTER TABLE invoiceline DROP CONSTRAINT fk_invoicelineinvoiceid;
ALTER TABLE invoiceline ADD CONSTRAINT fk_invoicelinetrackid FOREIGN KEY (invoiceid) REFERENCES invoice (invoiceid) ON DELETE CASCADE;
DELETE FROM customer WHERE firstname='Robert' AND lastname='Walter';

--SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION timenow
RETURN TIMESTAMP IS tm TIMESTAMP;
BEGIN
SELECT CURRENT_TIMESTAMP INTO tm FROM dual;
RETURN tm;
END;
/

--Task – create a function that returns the length of name in MEDIATYPE table

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
SELECT AVG(total) FROM invoice;
CREATE OR REPLACE FUNCTION avginvoice RETURN FLOAT IS
    avgi FLOAT(126);
BEGIN
    SELECT AVG(total) INTO avgi FROM invoice;
    RETURN avgi;
END;
/

BEGIN
    dbms_output.put_line('Average Total: ' || avginvoice());
END;
/

--Task – Create a function that returns the most expensive track
SELECT MAX(unitprice) FROM track;
CREATE OR REPLACE FUNCTION most_expensive RETURN track.unitprice%TYPE IS
    maxprice track.unitprice%TYPE;
BEGIN
    SELECT MAX(unitprice) INTO maxprice FROM track;
    RETURN maxprice;
END;
/

BEGIN
    dbms_output.put_line('Most expensive track: ' || most_expensive());
END;
/

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avgprice RETURN FLOAT IS avgprice FLOAT(126);
BEGIN
    SELECT AVG(unitprice) INTO avgprice FROM invoiceline;
    RETURN avgprice;
END;
/

BEGIN
    dbms_output.put_line(avgprice());
END;
/

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION employees1968 RETURN SYS_REFCURSOR IS 
    curs SYS_REFCURSOR;
    BEGIN
    OPEN curs FOR SELECT firstname, lastname FROM employee WHERE birthdate > TO_DATE('1968','YYYY');
    RETURN curs;
END;
/
DECLARE
    curs       SYS_REFCURSOR;
    firstname  VARCHAR(100);
    lastname   VARCHAR(100);
BEGIN
    curs := employees1968();
    LOOP
        FETCH curs INTO
            firstname,
            lastname;
        EXIT WHEN curs%notfound;
        dbms_output.put_line(firstname || ' ' || lastname);
    END LOOP;

END;
/

--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE employee_names(employees OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN employees FOR SELECT firstname, lastname FROM employee;
END;
/

DECLARE
    employees SYS_REFCURSOR;
    firstname VARCHAR2(50);
    lastname VARCHAR2(50);
BEGIN
    employee_names(employees);
    
   LOOP
    FETCH employees INTO
        firstname,
        lastname;
    EXIT WHEN employees%notfound;
    dbms_output.put_line(firstname || ' ' || lastname);
END LOOP;

CLOSE employees;
END;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE set_employee_info (
    e_id        IN  employee.employeeid%TYPE,
    e_address   IN  employee.address%TYPE,
    e_city      IN  employee.city%TYPE,
    e_state     IN  employee.state%TYPE,
    e_country   IN  employee.country%TYPE,
    e_postalcode  IN  employee.postalcode%TYPE,
    e_phone  IN  employee.phone%TYPE,
    e_fax  IN  employee.fax%TYPE,
    e_email  IN  employee.email%TYPE
) IS
BEGIN
    UPDATE employee
    SET
        address = e_address,
        city = e_city,
        state = e_state,
        country = e_country,
        postalcode = e_postalcode,
        phone = e_phone,
        fax = e_fax,
        email = e_email
    WHERE
        employeeid = e_id;
END;
/

BEGIN
    set_employee_info(6, '1 Random Street', 'Tampa', 'FL', 'United States', '33333', '1-800-285-2166', null, 'admin@company.com');
END;
/

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE getManager(id IN NUMBER, manager OUT VARCHAR2)
IS
    man_id NUMBER(10);
BEGIN
    SELECT reportsto INTO man_id FROM employee WHERE employeeid = id;
    SELECT firstname || ' ' || lastname INTO manager FROM employee WHERE employeeid = man_id;
END;
/

DECLARE
    manager VARCHAR(50);
BEGIN
    getManager(6, manager);
    dbms_output.put_line(manager);
END;
/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE p_customer(c_id IN NUMBER, c_name OUT VARCHAR2, c_company OUT VARCHAR2)
IS
BEGIN
    SELECT firstname || ' ' || lastname, company INTO c_name, c_company FROM customer WHERE customerid = c_id;
END;
/

DECLARE
    c_name VARCHAR2(100);
    company VARCHAR2(100);
BEGIN
    p_customer(5, c_name, company);
    dbms_output.put_line(c_name || ' with ' || company);
END;
/

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE deleteInvoice(invoice_id IN invoice.invoiceid%TYPE)
IS
BEGIN
    DELETE FROM invoice WHERE invoiceid = invoice_id;
    COMMIT;
END;
/

BEGIN
    deleteInvoice(1);
END;
/

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE createcustomer (
    cid      IN  customer.customerid%TYPE,
    fname    IN  customer.firstname%TYPE,
    lname    IN  customer.lastname%TYPE,
    c_email  IN  customer.email%TYPE
) IS
BEGIN
    INSERT INTO customer (
        customerid,
        firstname,
        lastname,
        email
    ) VALUES (
        cid,
        fname,
        lname,
        c_email
    );
    COMMIT;
END;
/

BEGIN
    createCustomer(214, 'Billy', 'Goat', 'dumbemail@company.com');
END;
/

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER employee_insert
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
    dbms_output.put_line('New Employee ' || :new.firstname);
END;
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table.
CREATE OR REPLACE TRIGGER album_update
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    dbms_output.put_line('Updated Album ' || :new.title);
END;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER customer_delete
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    dbms_output.put_line('Deleted Customer ' || :old.firstname || ' ' || :old.lastname);
END;
/
DELETE FROM customer WHERE customerid=8;

--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT inv.invoiceid, cus.firstname, cus.lastname FROM invoice inv INNER JOIN customer cus ON inv.customerid = cus.customerid;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT cus.customerid, cus.firstname, cus.lastname, inv.invoiceid, inv.total FROM invoice inv FULL OUTER JOIN customer cus 
ON inv.customerid = cus.customerid;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT art.name, alb.title FROM artist art RIGHT JOIN album alb ON art.artistid = alb.artistid;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM album alb CROSS JOIN artist art ORDER BY art.name;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM employee e1, employee e2 WHERE e1.reportsto = e2.employeeid;