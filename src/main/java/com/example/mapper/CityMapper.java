package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.domain.City;
import com.example.util.Pagination;

@Mapper
public interface CityMapper {
	/*
	 * Select
	 */
	
	@Select("SELECT count(*) FROM CITY")
	int selectTotalCount();
	
	@Select("select * from city where country_code='KOR'")
	List<City> selectAll();
	
	List<City> selectAllWithCountry();
	
	
	@Select({ 
			"SELECT * FROM CITY 					",
			"order by id 							",
			"OFFSET #{firstItem}-1 ROWS				",
			" FETCH NEXT #{itemsPerPage} ROWS ONLY	"
			})
	List<City> selectPage(Pagination page);
	
	
	
	
	List<City> selectPageWithCountry(Pagination page);
	
	@Select("select * from city where id=#{id}")
	City selectById(int id);
	
	City selectByIdWithContry(int id);
}
