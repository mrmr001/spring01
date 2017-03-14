package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.domain.City;
import com.example.domain.Country;
import com.example.util.Pagination;


@Mapper
public interface CountryMapper {

		
	@Select("SELECT count(*) FROM country")
	int selectTotalCount();
	
	@Select("select * from Country")
	List<Country> selectAll();
	
	List<Country> selectAllWithCity();
	
	
	@Select({ 
			"SELECT * FROM Country 					",
			"order by code							",
			"OFFSET #{firstItem}-1 ROWS				",
			" FETCH NEXT #{itemsPerPage} ROWS ONLY	"
			})
	List<Country> selectPage(Pagination page);
	
	List<Country> selectPageWithCode(Pagination page);
	
	
	
	@Select("select * from Country where code=#{code}")
	Country selectByCode(String code);
	
	Country selectByIdWithCty(String code);	
	
	
	
	/*
	 * @Insert
	 */

	int insert(Country country);
	
	
	/*
	 * @Update
	 */

	int updateByCode(Country country);
	
	/*
	 * @@Delete
	 */
	@Delete("delete from country where code= #{code}")
	int deleteByCode(String code);
}
