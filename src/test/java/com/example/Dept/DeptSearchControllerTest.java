package com.example.Dept;

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
public class DeptSearchControllerTest {

	@LocalServerPort
	int port;
	
	@Autowired
	TestRestTemplate rest;
	
	@Test
	public void test_getList(){
		String html = rest.getForObject("/dept/list", String.class);
		System.out.println(html);
	}
	
	
	@Test
	public void test_getItem() {
		String html = rest.getForObject("/dept/item/20", String.class);
		System.out.println(html);
		
	}
}
