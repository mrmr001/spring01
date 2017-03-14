package com.example.Dept;

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

import com.example.Dept.service.DeptSearchService;
import com.example.domain.Dept;
import com.example.exception.NotFoundRuntimeException;


@Controller
@RequestMapping("/dept")
public class DeptSearchController {

		
		static Log log = LogFactory.getLog(DeptSearchController.class);
		
		@Autowired
		DeptSearchService deptSearchService;
		
			@GetMapping("/list")
			public String getList(Model model) {
				log.info("getlistdept");
				List<Dept> list = deptSearchService.getListAll();
				model.addAttribute("list", list);
				
				return "dept/list";
				
			}
			@GetMapping("/page/{pageNo}")
			public String getPage(@PathVariable int pageNo, Model model) {
				log.info("getPage("+pageNo+")");
				Map<String, Object> page = deptSearchService.getPage(pageNo);
				model.addAttribute("page", page);
				return "dept/page";
			}
		@GetMapping("/item/{deptno}")
		public String getItem(@PathVariable int deptno,Model model) {
			log.info("getItem("+deptno+")");
			
			try {
				Dept d = deptSearchService.getBydeptno(deptno, true);
				model.addAttribute("dept", d);
			} catch (NotFoundRuntimeException e) {
				model.addAttribute("err",e.getMessage());
			}
			return "dept/item";
		}
	}

