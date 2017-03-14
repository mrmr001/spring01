package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.City;
import com.example.domain.Country;
import com.example.domain.Dept;
import com.example.domain.Emp;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpMapperTest {
	@Autowired
	EmpMapper empMapper;
	
	@Autowired
	DeptMapper deptMapper;
	
	@Test
	public void test01_selectAll(){
		System.out.println("empMapper="+empMapper);
		
		List<Emp> list = empMapper.selectAll();
		
		for (Emp e : list){
			System.out.println(e);
		}
		
	}
	
	@Test
	public void test01_selectAllWithDept(){
		System.out.println("empempMapper="+empMapper);
		
		List<Emp> list = empMapper.selectAllWithDept();
		
		for (Emp e : list){
			System.out.println(e);
		}
		
	}
	
	@Test
	public void test01_selectPage() {
		Pagination page =new Pagination();
		page.setTotalItem(empMapper.Count());
		page.setPageNo(-2);
		List<Emp> list = empMapper.selectPage(page);
		
		for (Emp e : list) {
			System.out.println(e);
			
		}
		
	}
	
	@Test
	public void test01_selectPageWithDept() {
		Pagination page =new Pagination();
		page.setTotalItem(empMapper.Count());
		page.setPageNo(2);
		List<Emp> list = empMapper.selectPageWithDept(page);
		for (Emp e : list) {
			System.out.println(e);
		}
		
	}
	@Test
	public void test01_selectById() {
		Emp emp = empMapper.selectByEmpno(7900);
		
		if (emp == null) {
			throw new NotFoundRuntimeException("정보부족");
			
		}
			System.out.println(emp);
	}
	
	@Test
	public void test01_selectByEmpnoWithDept() {
		Emp emp = empMapper.selectByEmpnoWithDept(7900);
		
		if (emp == null) {
			throw new NotFoundRuntimeException("정보부족");
			
		}
			System.out.println(emp);
	}
	
	
	
	@Test
	public void test_insert() {
		Emp emp = new Emp();
		emp.setEname("XXX");
		emp.setDeptno(20);
		Dept dept = deptMapper.selectByDeptno(emp.getDeptno());
		if (dept == null){
			System.out.println("error = "+"dept err");
		    return;
		}
		int cnt = empMapper.insert(emp);
		System.out.println(empMapper.selectByEmpno(emp.getEmpno()));
	}
}
