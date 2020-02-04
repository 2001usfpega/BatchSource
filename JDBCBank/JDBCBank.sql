-- --create user
-- CREATE USER jdbcbank IDENTIFIED BY p4ssw0rd;
-- GRANT CONNECT, RESOURCE TO jdbcbank;
-- GRANT DBA TO jdbcbank WITH ADMIN OPTION;

DROP TABLE customers;
CREATE TABLE customers(
    customerid NUMBER(15)
    , username VARCHAR2(100) UNIQUE
    , password VARCHAR2(100) 
    , firstname VARCHAR2(100) 
    , lastname VARCHAR2(100) 
    , rank number(1)
    , PRIMARY KEY(customerid)
);

DROP TABLE accounts;
CREATE TABLE accounts(
    accountid NUMBER(15)
    , balance NUMBER(32)
    , PRIMARY KEY(accountid)
);

DROP TABLE accountholders;
CREATE TABLE accountholders(
    customerid NUMBER NOT NULL
    , accountid NUMBER NOT NULL
    , CONSTRAINT combo_key 
    PRIMARY KEY(customerid, accountid)
    , FOREIGN KEY (customerid) REFERENCES customers (customerid)
    , FOREIGN KEY (accountid) REFERENCES accounts (accountid)
);

CREATE SEQUENCE user_seq
    START WITH 1001
    INCREMENT BY 7;
    
CREATE SEQUENCE account_seq
    START WITH 1001001
    INCREMENT BY 13;
    

CREATE OR REPLACE PROCEDURE new_account(cid IN NUMBER,c2id IN NUMBER)
IS
BEGIN
    INSERT INTO accounts VALUES(account_seq.NEXTVAL,0);
    INSERT INTO accountholders VALUES(cid,account_seq.CURRVAL);
    IF c2id IS NOT NULL THEN
        INSERT INTO accountholders VALUES(c2id,account_seq.CURRVAL);
    END IF;
    COMMIT;
END;
/
    DELETE FROM accounts WHERE accountid=1015;

---withdraw or deposit
CREATE OR REPLACE PROCEDURE transfer_money(a_id IN NUMBER,a_muns IN NUMBER,b_id IN NUMBER,b_muns IN NUMBER)
IS
BEGIN
    UPDATE accounts SET balance=a_muns WHERE accountid=a_id;
    UPDATE accounts SET balance=b_muns WHERE accountid=b_id;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE kill_account(a_id IN NUMBER)
IS
BEGIN
    DELETE FROM accountholders WHERE accountid=a_id;
    DELETE FROM accounts WHERE accountid=a_id;
    COMMIT;
END;
/



select * from customers;
select * from accounts;
select * from accountholders;
SELECT * FROM accountholders INNER JOIN accounts ON accounts.accountid = accountholders.accountid;-- WHERE customerid=1015;
begin
    new_account(1015,1141);
end;
/
CREATE OR REPLACE TRIGGER customerid_insert
BEFORE INSERT ON customers
FOR EACH ROW
BEGIN
    --catch the null insert
    IF :new.customerid IS NULL THEN
        SELECT user_seq.NEXTVAL INTO :new.customerid FROM dual;
    END IF;
END;
/


INSERT INTO customers VALUES (null, 'jeff', '456', 'Jeff', 'Bridge',1);
INSERT INTO customers VALUES (null, 'tod', '123', 'Todd', 'Emert',0);
INSERT INTO customers VALUES (null, 'admin', 'password', 'Bob', 'Free',2);
COMMIT;


--SELECT employeeid AS id, username, password, firstname, lastname FROM employees 
--UNION
SELECT customerid, username, password, firstname, lastname FROM customers;

SELECT * FROM customers;