package com.example.Dept.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptSearchServiceTest {
	@Autowired
	DeptSearchService sever;
	@Test
	public void test01() {
		System.out.println("sever="+sever);
	}
	
	@Test
	public void test01_getAll() {
		List<Dept> list = sever.getListAll();
		for(Dept d : list)
		System.out.println(d);
	}
	@Test
	public void test01_getAllWithCity() {
		List<Dept> list = sever.getListAll(true);
		for(Dept d: list)
		System.out.println(d);
	}


	@Test
	public void test02_getPage(){
	Map<String, Object> map = sever.getPage(1);
		System.out.println(map.get("dept"));
		System.out.println(map.get("paging"));
	}
	
	@Test
	public void test02_getPageWithEmp(){
	Map<String, Object> map = sever.getPage(2,true);
	List<Dept> list = (List<Dept>)map.get("dept");
	 for (Dept d : list )
		System.out.println(d);
		System.out.println(map.get("paging"));
	}
	
	
	@Test
	public void test03_getDeptByDeptno(){
		Dept d=sever.getBydeptno(20);
			System.out.println(d);
	}
	
	@Test
	public void test03_getDeptByDeptno_withEmp(){
		Dept d=sever.getBydeptno(20,true);
		System.out.println(d);
	}
	
	
}
