package com.sunseer.springbootthymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	/**
	 * submitのリクエスト方式はpost
	 * @param model
	 * @return
	 */
	@PostMapping("/addUser")
	public String showInfo(UserTable users) {
		try {
			this.usersService.addUser(users);
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return "redirect:/ok";
	}

	@GetMapping("/findUserAll")
	public String finduserAll(Model model) {
		List<UserTable> list = null;
		try {
			list = this.usersService.findUsersAll();
			model.addAttribute("list",list);
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return "showUsers";
	}
	/**
	 * <a>タグのリクエスト方式はGET
	 * 
	 */
	@GetMapping("/preUpdateUser")
	public String preUpdateUser(Integer id, Model model) {

		try {
			UserTable user = this.usersService.findUserById(id);
			model.addAttribute("user", user);
			
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return "updateUser";
	}
	
	@PostMapping("/updateUser")
	public String updateUser(UserTable users) {
		System.out.println(users.getUsersex());
		System.out.println(users.getUsername());
		System.out.println(users.getUserid());
		try {
			this.usersService.modifyUser(users);
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return "redirect:/ok";
	}
	
	@GetMapping("/deleteUser")
	public String deletuser(Integer id) {
		try {
			this.usersService.dropUser(id);
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return "redirect:/ok";
	}
}
