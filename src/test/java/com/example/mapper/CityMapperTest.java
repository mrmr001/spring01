package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.City;
import com.example.domain.Country;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityMapperTest {

	@Autowired
	CityMapper cityMapper;
	@Autowired
	CountryMapper countryMapper;
	
	@Test
	public void selectAll() {
		List<City> list = cityMapper.selectAll();
		
		for (City c : list) {
			System.out.println(c);
			
		}
		
	}
	
	
	@Test
	public void selectAllWithCountry() {
		List<City> list = cityMapper.selectAllWithCountry();
		
		for (City c : list) {
			System.out.println(c);
			
		}
		
	}
	
	@Test
	public void selectpage() {
		Pagination page =new Pagination();
		page.setTotalItem(cityMapper.selectTotalCount());
		page.setPageNo(1000);
		List<City> list = cityMapper.selectPage(page);
		
		for (City c : list) {
			System.out.println(c);
			
		}
		
	}
	
	@Test
	public void selectPageWithCountry() {
		Pagination page =new Pagination();
		page.setTotalItem(cityMapper.selectTotalCount());
		page.setPageNo(2);
		List<City> list = cityMapper.selectPageWithCountry(page);
		
		for (City c : list) {
			System.out.println(c);
			
		}
		
	}
	@Test
	public void selectById() {
		City city = cityMapper.selectById(10);
		
//		if (city == null) {
//			throw new NotFoundRuntimeException("정보부족");
//			
//		}
			System.out.println("city="+city);
	}
	
	@Test
	public void selectByIdWithContry() {
		City city = cityMapper.selectByIdWithContry(10);
		
		if (city == null) {
			throw new NotFoundRuntimeException("정보부족");
			
		}
			System.out.println(city);
	}
	
	@Test
	public void test_insert() {
		City city = new City();
		city.setName("xxx");
		city.setCountryCode("KOR");
		Country country = countryMapper.selectByCode(city.getCountryCode());
		if (country == null){
			System.out.println("error = "+"country err");
		    return;
		}
		int cnt = cityMapper.insert(city);
		System.out.println(cityMapper.selectById(city.getId()));
	}
	
}
