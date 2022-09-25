CREATE TABLE BOARD(
	BID INT PRIMARY KEY,
	TITLE VARCHAR(20) NOT NULL,
	CONTENT VARCHAR(50) NOT NULL,
	WRITER VARCHAR(20) NOT NULL -- MEMBER의 MID : 외래키는 상대 테이블의 PK사용
);

INSERT INTO BOARD VALUES(1, '제목', 'rwerwer', 'werwerw');

SELECT * FROM BOARD;

-- 추가해볼만한 칼럼
-- 1. 작성일 : 날짜 타입
-- 2. 좋아요 : 테이블 관계, 이퀄조인, 외래키 컨트롤이 가능하다는 것을어필
-- 3. 조회수 : scopr 이슈 관리 가능하다는 것을 어필 