CREATE TABLE GENIE(
	NUM INT PRIMARY KEY,
	NAME VARCHAR(200),
	ARTIST VARCHAR(200),
	ALBUM VARCHAR(200)
);
SELECT * FROM GENIE;

DELETE FROM GENIE WHERE NUM =1;
SELECT ROWNUM AS 순위, A.* FROM (SELECT * FROM GENIE ORDER BY NUM ASC) A;
INSERT INTO GENIE VALUES((SELECT NVL(MAX(NUM),0)+1 FROM GENIE));
UPDATE GENIE SET NAME='fsfs', ARTIST='sfsf', ALBUM='FWFD' WHERE NUM=2;

DROP TABLE GENIE;