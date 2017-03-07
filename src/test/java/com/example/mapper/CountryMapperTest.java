package com.example.mapper;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Country;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryMapperTest {
	@Autowired
	CountryMapper mapper;
	
	
	@Test
	public void test_selectAll() {
		List<Country> list = mapper.selectAll();
		for (Country c : list) {
			System.out.println(c);
			
		}
		
	}
	@Test
	public void test_selectAllWithCity() {
		List<Country> list = mapper.selectAllWithCity();
		for (Country c : list) {
			System.out.println(c);
			
		}
		
	}
	
	@Test
	public void test_selectPage() {
		Pagination page =new Pagination();
		page.setTotalItem(mapper.selectTotalCount());
		page.setPageNo(10);
		List<Country> list = mapper.selectPage(page);
		for (Country c : list) {
			System.out.println(c);
			
		}
	}
	
	@Test
	public void test_selectPageWithCode() {
		Pagination page =new Pagination();
		page.setTotalItem(mapper.selectTotalCount());
		page.setPageNo(1);
		List<Country> list = mapper.selectPageWithCode(page);
		for (Country c : list) {
			System.out.println(c);
			
		}
		
	}
	
	@Test
	public void test_selectByCode() {
		Country country = mapper.selectByCode("KOR");
				if (country == null) {
					throw new NotFoundRuntimeException("정보부족");
					
				}
					System.out.println(country);
	}
	
	
	
	
	@Test
	public void test_selectByIdWithCty() {
		Country country = mapper.selectByIdWithCty("KOR");
		if (country == null) {
			throw new NotFoundRuntimeException("정보부족");
			
		}
			System.out.println(country);
}


}
