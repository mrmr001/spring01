package com.example.domain;

import java.math.BigDecimal;

import org.junit.Test;

public class EmpTest {
	
		@Test
		public void test01_setSal() {
			Emp e = new Emp();
			
			BigDecimal sal1 = new BigDecimal("100000000000000000000000000000000.2211");
			BigDecimal sal2 = new BigDecimal("200000000000000000000000000000000.1111");
			BigDecimal sal = sal1.add(sal2);
			e.setSal(sal);
			System.out.println("mgr="+e.getSal());
			
		}
		
		@Test
		public void test01_toString() {
			Emp e = new Emp();
			e.setEmpno(1000);
			e.setEname("ggg");
			
			System.out.println(e);
		}
}
