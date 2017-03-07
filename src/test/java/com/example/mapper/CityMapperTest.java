package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.City;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityMapperTest {

	@Autowired
	CityMapper mapper;
	
	@Test
	public void selectAll() {
		List<City> list = mapper.selectAll();
		
		for (City c : list) {
			System.out.println(c);
			
		}
		
	}
	
	
	@Test
	public void selectAllWithCountry() {
		List<City> list = mapper.selectAllWithCountry();
		
		for (City c : list) {
			System.out.println(c);
			
		}
		
	}
	
	@Test
	public void selectpage() {
		Pagination page =new Pagination();
		page.setTotalItem(mapper.selectTotalCount());
		page.setPageNo(1000);
		List<City> list = mapper.selectPage(page);
		
		for (City c : list) {
			System.out.println(c);
			
		}
		
	}
	
	@Test
	public void selectPageWithCountry() {
		Pagination page =new Pagination();
		page.setTotalItem(mapper.selectTotalCount());
		page.setPageNo(2);
		List<City> list = mapper.selectPageWithCountry(page);
		
		for (City c : list) {
			System.out.println(c);
			
		}
		
	}
	@Test
	public void selectById() {
		City city = mapper.selectById(10);
		
		if (city == null) {
			throw new NotFoundRuntimeException("정보부족");
			
		}
			System.out.println(city);
	}
	
	@Test
	public void selectByIdWithContry() {
		City city = mapper.selectByIdWithContry(10);
		
		if (city == null) {
			throw new NotFoundRuntimeException("정보부족");
			
		}
			System.out.println(city);
	}
}
