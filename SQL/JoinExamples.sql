-----------JOIN EXAMPLES!!!

SELECT * FROM album;
SELECT * FROM artist;

-----------INNER JOIN
SELECT * FROM artist a INNER JOIN album b ON a.artistid = b.ARTISTID;
---let's do a count
SELECT COUNT(*)FROM artist a INNER JOIN album b ON a.artistid = b.ARTISTID;
--old way of doing an inner join
SELECT * FROM artist a, album b WHERE b.artistid = A.ARTISTID;

----------LEFT OUTER JOIN
SELECT * FROM artist a LEFT OUTER JOIN album b ON b.artistid = A.ARTISTID;
---let's do a count
SELECT COUNT(*) FROM artist a LEFT OUTER JOIN album b ON b.artistid = A.ARTISTID;
--old way of doing an left outer join
SELECT * FROM artist a, album b WHERE b.artistid = A.ARTISTID(+);

----------RIGHT OUTER JOIN
SELECT * FROM artist a RIGHT OUTER JOIN album b ON b.artistid = A.ARTISTID;
---let's do a count
SELECT COUNT(*) FROM artist a RIGHT OUTER JOIN album b ON b.artistid = A.ARTISTID;
--old way of doing an left outer join
SELECT * FROM artist a, album b WHERE b.artistid(+) = A.ARTISTID;

----------FULL OUTER JOIN
SELECT * FROM artist a FULL OUTER JOIN album b ON b.artistid = A.ARTISTID;
---let's do a count
SELECT COUNT(*) FROM artist a FULL OUTER JOIN album b ON b.artistid = A.ARTISTID;
--old way of doing an left outer join
SELECT * FROM artist a, album b WHERE b.artistid = A.ARTISTID(+);

---LEFT without middle of vendiagram,
----(exclusive left join, aka distinct left join, aka strictly left join)
SELECT * FROM artist a LEFT OUTER JOIN album b ON b.artistid = A.ARTISTID
    WHERE a.artistid NOT IN(
    SELECT c.artistid FROM artist c INNER JOIN album d ON c.artistid=d.artistid);

---ANOTHER WAY to do the same exact thing
SELECT * FROM artist a LEFT OUTER JOIN album b ON b.artistid = A.ARTISTID
    WHERE b.artistid IS NULL;

----EXCLUSIVE FULL JOIN
SELECT * FROM artist a FULL OUTER JOIN album b ON b.artistid = A.ARTISTID
    WHERE b.artistid IS NULL OR a.artistid IS NULL;
    

--SELF JOIN
---SELECT * FROM table01 a INNER JOIN table01 b ON a.id=b.foreignid;

---CROSS JOIN aka CARTESIAN JOIN
-----SELECT * FROM table01 CROSS JOIN table02;











