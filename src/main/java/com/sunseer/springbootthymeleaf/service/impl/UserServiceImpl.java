package com.sunseer.springbootthymeleaf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunseer.springbootthymeleaf.dao.UsersDao;
import com.sunseer.springbootthymeleaf.pojo.UserTable;
import com.sunseer.springbootthymeleaf.service.UsersService;

@Service
public class UserServiceImpl implements UsersService{

	@Autowired
	private UsersDao usersDao;

	@Override
	@Transactional
	public void addUser(UserTable users) {
		// TODO 自動生成されたメソッド・スタブ

		this.usersDao.insertUsers(users);

	}

	@Override
	public List<UserTable> findUsersAll() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
