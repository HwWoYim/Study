SELECT * FROM USER_TABLES;
  SHOW TABLES;

CREATE TABLE STUDENT(
	SID INT PRIMARY KEY,
	NAME VARCHAR(20) NOT NULL,
	SCORE INT DEFAULT 0
);

SELECT * FROM STUDENT;

INSERT INTO STUDENT VALUES(101,'홍길동',85);
INSERT INTO STUDENT VALUES(102,'임꺽정',76);
INSERT INTO STUDENT VALUES(103,'아무무',34);
  (SELECT NVL(MAX(SID),0)+1 FROM STUDENT)

SELECT * FROM STUDENT WHERE NAME LIKE '%%' ORDER BY SID ASC;
  