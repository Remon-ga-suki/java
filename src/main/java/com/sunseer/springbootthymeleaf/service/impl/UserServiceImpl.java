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

		this.usersDao.insertUsers(users);

	}

	@Override
	public List<UserTable> findUsersAll() {

		return this.usersDao.selectUsersAll();
	}

	@Override
	public UserTable findUserById(Integer id) {
		return this.usersDao.selectUserById(id);
	}

	@Override
	@Transactional //DML(Data Manipulation Language)作業,insert,update,delete
	public void modifyUser(UserTable users) {
		this.usersDao.updateusers(users);
		
	}

	@Override
	@Transactional
	public void dropUser(Integer id) {
		this.usersDao.deleteuserById(id);
		
	}

}
