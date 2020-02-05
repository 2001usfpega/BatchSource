--2.1
SELECT * FROM employee;
SELECT * FROM employee WHERE lastname = 'King';
SELECT * fROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
--2.2
SELECT * FROM ALBUM ORDER BY TITLE DESC;
SELECT firstname, city FROM customer ORDER BY city;
--2.3
SELECT * FROM genre;
INSERT INTO genre VALUES(26, 'Country');
INSERT INTO genre VALUES(27, 'Southern Rock');
SELECT * FROM employee;
INSERT INTO employee VALUES(10, 'Scott','Michael', 'Assistant to Regional Manager', null, '28-Feb-83', '28-Aug-06', '65 Old Town Row'
, 'Scranton','PA','Merica', 'TSK 2N2', '905=556-7890','9056-8567809', 'michaelgscott@scottstotts.lies');
INSERT INTO employee VALUES(9, 'Schrute','Dwight', 'Assistant to Regional Manager', 10, '28-Feb-85', '28-Aug-07', '56 Old Town Row'
, 'Scranton','PA','Merica', 'TSK 2N1', '905=555-7890','9056-5567809', 'dwightkschrute@schrutefarms.amish');
SELECT * FROM customer;
INSERT INTO customer (customerid, firstname, lastname, address, city, phone, email) VALUES (70, 'Frodo', 'Baggins', 'Bagend', 'The Shire', 555-555-555, 'ThatHalfling@HobbittFeet.gandalf');
INSERT INTO customer (customerid, firstname, lastname, address, city, phone, email) VALUES (70, 'Bilbo', 'Baggins', 'Bagend', 'The Shire', 123-456-7890, 'BilboBurgurlar@Dwarf.smaug');
--2.4
SELECT * FROM CUSTOMER WHERE firstname = 'Aaron' AND lastname= 'Mitchell';
UPDATE customer SET firstname= 'Robert', lastname ='Walter' where firstname ='Aaron' AND lastname = 'Mitchell';
SELECT * FROM ARTIST;
UPDATE artist SET name ='CCR' WHERE name = 'Creedence Clearwater Revival';
SELECT * FROM artist ORDER BY name;
--2.5
SELECT * FROM customer;
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';
--2.6
SELECT * FROM (SELECT * FROM INVOICE WHERE TOTAL >= 15) WHERE TOTAL<=20;
--2.7
----Record Robert Walter has a child record. We don't want to keave an orphan, so we'll drop constraint on invoice table
Alter table invoice drop constraint FK_INVOICECUSTOMERID;
delete from customer where firstname = 'Robert' and lastname ='Walter';

--3.1 
--first we'll use a system defined fucntion to give the current date
SELECT SYSDATE FROM dual;
--Next we'll use length function to give the number of characters in each entry in name column
select * from mediatype;
select length(name) from mediatype;
--3.2
--first we'll get the average total of all invoices using aggregate length function
SELECT  AVG(TOTAL) FROM invoice;
--Next we'll find the most expensive track
--First we'll look at out invoiceline table
SELECT * FROM invoiceline;
-- since track prices in seprate table from tarck name we need to use key to find corresponding track name
SELECT * FROM TRACK;

--Getting all 
SELECT MAX(unitprice) from Track;
select * from track where unitprice = 1.99;

--3.3
Select * from invoiceline;
--Create function to return average price of invoiceline items from invoiceline table
Select avg(unitprice) from invoiceline;

--3.4
--Create function that returns employees born after 1968
--first let's look at table
select * from employee;

select *
  from   employee where  birthdate > '1-jan-68';
--Or the way we did in class
CREATE OR REPLACE FUNCTION AFTER_1968 RETURN SYS_REFCURSOR
IS
  EMPLOYEE_C SYS_REFCURSOR;
BEGIN
  OPEN EMPLOYEE_C FOR SELECT * FROM EMPLOYEE
                        WHERE BIRTHDATE >= TO_DATE('01-01-1968','DD-MM-YYYY');
  RETURN EMPLOYEE_C;
END;
/
SELECT AFTER_1968 FROM DUAL;

--4.1
---Create procedure to give first and last name
CREATE OR REPLACE PROCEDURE basic_name_procedure(employees OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN employees FOR SELECT firstname, lastname FROM employee;
END;
/
DECLARE
    employees SYS_REFCURSOR;
    FIRSTNAME VARCHAR2(20);
    LASTNAME VARCHAR2(20);
BEGIN
    basic_name_procedure(employees);
    
    LOOP
    FETCH employees INTO
        firstname,
        lastname;
    EXIT WHEN employees%notfound;
    DBMS_OUTPUT.PUT_LINE(firstname|| ' ' || lastname);
END;
/
--6.0 Triggers
--6.1 INSERT AFTER TRIGGER THAT SIMPLY PRINTS TO SCREEN AFTER INSERT
 CREATE OR REPLACE TRIGGER employee_insert_after
 AFTER INSERT ON employee
-- FOR EACH ROW
 BEGIN
   DBMS_OUTPUT.PUT_LINE('RECORD INSERTED');
END;
/
--4,2(a)
CREATE OR REPLACE PROCEDURE set_employee_info(emp_id IN employee.employeeid%TYPE, emp_title IN employee.title%TYPE, emp_fname IN employee.firstname%TYPE, emp_lname IN employee.lastname%TYPE)
IS
BEGIN
    UPDATE employee SET  title =emp_title, firstname = emp_fname, lastname = emp_lname where employeeid=emp_id;
COMMIT;
END;
/
DECLARE
BEGIN set_employee_info(4, 'Boss', 'Johnny', 'Cash');
END;
/
SELECT * FROM employee;

--4.2 (b)
CREATE OR REPLACE PROCEDURE get_manager(id in number, manager out varchar2)
is
    man_id number(10);
begin
     select reportsto into man_id from employee where employeeid = id;
    select firstname || ' ' || lastname into manager from employee where employeeid = man+id;
 end;
 /
 --4.3
 create or replace procedure cust_info (c_id in number, c_name OUT VARCHAR2, c_company OUT VARCHAR2)
 IS
 BEGIN 
    SELECT firstname|| ' ' || lastname, company into c_name, c_company From customer where customerid = c_id;
    end;
/

DECLARE 
    c_name VARCHAR2(50);
    company VARCHAR2(50);
BEGIN
    cust_info(5, c_name, company);
    --print stastement
END;
/
--5.0
--a

--b
CREATE OR REPLACE PROCEDURE insert_cust(c_id IN NUMBER, c_fname IN VARCHAR2,
c_lname IN VARCHAR2, c_company in VARCHAR2, c_address in VARCHAR2, c_city in VARCHAR2, c_state in VARCHAR2, c_country in VARCHAR2,
c_postal in VARCHAR2 , c_phone in VARCHAR2,c_fax in VARCHAR2, c_email in VARCHAR2, c_support_id in NUMBER )
IS
BEGIN
    INSERT INTO CUSTOMER VALUES (c_id, c_fname, c_company, c_lname, c_address, c_city, c_state, c_country, c_postal, c_phone, c_fax,  c_email, c_support_id);
    COMMIT;
END;
/




--6.2 UPDATE AFTER TRIGGER THAT SIMPLY PRINTS TO SCREEN AFTER UPDATE

CREATE OR REPLACE TRIGGER employee_update_after
 AFTER UPDATE ON employee
 FOR EACH ROW
 BEGIN
   DBMS_OUTPUT.PUT_LINE('RECORD UPDATED');
END;
/
--6.3 DELETE AFTER TRIGGER THAT SIMPLY PRINTS TO SCREEN AFTER ROW DELETION

CREATE OR REPLACE TRIGGER employee_delete_after
AFTER DELETE ON employee
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('RECORD DELETED');
END;
/
INSERT INTO employee VALUES(23, 'SchruGGFe','Dwight', 'Assistant to Regional Manager', 10, '28-Feb-85', '28-Aug-07', '56 Old Town Row'
, 'Scranton','PA','Merica', 'TSK 2N1', '905=555-7890','9056-5567809', 'dwightkschrute@schrutefarms.amish');
--IT WORKS.
--7.0 JOINS
--first we'll do an inner join on customers and invoice
--let's look at the table contents
select * from invoice;
--7.1
SELECT c.firstname, c.lastname, d.invoiceid FROM customer c INNER JOIN invoice d ON c.customerid = d.customerid;
--7.2
SELECT a.customerid, a.firstname, a.lastname, b.invoiceid, b.total FROM customer a FULL OUTER JOIN invoice b ON a.customerid = b.customerid;
--7.3 right outer join
SELECT c.name, d.title FROM artist c RIGHT OUTER JOIN album d ON (c.artistid = d.artistid);

--7.3 cross join
SELECT name, title FROM artist CROSS JOIN album order by name;
--7.4 self join
SELECT a.lastname, b.lastname from employee a, employee b where a.reportsto = b.reportsto;














