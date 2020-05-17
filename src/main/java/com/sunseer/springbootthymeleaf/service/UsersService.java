package com.sunseer.springbootthymeleaf.service;

import java.util.List;

import com.sunseer.springbootthymeleaf.pojo.UserTable;

public interface UsersService {

	void addUser(UserTable users);
	List<UserTable> findUsersAll();
	UserTable findUserById(Integer id);
	void modifyUser(UserTable users);
	void dropUser(Integer id);

}
