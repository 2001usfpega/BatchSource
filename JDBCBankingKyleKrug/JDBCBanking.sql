CREATE USER bankingdb IDENTIFIED BY p4ssw0rd;

GRANT CONNECT, RESOURCE TO bankingdb;
GRANT DBA TO bankingdb WITH ADMIN OPTION;

--- DROPS TABLE
DROP TABLE customer;
DROP TABLE balance;
DROP TABLE banking_employee;

---CREATES TABLES
CREATE TABLE balance(
    b_id NUMBER(15)
    ,b_amount NUMBER(38,2)
    ,PRIMARY KEY(b_id)
);
------------------------
--CREATE TABLES---------
CREATE TABLE customer(
   customer_id INT NOT NULL
   ,first_name VARCHAR2(25) not null
   ,last_name VARCHAR2(25) not null
   ,age NUMBER(3) not null
   ,gender VARCHAR2(10) not null
   ,ssn NUMBER(9) not null UNIQUE
   ,username VARCHAR2(25) not null UNIQUE
   ,user_pass VARCHAR2(25) not null 
   ,approved VARCHAR2(10)
   ,disabled VARCHAR2(10)
   ,jointacc VARCHAR2(10)
   ,balance_id NUMBER (15)constraint balance_fk references balance(b_id)
   --,balance_id NUMBER(15) not null REFERENCES balance(b_id) ON DELETE CASCADE 
   ,PRIMARY KEY(customer_id)
   
   );
  
CREATE TABLE banking_employee(
    employee_id INT NOT NULL
    ,first_name VARCHAR2(25) not null
    ,last_name VARCHAR2(25) not null
    ,age NUMBER(3) not null
    ,gender VARCHAR2(10) not null
    ,ssn NUMBER(9) not null UNIQUE
    ,username VARCHAR2(25) not null UNIQUE
    ,user_pass VARCHAR2(25) not null 
    ,PRIMARY KEY (employee_id)
    );
    

CREATE SEQUENCE balance_id_seq
MINVALUE 1
MAXVALUE 9999999999999
START WITH 1
INCREMENT BY 1;


CREATE OR REPLACE TRIGGER b_id 
BEFORE INSERT ON balance
FOR EACH ROW
BEGIN
    SELECT balance_id_seq.nextval
    INTO :new.b_id
    FROM dual;
end;
/

--auto increments the id of the tables

CREATE SEQUENCE customer_id_seq;

CREATE OR REPLACE TRIGGER customer_id 
BEFORE INSERT ON customer
FOR EACH ROW
BEGIN
    SELECT customer_id_seq.nextval
    INTO :new.customer_id
    FROM dual;
end;
/

CREATE SEQUENCE emp_id_seq;

CREATE OR REPLACE TRIGGER emp_id 
BEFORE INSERT ON banking_employee
FOR EACH ROW
BEGIN 
    SELECT emp_id_seq.nextval
    INTO :new.employee_id
    FROM dual;
end;
/



-- create a new account for customer
-- same wit hadmin and employee just remove the balance line
INSERT INTO balance (b_amount) values(23007.32);
Insert INTO customer(first_name,last_name, age, gender, ssn, username, user_pass, approved, disabled,jointacc) values('Kyle','Krug', 23, 'Male','111111111','kkrug25','password','true','false','false');
UPDATE customer set balance_id = (
 SELECT max(b_id) FROM balance);


INSERT INTO banking_employee(first_name,last_name,age,gender,ssn,username,user_pass) VALUES('Employee','Employee',28,'Male',001000000,'EmployeeUser','EmpPass');

delete from customer;
delete from balance;


SELECT * FROM customer;
SELECT * FROM balance;
SELECT * FROM banking_employee;



commit;
