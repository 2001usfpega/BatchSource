--SQL LAB
--KYLE KRUG
--DUE FEb 3rd

--Question 2
--2.1
SELECT * FROM employee;
SELECT *FROM employee WHERE lastname = 'King';
SELECT * FROM employee WHERE firstname = 'Andrew' and REPORTSTO is null;

--2.2
SELECT * FROM album ORDER BY title DESC;
SELECT firstname FROM customer ORDER BY city ASC;

--2.3
SELECT * FROM Genre;
INSERT INTO Genre(GENREID, NAME) VALUES (26,'Insert one');
INSERT INTO Genre(GENREID, NAME) VALUES (27,'Insert two');

SELECT * FROM employee;
INSERT INTO employee(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL)
    VALUES(9,'nULL','nULL','Null',NULL,NULL,NULL,NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO employee(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL)
    VALUES(10,'nULL','nULL','Null',NULL,NULL,NULL,NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SELECT * FROM customer;
INSERT INTO customer(customerid,firstname,lastname,company,address,city,state,country,postalcode,fax,email,supportrepid) 
                VALUES(60,'a','b',null,null,null,null,null,null,null,'no',null);
INSERT INTO customer(customerid,firstname,lastname,company,address,city,state,country,postalcode,fax,email,supportrepid) 
                VALUES(61,'a','b',null,null,null,null,null,null,null,'no',null);


--2.4
SELECT * from customer where firstname = 'Robert' and lastname = 'Walter';
UPDATE customer
SET firstname = 'Robert'
,lastname = 'Walter'
WHERE  firstname = 'Aaron' and lastname = 'Mitchell';

SELECT * FROM artist where name = 'CCR';
UPDATE artist
SET name = 'CCR'
where name = 'Creedence Clearwater Revival';

--2.5
SELECT * FROM invoice WHERE billingaddress LIKE 'T%';
--2.6
SELECT * FROM invoice WHERE total between 15 and 50;
SELECT * FROM employee WHERE hiredate between '01-JUN-03' and '01-MAR-04';
--2.7
ALTER TABLE 
DELETE FROM customer
WHERE firstname = 'Robert' and lastname = 'Walter';

--3.1
SELECT CURRENT_TIMESTAMP FROM dual;
SELECT LENGTH(name) from mediatype;

--3.2
SELECT AVG(TOTAL) FROM invoice;
SELECT MAX(UNITPRICE) FROM TRACK;


--3.3
SELECT 





--4.1
CREATE OR REPLACE PROCEDURE basic
AS
BEGIN
SELECT firstname, lastname FROM employee;
END;
/

--6.1
CREATE OR REPLACE TRIGGER after_in
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
--does something on insert into employee table
END;
/
CREATE OR REPLACE TRIGGER after_in
AFTER UPDATE ON employee
FOR EACH ROW
BEGIN
--does something on update into employee table
END;
/
CREATE OR REPLACE TRIGGER after_in
AFTER DELETE ON employee
FOR EACH ROW
BEGIN
--does something on delete on employee table
END;
/



--7.1
SELECT customer.firstname, customer.lastname,invoice.invoiceid
FROM customer
INNER JOIN invoiceid
on customer.customerid = invoice.invoiceid;

--7.2
SELECT customer.customerid,customer.firstname,customer.lastname,invoice.invoiceid,invoice.total
FROM customer
LEFT OUTER JOIN invoice on customer.customerid = invoice.customerid;


--7.3
SELECT ALBUM.TITLE,ARTIST.NAME
FROM ARTIST
RIGHT OUTER JOIN ALBUM
ON ALBUM.ARTISTID = ARTIST.ARTISTID;

--7.4
SELECT * FROM album
    CROSS JOIN artist
    ORDER BY artist.name asc;
    
--7.5

