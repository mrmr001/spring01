package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.domain.Dept;
import com.example.util.Pagination;

@Mapper
public interface DeptMapper {

	@Select("select count(*) from dept")
	int count();
	
	@Select("select * from dept")
	List<Dept> selectAll();
	
	List<Dept> selectAllWithEmp();
	
	@Select({
			"select * from dept						",
			"offset #{firstItem}-1 rows				",
			" fetch next #{itemsPerPage} rows only	"
			})
	List<Dept> selectPage(Pagination page);
	
	List<Dept> selectPageWithEmp(Pagination page);
	
	@Select("select * from dept where deptno = #{deptno}")
	Dept selectByDeptno(int deptno);
	
	Dept selectByDeptnoWithEmp(int deptno);
}
