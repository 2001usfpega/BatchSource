--2.1 SELECT
SELECT *FROM employee;--Task – Select all records from the Employee table
--Task – Select all records from the Employee table where last name is King.

SELECT* FROM employee WHERE lastname='King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM employee WHERE firstname='Andrew' AND reportsto IS NULL;
--2.2SQL ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT albumid ,title from ALBUM ORDER BY title DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT firstname,city  FROM customer ORDER BY city;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table 
DESC genre;
SELECT*FROM genre;
INSERT INTO genre VALUES (26,'ficcion');
INSERT INTO genre VALUES (27,'horror');
COMMIT;
--Task – Insert two new records into Employee table
SELECT * FROM  employee;
INSERT INTO employee VALUES('9','Camara','Teresa','IT','1','11-APR-89','13-JAN-20', '1737 20th','Aberdeen','SD','United','57401','+1(605)335-4587','','');
INSERT INTO employee VALUES('10','Trefilo','Samanba','IT','1','03-APR-78','1-JAN-20', '1737 20th ave se','sioux falls','NC','United','57401','+1(605)335-4587','','');
COMMIT;
--Task – Insert two new records into Customer table
SELECT *FROM customer;
INSERT INTO customer VALUES('60','Teresa','Camara','Revature','1737 20th ave se','Aberdeen','SD', 'North Americ','57401','+1(605)335-4587','','tsca@gmail.com','5');
INSERT INTO customer VALUES('61','Sidiki','Trefilo','banner','8666 green verde','Tampa','FL', 'North Americ','33632','+1(813)335-4287','','sidjob@gmail.com','2');
COMMIT;

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE  customer SET firstname='Robert', lastname='Walter' WHERE firstname='Aaron' and lastname='Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
SELECT * FROM artist;
UPDATE artist SET name='CCR' WHERE name='Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%” 
SELECT * FROM invoice;
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT* FROM employee;
SELECT* FROM employee WHERE hiredate BETWEEN '01-JUN-2003' AND '01-MAR-2004';
COMMIT;
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
SELECT*FROM customer;
ALTER TABLE invoice DISABLE CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM customer where firstname='Robert' and lastname='Walter' ;

--SQL Functions
--3.1 System Defined Functions
--Task – Create a function that returns the current time
--SELECT  CURRENT_TIMESTAMP  FROM DUAL;
CREATE OR REPLACE FUNCTION current_time
RETURN DATE
IS
current_date DATE :=NULL;
BEGIN
SELECT sysdate INTO current_date FROM dual;
RETURN current_date;
END;
/
 DECLARE
current_date DATE :=NULL;
BEGIN
current_date := current_time();
DBMS_OUTPUT.PUT_LINE('The current time is : '||current_date);
END;
/


--Task – create a function that returns the length of name in MEDIATYPE table

SELECT * FROM mediatype;
SELECT NAME , LENGTH(NAME) FROM mediatype;

CREATE OR REPLACE FUNCTION length_name( media_id number ,media_name VARCHAR2)
RETURN number
IS
name_length NUMBER;
BEGIN
SELECT LENGTH(media_name)  INTO name_length FROM mediatype where mediatypeid=media_id;
RETURN name_length;
END;
/

declare
length_of_name number;
begin
 length_of_name:=length_name(5,'Teresa');
 DBMS_OUTPUT.PUT_LINE('the length is '|| length_of_name);
 end;
 /
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 
 SELECT  AVG(total) FROM invoice;
 Create or replace FUNCTION invoices_average RETURN number
 is
 average number;
 BEGIN
 SELECT  AVG(total) into average FROM invoice;
 RETURN average;
 end;
 /
 
 DECLARE
 average number;
 BEGIN
 average:=invoices_average();
 DBMS_OUTPUT.PUT_LINE('The average of all total invoices is '|| average);
 END;
/
--Task – Create a function that returns the most expensive track
SELECT * from track;
 SELECT MAX(unitprice)FROM track ;
 
 CREATE or REPLACE FUNCTION most_expensive_track return NUMBER
 IS
 most_expensive number;
 Begin
 SELECT  MAX(unitprice) into most_expensive FROM track;
 RETURN most_expensive;
 END;
 /
 
 DECLARE
 most_exp NUMBER;
 BEGIN
 most_exp:=most_expensive_track();
 DBMS_OUTPUT.PUT_LINE('The most expensive track is '|| most_exp);
 END;
/
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE or REPLACE FUNCTION average_price RETURN NUMBER
IS
average NUMBER;
BEGIN
SELECT   avg(unitprice)Into average from invoiceline ;
RETURN average;
END;
/
SELECT   avg(unitprice) from invoiceline GROUP BY unitprice;
DECLARE
average NUMBER;
BEGIN
average:=average_price();
DBMS_OUTPUT.PUT_LINE('The averege price for items is '||average);
END;
/
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
SELECT * from employee;
SELECT *from employee where birthdate > '31-DEC-68';

CREATE OR REPLACE FUNCTION after_date(dates VARCHAR2) RETURN SYS_REFCURSOR
IS
  EMPLOYEE_C SYS_REFCURSOR;
BEGIN
  OPEN EMPLOYEE_C FOR SELECT * FROM EMPLOYEE
                        WHERE BIRTHDATE >= dates;
  RETURN EMPLOYEE_C;
END;
/

DECLARE
  EMPLOYEE_C SYS_REFCURSOR;
dates VARCHAR2;
 BEGIN
 EMPLOYEE_C :=after_date('01-JAN-70');
LOOP
        FETCH  EMPLOYEE_C  INTO f_name, last_name;
        EXIT WHEN  EMPLOYEE_C %NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(f_name || '     ' || last_name);
    END LOOP;
     CLOSE  EMPLOYEE_C ;
END;
/
--4.0 Stored Procedures
 --In this section you will be creating and executing stored procedures.
 --You will be creating various types of stored procedures that take input and output parameters.
 
 --4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
select * from employee;


CREATE OR REPLACE PROCEDURE get_employee_names( employee_names  OUT SYS_REFCURSOR)  
IS
 
BEGIN
  OPEN employee_names FOR SELECT firstname,lastname FROM employee;
 
END;
/
-------executation---------------
DECLARE
 names_recursor SYS_REFCURSOR;
 f_name VARCHAR2(4000);
 last_name VARCHAR2(4000);
 BEGIN
 get_employee_names(names_recursor);
LOOP
        FETCH names_recursor INTO f_name, last_name;
        EXIT WHEN names_recursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(f_name || '     ' || last_name);
    END LOOP;
     CLOSE names_recursor;
END;
/
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE or REPLACE PROCEDURE Update_Employee(emp_id IN NUMBER,new_title IN VARCHAR2,new_city IN VARCHAR2)
IS
BEGIN
UPDATE employee SET title=new_title where employeeid=emp_id;
UPDATE employee SET city=new_city where employeeid=emp_id;

COMMIT;
end;
/
DECLARE
emp_new_name VARCHAR2(4000);
begin
update_employee(2,'IT ','Aberdeen');
 DBMS_OUTPUT.PUT_LINE('Well Done');
end;
/
SELECT*FROM employee;
SELECT reportsto from employee where employeeid=2;
--Task – Create a stored procedure that returns the managers of an employee .
CREATE OR REPLACE PROCEDURE  employee_managers(emp_id IN NUMBER,manager_name OUT VARCHAR2)
IS
BEGIN
SELECT firstname INTO manager_name from employee where employeeid=(SELECT reportsto from employee where employeeid=emp_id );
end;
/
DECLARE
emp_manager_name VARCHAR2(4000);
begin
 employee_managers(66,emp_manager_name);
 DBMS_OUTPUT.PUT_LINE('this employee manager is ' ||emp_manager_name);
end;
/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer
SELECT
    *
FROM customer;

 SELECT firstname,lastname,company from customer where customerid=14;

 CREATE OR REPLACE PROCEDURE customer_company(cust_id IN NUMBER,cust_name out VARCHAR2,cust_last out VARCHAR2,cust_company out VARCHAR2)
 is
 BEGIN
 SELECT firstname into cust_name from customer where customerid=cust_id;
 SELECT lastname into cust_last from customer where customerid=cust_id;
 SELECT company into cust_company from customer where customerid=cust_id;
 COMMIT;
 end; 
/
DECLARE
cust_name VARCHAR2(40 BYTE);
cust_last VARCHAR2(20 BYTE);
cust_company VARCHAR2(80 BYTE);
BEGIN
customer_company(15,cust_name,cust_last,cust_company);
 DBMS_OUTPUT.PUT_LINE(cust_name||' '|| cust_last||' Company is '||cust_company);
end;
/

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER after_insert_employee
AFTER INSERT ON employee
FOR EACH ROW

BEGIN

DBMS_OUTPUT.PUT_LINE('A new employee record has been inserted');
end;
/
INSERT INTO employee VALUES('52','Rosalez','Maria','HR','1','11-NOV-88','15-JAN-20', '1737 20th','Aberdeen','SD','United','57401','+1(605)335-4587','','');
INSERT INTO employee VALUES('67','Perez','John','Sales','2','03-APR-69','1-JAN-20', '1737 20th ave se','sioux falls','NC','United','57401','+1(605)335-4587','','');
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER after_delete_employee
AFTER Delete ON employee
FOR EACH ROW

BEGIN

DBMS_OUTPUT.PUT_LINE('An employee record has been delete');
end;
/
SELECT * FROM employee;

DELETE FROM employee WHERE employeeid=64;
---7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

SELECT *FROM customer;

SELECT a.firstname,b.invoiceid FROM customer a INNER JOIN invoice b  ON a.customerid=b.customerid;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.


SELECT cus.customerid,cus.firstname,cus.lastname,inv.invoiceid,inv.total  FROM customer cus LEFT OUTER JOIN invoice inv ON cus.customerid=inv.customerid ;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT art.name,alb.title from  album alb RIGHT JOIN artist art on art.artistid = alb.artistid;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * from album CROSS JOIN artist ORDER BY  artist.name;--- return a ascendin order

SELECT * from album CROSS JOIN artist ORDER BY  artist.name DESC ;-- return a descending order


--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * from employee  a INNER JOIN employee b on  a.employeeid=b.reportsto;


COMMIT;






 
 