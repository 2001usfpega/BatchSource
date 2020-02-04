
------Question 2.1

SELECT * FROM employee;

SELECT * FROM employee WHERE lastname = 'King';

SELECT * FROM employee WHERE firstname = 'Andrew' AND reportsto IS NULL;

------Question 2.2

SELECT * FROM album ORDER BY title ASC;

SELECT firstname FROM customer ORDER BY city ASC;

------Question 2.3
SELECT * FROM genre;

INSERT INTO genre VALUES (26, 'dancehall');

INSERT INTO genre VALUES (27, 'reggaeton');

SELECT * FROM employee;

INSERT INTO employee VALUES (9, 'J', 'K', 'Top Man', (null), '08-MAR-95','08-MAR-95', 'Gangsta World', 'Portmore', 'JA','Jamaica', 'jam 123', '+1 (876) 576 1234', '+1 (876) 576 1234', 'jamminz@aol.com' );
INSERT INTO employee VALUES (10, 'Jah', 'God', 'The Most High', (null), '08-MAR-95','08-MAR-95', 'Gangsta World', 'Portmore', 'JA','Jamaica', 'jam 123', '+1 (876) 576 1234', '+1 (876) 576 1234', 'jamminz@aol.com' );

SELECT * FROM customer;

INSERT INTO customer VALUES (60, 'J', 'K', 'Top Man', 'Gangsta World', 'Portmore', 'JA','Jamaica','12345', '+1 (876) 576 1234', '+1 (876) 576 1234', 'jamminz@aol.com', 1 );
INSERT INTO customer VALUES (61, 'Ja', 'Ka', 'Top Man', 'Gangsta World', 'Portmore', 'JA','Jamaica','12345', '+1 (876) 576 1234', '+1 (876) 576 1234', 'jamminz@aol.com', 1 );

------Question 2.4

UPDATE customer SET firstname = 'Robert', lastname= 'Walker' WHERE customerid = 32;

SELECT * FROM artist;
UPDATE artist SET name = 'CCR' WHERE name = 'Creedence Clearwater Revival';

------Question 2.5

SELECT * FROM invoice WHERE billingaddress LIKE 'T%';

-----Question 2.6

SELECT * FROM invoice WHERE total BETWEEN 15 and 50;

SELECT * FROM employee;
SELECT * FROM employee WHERE hiredate BETWEEN '01-JUN-03' and '1-MAR-04';

------Question 2.7 
SELECT * FROM customer;
SELECT * FROM invoice;
SELECT * FROM invoiceline;

ALTER TABLE invoice DROP CONSTRAINT FK_InvoiceCustomerId;
DELETE FROM customer WHERE customerid = 32;



ROLLBACK;
COMMIT;

-------Question 3.1

SELECT sysdate FROM dual;
SELECT * FROM mediatype;
SELECT name, length(name) FROM mediatype;

-------Question 3.2

SELECT AVG(total) FROM invoice;
SELECT MAX(total) FROM invoice;

------Questin 3.3

SELECT AVG(unitprice) FROM invoiceline;

----Question 3.4

SELECT * FROM employee WHERE birthdate > '31-DEC-68';

-----Question 4.1
CREATE OR REPLACE PROCEDURE first_last(names OUT Repet)
AS
BEGIN
SELECT firstname, lastname FROM employee;
END;
/

----Question 4.2.1

CREATE OR REPLACE PROCEDURE update_emp(e_id IN employee.employeeid%TYPE, e_title IN employee.title%TYPE , e_fname IN employee.firstname%Type , e_lname IN employee.lastname%type)
IS
BEGIN
	UPDATE employee SET title=e_title, firstname=e_fname, lastname=e_lname WHERE employeeid=e_id;
COMMIT;	
END;
/
DECLARE

BEGIN
	update_emp(12, 'Badman', 'Jay','Kay');
END;
/


-----Question 4.2.2

CREATE OR REPLACE PROCEDURE get_man(e_id IN NUMBER, m_id OUT NUMBER)
IS
BEGIN
SELECT reportsto INTO m_id FROM employee
WHERE employeeid = e_id;
END;
/
DECLARE
m_id NUMBER(3);
BEGIN
    get_man(3, m_id);
    DBMS_OUTPUT.PUT_LINE('Your manager is: '|| m_id);
END;
/

----Question 4.3

CREATE OR REPLACE PROCEDURE get_emp(c_id IN NUMBER, c_fn OUT VARCHAR2, c_ln OUT VARCHAR2, c_co OUT VARCHAR2)
IS
BEGIN
SELECT firstname, lastname, company INTO c_fn, c_ln, c_co FROM customer
WHERE customerid = c_id;
END; 
/

DECLARE
c_fn VARCHAR2(250);
c_ln VARCHAR2(250);
c_co VARCHAR2(250);
BEGIN
    get_emp(5, c_fn, c_ln, c_co);
    DBMS_OUTPUT.PUT_LINE('Your Employee name and Company is: '|| c_fn || ' ' || c_ln || ' ' || c_co);
END;
/

----Question 5.0.1
ALTER TABLE invoiceline DROP CONSTRAINT FK_INVOICELINEINVOICEID;
CREATE OR REPLACE PROCEDURE delInvoice(i_id IN invoice.invoiceid%TYPE)
IS
BEGIN
DELETE FROM invoice WHERE i_id = invoiceid;
COMMIT;
END;
/

BEGIN
delInvoice(3);
END;
/

---Question 5.0.2

CREATE OR REPLACE PROCEDURE newRow(c_id IN customer.customerid%TYPE, c_fn IN customer.firstname%TYPE, c_ln IN customer.lastname%TYPE, c_mail IN customer.email%TYPE)
IS
BEGIN
INSERT INTO customer(customerid, firstname, lastname, email) VALUES (c_id, c_fn, c_ln, c_mail);
COMMIT;
END;
/

BEGIN
  newRow(321, 'Jay', 'Don', 'topdawg@email.com');
END;
/

-----Question 6.1
CREATE OR REPLACE TRIGGER emp_in
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('New Employee' || :new.firstname);
END;
/

----Question 6.2

CREATE OR REPLACE TRIGGER album_up
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('Album Updated' || :new.title);
END;
/


CREATE OR REPLACE TRIGGER c_out
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('Customer deleted' || :old.firstname || ' ' || :old.lastname);
END;
/

-----Question 7.1
SELECT voi.invoiceid, c.firstname, c.lastname FROM invoice voi INNER JOIN customer c ON voi.customerid = c.customerid;

-----Question 7.2

SELECT c.customerid, c.firstname, c.lastname, voi.invoiceid, voi.total FROM invoice voi FULL OUTER JOIN customer c ON voi.customerid = c.customerid;

-----Question 7.3

SELECT t.name, b.title FROM artist t RIGHT JOIN album b ON t.artistid = b.artistid;

----Question 7.4

SELECT * FROM artist t CROSS JOIN album b ORDER BY t.name;

-----Question 7.5

SELECT * FROM employee emp1, employee emp2 WHERE emp1.reportsto = emp2.employeeid;









 










