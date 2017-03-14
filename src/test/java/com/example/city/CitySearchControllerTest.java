package com.example.city;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.city.CitySearchController;
import com.example.domain.City;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CitySearchControllerTest {
	@LocalServerPort
	int port;
	
	@Autowired
	TestRestTemplate rest;

	
	@Test
	public void test_getList() {
		String html = rest.getForObject("/city/list", String.class);
		System.out.println(html);
		
	}

	@Test
	public void test_getPage(){
		String html = rest.getForObject("/city/page/5", String.class);
		System.out.println(html);
	}
	@Test
	public void test_getItem() {
		String html = rest.getForObject("/city/item/xxx", String.class);
		System.out.println(html);
		
	}
	
	@Test
	public void test_getItem_NotFoundRu() {
		String html = rest.getForObject("/city/item/xxx", String.class);
		System.out.println(html);
		
	}
	

	
}
