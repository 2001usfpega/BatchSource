CREATE USER kumquat IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO kumquat;
GRANT DBA TO kumquat WITH ADMIN OPTION;


CREATE TABLE customer(
    customerid NUMBER(15)
    ,username VARCHAR2(100) NOT NULL
    ,password VARCHAR2(100) NOT NULL
    ,fname VARCHAR2(50) NOT NULL
    ,lname VARCHAR2(50) NOT NULL
    ,address VARCHAR2(100) NOT NULL
    ,city VARCHAR2(50) NOT NULL
    ,state VARCHAR2(30) NOT NULL
    ,zipcode VARCHAR2(9) NOT NULL
    ,phone VARCHAR2(15) NOT NULL
    ,email VARCHAR2(50) NOT NULL
    ,PRIMARY KEY(customerid)
    ,UNIQUE (username)
);

CREATE TABLE accounts(
    accountid NUMBER(15)
    ,customerid NUMBER(15) NOT NULL
    ,balance NUMBER
    ,PRIMARY KEY(accountid)
    ,FOREIGN KEY(customerid) REFERENCES customer (customerid)
);

CREATE TABLE employee(
    employeeid NUMBER(15)
    ,username VARCHAR2(100) NOT NULL
    ,password VARCHAR2(100) NOT NULL
    ,fname VARCHAR2(50) NOT NULL
    ,lname VARCHAR2(50) NOT NULL
    ,address VARCHAR2(100) NOT NULL
    ,city VARCHAR2(50) NOT NULL
    ,state VARCHAR2(30) NOT NULL
    ,zipcode VARCHAR2(9) NOT NULL
    ,phone VARCHAR2(15) NOT NULL
    ,email VARCHAR2(50) NOT NULL
    --,adminflag BOOLEAN NOT NULL
    ,PRIMARY KEY(employeeid)
    ,UNIQUE (username)
);


CREATE SEQUENCE customer_seq
    START WITH 10
    INCREMENT BY 2;
    
CREATE SEQUENCE account_seq
    START WITH 10
    INCREMENT BY 2;
    
    
CREATE OR REPLACE TRIGGER insert_accountb
BEFORE INSERT on accounts
FOR EACH ROW
BEGIN
    IF :new.accountid IS NULL THEN
        SELECT account_seq.NEXTVAL INTO :new.accountid FROM dual;
    END IF;
END;
/


CREATE OR REPLACE TRIGGER insert_customerb
BEFORE INSERT on customer
FOR EACH ROW
BEGIN
    IF :new.customerid IS NULL THEN
        SELECT customer_seq.NEXTVAL INTO :new.customerid FROM dual;
    END IF;
END;
/

CREATE SEQUENCE employee_seq
    START WITH 10
    INCREMENT BY 2;

CREATE OR REPLACE TRIGGER insert_employeeb
BEFORE INSERT on employee
FOR EACH ROW
BEGIN
    IF :new.employeeid IS NULL THEN
        SELECT employee_seq.NEXTVAL INTO :new.employeeid FROM dual;
    END IF;
END;
/

CREATE OR REPLACE PROCEDURE delete_account_0_balance(acctid IN NUMBER)
IS
    bal NUMBER;
BEGIN
    SELECT balance INTO bal FROM accounts WHERE accountid = acctid;
    IF bal = 0 THEN
        DELETE FROM accounts WHERE accountid = acctid;
    END IF;
    COMMIT;
END;
/

BEGIN
    delete_account_0_balance(12);
END;
/


SELECT * FROM accounts;
Insert into accounts Values(1,10,0);

INSERT INTO EMPLOYEE VALUES(null, 'JGWentworth', 'NeedCashNow', 'JG', 'Wentworth', '1123 MadeUp Street', 'Fakesville', 'NY', 12345, '(866) 930-6480','JGWentworth@jgwentworth.org');
UPDATE employee set username = 'jg' WHERE employeeid = 10;

SELECT * FROM employee WHERE username = 'jg';
SELECT * FROM customer;
SELECT * FROM accounts;
SELECT * FROM employee;
commit;