package com.example.Country.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.City;
import com.example.domain.Country;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountrySearchServiceTest {
	@Autowired
	CountrySearchService service;
	
	@Test
	public void test01() {
		System.out.println("sever="+service);
	}
	
	@Test
	public void test01_getAll() {
		List<Country> list = service.getListAll();
		for(Country c : list)
		System.out.println(c);
	}
	@Test
	public void test01_getAllWithCity() {
		List<Country> list = service.getListAll(true);
		for(Country c : list)
		System.out.println(c);
	}


	@Test
	public void test02_getPage(){
	Map<String, Object> map = service.getPage(1);
		System.out.println(map.get("country"));
		System.out.println(map.get("paging"));
	}
	
	@Test
	public void test02_getPageWithCity(){
	Map<String, Object> map = service.getPage(1,true);
	List<Country> list = (List<Country>)map.get("country");
	 for (Country c : list )
		System.out.println(c);
		System.out.println(map.get("paging"));
	}
	
	
	@Test
	public void test03_getCountryByCode(){
		Country c=service.getByCode("KOR");
			System.out.println(c);
	}
	
	@Test
	public void test03_getCountryByCode_withCitys(){
		Country c=service.getByCode("KOR",true);
		System.out.println(c);
	}
	
	
	
}
