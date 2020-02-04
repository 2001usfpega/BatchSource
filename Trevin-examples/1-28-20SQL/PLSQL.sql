---PLSQLexample.sql

--let's start by creating a user
CREATE USER fooddb IDENTIFIED BY p4ssw0rd;

GRANT CONNECT, RESOURCE TO fooddb;
GRANT DBA TO fooddb WITH ADMIN OPTION;

--next, let's create a food table
DROP TABLE food;
CREATE TABLE food(
    food_id NUMBER(15)
    , food_name VARCHAR2(100) UNIQUE
    , recipe VARCHAR2(500) NOT NULL
    , PRIMARY KEY(food_id)
);

INSERT INTO food VALUES (0, 'Macaroni and Cheese', 'Pure love');
INSERT INTO food VALUES (1, 'Bacon', 'Love and clogged arteries');
INSERT INTO food VALUES (2, 'Cereal', 'Milk and stuff');
INSERT INTO food VALUES (3, 'PB and J', 'Otters');
INSERT INTO food VALUES (4, 'Sphaghet', 'So much sphaghet');

SELECT * FROM food;


-------STORED PROCEDURES
-- a block of code. Essentially, it is a function/method in sql

--how to create a procedure?
CREATE OR REPLACE PROCEDURE hello_world_procedure
IS

BEGIN
    DBMS_OUTPUT.PUT_LINE('HELLO WORLD!');
END;
/
--how do we INVOKE a procedure?
BEGIN
    --THIS is the execution block, you may execute code here
    hello_world_procedure();
END;
/
/*STRUCTURE OF A STORED PROCEDUDRE IN PL/SQL
CREATE [OR REPLACE] PROCEDURE proc_name [list of parameters]
IS
    *note: declaration section*
BEGIN
    *note: execution of your logic section
EXCEPTION
    *note: exception section*
END;
/   <----------NOTE THAT THERE IS A SLASH AT THE END OF THE PROCEDURE

*/

--INSERT stored procedure
CREATE OR REPLACE PROCEDURE insert_food(f_id IN NUMBER, f_name IN VARCHAR2,
    f_recipe IN VARCHAR2)
IS
BEGIN
    INSERT INTO food VALUES (f_id, f_name, f_recipe);
    COMMIT;
END;
/
--execution block
BEGIN
    insert_food(11, 'pizza', 'cheese, bread, love');
    insert_food(12, 'booze', 'booze aint foods');
END;
/
SELECT * FROM food;

---OUT example
CREATE OR REPLACE PROCEDURE get_food(f_id IN food.food_id%TYPE,
        f_name OUT food.food_name%TYPE, tempVar OUT NUMBER)
IS
BEGIN
    SELECT food_name INTO f_name FROM food WHERE food_id=f_id;
    SELECT 5 INTO tempVar FROM dual;
END;
/
--exe block
DECLARE
    tempVariable food.food_name%TYPE;
    temp2 NUMBER(10);
BEGIN
    get_food(11, tempVariable, temp2);
    DBMS_OUTPUT.PUT_LINE(temp2 || ' solution: ' || tempVariable);
END;
/

-------FUNCTIONS
-- a block of code. Essentially, it is a function/method in sql
CREATE OR REPLACE FUNCTION get_max_id
RETURN NUMBER
IS
    max_id NUMBER;
BEGIN
    SELECT MAX(food_id) INTO max_id FROM food;
    RETURN max_id;
END;
/
--exec block, call get_max_id
DECLARE
    max_id NUMBER;
BEGIN
    --":=" is an assignment operator like "=" in java
    max_id := get_max_id();
    DBMS_OUTPUT.PUT_LINE('THE MAX: ' || max_id);
END;
/
SELECT * FROM food ORDER BY food_id DESC;

--GET MAX
CREATE OR REPLACE FUNCTION get_max(num1 IN NUMBER, num2 IN NUMBER)
RETURN NUMBER
IS
BEGIN
    IF num1>num2 THEN
        RETURN num1;
    ELSE
        RETURN num2;
    END IF;
END;
/
--EXEC block
DECLARE
    greater NUMBER;
BEGIN
    greater := get_max(550000, 26000);
    DBMS_OUTPUT.PUT_LINE('max num is: ' || greater);
END;
/
--let's execute this code AGAIN
SELECT get_max(330, 4000) FROM dual;
SELECT * FROM food WHERE food_id=get_max(11, 1);

/*
    stored procedures           vs              functions
    
NO return                                           MUST return a value or set
DML, DQL                                            DQL
IN/OUT parameters (values and references)           only IN parameters
procedures can call functions                       CANNOT call procedures
execution block only                CAN be used in queries OR execution blocks
(yes, you can use a procedure inside of another procedure)
*/

------SEQUENCES---------
--a sequence is a number generator
CREATE SEQUENCE food_seq
    START WITH 100
    INCREMENT BY 3;
--how to drop a sequence?
DROP SEQUENCE food_seq;

CREATE OR REPLACE PROCEDURE insert_food_null_id(f_name IN VARCHAR2,
    f_recipe IN VARCHAR2)
IS
BEGIN
    INSERT INTO food VALUES(food_seq.NEXTVAL, f_name, f_recipe);
    COMMIT;
END;
/
SELECT * FROM food;
INSERT INTO food VALUES(null, 'chicken', 'chicken');
--EXEC
BEGIN
    --insert_food_null_id('buttered toast', 'gravy, double d');
    insert_food_null_id('jaw breaker', 'only a quarter');
END;
/


----TRIGGERS
---a trigger is essentially an event listener
CREATE OR REPLACE TRIGGER food_insertb
BEFORE INSERT ON food
FOR EACH ROW
BEGIN
    IF :new.food_id IS NULL THEN
        SELECT food_seq.NEXTVAL INTO :new.food_id FROM dual;
    END IF;
END;
/
SELECT * FROM food;
INSERT INTO food VALUES(null, 'chicken', 'chicken');
INSERT INTO food VALUES(null, 'dressing', 'Moms love');

/*TRIGGER SYNTAX
CREATE [OR REPLACE] TRIGGER trigger_name
BEFORE | AFTER      INSERT | UPDATE | DELETE
ON table_name
FOR EACH ROW     <-----required if you want to see/manipulate rows of data
DECLARE
BEGIN
EXCEPTION
END;
/     <----------SLASH
*/






------OTHER STRUCTURES IN PL/SQL----------------
---VIEW
/* in sql, a view is a virtual table based on the result set of a sql statement.
A view contains rows and columns just like a real table...BUT...it is NOT a real
table. The fields in a view are fields from one or more REAL tables.
You can add SQL functiosn, WHERE clauses, JOIN clauses, etc to a view and 
represent that data as if the data was coming from a single table.
IN SHORT, a view is a saved query in your database.
*/
SELECT * FROM food;
SELECT * FROM food WHERE food_id BETWEEN 2 and 4;
CREATE OR REPLACE VIEW between_food_view AS
    SELECT * FROM food WHERE food_id BETWEEN 2 and 4;

SELECT * FROM between_food_view;
---CURSOR
/* a cursor is a temporary work area created in the system memory when a SQL
    statement has executed. A cursor cotnains information on a select statement
    and the rows of data accessed by it. (basically, it points to a result set
    AND remembers which line numbers it has already read so far).
    (it's similar to an iterator in java).
*/
--cursor example
--CURSOR RETURN TYPE FUNCTION
CREATE OR REPLACE FUNCTION AFTER_1968 RETURN SYS_REFCURSOR
IS
  EMPLOYEE_C SYS_REFCURSOR;
BEGIN
  OPEN EMPLOYEE_C FOR SELECT * FROM EMPLOYEE
                        WHERE BIRTHDATE >= TO_DATE('01-01-1968','DD-MM-YYYY');
  RETURN EMPLOYEE_C;
END;
/

--TESTING EXAMPLE 4
SELECT AFTER_1968 FROM DUAL;
COMMIT;








