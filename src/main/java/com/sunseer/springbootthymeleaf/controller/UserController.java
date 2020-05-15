package com.sunseer.springbootthymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunseer.springbootthymeleaf.pojo.UserTable;
import com.sunseer.springbootthymeleaf.service.UsersService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired

	private UsersService usersService;

	@PostMapping("/addUser")
	public String showInfo(UserTable users) {
		System.out.println(users.getUsername());
		try {
			this.usersService.addUser(users);
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return "redirect:/ok";
	}

	@GetMapping("/findUserAll")
	public String finduserAll() {
		try {

		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return null;
	}
}
