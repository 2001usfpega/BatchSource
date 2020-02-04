CREATE TABLE administrator(

    admin_id NUMBER(15)
    , first_name VARCHAR2(100) not NULL
    , last_name VARCHAR2(500) not null
    ,username VARCHAR2(100)not null
    ,password VARCHAR2(100) not null
        , PRIMARY KEY(admin_id)
        
);


select * from employee;
select * from administrator;

CREATE TABLE accounts(
account_num NUMBER(15) not null
    , account_type VARCHAR2(100) not NULL
    , balance VARCHAR2(500) not null
    , PRIMARY KEY(account_num)
       );
       
INSERT INTO employee VALUES(1,'Teresa','Camara','tscamara','password',NULL);   
INSERT INTO employee VALUES(2,'Sidiki','kourouma','skade','password',NULL);   

     select * from customer;
     -----------------------------------------
 CREATE SEQUENCE customer_id_sequence
    START WITH 100
    INCREMENT BY 10; 
    
     
    
CREATE OR REPLACE PROCEDURE insert_customerid_null_id(customer_firstname IN VARCHAR2,
   cust_email IN VARCHAR2,cust_address IN VARCHAR2, cust_phone IN VARCHAR2,account_num IN NUMBER, cust_password IN VARCHAR2)
IS
BEGIN
    INSERT INTO customer VALUES(customer_id.NEXTVAL,customer_firstname ,cust_email,cust_address,cust_phone,account_num,cust_password);
    COMMIT;
END;
/    
   
CREATE OR REPLACE TRIGGER customer_insertb
BEFORE INSERT ON customer
FOR EACH ROW
BEGIN
    IF :new.customer_id IS NULL THEN
        SELECT customer_id_sequence.NEXTVAL INTO :new.customer_id FROM dual;
    END IF;
END;  
 /      
  INSERT into customer VALUES(1,'Maria','m@gmai.com','8665 green st' ,'6058883214',null,null,NULL,'password');
    INSERT into customer VALUES(2,'Teresa','m@gmai.com','8665 green st' ,'6058883214',null,null,NULL,'password');
      INSERT into customer VALUES(3,'fatima','m@gmai.com','8665 green st' ,'6058883214',null,null,NULL,'password');
      
  COMMIT;
  INSERT into customer VALUES(null,'kade','m@gmai.com','8665 green st' ,'6058883214',null,'password');

  COMMIT;
  select * from customer;


 CREATE SEQUENCE account_num_sequence
    START WITH 200
    INCREMENT BY 10;
    /
 
 CREATE OR REPLACE TRIGGER customer_update
BEFORE UPDATE ON customer
FOR EACH ROW
BEGIN
    IF :new.account_num IS NULL THEN
        SELECT account_num_sequence.NEXTVAL INTO :new.account_num FROM dual;
    END IF;
END;  
/
DROP TRIGGER customer_update;
 
 CREATE OR REPLACE TRIGGER customer_After_update
AFTER UPDATE ON customer
FOR EACH ROW
BEGIN
    IF :new.account_num IS NULL THEN
        SELECT account_num_sequence.NEXTVAL INTO :new.account_num FROM dual;
    END IF;
END;
 /
 
 DROP TRIGGER customer_After_update;
 UPDATE customer SET cust_email='josemail@yahoo.com',cust_address='5ta ave soth east',cust_phone='8135647892',account_num='102' WHERE customer_firstname='Jose' AND cust_password='password';
    
  UPDATE customer SET cust_email='josemail@yahoo.com',cust_address='5ta ave soth east',cust_phone='8135647892' WHERE customer_firstname='sanamba' AND cust_password='pass';

 INSERT INTO accounts VALUES(102,'cheking',58);
 
 SELECT
     *
 FROM customer;
 
 select *from accounts;
 
 
  ROLLBACK;
  
  
  SELECT
      *
  FROM accounts;
  
  select *from customer;
  
INSERT INTO accounts(account_num,account_type,balance) values(105,'cheking',478);

CREATE  SEQUENCE account_num_sec

    START WITH 200
    INCREMENT BY 10;
    /
 drop SEQUENCE account_num_sec;
  CREATE OR REPLACE PROCEDURE insert_Cus_account_null_id(customer_firstname IN VARCHAR2,
   cust_email IN VARCHAR2,cust_address IN VARCHAR2, cust_phone IN VARCHAR2, cust_password IN VARCHAR2)
IS
BEGIN
    INSERT INTO customer VALUES(customer_id.nextval,customer_firstname ,cust_email,cust_address,cust_phone,account_num.nextval,cust_password);
    COMMIT;
END;
/    

   
CREATE OR REPLACE TRIGGER account_insertb
BEFORE INSERT ON customer
FOR EACH ROW
BEGIN
    IF :new.account_num IS NULL THEN
        SELECT account_num_sec.NEXTVAL INTO :new.account_num FROM dual;
    END IF;
END;  
 / 

Drop trigger account_insertb; 
  
  INSERT into customer VALUES(null,'Days','m@gmai.com','8665 green st' ,'6058883214',null,'password');
  select *from customer;  
  
UPDATE customer SET  cust_email='sddg@gmail',cust_address='2344 ave',cust_phone='5649231898' WHERE customer_firstname='Sidi'AND cust_password='pass';
UPDATE customer SET  cust_email='isa@gmail',cust_address='2344 ave aberdeen',cust_phone='56492898' WHERE customer_firstname='isa'AND cust_password='pass';


COMMIT;

-----------------------------------create account table--------------------------------------

CREATE TABLE accounts(
    account_number NUMBER(15)
    , balance number(15)
    ,cust_fk number(15)
    , PRIMARY KEY(account_number)
    ,FOREIGN KEY (cust_fk) REFERENCES customer (customer_id)
);
---------------------------------------------------------------------------------------
insert into accounts values(10,15,300);
select * from accounts;

select *from accounts;
SELECT
    *
FROM customer;

insert into accounts values(107,'single',45,100);
UPDATE customer SET  cust_email='emal@',cust_address='my address',cust_phone='323454665' WHERE customer_firstname='Sam' AND cust_password='pass';

insert INTO administrator values (1,'Merlyn','pass');

CREATE OR REPLACE PROCEDURE deposit_update_balance (cust_id IN NUMBER,amount IN NUMBER)
is
new_balance NUMBER;
begin
select balance into new_balance from accounts where cust_fk=cust_id;
UPDATE accounts set balance=amount+balance where cust_fk=cust_id;
ENd;
/

select * from accounts;
commit;

CREATE OR REPLACE PROCEDURE withdraw_update_balance (cust_id IN NUMBER,amount IN NUMBER)
is
new_balance NUMBER;
begin
select balance into new_balance from accounts where cust_fk=cust_id;
UPDATE accounts set balance=-amount where cust_fk=cust_id;
ENd;
/

SELECT*from administrator;
Insert into administrator values(1,'tscamara','pass');
