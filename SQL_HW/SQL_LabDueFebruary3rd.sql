---SQL LabDue February 3rd   
---            by  jinjun zhen
SET SERVEROUTPUT ON;
-- 2.1

SELECT * FROM Employee; 
SELECT * FROM Employee WHERE lastname = 'King'; 
SELECT * FROM Employee WHERE firstname = 'Andrew' AND REPORTSTO is NULL; 

-- 2.2

SELECT * FROM Album ORDER BY title DESC;
SELECT firstname FROM Customer ORDER BY city;


--2.3
SELECT * FROM Genre;
INSERT INTO Genre (GenreId, Name) VALUES (26, 'insert1');
INSERT INTO Genre (GenreId, Name) VALUES (27, 'insert2');

SELECT * FROM Employee;
INSERT INTO employee (firstname, lastname, title, city, employeeid) VALUES ('monkey', 'king', 'king', 'monkey city', 9);
INSERT INTO employee (firstname, lastname, title, city, employeeid) VALUES ('hello', 'monkey', 'queen', 'monkey villege', 10);

SELECT * FROM Customer;
INSERT INTO customer (customerid, firstname, lastname, email) VALUES (60, 'monkey', 'king', 'monkey@king.com');
INSERT INTO customer (customerid, firstname, lastname, email) VALUES (61, 'hello', 'monkey', 'hello@monkey.com');


---2.4 UPDATE
SELECT * FROM Customer; 

UPDATE customer
SET firstname = 'Robert', lastname = 'Walter'
Where firstname = 'Araon';

SELECT * FROM artist ORDER BY name;
UPDATE Artist
SET name = 'CCR'
Where name = 'Creedence Clearwater Revival';


-- 2.5 LIKE
SELECT * FROM invoice;
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';


--2.6 BETWEEN

SELECT * FROM invoice;
SELECT * FROM invoice WHERE total BETWEEN 15 AND 50;

SELECT * FROM employee;
SELECT * FROM employee WHERE hiredate between '1-JUN-2003' and '1-MAR-2004';


--2.7 DELETE
select * from customer;


ALTER TABLE invoice DROP CONSTRAINT FK_INVOICECUSTOMERID;
delete from invoice where firstname='Robert';
rollback;

--3.1
SELECT CURRENT_TIMESTAMP FROM dual;

select * from mediatype;
select length(name) from mediatype;

--3.2
select * from invoice;
select AVG(total) from invoice;

select * from track;
select max(unitprice) from track;

-- 3.3
select * from invoiceline;
select avg(unitprice) from invoiceline;


-- 3.4 User Defined Table Valued Functions
select * from employee;
select * from employee where birthdate > '31-DEC-68';


--4.1 Basic Stored Procedure

/
select * from employee;

CREATE OR REPLACE PROCEDURE getName(e_id IN NUMBER, f_name OUT employee.firstname%TYPE, l_name OUT employee.lastname%TYPE)
IS
BEGIN
    SELECT firstname, lastname INTO f_name, l_name FROM employee WHERE employeeid=e_id;
END;
/

DECLARE
    e_id employee.employeeid%TYPE;
    f_name employee.firstname%TYPE;
    l_name employee.lastname%TYPE;
    CURSOR c_cursor is
        SELECT employeeid FROM employee;
BEGIN
    open c_cursor;
    loop
    fetch c_cursor into e_id;
        exit when c_cursor%notfound;
        getName(e_id, f_name, l_name);
        dbms_output.put_line(e_id || ' ' || f_name ||' '|| l_name );
    end loop;
    close c_cursor;
end;
/
           

-- 4.2 Stored Procedure Input Parameters .    A

select * from employee;
DROP PROCEDURE update_perInfor;

CREATE OR REPLACE PROCEDURE update_perInfor(in_firstname IN employee.firstname%TYPE, in_lastname IN employee.lastname%TYPE, new_city IN employee.city%TYPE)
IS
BEGIN
    UPDATE employee SET city = new_city where firstname = in_firstname;
END;
/

DECLARE
    c_ity employee.city%TYPE;
    f_name employee.firstname%TYPE;
    l_name employee.lastname%TYPE;
BEGIN
    update_perInfor('Andrew', 'Adams', 'buyo');
    dbms_output.put_line( f_name || l_name || c_ity );
end;
/

commit;

-- 4.2                             .B



select * from employee; 
DROP PROCEDURE return_manager;

CREATE OR REPLACE PROCEDURE return_manager(in_firstname IN employee.firstname%TYPE ,
in_lastname IN employee.lastname%TYPE , out_reportsto OUT NUMBER)
IS
BEGIN
    SELECT reportsto into out_reportsto from employee where firstname = in_firstname and lastname = in_lastname;
    commit;
END;
/

SET SERVEROUTPUT ON;

DECLARE
    f_name employee.firstname%TYPE;
    l_name employee.lastname%TYPE;
    managerID employee.reportsto%TYPE;
BEGIN
    update_perInfor('Andrew', 'Adams', managerID);
    dbms_output.put_line( f_name || l_name || managerID );
end;
/
commit;



-- 4.3 
select * from customer;
CREATE OR REPLACE PROCEDURE nameAndCompany(in_customerID IN customer.customerid%type, out_firstname out customer.firstname%type,
out_lastname out customer.lastname%type, out_company out customer.company%type)
IS
BEGIN
    SELECT company, firstname, lastname into out_company, out_firstname, out_lastname from customer where customerid = in_customerID;
END;
/

DECLARE
    customerID customer.customerid%TYPE;
    company customer.company%TYPE;
    f_name customer.firstname%TYPE;
    l_name customer.lastname%TYPE;
    
BEGIN
    nameAndCompany(1, f_name, l_name, company  );
    dbms_output.put_line( f_name || l_name || company );
end;
/
commit;




5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that

rely on this, find out how to resolve them).
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table




6.1 AFTER/FOR
select * from employee;

------------------------------------
CREATE SEQUENCE employee_seq
    START WITH 100
    INCREMENT BY 2;


 CREATE OR REPLACE TRIGGER employee_insert
 BEFORE INSERT ON employee
 FOR EACH ROW
 BEGIN 
    IF : new.employeeid IS NULL THEN
        SELECT employee_seq.NEXTVAL INTO : NEW.employeeid FROM dual;
        END IF;
END;
/
INSERT INTO employee (lastname, firstname) VALUES ('employee chicken', 'employee block');
INSERT INTO employee (lastname, firstname) VALUES ('employee dressing', 'employee love');

-------------------------
-- after update

select * from artist;


drop trigger artist_update;
/


CREATE OR REPLACE TRIGGER artist_update
AFTER UPDATE ON artist
BEGIN
    dbms_output.put_line( 'okay ~ i am so lazy~ just print this out' );
END;
/

CREATE OR REPLACE TRIGGER artist_update
AFTER DELETE ON artist
BEGIN
    dbms_output.put_line( 'This is slightly different, cuz it is after delete this time' );
END;
/

rollback;


-----------------------------------------------
-- after delete
Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.










-----------------------------------------------
--7.0 JOINS

--7.1 INNER

SELECT a.customerid, firstname, lastname FROM customer a INNER JOIN invoice b ON a.customerid = b.customerid ORDER BY a.customerid;

-- 7.2 outer

SELECT a.customerid, firstname, lastname, invoiceid, total FROM customer a full outer join invoice b ON a.customerid = b.customerid;

-- 7.3 RIGHT

SELECT * from album;
SELECT * from artist;
select name, title from album a right join  artist b ON a.artistid = b.artistid;

-- 7.4 CROSS
select * from album a cross join artist b order by name; 

-- 7.5 SELF
select * from employee;

select * from employee a full outer join employee b ON a.reportsto = b.reportsto;


