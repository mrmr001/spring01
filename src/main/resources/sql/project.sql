
select	e.EMPNO 	as emp_empno,
	 	e.ENAME		as emp_ename,
	   	e.JOB		as emp_jpb,
	   	e.MGR		as emp_mgr,
	   	e.HIREDATE	as emp_hiredate,
	   	e.SAL		as emp_sal,
	   	e.COMM		as emp_comm,
	   	e.DEPTNO	as emp_deptno,
 		d.DEPTNO 	as dept_deptno,
	   	d.DNAME		as dept_dname,
	   	d.LOC 		as dept_loc
	     from emp e left outer join dept d on d.deptno = e.deptno;










SELECT		co.CODE 			AS country_code,
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
			co.CODE2			AS country_code2,
    		c.ID 				AS city_id,
			c.NAME 				AS city_name,
			c.COUNTRY_CODE 		AS city_contry_code,
			c.DISTRICT 			AS city_district,
			c.POPULATION 		AS city_population
		  FROM COUNTRY co LEFT outer JOIN CITY c ON co.CODE =c.COUNTRY_CODE;





















select d.DEPTNO 	as dept_deptno,
	   d.DNAME		as dept_dname,
	   d.LOC 		as dept_loc,
	   e.EMPNO 		as emp_empno,
	   e.ENAME		as emp_ename,
	   e.JOB		as emp_jpb,
	   e.MGR		as emp_mgr,
	   e.HIREDATE	as emp_hiredate,
	   e.SAL		as emp_sal,
	   e.COMM		as emp_comm,
	   e.DEPTNO		as emp_deptno
	     from dept d left join emp e on d.deptno = e.deptno;



-- empolyee

SELECT count(*) FROM DEPT;
SELECT count(*) FROM emp;
SELECT count(*) FROM BONUS;
SELECT count(*) FROM SALGRADE;
SELECT * FROM DEPT;
SELECT * FROM emp;
SELECT * FROM BONUS;
SELECT * FROM SALGRADE;


-- world

SELECT count(*) FROM COUNTRY;
SELECT count(*) FROM CITY;
SELECT count(*) FROM COUNTRYLANGUAGE;



SELECT * FROM COUNTRY WHERE CODE = 'USA';
SELECT * FROM CITY WHERE  COUNTRY_CODE = 'KOR';
SELECT * FROM COUNTRY_LANGUAGE;




drop table city;
drop table country;
drop table country_language;


/*
 * City
 */
create table city (
	id		number(11)	not null,
	name		char(35 char),
	country_code 	char(3 char),
	district	char(20 char),
	population	number(11)	default 0,
	constraint pk_city primary key (id),
	constraint fk_country foreign key (country_code) references country(code) 
);

/*
 * CountryLanguage
 */
create table country_language (
	country_code	char(3 char),
	language	char(30 char),
	is_official	char(1 char)		default 'F',
	percentage	number(4,1)			default '0.0',
	constraint ck_isofficial check (is_official in ('T','F')),
	constraint pk_country_language primary key (country_code, language)
);


create table country (
	code 			char(3 char),						--국가코드
	name 			char(52 char),						--국가이름(South korea)
	continent		char(20 char)	default 'Asia',				--대륙
	region			char(26 char),						--지역
	surface_area		number(10,2)	default '0.00',				--표면적
	indep_year		number(6),						--독립일
	population		number(11)		default 0,			--국가인구
	life_expectancy		number(3,1),						--기대수명
	gnp				number(10,2),					
	gnp_old			number(10,2),											
	local_name		char(45 char),						--국가지역이름(대한민국)
	government_form	char(45 char),
	head_of_state		char(60 char)	default null,
	capital			number(11)		default null,
	code2			char(2  char),
	constraint ck_continent check (continent in ('Asia','Europe','North America','Africa','Oceania','Antarctica','South America')),
	constraint pk_country primary key (code)
);