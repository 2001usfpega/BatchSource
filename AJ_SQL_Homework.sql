/*2.1.1 - Select ALL records from the employee table */
SELECT
    employee.*
FROM
    employee;

/*2.1.2 - Select ALL records from the employee table where the last name is King */

SELECT
    employee.*
FROM
    "EMPLOYEE" "A1"
WHERE
    "A1"."LASTNAME" LIKE 'King';
    
/*2.1.3 Select ALL records from the employee table where first name is Andrew and REPORTSTO is null*/

SELECT
    employee.*
FROM
    employee
WHERE
        firstname = 'Andrew'
    AND reportsto IS NULL;
 
/* 2.2.1 Select all albums in Album table and sort results in descending order by title */

SELECT
    album.*
FROM
    album
ORDER BY
    title DESC;

/* 2.2.2 Select first name from Customer and sort result set in ascending order by city */

SELECT
    customer.firstname
FROM
    customer
ORDER BY
    city ASC;
    
/* 2.3.1 Insert two new records into Genre table */

INSERT INTO genre (
    genreid,
    name
) VALUES (
    120,
    'myGenre'
);

INSERT INTO genre (
    genreid,
    name
) VALUES (
    130,
    'myGenre1'
);

/* 2.3.2 Insert two new records into Employee table */

INSERT INTO employee VALUES (
    12001,
    'Jordan',
    'AJ',
    'Software Developer',
    1,
    '25-DEC-89',
    '13-JAN-20',
    'BB Downs',
    'Tampa',
    'Florida',
    'USA',
    '36091',
    '7705954421',
    'wat is fax',
    'aj@ajjordan.co'
);

INSERT INTO employee VALUES (
    2342,
    'Lance',
    'Sara',
    'White Canary',
    NULL,
    '25-DEC-87',
    '28-JAN-20',
    'The Waverider',
    'Temporal Stream',
    'Galaxy',
    'Universe',
    '31234',
    '4045954421',
    'fax',
    'saralance@waverider.com'
);

/* 2.3.3 Insert two new records into Customer table */

INSERT INTO customer VALUES (
    1234,
    'Helena',
    'Wells',
    'Time Machine Inc.',
    'KZ3000',
    'Univille',
    'South Dakota',
    'USA',
    '12345',
    NULL,
    NULL,
    'hgwells@timemachineinc.com',
    NULL
);

INSERT INTO customer VALUES (
    1236,
    'Myka',
    'Bering',
    'Bering and Wells',
    'KZ3000',
    'Univille',
    'South Dakota',
    'USA',
    '12345',
    NULL,
    NULL,
    'mbering@beringandwells',
    NULL
);

/* 2.4.1 Update Aaron Mitchell in Customer table to Robert Walter*/

UPDATE customer
SET
    firstname = 'Robert',
    lastname = 'Walter'
WHERE
    firstname = 'Aaron';

/* 2.4.2 Update name of artist in the Artist table "Creedence Clearwater Revival" to "CCR"*/

UPDATE artist
SET
    name = 'CCR'
WHERE
    name = 'Creedence Clearwater Revival';

/* 2.5.1 Select all invoices with a billing address like “T%” */

SELECT
    *
FROM
    invoice
WHERE
    billingaddress LIKE 'T%';

/* 2.6.1 Select all invoices that have a total between 15 and 50*/

SELECT
    *
FROM
    invoice
WHERE
        total > 15
    AND total < 50;

/* 2.6.2 
Select all employees hired between 
1st of June 2003 and 1st of March 2004 */

SELECT
    *
FROM
    employee
WHERE
    hiredate BETWEEN '01-JUN-03' AND '01-MAR-04';

/* 2.7.1 Delete a record in Customer table where the name is Robert Walter */

DELETE FROM invoiceline
WHERE
    invoiceid = 50
    OR invoiceid = 61
    OR invoiceid = 116
    OR invoiceid = 245
    OR invoiceid = 268
    OR invoiceid = 290
    OR invoiceid = 342;

DELETE FROM invoice
WHERE
    customerid = 32;

DELETE FROM customer
WHERE
        firstname = 'Robert'
    AND lastname = 'Walter';

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

/* 3.1.1 Create a function that returns the current time.*/

SELECT
    to_char(sysdate, 'mm-dd-yyyy hh24:mi') "NOW"
FROM
    sys.dual;

/* 3.1.2 Create a function that returns the length of name in 
MEDIATYPE table*/

SELECT
    name,
    length(name)
FROM
    mediatype;

/* 3.2.1 Create a function that returns the average total of 
all invoices */

CREATE OR REPLACE FUNCTION avinvoice RETURN FLOAT IS
    avgin FLOAT(12);
BEGIN
    SELECT
        AVG(total)
    INTO avgin
    FROM
        invoice;

    RETURN avgin;
END;
/

BEGIN
    dbms_output.put_line(avinvoice());
END;
/
/* 3.2.2 Create a function that returns the 
most expensive track */

CREATE OR REPLACE FUNCTION mostexpensive RETURN NUMBER IS
    mostexp NUMBER(6);
BEGIN
    SELECT
        MAX(unitprice)
    INTO mostexp
    FROM
        track;

    RETURN mostexp;
END;
/

BEGIN
    dbms_output.put_line(mostexpensive());
END;
/
/* 3.3.1 Create a function that returns 
the average price of invoiceline
items in the invoiceline table */

CREATE OR REPLACE FUNCTION avgprice RETURN FLOAT IS
    avgprice FLOAT(12);
BEGIN
    SELECT
        AVG(unitprice)
    INTO avgprice
    FROM
        invoiceline;

    RETURN avgprice;
END;
/

BEGIN
    dbms_output.put_line(avgprice());
END;
/
/* 3.4.1 Create a function that returns 
all employees who are born after 1968 */

CREATE OR REPLACE FUNCTION born_after_1968 RETURN SYS_REFCURSOR IS
    after1968 SYS_REFCURSOR;
BEGIN
    OPEN after1968 FOR SELECT
                           *
                       FROM
                           employee
                       WHERE
                           birthdate >= TO_DATE('31-DEC-1968', 'DD-MM-YYYY');

    RETURN after1968;
END;
/

SELECT
    born_after_1968
FROM
    dual;
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

/* 4.1.1 Create a stored procedure that selects 
the first and last names of all the employees */

CREATE OR REPLACE PROCEDURE returnemployeenames (
    employees OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN employees FOR SELECT
                           firstname,
                           lastname
                       FROM
                           employee;

END;
/

DECLARE
    employees  SYS_REFCURSOR;
    fname      VARCHAR2(100);
    lname      VARCHAR2(100);
BEGIN
    returnemployeenames(employees);
    LOOP
        FETCH employees INTO
            fname,
            lname;
        EXIT WHEN employees%notfound;
        dbms_output.put_line(fname
                             || ' '
                             || lname);
    END LOOP;

    CLOSE employees;
END;
/
/* 4.2.1 Create a stored procedure that updates 
the personal information of an employee */

CREATE OR REPLACE PROCEDURE update_employee (
    empl_id   IN  NUMBER,
    fname     IN  VARCHAR2,
    lname     IN  VARCHAR2,
    emptitle  IN  VARCHAR2
) IS
BEGIN
    UPDATE employee
    SET
        firstname = fname,
        lastname = lname,
        title = emptitle
    WHERE
        employeeid = empl_id;

    COMMIT;
END;
/

BEGIN
    update_employee(12001, 'Kate', 'Kane', 'Batwoman');
END;
/

/* 4.2.2 Create a stored procedure that 
returns the managers of an employee */

CREATE OR REPLACE PROCEDURE get_empl_manager (
    empl_id     IN   NUMBER,
    mngr_fname  OUT  VARCHAR2,
    mngr_lname  OUT  VARCHAR2
) IS
    mngr_id NUMBER(10);
BEGIN
    SELECT 
    reportsto
    INTO mngr_id
    FROM employee
    WHERE employeeid = empl_id;
    SELECT
        firstname,
        lastname
    INTO
        mngr_fname,
        mngr_lname
    FROM
        employee
    WHERE
        employeeid = mngr_id;

END;
/

DECLARE
    mfname  VARCHAR2(20);
    mlname  VARCHAR2(20);
BEGIN
    get_empl_manager(7, mfname, mlname);
    dbms_output.put_line('Manager name: '
                         || mfname
                         || ' '
                         || mlname);
END;
/

/* 4.3.1 Create a stored procedure that 
returns the name and company of a customer */

CREATE OR REPLACE PROCEDURE return_cust_info (
    cust_id     IN   NUMBER,
    cust_fname  OUT  VARCHAR2,
    cust_lname  OUT  VARCHAR2,
    cust_comp   OUT  VARCHAR2
) IS
BEGIN
    SELECT
        firstname,
        lastname,
        company
    INTO
        cust_fname,
        cust_lname,
        cust_comp
    FROM
        customer
    WHERE
        customerid = cust_id;

END;
/

DECLARE
    fname  VARCHAR2(20);
    lname  VARCHAR2(20);
    comp   VARCHAR2(20);
BEGIN
    return_cust_info(1236, fname, lname, comp);
    dbms_output.put_line('Customer name: '
                         || fname
                         || ' '
                         || lname
                         || ' ' 
                         || 'Customer Company: '
                         || comp);

END;
/
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

/* 5.0.1 Create a transaction that given an 
invoiceId will delete that invoice */

CREATE OR REPLACE PROCEDURE delete_by_id (
    invoice_id IN NUMBER
) IS
BEGIN
    DELETE FROM invoice
    WHERE
        invoice_id = invoiceid;

    COMMIT;
END;
/

BEGIN
    delete_by_id(14);
END;
/

/* 5.0.2 Create a transaction nested within a stored 
procedure that inserts a new record in the Customer table */

CREATE OR REPLACE PROCEDURE insert_new_customer (
    customerid    IN  NUMBER,
    firstname     IN  VARCHAR2,
    lastname      IN  VARCHAR2,
    company       IN  VARCHAR2,
    address       IN  VARCHAR2,
    city          IN  VARCHAR2,
    state         IN  VARCHAR2,
    country       IN  VARCHAR2,
    postalcode    IN  VARCHAR2,
    phone         IN  VARCHAR2,
    fax           IN  VARCHAR2,
    email         IN  VARCHAR2,
    supportrepid  IN  NUMBER
) IS
BEGIN
    INSERT INTO customer VALUES (
        customerid,
        firstname,
        lastname,
        company,
        address,
        city,
        state,
        country,
        postalcode,
        phone,
        fax,
        email,
        supportrepid
    );

    COMMIT;
END;
/

BEGIN
    insert_new_customer(61, 'dana', 'scully', NULL, NULL,
                        NULL, NULL, NULL, NULL, NULL,
                        NULL, 'dana.scully@fbi.gov', 3);

    COMMIT;
END;
/

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

/* 6.1.1 Create an after insert trigger on the employee 
table fired after a new record is inserted into the table */

CREATE OR REPLACE TRIGGER after_employee_insert AFTER
    INSERT ON employee
    FOR EACH ROW
BEGIN
    dbms_output.put_line('Employee record insert trigger pulled.');
END;
/

SELECT
    *
FROM
    employee;

DELETE FROM employee
WHERE
    employeeid = 73;

INSERT INTO employee VALUES (
    73,
    'Smoak',
    'Felicity',
    'Overwatch',
    NULL,
    '15-NOV-1985',
    '24-OCT-2012',
    '143 Arrowverse Way',
    'Starling City',
    'Some State',
    'USA',
    'ZipCode',
    'phone number',
    'fax isn''t a thing',
    'felicity.smoak@queenconsolidated.org'
);

/* 6.1.2 Create an after update trigger on the album table 
that fires after a row is inserted in the table */

CREATE OR REPLACE TRIGGER album_after_update AFTER
    UPDATE ON album
    FOR EACH ROW
BEGIN
    dbms_output.put_line('Album record update trigger pulled.');
END;
/

UPDATE album
SET
    albumid = 2011,
    title = 'new title',
    artistid = 10
WHERE
    albumid = 20;

/* 6.1.3 Create an after delete trigger on the customer 
table that fires after a row is deleted from the table */

CREATE OR REPLACE TRIGGER after_customer_delete AFTER
    DELETE ON customer
    FOR EACH ROW
BEGIN
    dbms_output.put_line('Customer record delete trigger pulled.');
END;
/

DELETE FROM invoiceline
WHERE
    invoiceid = 14
    OR invoiceid = 37
    OR invoiceid = 59
    OR invoiceid = 111
    OR invoiceid = 232
    OR invoiceid = 243
    OR invoiceid = 298;

DELETE FROM invoice
WHERE
    customerid = 17;

DELETE FROM customer
WHERE
    customerid = 17;
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

/* 7.1.1 Create an inner join that joins customers and orders 
and specifies the name of the customer and the invoiceId */

SELECT
    customer.customerid,
    customer.firstname,
    customer.lastname,
    invoice.invoiceid
FROM
         invoice
    INNER JOIN customer ON invoice.customerid = customer.customerid;
/* 7.2.1 Create an outer join that joins the customer and 
invoice table, specifying the CustomerId, firstname, 
lastname, invoiceId, and total */

SELECT
    customer.customerid,
    customer.firstname,
    customer.lastname,
    invoice.invoiceid,
    invoice.total
FROM
    invoice
    FULL OUTER JOIN customer ON invoice.customerid = customer.customerid;

/* 7.3.1 Create a right join that joins album and artist 
specifying artist name and title */

SELECT
    album.artistid,
    album.title,
    artist.name
FROM
         album right
    JOIN artist ON album.artistid = artist.artistid;

/* 7.4.1 Create a cross join that joins album and artist 
and sorts by artist name in ascending order */

SELECT
    *
FROM
    album,
    artist
ORDER BY
    artist.name ASC;

/* 7.5.1 Perform a self-join on the employee table, 
joining on the reportsto column */

SELECT
    a.firstname    AS fname1,
    a.lastname     AS lname1,
    b.firstname    AS fname2,
    b.lastname     AS lname2,
    b.reportsto,
    a.employeeid
FROM
    employee  a,
    employee  b
WHERE
        a.firstname <> b.firstname
    AND a.lastname <> b.lastname
    AND a.employeeid = b.reportsto;