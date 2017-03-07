package com.example.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dept;
import com.example.exception.NotFoundRuntimeException;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptMapperTest {
 
	@Autowired
	DeptMapper mapper;
	
	
	@Test
	public void test_selectAll() {
		List<Dept> list = mapper.selectAll();
		for (Dept c : list) {
			System.out.println(c);
			
		}
		
	}
	@Test
	public void test_selectAllWithCity() {
		List<Dept> list = mapper.selectAllWithEmp();
		for (Dept c : list) {
			System.out.println(c);
			
		}
		
	}
	
	@Test
	public void test_selectPage() {
		Pagination page =new Pagination();
		page.setTotalItem(mapper.count());
		page.setPageNo(10);
		List<Dept> list = mapper.selectPage(page);
		for (Dept c : list) {
			System.out.println(c);
			
		}
	}
	
	@Test
	public void test_selectPageWithCode() {
		Pagination page =new Pagination();
		page.setTotalItem(mapper.count());
		page.setPageNo(1);
		List<Dept> list = mapper.selectPageWithEmp(page);
		for (Dept c : list) {
			System.out.println(c);
			
		}
		
	}
	
	@Test
	public void test_selectByCode() {
		Dept dept = mapper.selectByDeptno(10);
				if (dept == null) {
					throw new NotFoundRuntimeException("정보부족");
					
				}
					System.out.println(dept);
	}
	
	
	
	
	@Test
	public void test_selectByIdWithCty() {
		Dept dept = mapper.selectByDeptnoWithEmp(10);
		if (dept == null) {
			throw new NotFoundRuntimeException("정보부족");
			
		}
			System.out.println(dept);
}

	
}
