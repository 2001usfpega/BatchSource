--To create a new user and grant that user permissiona
CREATE USER BankAssignment IDENTIFIED BY p4ssw0rd;

GRANT CONNECT, RESOURCE TO BankAssignment ;
GRANT DBA TO BankAssignment WITH ADMIN OPTION;

--

CREATE TABLE Customer(
     customer_id VARCHAR2(20) 
    , passwords VARCHAR(20)
    , fname VARCHAR(20)
    , lname VARCHAR(20)
    , email VARCHAR(20)
    , PRIMARY KEY(customer_id)
    
);

SELECT * FROM Customer;
DROP TABLE customer;
DROP TABLE accounts;



CREATE TABLE Employee(
     emp_id VARCHAR2(20) 
    , emp_username VARCHAR2(20)
    , emp_passwords VARCHAR(20)
    , PRIMARY KEY(emp_id)
    
);


CREATE TABLE Accounts(
     acct_id NUMBER(20) 
    , balance NUMBER(20)
    , fk_customer_id VARCHAR(20)
    , PRIMARY KEY(acct_id)
    , FOREIGN KEY(fk_customer_id) REFERENCES customer(customer_id)
    
);



CREATE SEQUENCE acct_seq
    START WITH 10000
    INCREMENT BY 1;

SELECT * FROM Accounts;
SELECT * FROM Customer;

CREATE OR REPLACE TRIGGER new_account
AFTER INSERT on customer
FOR EACH ROW
BEGIN
       IF: new.customer_id IS NOT NULL THEN
        INSERT INTO accounts VALUES (ACCT_SEQ.nextval, 0, :new.customer_id); 
        END IF;
END;

DELETE FROM accounts Where fk_customer_id='rkrhamy';



CREATE OR REPLACE PROCEDURE commits
IS
BEGIN
    COMMIT;
END;











INSERT INTO accounts VALUES(100, 0, 'rkrhamy');
INSERT INTO customer VALUES('rkrhamy','rkrhamy22222','password','Rob','Rhamy','rob@gmail.com');
INSERT INTO employee VALUES('RobRhamy', 'RobRhamy', 'password');

DROP TABLE accounts;
DROP TABLE customer;





SELECT * FROM customer a INNER JOIN accounts b ON a.customer_id = b.fk_customer_id WHERE b.fk_customer_id='rkrhamy' AND a.passwords='password'; 

SELECT balance FROM accounts a INNER JOIN customer b ON b.customer_id = a.fk_customer_id WHERE a.fk_customer_id = 'rkrhamy' AND b.passwords='password';

SELECT * FROM employee WHERE emp_username ='RobRhamy' AND emp_passwords='password'; 

commit;

