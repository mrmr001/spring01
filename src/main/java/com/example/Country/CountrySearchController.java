package com.example.Country;

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

import com.example.Country.service.CountrySearchService;
import com.example.domain.Country;
import com.example.exception.NotFoundRuntimeException;

@Controller
@RequestMapping("/country")
public class CountrySearchController {

		
		static Log log = LogFactory.getLog(CountrySearchController.class);
		
		@Autowired
		CountrySearchService countrySearchService;
		
		@GetMapping("/list")
		public String getList(Model model) {
			log.info("getlist");
			List<Country> list = countrySearchService.getListAll();
			model.addAttribute("list", list);
			return "country/list";
		}
		@GetMapping("/page/{pageNo}")
		public String getPage(@PathVariable int pageNo, Model model) {
			log.info("getPage("+pageNo+")");
			Map<String, Object> page = countrySearchService.getPage(pageNo);
			model.addAttribute("page", page);
			return "country/page";
		}	
			
		@GetMapping("/item/{code}")
		public String getItem(@PathVariable String code,Model model) {
			log.info("getItem("+code+")");
//			try {
				Country c = countrySearchService.getByCode(code, true);
				model.addAttribute("country", c);
//			} catch (NotFoundRuntimeException e) {
//				model.addAttribute("err",e.getMessage());
//			}
			return "country/item";
		}
		
		
	}

