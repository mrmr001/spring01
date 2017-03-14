package com.example.Emp;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Emp.service.EmpSearchService;
import com.example.domain.Emp;
import com.example.exception.NotFoundRuntimeException;

@Controller
@RequestMapping("/emp")
public class EmpSearchController {
	static Log log = LogFactory.getLog(EmpSearchController.class);
	
	
	@Autowired
	EmpSearchService empSearchService;
	
	@GetMapping("/list")
	public String getList(Model model) {
		log.info("getlistdept");
		List<Emp> list = empSearchService.getListAll();
		model.addAttribute("list", list);
		
		return "emp/list";
		
	}
	@GetMapping("/page/{pageNo}")
	public String getPage(@PathVariable int pageNo, Model model) {
		log.info("getPage("+pageNo+")");
		Map<String, Object> page = empSearchService.getPage(pageNo);
		model.addAttribute("page", page);
		return "emp/page";
	}
	@GetMapping("/item/{empno}")
	public String getItem(@PathVariable int empno,Model model) {
		log.info("getItem("+empno+")");
		
		try {
			Emp m = empSearchService.getByEmpno(empno , true);
			model.addAttribute("emp", m);
		} catch (NotFoundRuntimeException e) {
			model.addAttribute("err",e.getMessage());
		}
		return "emp/item";
	}
}
