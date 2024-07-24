-- 코드를 입력하세요
select a.MEMBER_NAME,
       b.REVIEW_TEXT,
       TO_CHAR(b.REVIEW_DATE, 'YYYY-MM-DD') as REVIEW_DATE
from MEMBER_PROFILE a,
     REST_REVIEW b,
     ( select member_id
       from (
                select member_id, count(member_id) as cnt
                from REST_REVIEW
                group by member_id
                order by cnt desc
            )
       where rownum = 1
     ) c
where a.MEMBER_ID = b.MEMBER_ID
  and b.MEMBER_ID = c.MEMBER_ID
order by REVIEW_DATE, b.REVIEW_TEXT
;

-- 코드를 입력하세요

select TO_CHAR(SALES_DATE, 'YYYY-MM-DD') as  SALES_DATE,
       PRODUCT_ID,
       case
           when USER_ID is not null then USER_ID
           else NULL
           end USER_ID,
       SALES_AMOUNT
from(
        SELECT SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
        from ONLINE_SALE

        union all

        select SALES_DATE, PRODUCT_ID, NULL as USER_ID, SALES_AMOUNT
        from OFFLINE_SALE
    )
where SALES_DATE >= TO_DATE('2022-03-01', 'YYYY-MM-DD')
  and SALES_DATE < TO_DATE('2022-04-01', 'YYYY-MM-DD')
order by SALES_DATE, PRODUCT_ID, USER_ID
;

-- 코드를 입력하세요

SELECT CAR_ID,
       CASE
           WHEN CAR_ID IN ( SELECT CAR_ID
                            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                            WHERE START_DATE <= TO_DATE('20221016 000000', 'YYYYMMDD HH24MISS')
                              AND END_DATE >= TO_DATE('20221016 000000', 'YYYYMMDD HH24MISS'))
               THEN '대여중'
           ELSE '대여 가능'
           END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC

---

SELECT '/HOME/GREP/SRC/' || BOARD_ID || '/' || FILE_ID || FILE_NAME || FILE_EXT AS FILE_PATH
FROM USED_GOODS_FILE A
WHERE A.BOARD_ID IN (
    SELECT BOARD_ID
    FROM (
             SELECT *
             FROM USED_GOODS_BOARD
             ORDER BY VIEWS DESC
         )
    WHERE ROWNUM = 1
)
ORDER BY FILE_ID DESC