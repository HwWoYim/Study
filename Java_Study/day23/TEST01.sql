
-- 첫 번째 문제
CREATE TABLE STUDENT1(
	PID INT PRIMARY KEY,
	NAME VARCHAR(50) NOT NULL,
	PRICE INT NOT NULL,
	CNT INT DEFAULT 0,
	CATEGORY VARCHAR(50) NOT NULL
);
INSERT INTO STUDENT1 VALUES((SELECT NVL(MAX(PID),0)+1 FROM STUDENT1),'운동화',59000,10,'신발');
INSERT INTO STUDENT1 VALUES((SELECT NVL(MAX(PID),0)+1 FROM STUDENT1),'실내화',9900,24,'신발');
INSERT INTO STUDENT1 VALUES((SELECT NVL(MAX(PID),0)+1 FROM STUDENT1),'샌들',28000,24,'신발');

SELECT * FROM STUDENT1;
DROP TABLE PRODUCT;
SELECT * FROM USER_TABLES;
-- Q1

-- 제품 테이블(PRODUCT)을 다음의 제약조건들을 모두 만족할 수 있도록 생성하세요.

-- 1) 제품 번호(PID)는 PK입니다.

-- 2) 제품 이름(NAME),가격(PRICE),카테고리(CATEGORY)는 NULL을 허용하지않습니다.

-- 3) 제품 재고(CNT)는 0을 기본 값으로 가집니다.
CREATE TABLE PRODUCT(PID INT PRIMARY KEY, NAME VARCHAR(20) NOT NULL, PRICE INT NOT NULL, CNT INT DEFAULT 0, CATEGORY VARCHAR(50) NOT NULL);
-- 정수타입 PID PRIMARY KEY, 20btye 크기의 넉넉한 NAME 값이 없는 것은 안됨, 정수 타입의 PRICE 값이 없으면 안됨, 50byte의 넉넉한 CATREGORY.값이 없으면 안된다. 정수타입의 CNT는 값이 없다면 기본 값으로 0을 부여함

-- Q2

-- 제품 테이블(PRODUCT)에 제품 번호(PID)가 1부터 10까지 순차적으로 적용될 수 있도록 10개의 제품을 등록하세요.

-- 제품 테이블(PRODUCT)에 등록된 제품들의 모든 컬럼을 출력해주세요.

INSERT INTO PRODUCT VALUES((SELECT NVL(MAX(PID),0)+1 FROM PRODUCT),'운동화',59000,10,'신발');
INSERT INTO PRODUCT VALUES((SELECT NVL(MAX(PID),0)+1 FROM PRODUCT),'실내화',9900,24,'신발');
INSERT INTO PRODUCT VALUES((SELECT NVL(MAX(PID),0)+1 FROM PRODUCT),'샌들',28000,30,'신발');
INSERT INTO PRODUCT VALUES((SELECT NVL(MAX(PID),0)+1 FROM PRODUCT),'콜라',1200,100,'음료');
INSERT INTO PRODUCT VALUES((SELECT NVL(MAX(PID),0)+1 FROM PRODUCT),'사이다',900,95,'음료');
INSERT INTO PRODUCT VALUES((SELECT NVL(MAX(PID),0)+1 FROM PRODUCT),'단팥빵',1500,20,'빵');
INSERT INTO PRODUCT VALUES((SELECT NVL(MAX(PID),0)+1 FROM PRODUCT),'소보로',1400,21,'빵');
INSERT INTO PRODUCT VALUES((SELECT NVL(MAX(PID),0)+1 FROM PRODUCT),'도너츠',1300,22,'빵');
INSERT INTO PRODUCT VALUES((SELECT NVL(MAX(PID),0)+1 FROM PRODUCT),'만화책',23000,70,'도서');
INSERT INTO PRODUCT VALUES((SELECT NVL(MAX(PID),0)+1 FROM PRODUCT),'장편소설',21800,120,'도서');


SELECT * FROM PRODUCT;

-- Q3

-- 다음과 같은 결과가 나오도록 SQL문을 작성해 보세요.

-- PRODUCT 테이블을 이용하여 카테고리(CATEGORY), 평균 재고(평균 재고), 최고 가격(최고가), 상품 수(카테고리별 상품 수)를 출력합니다.

-- 단 평균 재고를 출력할 때 소수점을 제외하고 각 카테고리별로 출력하세요.



SELECT DISTINCT CATEGORY, ROUND(AVG(CNT),0) AS "평균 재고", MAX(PRICE) AS 최고가, COUNT(CATEGORY) AS "카테고리별 상품 수" FROM PRODUCT GROUP BY CATEGORY;-- 중복제거 DISTINCT 사용, 평균 AVG함수 사용 그리고 반올림 ROUND()사용, 데이터 갯수는 COUNT
-- Q4

-- 다음과 같은 결과가 나오도록 SQL문을 작성해 보세요.

-- PID 열에는 PRODUCT 테이블에서 제품 이름(NAME)이 세 글자 이상인 제품 정보를 출력합니다.

-- MASKING_NAME 열에는 제품 이름의 첫 글자와 마지막 글자만 보여 주고 나머지 글자를 * 기호로 출력합니다.

SELECT PID, CONCAT(CONCAT(SUBSTR(NAME,1,1),'*'),SUBSTR(REPLACE(NAME,'',''),3,1)) AS MASKING_NAME FROM PRODUCT WHERE NAME LIKE '___%'; -- CONCAT으로 "*"문자열을 합쳐주다, 특정문자 치환은 REPLACE,LIKE로 세글자로 된 이름만 출력

-- Q5

-- PRODUCT 테이블을 사용하여 다음과 같이 제품 이름(NAME)에 '화'가 들어가는 제품 데이터를 모두 출력하는 SQL문을 작성해 보세요.

-- 단 제품 번호(PID)에 대하여 오름차순 정렬한 결과로 출력하세요.


SELECT * FROM PRODUCT WHERE NAME LIKE '%화%' ORDER BY PID ASC;	-- LIKE '%화%' 는 화라는 문자가 들어가기만 해도 데이터를 가져오며 ORDER BY ASC로 오름차순 정렬

-- Q6

-- PRODUCT 테이블을 사용하여 '신발' 카테고리(CATEGORY)에 존재하고 있는 제품 중에 가격(PRICE)이 10000원 이상인 제품의 제품 번호, 이름, 가격, 카테고리를 출력하는 SQL문을 작성해 보세요.

SELECT * FROM PRODUCT WHERE CATEGORY LIKE '%신발%' AND PRICE >= 10000;	-- LIKE로 신발 카테고리 데이터를 가져와서 AND 사용해서 PRICE 10000원 이상 조건절도 사용

-- Q7

-- 제품 테이블(PRODUCT)을 삭제하세요.
DROP TABLE PRODUCT; --DROP사용해서 테이블 삭제

SELECT PID, CONCAT(CONCAT(SUBSTR(NAME,1,1),'*'),SUBSTR(REPLACE(NAME,'',''),3,1)) AS MASKING_NAME FROM PRODUCT WHERE NAME LIKE '___%';

--CONCAT으로 "*"문자열을 합쳐주다, 특정문자 치환은 REPLACE,LIKE로 세글자로 된 이름만 출력

----------------------------------------------------------SQL응용-----------------------------------------------------

-- Q1 ( TEST1 테이블 제공 )

-- TEST1 테이블에 저장된 포지션 넘버(NUM)들을 중복없이 출력해주세요.
SELECT DISTINCT NUM FROM TEST1;	--DISTINCT를 사용해 TEST1테이블의 NUM컬럼을 중복없이 출력
-- Q2

-- TEST1 테이블에 저장된 포지션 넘버(NUM)가 101이거나 401인 데이터의 개수를 출력해주세요.
--SELECT COUNT(WHERE NUM=101 OR 401) AS "탑 OR 서포터" FROM TEST1;
--SELECT COUNT(CASE WHEN NUM LIKE 101 THEN 1 END) OR COUNT(CASE WHEN NUM LIKE 401 THEN 1 END) AS "탑 OR 서포터" FROM TEST1;
--SELECT SUM(WHEN NUM LIKE 101 THEN 1 END) FROM TEST1;
SELECT COUNT(*) AS "탑 OR 서포터" FROM TEST1 WHERE NUM=101 OR NUM=401; 	-- COUNT함수에 별칭 지정해주고 WHERE 조건절 사용

-- Q3

-- 1) 2개의 테이블을 생성하세요.

-- 2) 1에서 생성한 2개의 테이블 데이터를 조인해서 출력하기위해 EQUI JOIN을 사용해주세요.

-- 3) 조인 조건을 주석으로 설명하세요.

-- 4) 1에서 생성한 2개의 테이블을 제거하세요.
SELECT NAME,PNAME FROM TEST1,TEST2 WHERE TEST1.NUM=TEST2.PID;
-- TEST1의 NUM과 TES2의 PID(PK)가 공통된 칼럼으로 TEST1의 NUM이 외래키 역할을 하여 테이블을 결합하여 데이터를 처리 할 수 있음.
DROP TABLE TEST1;
DROP TABLE TEST2;




-- Q4 ( PRODUCT 테이블 제공 )

-- PRODUCT 테이블에 저장된 데이터들 가운데 가장 비싼 상품 4~6위를 출력해주세요.

-- 단, 페이징 기법을 사용하세요.

--SELECT * FROM (SELECT PRICE.*, ROWNUM AS PRICE FROM (SELECT * FROM PRODUCT ORDER BY PRICE DESC/ASC) A WHERE 조건) WHERE 조건;
SELECT * FROM (SELECT A.*, ROWNUM AS RNUM, COUNT(*) OVER() AS A FROM (SELECT * FROM PRODUCT ORDER BY PRICE desc) A) WHERE RNUM>3 AND RNUM<7; 
-- ROWNUM을 사용한 페이징 처리 기법으로 마지막 조건절을 이용해 특점 범위만 출력


-- Q5

-- PRODUCT 테이블에 저장된 데이터들의 재고를 각각의 카테고리별로 모두 합했을때, 총합이 100을 초과하는 카테고리(CATEGORY)와 
-- 그 총합(재고총합)을 출력해주세요.

-- 그룹 함수로 조건을 줄 때는 HAVING절을 사용해야합니다.
SELECT CATEGORY, SUM(CNT) AS 재고총합 FROM PRODUCT GROUP BY CATEGORY;
SELECT CATEGORY, SUM(CNT) AS 재고총합 FROM PRODUCT GROUP BY CATEGORY HAVING SUM(CNT) >= 100;
--GROUP BY절을 사용해서 마지막에 HAVING절로 조건을 달아줌











