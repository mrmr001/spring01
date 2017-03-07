package com.example.Dept.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.City;
import com.example.domain.Country;
import com.example.domain.Dept;
import com.example.mapper.CityMapper;
import com.example.mapper.CountryMapper;
import com.example.mapper.DeptMapper;
import com.example.util.Pagination;

@Service
public class DeptSearchServiceTest {
	static Log log = LogFactory.getLog(DeptSearchService.class);
	@Autowired
	DeptMapper Deptmapper;
	
	public List<Dept> getListAll() {
		log.info("getListAll()");
		return getListAll(false);
	}
	
	
	public List<Dept> getListAll(boolean withEmp){
		log.info("getListAll("+withEmp+")");
		List<Dept> list =null;
		if(withEmp) 
			list = Deptmapper.selectAllWithEmp();
		else
			list=Deptmapper.selectAll();
		return list;
	}
	
//	public Map<String, Object>  getPage(int pageNo) {
//		log.info("getCityById("+pageNo+")");
//		return getPage(pageNo,false);
//		
//	}
	
//	public Map<String, Object>  getPage(int pageNo, boolean withCity) {
//		log.info("getCityById("+pageNo+","+withCity+")");
//		Pagination paging = new Pagination();
//		paging.setTotalItem(Deptmapper.selectTotalCount());
//		paging.setPageNo(pageNo);
//		List<Dept> list =null;
//		if (withCity)
//			list = Deptmapper.selectPageWithCode(paging);
//		else
//			list = Deptmapper.selectPage(paging);
//		
//		
//		Map<String, Object> map =new HashMap<>();
//		map.put("country", list);
//		map.put("paging", paging);
//		return map;
//		
//	}
//	
//	
//	public Dept getByCode(String code){
//		log.info("selectByCode("+code+")");
//		return getByCode(code,false);
//	}
//	public Dept getByCode(String code,boolean withCity){
//		log.info("getCityById("+code+","+withCity+")");
//		Dept country=null;
//		if(withCity)
//			country=Deptmapper.selectByIdWithCty(code);
//		else
//			country=Deptmapper.selectByCode(code);
//		return country;
//		
//	}
}
