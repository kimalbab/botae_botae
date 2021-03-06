SELECT TO_NUMBER(SUBSTR(PRICE, 1, 1))
FROM CAR;


DECLARE 
    QPRICE NUMBER;
BEGIN
    SELECT PRICE
      INTO QPRICE
      FROM CAR;
    IF LENGTH(PRICE) = 6
       THEN TO_NUMBER(SUBSTR(PRICE, 1, 2));
    ELSE
        TO_NUMBER(SUBSTR(PRICE, 1, 1));
    END IF;
    DBMS_OUTPUT.PUT_LINE (QPRICE);
END;
/


CREATE TABLE PRICE_ORDER (
    CAR_NAME VARCHAR2 (50) NOT NULL,
    CAR_TYPE VARCHAR2 (50) NOT NULL CHECK(CAR_TYPE IN ('세단','SUV','경차')),
    INT_PRICE NUMBER NOT NULL,
    FUEL VARCHAR2 (50) NOT NULL,
    NATION VARCHAR2 (50) NOT NULL,
    BRAND VARCHAR2 (50) NOT NULL
);

DROP TABLE PRICE_ORDER;
COMMIT;

INSERT INTO PRICE_ORDER
VALUES('MODELX', '세단', '12', '전기', '외제차', '테슬라');


SELECT
	       CAR_NAME
	     , CAR_TYPE
	     , INT_PRICE
	     , FUEL
	     , NATION
	     , BRAND
	  FROM
	       PRICE_ORDER
  ORDER BY	   
  		   INT_PRICE