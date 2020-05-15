package com.sunseer.springbootthymeleaf.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunseer.springbootthymeleaf.pojo.Users;

/**
 * Controller
 * @author 2018SUNSEERL3
 *
 */

@Controller
public class PageController {

	@Autowired
	private DataSource dataSource;

	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page) {
		return page;
	}

	@GetMapping("/showInfo")
	public String showInfo() {
		System.out.println(this.dataSource.getClass().getPackage());
		return "ok";
	}


	@GetMapping("/show")
	public String showPage(Model model) {
		model.addAttribute("msg","Hello Thymeleaf");
		model.addAttribute("date", new Date());
		model.addAttribute("sex","女");
		model.addAttribute("id",12);

		List<Users> list = new ArrayList<Users>();
		list.add(new Users("1", "admin1", 21));
		list.add(new Users("2", "admin2", 22));
		list.add(new Users("3", "admin3", 23));
		list.add(new Users("4", "admin4", 24));
		model.addAttribute("list",list);

		Map<String,Users> map = new HashMap<>();
		map.put("user5",new Users("5", "admin5", 25));
		map.put("user6",new Users("6", "admin6", 26));
		map.put("user7",new Users("7", "admin7", 27));
		map.put("user8",new Users("8", "admin8", 28));
		model.addAttribute("map",map);


		return "index";
	}

	@GetMapping("/show1")
	public String showPage1(Model model,HttpServletRequest request) {
		request.setAttribute("req", "HttpServletReauest");
		request.getSession().setAttribute("ses", "HttpSession");
		request.getSession().getServletContext().setAttribute("app", "application");

		model.addAttribute("id","100");
		model.addAttribute("name","admin100");

		return "index1";
	}


	@GetMapping("/show2")
	public String showPage2(String id,String name) {
		System.out.println(id+"\t"+name);

		return "index2";
	}

	@GetMapping("/show3/{id}/{name}")
	public String showPage3(@PathVariable String id,@PathVariable String name) {
		System.out.println(id+"\t"+name);

		return "index2";
	}

	@GetMapping("/show4/{id}")
	public String showPage4(@PathVariable String id,String name) {
		System.out.println(id+"\t"+name);

		return "index2";
	}

	@GetMapping("/show5")
	public String showPage5() {

		return "index3";
	}




}
