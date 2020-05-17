package com.sunseer.springbootthymeleaf.dao;

import java.util.List;

import com.sunseer.springbootthymeleaf.pojo.UserTable;

public interface UsersDao {
	void insertUsers(UserTable users);
	List<UserTable> selectUsersAll();
	UserTable selectUserById(Integer id);
	void updateusers(UserTable users);
	void deleteuserById(Integer id);
}
