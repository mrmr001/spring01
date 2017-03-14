package com.example.Country;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CountrySearchControllerTest {
	
	
	@LocalServerPort
	int port;
	
	@Autowired
	TestRestTemplate rest;
	
	@Test
	public void test_port() {
		System.out.println("port"+port);
		
	}
	
	@Test
	public void test_RestTempleat() {
		System.out.println("rest"+rest);
		
	}
	
	@Test
	public void test_getList() {
		String html = rest.getForObject("/country/list", String.class);
		System.out.println(html);
		
	}

	@Test
	public void test_getPage(){
		String html = rest.getForObject("/country/page/5", String.class);
		System.out.println(html);
	}
	@Test
	public void test_getItem() {
		String html = rest.getForObject("/country/item/xxx", String.class);
		System.out.println(html);
		
	}
	
	@Test
	public void test_getItem_NotFoundRu() {
		String html = rest.getForObject("/country/item/xxx", String.class);
		System.out.println(html);
		
	}
	

	
}
