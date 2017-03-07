package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.City;
import com.example.domain.Emp;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpMapperTest {
	@Autowired
	EmpMapper mapper;
	
	@Test
	public void test01_selectAll(){
		System.out.println("mapper="+mapper);
		
		List<Emp> list = mapper.selectAll();
		
		for (Emp e : list){
			System.out.println(e);
		}
		
	}
	
	@Test
	public void test01_selectAllWithDept(){
		System.out.println("mapper="+mapper);
		
		List<Emp> list = mapper.selectAllWithDept();
		
		for (Emp e : list){
			System.out.println(e);
		}
		
	}
	
	@Test
	public void test01_selectPage() {
		Pagination page =new Pagination();
		page.setTotalItem(mapper.Count());
		page.setPageNo(-2);
		List<Emp> list = mapper.selectPage(page);
		
		for (Emp e : list) {
			System.out.println(e);
			
		}
		
	}
	
	@Test
	public void test01_selectPageWithDept() {
		Pagination page =new Pagination();
		page.setTotalItem(mapper.Count());
		page.setPageNo(2);
		List<Emp> list = mapper.selectPageWithDept(page);
		for (Emp e : list) {
			System.out.println(e);
		}
		
	}
	@Test
	public void test01_selectById() {
		Emp emp = mapper.selectByEmpno(7900);
		
		if (emp == null) {
			throw new NotFoundRuntimeException("정보부족");
			
		}
			System.out.println(emp);
	}
	
	@Test
	public void test01_selectByEmpnoWithDept() {
		Emp emp = mapper.selectByEmpnoWithDept(7900);
		
		if (emp == null) {
			throw new NotFoundRuntimeException("정보부족");
			
		}
			System.out.println(emp);
	}
}
