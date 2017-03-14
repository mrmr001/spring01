package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.domain.City;
import com.example.util.Pagination;

@Mapper
public interface CityMapper {
	/*
	 * Select
	 */
	
	@Select("SELECT count(*) FROM CITY")
	int selectTotalCount();
	
	@Select("select * from city")
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
	
	
	/*
	 * @Insert
	 */

	int insert(City city);
	
	
	/*
	 * @Update
	 */

	int updateById(City city);
	
	/*
	 * @@Delete
	 */
	@Delete("delete from city where id= #{id}")
	int deleteById(int id);
}
