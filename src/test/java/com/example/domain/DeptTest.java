package com.example.domain;

import org.junit.Test;

public class DeptTest {
		@Test
		public void test01_ToString() {
			Dept d = new Dept();
			d.setDeptno(10);
			d.setDname("yyy");
			System.out.println(d);
			
		}
}
