


SELECT count(*) FROM CITY;

SELECT * FROM CITY 
	 order by id 
	   OFFSET 11 ROW  
   FETCH NEXT 10 ROWS ONLY ;

   
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


























		  
		  
		  