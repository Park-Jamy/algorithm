-- 3월에 태어난 여성 회원 목록 출력하기
-- 제출 내역

-- 문제 설명
-- 다음은 식당 리뷰 사이트의 회원 정보를 담은 MEMBER_PROFILE 테이블입니다.
-- MEMBER_PROFILE 테이블은 다음과 같으며
-- MEMBER_ID, MEMBER_NAME, TLNO, GENDER, DATE_OF_BIRTH는
-- 회원 ID, 회원 이름, 회원 연락처, 성별, 생년월일을 의미합니다.
--
-- Column name	Type	Nullable
-- MEMBER_ID	VARCHAR(100)	FALSE
-- MEMBER_NAME	VARCHAR(50)	FALSE
-- TLNO	VARCHAR(50)	TRUE
-- GENDER	VARCHAR(1)	TRUE
-- DATE_OF_BIRTH	DATE	TRUE
-- 문제
-- MEMBER_PROFILE 테이블에서 생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일을 조회하는 SQL문을 작성해주세요.
-- 이때 전화번호가 NULL인 경우는 출력대상에서 제외시켜 주시고, 결과는 회원ID를 기준으로 오름차순 정렬해주세요.

SELECT
    member_id AS MEMBER_ID
     , member_name AS MEMBER_NAME
     , gender AS GENDER
     , TO_CHAR(DATE_OF_BIRTH, 'YYYY-MM-DD')
FROM MEMBER_PROFILE
WHERE GENDER = 'W'
  AND TLNO IS NOT NULL
  AND SUBSTR(TO_CHAR(DATE_OF_BIRTH),4,3) = 'MAR'
ORDER BY MEMBER_ID ASC;


-- 동물 수 구하기

-- 제출 내역
-- 문제 설명
-- ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.
--
-- NAME	TYPE	NULLABLE
-- ANIMAL_ID	VARCHAR(N)	FALSE
-- ANIMAL_TYPE	VARCHAR(N)	FALSE
-- DATETIME	DATETIME	FALSE
-- INTAKE_CONDITION	VARCHAR(N)	FALSE
-- NAME	VARCHAR(N)	TRUE
-- SEX_UPON_INTAKE	VARCHAR(N)	FALSE

-- 동물 보호소에 동물이 몇 마리 들어왔는지 조회하는 SQL 문을 작성해주세요.
--
-- 예시
-- 예를 들어 ANIMAL_INS 테이블이 다음과 같다면
--
-- ANIMAL_ID	ANIMAL_TYPE	DATETIME	INTAKE_CONDITION	NAME	SEX_UPON_INTAKE
-- A399552	    Dog	       2013-10-14 15:38:00	   Normal	Jack	Neutered Male
-- A379998	Dog	2013-10-23 11:42:00	Normal	Disciple	Intact Male
-- A370852	Dog	2013-11-03 15:04:00	Normal	Katie	Spayed Female
-- A403564	Dog	2013-11-18 17:03:00	Normal	Anna	Spayed Female
-- 동물 보호소에 들어온 동물은 4마리입니다. 따라서 SQL문을 실행하면 다음과 같이 나와야 합니다.
--
-- count
-- 4
-- ※ 컬럼 이름(위 예제에서는 count)은 일치하지 않아도 됩니다.

SELECT COUNT(*)
FROM ANIMAL_INS


--          중복 제거하기
-- 제출 내역
-- 문제 설명
-- ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.
--
-- NAME	TYPE	NULLABLE
-- ANIMAL_ID	VARCHAR(N)	FALSE
-- ANIMAL_TYPE	VARCHAR(N)	FALSE
-- DATETIME	DATETIME	FALSE
-- INTAKE_CONDITION	VARCHAR(N)	FALSE
-- NAME	VARCHAR(N)	TRUE
-- SEX_UPON_INTAKE	VARCHAR(N)	FALSE
-- 동물 보호소에 들어온 동물의 이름은 몇 개인지 조회하는 SQL 문을 작성해주세요. 이때 이름이 NULL인 경우는 집계하지 않으며 중복되는 이름은 하나로 칩니다.
--
-- 예시
-- 예를 들어 ANIMAL_INS 테이블이 다음과 같다면
--
-- ANIMAL_ID	ANIMAL_TYPE	DATETIME	INTAKE_CONDITION	NAME	SEX_UPON_INTAKE
-- A562649	Dog	2014-03-20 18:06:00	Sick	NULL	Spayed Female
-- A412626	Dog	2016-03-13 11:17:00	Normal	*Sam	Neutered Male
-- A563492	Dog	2014-10-24 14:45:00	Normal	*Sam	Neutered Male
-- A513956	Dog	2017-06-14 11:54:00	Normal	*Sweetie	Spayed Female
-- 보호소에 들어온 동물의 이름은 NULL(없음), *Sam, *Sam, *Sweetie입니다. 이 중 NULL과 중복되는 이름을 고려하면, 보호소에 들어온 동물 이름의 수는 2입니다. 따라서 SQL문을 실행하면 다음과 같이 나와야 합니다.
--
-- count
-- 2
--     ※ 컬럼 이름(위 예제에서는 count)은 일치하지 않아도 됩니다.

SELECT COUNT(DISTINCT NAME)
FROM ANIMAL_INS
WHERE NAME IS NOT NULL;


-- 오랜 기간 보호한 동물(2)
-- 제출 내역
-- 문제 설명
-- ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.
--
-- NAME	TYPE	NULLABLE
-- ANIMAL_ID	VARCHAR(N)	FALSE
-- ANIMAL_TYPE	VARCHAR(N)	FALSE
-- DATETIME	DATETIME	FALSE
-- INTAKE_CONDITION	VARCHAR(N)	FALSE
-- NAME	VARCHAR(N)	TRUE
-- SEX_UPON_INTAKE	VARCHAR(N)	FALSE
-- ANIMAL_OUTS 테이블은 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블입니다. ANIMAL_OUTS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME는 각각 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부를 나타냅니다. ANIMAL_OUTS 테이블의 ANIMAL_ID는 ANIMAL_INS의 ANIMAL_ID의 외래 키입니다.
--
-- NAME	TYPE	NULLABLE
-- ANIMAL_ID	VARCHAR(N)	FALSE
-- ANIMAL_TYPE	VARCHAR(N)	FALSE
-- DATETIME	DATETIME	FALSE
-- NAME	VARCHAR(N)	TRUE
-- SEX_UPON_OUTCOME	VARCHAR(N)	FALSE
-- 입양을 간 동물 중, 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름을 조회하는 SQL문을 작성해주세요.
-- 이때 결과는 보호 기간이 긴 순으로 조회해야 합니다.
--
-- 예시
-- 예를 들어, ANIMAL_INS 테이블과 ANIMAL_OUTS 테이블이 다음과 같다면
--
-- ANIMAL_INS
--
-- ANIMAL_ID	ANIMAL_TYPE	DATETIME	INTAKE_CONDITION	NAME	SEX_UPON_INTAKE
-- A354597	Cat	2014-05-02 12:16:00	Normal	Ariel	Spayed Female
-- A362707	Dog	2016-01-27 12:27:00	Sick	Girly Girl	Spayed Female
-- A370507	Cat	2014-10-27 14:43:00	Normal	Emily	Spayed Female
-- A414513	Dog	2016-06-07 09:17:00	Normal	Rocky	Neutered Male
-- ANIMAL_OUTS
--
-- ANIMAL_ID	ANIMAL_TYPE	DATETIME	NAME	SEX_UPON_OUTCOME
-- A354597	Cat	2014-06-03 12:30:00	Ariel	Spayed Female
-- A362707	Dog	2017-01-10 10:44:00	Girly Girl	Spayed Female
-- A370507	Cat	2015-08-15 09:24:00	Emily	Spayed Female
-- SQL문을 실행하면 다음과 같이 나와야 합니다.
--
-- ANIMAL_ID	NAME
-- A362707	Girly Girl
-- A370507	Emily
-- ※ 입양을 간 동물이 2마리 이상인 경우만 입력으로 주어집니다.

SELECT ANIMAL_ID, NAME
FROM (
         SELECT *
         FROM (SELECT (ANIMAL_OUTS.DATETIME - ANIMAL_INS.DATETIME) AS A, ANIMAL_INS.ANIMAL_ID, ANIMAL_INS.NAME
               FROM ANIMAL_INS,
                    ANIMAL_OUTS
               WHERE ANIMAL_INS.ANIMAL_ID = ANIMAL_OUTS.ANIMAL_ID) X
         ORDER BY X.A DESC
     )
WHERE ROWNUM <= 2