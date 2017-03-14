package com.example.Emp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.city.service.CitySearchService;
import com.example.domain.City;
import com.example.domain.Dept;
import com.example.domain.Emp;
import com.example.mapper.DeptMapper;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpSearchServiceTest {
	
	
	@Autowired
	EmpSearchService sever;
	
	@Test
	public void test01_getAll() {
		List<Emp> list = sever.getListAll();
		for(Emp e : list)
		System.out.println(e);
	}
	@Test
	public void test01_getAllWithEmp() {
		List<Emp> list = sever.getListAll(true);
		for(Emp e : list)
		System.out.println(e);
	}
	@Test
	public void test02_getPage(){
	Map<String, Object> map = sever.getPage(1);
		System.out.println(map.get("emp"));
		System.out.println(map.get("paging"));
	}
	
	@Test
	public void test02_getPageWithEmp(){
	Map<String, Object> map = sever.getPage(1,true);
		System.out.println(map.get("emp"));
		System.out.println(map.get("paging"));
	}
	
	@Test
	public void test03_getEmpByEmpno(){
		Emp e =sever.getByEmpno(7369);
			System.out.println(e);
	}
	
	@Test
	public void test03_getEmpByEmpno_withDept(){
		 Emp e =sever.getByEmpno(7369, true);
		System.out.println(e);
	}
}
