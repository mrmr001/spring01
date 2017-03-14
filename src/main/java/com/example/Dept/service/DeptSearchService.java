package com.example.Dept.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Dept;
import com.example.exception.NotFoundRuntimeException;
import com.example.mapper.DeptMapper;
import com.example.util.Pagination;

@Service
public class DeptSearchService {
	static Log log = LogFactory.getLog(DeptSearchService.class);
	
	
	@Autowired
	DeptMapper deptMapper;
	
	public List<Dept> getListAll() {
		log.info("getListAll()");
		return getListAll(false);
	}
	
	
	public List<Dept> getListAll(boolean withEmp){
		log.info("getListAll("+withEmp+")");
		List<Dept> list =null;
		if(withEmp) 
			list = deptMapper.selectAllWithEmp();
		else
			list=deptMapper.selectAll();
		return list;
	}
	
	public Map<String, Object>  getPage(int pageNo) {
		log.info("getdeptByDeptno("+pageNo+")");
		return getPage(pageNo,false);
		
	}
	
	public Map<String, Object>  getPage(int pageNo, boolean withEmp) {
		log.info("getdeptByDeptno("+pageNo+","+withEmp+")");
		Pagination paging = new Pagination();
		paging.setTotalItem(deptMapper.count());
		paging.setPageNo(pageNo);
		List<Dept> list =null;
		if (withEmp)
			list = deptMapper.selectPageWithEmp(paging);
		else
			list = deptMapper.selectPage(paging);
		
		
		Map<String, Object> map =new HashMap<>();
		map.put("depts", list);
		map.put("paging", paging);
		return map;
		
	}
	
	
	public Dept getBydeptno(int deptno){
		log.info("getBydeptno("+deptno+")");
		return getBydeptno(deptno,false);
	}
	public  Dept getBydeptno(int deptno,boolean withEmp){
		log.info("getBydeptno("+deptno+","+withEmp+")");
		Dept dept=null;
		if(withEmp)
			dept=deptMapper.selectByDeptnoWithEmp(deptno);
		else
			dept=deptMapper.selectByDeptno(deptno);
		if ( dept == null)
			throw new NotFoundRuntimeException("dept가 없습니다");
		return dept;
		
	}
}
