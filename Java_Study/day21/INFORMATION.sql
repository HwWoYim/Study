--1. 테이블 생성하기
--CREATE TABLE 테이블명(
--   컬럼명 데이터타입(길이) 키유형,
--   컬럼명 데이터타입(길이) 키유형,
--   ...
--   컬럼명 데이터타입(길이) 키유형
--);
--일반적으로 쿼리문을 대문자로 많이 작성함
--이유 : 쿼리문을 사용하는 오라클 등의 DBMS가 대소문자를 구분하지않아서



--2. 자료 등록하기
--데이터(자료)를 테이블에 등록(추가)
--INSERT INTO 테이블명 VALUES(값,값,...,값);




--3. 데이터 변경하기
--UPDATE 테이블명 SET 컬럼명=변경할값 WHERE 컬럼명=대상;




--4. 자료 삭제하기
--DELETE FROM 테이블명 WHERE 컬럼명=대상;
--일반적으로 PRIMARY KEY 에 해당하는 컬럼명으로 데이터에 접근함
--PRIMARY KEY(이하 PK)는 주민등록번호같은 역할임!
--데이터 식별가능하게해주는 유일한 값   학번,군번,...




--5. 테이블 구조 변경하기(1)
--ALTER TABLE 테이블명 MODIFY 컬럼명 변경할내용
--테이블 구조 변경중에서 [컬럼수정]에 해당함




--6. 테이블 구조 변경하기(2)
--ALTER TABLE 테이블명 ADD 컬럼명 추가할내용
--테이블 구조 변경중에서 [컬럼추가]에 해당함




--7. 테이블 구조 변경하기(3)
--ALTER TABLE 테이블명 DROP COLUMN 컬럼명
--테이블 구조 변경중에서 [컬럼삭제]에 해당함

----------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------------------------------

--[문제풀이 사전준비] EMP 테이블 생성하기
CREATE TABLE EMP(
   DEPTNO INT,
   ENAME VARCHAR2(10),
   JOB VARCHAR2(10),
   HIREDATE DATE,
   EMPNO INT,
   SAL INT,
   COMM INT
);

INSERT INTO EMP (EMPNO,ENAME,SAL,DEPTNO,JOB,HIREDATE) VALUES(7369,'SMITH',800,20,'CLERK',TO_DATE('80/12/17','RR/MM/DD'));
INSERT INTO EMP (EMPNO,ENAME,SAL,DEPTNO,JOB,HIREDATE,COMM) VALUES(7499,'ALLEN',1600,30,'SALESMAN',TO_DATE('81/02/20','RR/MM/DD'),300);
INSERT INTO EMP (EMPNO,ENAME,SAL,DEPTNO,JOB,HIREDATE,COMM) VALUES(7521,'WARD',1250,30,'SALESMAN',TO_DATE('81/02/22','RR/MM/DD'),500);
INSERT INTO EMP (EMPNO,ENAME,SAL,DEPTNO,JOB,HIREDATE) VALUES(7566,'JONES',2975,20,'MANAGER',TO_DATE('81/04/02','RR/MM/DD'));
INSERT INTO EMP (EMPNO,ENAME,SAL,DEPTNO,JOB,HIREDATE,COMM) VALUES(7654,'MARTIN',1250,30,'SALESMAN',TO_DATE('81/09/28','RR/MM/DD'),1400);
INSERT INTO EMP (EMPNO,ENAME,SAL,DEPTNO,JOB,HIREDATE) VALUES(7698,'BLAKE',2850,30,'MANAGER',TO_DATE('81/05/01','RR/MM/DD'));
INSERT INTO EMP (EMPNO,ENAME,SAL,DEPTNO,JOB,HIREDATE) VALUES(7782,'CLARK',2450,10,'MANAGER',TO_DATE('81/06/09','RR/MM/DD'));
INSERT INTO EMP (EMPNO,ENAME,SAL,DEPTNO,JOB,HIREDATE) VALUES(7839,'KING',5000,10,'PRESIDENT',TO_DATE('81/11/17','RR/MM/DD'));
INSERT INTO EMP (EMPNO,ENAME,SAL,DEPTNO,JOB,HIREDATE,COMM) VALUES(7844,'TURNER',1500,30,'SALESMAN',TO_DATE('81/09/08','RR/MM/DD'),0);
INSERT INTO EMP (EMPNO,ENAME,SAL,DEPTNO,JOB,HIREDATE) VALUES(7900,'JAMES',950,30,'CLERK',TO_DATE('81/12/03','RR/MM/DD'));
INSERT INTO EMP (EMPNO,ENAME,SAL,DEPTNO,JOB,HIREDATE) VALUES(7902,'FORD',3000,20,'ANALYST',TO_DATE('81/12/03','RR/MM/DD'));
INSERT INTO EMP (EMPNO,ENAME,SAL,DEPTNO,JOB,HIREDATE) VALUES(7934,'MILLER',1300,10,'CLERK',TO_DATE('82/01/23','RR/MM/DD'));

--[1] 데이터 조회하기
--SELECT 컬럼명,컬럼명,...,컬럼명 FROM 테이블명 WHERE 조건절;
--SELECT 컬럼명,컬럼명,...,컬럼명 FROM 테이블명 WHERE 조회할데이터조건;


--컬럼명=조건값          컬럼명!=조건값
--컬러명 IN(조건값)      컬럼명 NOT IN(조건값)
--SELECT EMPNO,ENAME,JOB FROM EMP WHERE JOB!='CLERK';
--SELECT EMPNO,ENAME,JOB FROM EMP WHERE JOB NOT IN('CLERK');


--[2] 데이터 조회하기
--NULL 이란?
-- : 공백의 값. 무(無). 0과는 다름에 유의!
-- : INSERT 당시에 값을 지정하지않은 부분
---> WHERE 컬럼명 IS NULL : 컬럼이 NULL인 데이터
---> WHERE 컬러명 IS NOT NULL : 컬럼이 NULL이 아닌 데이터


--[3] 데이터 조회하기
--WHERE ENAME LIKE '%A%'
-- : ENAME 컬럼에 'A'가 포함되었나?


--[4] 데이터 정렬해서 조회하기
--ORDER BY 컬럼명 ASC
-- : 해당컬럼값 기준으로 오름차순 정렬
--ORDER BY 컬럼명 DESC
-- : 해당컬럼값 기준으로 내림차순 정렬


--[5] 데이터 중복없이 조회하기
--SELECT DISTINCT 컬럼명 FROM 테이블명;
-- : 출력될 값에서 중복되는 값 제거