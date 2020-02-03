-----SQL Homework Assignment-----

---Question 2.1
SELECT * FROM employee;

SELECT * FROM employee WHERE lastname='King';

SELECT * FROM employee WHERE firstname='Andrew' AND reportsto IS NULL;

---Question 2.2
SELECT * FROM album ORDER BY title DESC;
SELECT * FROM customer ORDER BY city ASC;

---Question 2.3
SELECT * FROM genre ORDER BY genreid;
INSERT INTO genre VALUES (26, 'K-Pop'); 
INSERT INTO genre VALUES (27, 'Indie');
SELECT * FROM employee ORDER BY employeeid;
INSERT INTO employee VALUES (9, 'Joe', 'Skura', 'Maintenance Assistant', 4, '23-OCT-94', '27-AUG-15','410 Ingleside Ave', 'Catonsville', 'MD','United States', '21228', '+1 (410) 364-9382', '+1 (410) 364-9382', 'jskuraaa@gmail.com'); 
INSERT INTO employee VALUES (10, 'Colby', 'Jack', 'Charcuterie Expert', 1, '16-MAY-95', '19-NOV-13','1107 Oakland Terrace Rd', 'Halethorpe', 'MD','United States', '21227', '+1 (410) 638-7628', '+1 (410) 638-7628', 'cheezeman@gmail.com'); 
SELECT * FROM customer ORDER BY customerid;
INSERT INTO customer VALUES (60, 'Joe', 'Skura', 'ManTech', '410 Ingleside Ave', 'Catonsville', 'MD','United States', '21228', '+1 (410) 364-9382', '+1 (410) 364-9382', 'jskuraaa@gmail.com', 4); 
INSERT INTO customer VALUES (61, 'Colby', 'Jack', 'Revature', '1107 Oakland Terrace Rd', 'Halethorpe', 'MD','United States', '21227', '+1 (410) 638-7628', '+1 (410) 638-7628', 'cheezeman@gmail.com', 5);

---Question 2.4
UPDATE customer SET firstname= 'Robert' WHERE customerid=32;
UPDATE customer SET lastname= 'Walter' WHERE customerid=32;
SELECT * FROM customer ORDER BY customerid;

SELECT * FROM artist;
UPDATE artist SET name= 'CCR' WHERE artistid=76;

---Question 2.5
SELECT * FROM invoice;
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

---Question 2.6
SELECT * FROM invoice WHERE total BETWEEN 15 and 50;
SELECT * FROM employee;
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' and '01-MAR-04';
SAVEPOINT;
---Question 2.7
SELECT * FROM customer;
DELETE FROM customer WHERE firstname='Robert' and lastname='Walter';

---Question 3.1
SELECT CURRENT_TIMESTAMP FROM dual;

SELECT * FROM mediatype;
SELECT COUNT(DISTINCT(name)) FROM mediatype;

---Question 3.2
SELECT * FROM invoice;
SELECT AVG(total) FROM invoice;

SELECT MAX(total) FROM invoice;

---Question 3.3
SELECT * FROM invoiceline;
SELECT AVG(unitprice) FROM invoiceline;

---Question 3.4
SELECT * FROM employee;
SELECT * FROM employee WHERE birthdate>'01-DEC-68';
SAVEPOINT;

---Question 4.1

CREATE OR REPLACE PROCEDURE emp_names
IS 
  CURSOR E IS SELECT firstname, lastname FROM employee;
  fname employee.firstname%TYPE;
  lname employee.lastname%TYPE;
 BEGIN 
  OPEN E; 
  LOOP FETCH E INTO fname, lname;
  dbms_output.put_line(E.fname || ' ' ||E.lname);
  EXIT WHEN E%NOTFOUND;
 END LOOP;
END;
/ 
BEGIN
emp_names;
END;
/


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






















































