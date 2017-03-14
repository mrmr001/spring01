
select	e.* , d.*
	     from emp e left outer join dept d 
	       on d.deptno = e.deptno
		where e.deptno = 10	;


SELECT 	c.*,co.*
   FROM CITY c LEFT outer JOIN COUNTRY co 
     ON c.COUNTRY_CODE = co.CODE
 where c.id = #{id};

SELECT * FROM emp;
SELECT count(*) FROM CITY;

SELECT * FROM CITY 
	 order by id 
	   OFFSET 11 ROW  
   FETCH NEXT 10 ROWS ONLY ;

DELETE FROM country where code = 'KOR';
   
   select * FROM  emp where deptno = 10;
   drop SEQUENCE CITY_ID_SEQ;
   CREATE  SEQUENCE city_id_seq START  WITH 4000;
   SELECT city_id_seq.n;
   
    drop SEQUENCE emp_empno_seq;
   CREATE  SEQUENCE emp_empno_seq START  WITH 8000;
    SELECT emp_empno_seq.nextval from dual;
   
   
   
   
   SELECT 	c.ID 				AS city_id,
			c.NAME 				AS city_name,
			c.COUNTRY_CODE 		AS city_contry_code,
			c.DISTRICT 			AS city_district,
			c.POPULATION 		AS city_population,
			co.CODE 			AS country_code,
			co.NAME				AS country_name,
			co.CONTINENT		AS country_continent,
			co.REGION			AS country_region,
			co.SURFACE_AREA		AS country_surfaceArea,
			co.INDEP_YEAR		AS country_indepYear,
			co.POPULATION		AS country_population,
			co.LIFE_EXPECTANCY	AS country_lifeExpectancy,
			co.GNP				AS country_gnp,
			co.GNP_OLD			AS country_gnpOld,
			co.LOCAL_NAME		AS country_localName,
			co.GOVERNMENT_FORM	AS country_governmentForm,
			co.HEAD_OF_STATE	AS country_headOfState,
			co.CAPITAL			AS country_capital,
			co.CODE2			AS country_code2
		  FROM CITY c LEFT outer JOIN COUNTRY co ON c.COUNTRY_CODE =co.CODE
		  where c.COUNTRY_CODE = 'KOR'
		   order by c.id 
	   		OFFSET 11 ROW  
  			 FETCH NEXT 10 ROWS ONLY;
		  
SELECT count(*) 
  from city
  where country_code = 'KOR';

SELECT * 
  from city
  where country_code = 'KOR'
 OFFSET 2 ROW  
FETCH NEXT 3 ROWS ONLY;


	SELECT * 
	  FROM COUNTRY 
 	 order by code 
	OFFSET 2 ROW  
FETCH NEXT 3 ROWS ONLY;



SELECT * FROM COUNTRY
OFFSET 0 ROWS  
FETCH NEXT 10 ROWS ONLY;




 SELECT city_id_seq.nextval from dual;

		insert into city
				(
						ID, 				
						NAME, 				
						COUNTRY_CODE, 		
						DISTRICT, 			
						POPULATION 		
				)
		values(	"4,0008","xxx",null, 		
						null, 			
						null 
				)
;







SELECT 	c.ID 				AS city_id,
		c.NAME 				AS city_name,
		c.COUNTRY_CODE 		AS city_contry_code,
		c.DISTRICT 			AS city_district,
		c.POPULATION 		AS city_population,
		co.CODE 			AS country_code,
		co.NAME				AS country_name,
		co.CONTINENT		AS country_continent,
		co.REGION			AS country_region,
		co.SURFACE_AREA		AS country_surfaceArea,
		co.INDEP_YEAR		AS country_indepYear,
		co.POPULATION		AS country_population,
		co.LIFE_EXPECTANCY	AS country_lifeExpectancy,
		co.GNP				AS country_gnp,
		co.GNP_OLD			AS country_gnpOld,
		co.LOCAL_NAME		AS country_localName,
		co.GOVERNMENT_FORM	AS country_governmentForm,
		co.HEAD_OF_STATE	AS country_headOfState,
		co.CAPITAL			AS country_capital,
		co.CODE2			AS country_code2
   FROM CITY c LEFT outer JOIN COUNTRY co 
     ON c.COUNTRY_CODE = co.CODE
 where c.id = 2;












		  
		  
		  