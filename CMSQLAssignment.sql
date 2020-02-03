--2.1
SELECT * FROM employee;
SELECT * FROM employee WHERE lastname = 'King';
SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS NULL;

--2.2
SELECT * FROM album ORDER BY title DESC;
SELECT * FROM customer ORDER BY firstname, city ASC;

--2.3
INSERT INTO genre VALUES ('EDM', 'LoFi');
INSERT INTO employee VALUES ('Collinder', 'Bob');
INSERT INTO customer VALUES ('Potato Man', 'Jimmy');

--2.4
SELECT * FROM customer;
SELECT * FROM artist;
UPDATE customer SET first_name ='Robert', last_name = 'Walter' WHERE customer_id = 32;
UPDATE artist SET name ='CCR' WHERE artist_id = 76;

--2.5
SELECT * FROM invoice WHERE billingaddress = 'T%';

--2.6
SELECT * FROM invoice WHERE total BETWEEN 15 and 50;
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' and '01-MAR-04';

--2.7
DELETE FROM customer WHERE customer_id = 32;

--3.1
SELECT * FROM mediatype;
SELECT sysdate FROM dual;
SELECT mediatypeid, length(name)FROM mediatype;

--3.2
SELECT COUNT(*) AVG FROM invoice;
SELECT COUNT(*) MAX FROM track;

--3.3
SELECT AVG(unitprice) FROM invoiceline;

--3.4
SELECT * FROM employee;
SELECT * FROM employee WHERE birthdate > TO_DATE('01-JAN-68');

--4.1
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

--4.2
select reportsto from employee;
CREATE OR REPLACE PROCEDURE update_customer_lastname(c_id IN NUMBER, c_name IN VARCHAR2)

IS

BEGIN

    UPDATE customer SET lastname= c_name WHERE customerid = c_id;

    COMMIT;

END;

/
BEGIN
update_customer_lastname(5, 'dfjbk');
END;
/

select * from customer;

CREATE OR REPLACE PROCEDURE return_managers(e_id IN NUMBER, m_id OUT VARCHAR2)

IS

BEGIN

   SELECT reportsto INTO m_id FROM employee WHERE employeeid = e_id;

END;

/
DECLARE
m_id NUMBER (3);
BEGIN
    return_managers(4, m_id);
    dbms_OUTPUT.put_line(m_id);
END;
/


--4.3
CREATE OR REPLACE PROCEDURE returns_name(c_id IN NUMBER, c_fname OUT VARCHAR2, c_lname OUT VARCHAR2, cc_name OUT VARCHAR2)

IS

BEGIN

   SELECT firstname, lastname, company INTO c_fname, c_lname, cc_name FROM customer WHERE customerid = c_id;

END;
/
DECLARE
    c_fname VARCHAR2(22);
    c_lname VARCHAR2(22);
    cc_name VARCHAR2(121);
BEGIN
    returns_name(4, c_fname, c_lname, cc_name);
    DBMS_OUTPUT.PUT_LINE(c_fname || c_lname || cc_name);
END;
/

--5.0


--6.1
CREATE OR REPLACE TRIGGER e_fire 
    AFTER INSERT
     ON employee
DECLARE     

BEGIN

END;
/

CREATE OR REPLACE TRIGGER songs 
    AFTER UPDATE 
        ON album
DECLARE

BEGIN

END;
/

CREATE OR CREATE TRIGGER ire
    AFTER DELETE 
        ON customer
DECLARE

BEGIN

END;


--7.1
SELECT COUNT(*) FROM customer a INNER JOIN orders b 
    ON a.customerid = b.customerid + invoiceid;

--7.2
SELECT a.customerid, b.firstname, c.lastname,invioceid FROM customer a FULL OUTER JOIN orders b 
    ON a.customerid = b.customerid + invoiceid;

--7.3
SELECT * FROM artist a RIGHT OUTER JOIN album b 
    ON a.artistid = b.artistid;

--7.4
SELECT * FROM album CROSS JOIN artist 
    ORDER BY artist.name;

--7.5
SELECT * FROM employee a INNER JOIN employee b 
    ON a.reportsto = b.reportsto;

