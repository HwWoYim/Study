CREATE TABLE MEMBER(
	MID VARCHAR(10) PRIMARY KEY,
	MPW VARCHAR(10) NOT NULL,
	MNAME VARCHAR(20) NOT NULL
);
CREATE TABLE BOARD(
	BID INT PRIMARY KEY,
	MID VARCHAR(10) NOT NULL, -- FK는 반드시 상대 테이블의 PK를 사용한다.
	MSG VARCHAR(50) NOT NULL,
	FAVCNT INT DEFAULT 0,
	RCNT INT DEFAULT 0
);
CREATE TABLE REPLY(
	RID INT PRIMARY KEY,
	MID VARCHAR(10) NOT NULL,
	BID INT NOT NULL,
	RMSG VARCHAR(30) NOT NULL,
	CONSTRAINT BOARD_REPLY FOREIGN KEY(BID) REFERENCES BOARD(BID) ON DELETE CASCADE
);

DROP TABLE MEMBER;
DROP TABLE BOARD;
DROP TABLE REPLY;
SELECT * FROM MEMBER;
SELECT * FROM BOARD;
SELECT * FROM USER_TABLES;

INSERT INTO BOARD(BID, MID,MSG) VALUES((SELECT NVL(MAX(BID),0) +1 FROM BOARD),'티모','11111');
INSERT INTO BOARD(BID, MID,MSG) VALUES((SELECT NVL(MAX(BID),0) +1 FROM BOARD),'티모2','22222');
INSERT INTO BOARD(BID, MID,MSG) VALUES((SELECT NVL(MAX(BID),0) +1 FROM BOARD),'티모3','33333');
INSERT INTO BOARD(BID, MID,MSG) VALUES((SELECT NVL(MAX(BID),0) +1 FROM BOARD),'티모4','44444');
INSERT INTO BOARD(BID, MID,MSG) VALUES((SELECT NVL(MAX(BID),0) +1 FROM BOARD),'티모5','55555');
INSERT INTO BOARD(BID, MID,MSG) VALUES((SELECT NVL(MAX(BID),0) +1 FROM BOARD),'티모6','66666');
INSERT INTO BOARD(BID, MID,MSG) VALUES((SELECT NVL(MAX(BID),0) +1 FROM BOARD),'티모7','77777');
INSERT INTO BOARD(BID, MID,MSG) VALUES((SELECT NVL(MAX(BID),0) +1 FROM BOARD),'티모8','88888');

INSERT INTO REPLY(RID, MID, BID, RMSG) VALUES((SELECT NVL(MAX(RID),0) +1 FROM REPLY), '티모23', 3, '대댓23')