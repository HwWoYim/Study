SELECT * FROM USER_TABLES;

CREATE TABLE MEMBER(
	MID INT PRIMARY KEY,
	NAME VARCHAR(20) NOT NULL,
	WIN INT,
	PICK INT,
	BAN INT
);

SELECT * FROM MEMBER;