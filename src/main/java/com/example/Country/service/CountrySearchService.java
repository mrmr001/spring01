package com.example.Country.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.City;
import com.example.domain.Country;
import com.example.mapper.CityMapper;
import com.example.mapper.CountryMapper;
import com.example.util.Pagination;

@Service
public class CountrySearchService {
	static Log log = LogFactory.getLog(CountrySearchService.class);
	@Autowired
	CountryMapper countrymapper;
	
	public List<Country> getListAll() {
		log.info("getListAll()");
		return getListAll(false);
	}
	
	
	public List<Country> getListAll(boolean withCity){
		log.info("getListAll("+withCity+")");
		List<Country> list =null;
		if(withCity) 
			list = countrymapper.selectAllWithCity();
		else
			list=countrymapper.selectAll();
		return list;
	}
	
	public Map<String, Object>  getPage(int pageNo) {
		log.info("getCityById("+pageNo+")");
		return getPage(pageNo,false);
		
	}
	
	public Map<String, Object>  getPage(int pageNo, boolean withCity) {
		log.info("getCityById("+pageNo+","+withCity+")");
		Pagination paging = new Pagination();
		paging.setTotalItem(countrymapper.selectTotalCount());
		paging.setPageNo(pageNo);
		List<Country> list =null;
		if (withCity)
			list = countrymapper.selectPageWithCode(paging);
		else
			list = countrymapper.selectPage(paging);
		
		
		Map<String, Object> map =new HashMap<>();
		map.put("country", list);
		map.put("paging", paging);
		return map;
		
	}
	
	
	public Country getByCode(String code){
		log.info("selectByCode("+code+")");
		return getByCode(code,false);
	}
	public Country getByCode(String code,boolean withCity){
		log.info("getCityById("+code+","+withCity+")");
		Country country=null;
		if(withCity)
			country=countrymapper.selectByIdWithCty(code);
		else
			country=countrymapper.selectByCode(code);
		return country;
		
	}
}
