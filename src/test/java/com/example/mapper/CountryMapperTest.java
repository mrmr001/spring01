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

	@Test
	public void test_insert() {
		Country country = new Country();
		country.setCode("XXX");
		country.setName("DDDD");
		Country c = mapper.selectByCode(country.getCode());
		if (c != null) {
			System.out.println("key err");
			return;
		}
		int cnt = mapper.insert(country);
		System.out.println(mapper.selectByCode(country.getCode()));
		
	}
	
	@Test
	public void test_delete() {
		String code = "XXX";
		int cnt=mapper.deleteByCode(code);
		System.out.println("cmt="+cnt);
		System.out.println("country="+mapper.selectByCode(code));
	}
}
