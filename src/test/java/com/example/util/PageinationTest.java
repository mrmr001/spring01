package com.example.util;

import org.junit.Test;

public class PageinationTest {

	@Test
	public void test01() {
		Pagination page = new Pagination();
		
		page.setTotalItem(4079); //select count(*) from city
		page.setPageNo(2);		//1page
		
			System.out.println("itemspage="+page.getItemsPerPage());
			System.out.println("totalpage="+page.getTotalPage());
			System.out.println("firstitem="+page.getFirstItem());
			System.out.println("listtitem="+page.getLastItem());
		

	}
	
	@Test
	public void test02() {
		Pagination page = new Pagination();
		
		page.setTotalItem(457); //select count(*) from city

		for (int i=0; i<=page.getTotalPage()+1; i++){
			page.setPageNo(i);		//1page
			System.out.println("itemspage="+page.getPageNo() + 
								",firstitem="+page.getFirstItem()+
								",listtitem="+page.getLastItem()+
								",offset="+ (page.getFirstItem()-1)+
								",itemspage="+page.getItemsPerPage()
								);
		}

	}
}
