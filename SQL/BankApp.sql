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

select * FROM customer;
SELECT * FROM accounts;