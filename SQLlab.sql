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
CREATE OR REPLACE PROCEDURE emp_names
IS
CURSOR S IS SELECT firstname, lastname FROM employee;
fname employee.firstname%TYPE;
lname employee.lastname%TYPE;
BEGIN
OPEN S;
LOOP FETCH S INTO fname, lname;
DBMS_OUTPUT.PUT_LINE('FIRST name: ' || fname || ' LAST name: ' || lname);
EXIT WHEN S%NOTFOUND;
END LOOP;
END;
/

BEGIN
emp_names;
END;
/

---4.2 STORED PROCEDURE INPUT PARAMETERS
CREATE OR REPLACE PROCEDURE update_employee (EID IN EMPLOLYEE.EMPLOYEEIDf%TYPE, UE IN OUT EMPLOYEE%ROWTYPE)
IS ERES EMPLOYEE%ROWTYPE;
BEGIN
SELECT * INTO ERES
FROM EMPLOYEE
WHERE EMPLOYEE.EMPLOYEEID = EID;

IF UE.LASTNAME IS NULL
    THEN UE.LASTNAME := ERES.LASTNAME;
END IF;

IF UE.FIRSTFIRSTNAME IS NULL
    THEN UE.FIRSTNAME := ERES.FIRSTNAME;
END IF;

UPDATE EMPLOYEE E
SET E.LASTNAME = UE.LASTNAME,
    E.FIRSTNAME = UE.FIRSTNAME,
    E.TITLE = UE.TITLE,
    E.BIRTHDATE = UE.BIRTHDATE,
    E.HIREDATE = UE.HIREDATE,
    E.ADDRESS = UE.ADDRES,
    E.CITY = UE.CITY,
    E.STATE = UE.STATE,
    E.COUNTRY = UE.COUNTRY,
    E.POSTALCODE = UE.POSTALCODE,
    E.PHONE = UE.PHONE,
    E.FAX = UE.FAX,
    E.EMAIL = UE.EMAIL,
WHERE E.EMPLOYEEID = EID;

DBMS_OUTPUT.PUT_LINE('UPDATED ' || EID);
END;
/

CREATE OR REPLACE PROCEDURE find_managers
IS
    CURSOR S IS 
        SELECT E1.FIRSTNAME, E2.LASTNAME
        FROM EMPLOYEE E1 INNER JOIN EMPLOYEE E2
        ON E1.EMPLOYEEID = E2.REPORTSTO;
    FNAME EMPLOYEE.FIRSTNAME%TYPE;
    LNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN 
    OPEN S;
    LOOP
        FETCH S INTO FNAME, LNAME;
        DBMS_OUTPUT.PUT_LINE('MANAGER NAME: ' || FNAME ' ' ||LNAME);
        EXIT WHEN S%NOTFOUND;
    END LOOP;
    CLOSE S;
END;
/

BEGIN
find_managers;
END;
/

---4.3 STORED PROCEDURE OUTPUT PARAMETERS
CREATE OR REPLACE PROCEDURE company_name
IS 
    CURSOR S IS 
        SELECT FIRSTNAME, LASTNAME, COMPANY
        FROM CUSTOMER;
        
FNAME CUSTOMER.FIRSTNAME%TYPE;
LNAME CUSTOMER.LASTNAME%TYPE;
CMPY CUSTOMER.COMPANY%TYPE;
BEGIN
    OPEN S;
    LOOP
        FETCH S INTO FNAME, LNAME, CMPY;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FNAME || ' ' || LNAME || ' at ' ||CMPY);
    END LOOP;
    CLOSE S;
END;
/

BEGIN 
    company_name;
END;
/

---5.0 TRANSACTIONS
CREATE or REPLACE PROCEDURE delete_invoice (req_id IN invoice.invoiceid%TYPE)
IS 
BEGIN
    DELETE FROM invoiceline WHERE invoiceid = req_id;
    DELETE FROM invoice WHERE invoiceid = req_id;
    COMMIT;
END;
/

BEGIN delete_invoice(10);
END;
/

CREATE OR REPLACE PROCEDURE insert_customer (new_customer IN CUSTOMER%ROWTYPE)
IS
BEGIN
INSERT INTO customer VALUES NEW_CUSTOMER;
COMMIT;
END;
/

DECLARE
add_one CUSTOMER%ROWTYPE;
CURSOR S IS
    SELECT * FROM CUSTOMER ORDER BY CUSTOMERID DESC;
BEGIN
OPEN S;
LOOP
    FETCH S INTO add_one;
    EXIT;
END LOOP;
CLOSE S;
END;
/

add_one.customerid := add_one.customerid+1;
insert_customer(add_one);
DBMS_OUTPUT.PUT_LINE('Added Customer with ID of: ' || add_one.customerid);
END;
/

---6.0 TRIGGERS
---6.1 AFTER/FOR
---insert TRIGGER on employee table after new record is inserted
CREATE OR REPLACE TRIGGER new_employee_record
AFTER INSERT 
ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('A new EMPLOYEE record has been inserted');
END;
/

INSERT INTO employee VALUES (11, 'Rhamy', 'Rob', 'Owner', 0, '08-AUG-97', '13-JAN-20', '14511 Prism Circle, Unit 208', 'Tampa Bay', 'FL', 'USA', '33613', '+1 (504) 722-0278', '+1 (504) 324-0179', 'rhamdog@gmail.com');
INSERT INTO employee VALUES (12, 'Agar', 'Colby', 'IT Wench', 6, '06-APR-98', '13-JAN-20', '14511 Prism Circle, Unit 208', 'Tampa Bay', 'FL', 'USA', '33613', '+1 (321) 314-2172', '+1 (321) 654-8927', 'cagar@gmail.com');

---create TRIGGER on album after a new row is inserted
CREATE OR REPLACE TRIGGER album_row_update
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Album table row has been UPDATED');
END;
/

SELECT * FROM album;

UPDATE album SET title='BIG ONES' WHERE albumid = 5;
UPDATE album SET title='Audio Slave' WHERE albumid = 10;

---insert TRIGGER on customer table after a row has been deleted
SELECT * FROM customer;
CREATE OR REPLACE TRIGGER customer_delete
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('A customer has been deleted and now your children can no longer afford to go to college');
END;

INSERT INTO customer VALUES (62, 'Bob', 'Ellis', 'R J Ellis Law Firm', '650 Poydras Street', 'New Orleans', 'LA', 'USA', '70130', '+1 (225) 578-1623', 'null', 'bob@rjellis.com', 2);
INSERT INTO customer VALUES (63, 'Lorn', 'Johnson', 'NOPD', '8th District', 'New Orleans', 'LA', 'United States', '70116', '+1 (504) 682-8672', 'null', 'cuthgar@gmail.com', 2);

DELETE FROM customer WHERE firstname='Thomas';

---7.0 JOINS
---7.1 INNER JOIN
SELECT a.firstname, a.lastname, b.invoiceid FROM customer a INNER JOIN invoice b ON a.customerid=b.customerid;
---7.2 OUTER JOIN
SELECT a.customerid, a.firstname, a.lastname, b.invoiceid, b.total FROM customer a LEFT OUTER JOIN invoice b ON a.customerid=b.customerid;
---7.3 RIGHT JOIN
SELECT b.name, a.title FROM album a RIGHT JOIN artist b ON a.artistid=b.artistid;
---7.4 CROSS JOIN
SELECT * FROM album CROSS JOIN artist ORDER BY artist.name;
---7.5 SELF JOIN
SELECT * FROM employee a INNER JOIN employee b ON a.reportsto=b.reportsto;