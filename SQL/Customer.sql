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
    ,userid VARCHAR2(50) NOT NULL
    ,balance NUMBER
    ,PRIMARY KEY(accountid)
    ,UNIQUE (userid)
);

CREATE TABLE jared(
    jaredid NUMBER(15)
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
    ,PRIMARY KEY(jaredid)
    ,UNIQUE (username)
    
);

























