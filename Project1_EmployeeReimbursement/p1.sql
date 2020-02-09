CREATE USER p1 IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO p1;
GRANT DBA TO p1 WITH ADMIN OPTION;

------------------------------------------
--Drop tables
DROP TABLE re_request;
DROP TABLE employee_user;
-----------------------------------------

CREATE TABLE employee_user(
    emp_id NUMBER(15) NOT NULL,
    emp_username VARCHAR2(25) UNIQUE,
    emp_pass VARCHAR2(25),
    emp_fname VARCHAR2(15),
    emp_lname VARCHAR2(15),
    emp_type NUMBER(1), -- either 0 or 1, 0 is a regular employee and 1 is an admin
    PRIMARY KEY(emp_id)
);
CREATE TABLE re_request(
    request_id NUMBER(15) NOT NULL,
    emp_id NUMBER(15) NOT NULL,
    status VARCHAR2(10),
    re_type NUMBER(1) NOT NULL,
    amount NUMBER(15,2),
    date_sub VARCHAR2(15),
    date_res VARCHAR2(15),
    info VARCHAR2(200),
    PRIMARY KEY (request_id)
    ,CONSTRAINT fk_customer 
        FOREIGN KEY (emp_id)
        REFERENCES employee_user(emp_id)
);

CREATE SEQUENCE employee_id_seq;

CREATE OR REPLACE TRIGGER employee_id 
BEFORE INSERT ON employee_user
FOR EACH ROW
BEGIN 
    SELECT employee_id_seq.nextval
    INTO :new.emp_id
    FROM dual;
end;
/

CREATE SEQUENCE request_id_sequence;

CREATE OR REPLACE TRIGGER request_id 
BEFORE INSERT ON re_request
FOR EACH ROW
BEGIN 
    SELECT request_id_sequence.nextval
    INTO :new.request_id
    FROM dual;
end;
/


INSERT INTO employee_user(emp_id,emp_username,emp_pass,emp_fname,emp_lname,emp_type) VALUES (1,'employee','password','Kyle','Krug','0');
INSERT INTO employee_user(emp_username,emp_pass,emp_fname,emp_lname,emp_type) VALUES ('employee1','password','Kyle','Krug','0');
INSERT INTO employee_user(emp_username,emp_pass,emp_fname,emp_lname,emp_type) VALUES ('admin','password','Kyle','Krug','1');
INSERT INTO re_request(emp_id, status, re_type, amount,date_sub,date_res, info) VALUES(1,'pending',2,12.45,null,null,'n/a');
UPDATE employee_user
SET
emp_type = 0
WHERE emp_id = 1;


SELECT * FROM employee_user;
SELECT * FROM re_request;

DELETE FROM re_request;

commit;