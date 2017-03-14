package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.domain.City;
import com.example.domain.Emp;
import com.example.util.Pagination;

@Mapper
public interface EmpMapper {
	
	@Select("SELECT count(*) FROM EMP")
	int Count();
	
	@Select("select * from emp")
	List<Emp> selectAll();
	
	List<Emp> selectAllWithDept();
	
	
	@Select({ 
		"SELECT * FROM emp 		",
		"order by deptno 				",
		"OFFSET #{firstItem}-1 ROWS				",
		" FETCH NEXT #{itemsPerPage} ROWS ONLY	"
		})
	List<Emp> selectPage(Pagination page);
	
	List<Emp> selectPageWithDept(Pagination page);
	
	
	@Select("select * from emp where empno = #{empno}")
	Emp selectByEmpno(int empno); 
	
	Emp selectByEmpnoWithDept(int empno);
	
	int insert(Emp emp);
	
	int updateById(Emp emp);
	
	@Delete("delete from emp where empno= #{empno}")
	int deleteById(int id);
	
}
