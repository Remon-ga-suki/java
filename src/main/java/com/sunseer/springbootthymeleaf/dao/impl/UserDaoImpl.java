package com.sunseer.springbootthymeleaf.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sunseer.springbootthymeleaf.dao.UsersDao;
import com.sunseer.springbootthymeleaf.pojo.UserTable;

@Repository
public class UserDaoImpl implements UsersDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertUsers(UserTable users) {
		String sql = "insert into users(username,usersex) values (?,?)";
		this.jdbcTemplate.update(sql, users.getUsername(),users.getUsersex());

	}

	@Override
	public List<UserTable> selectUsersAll() {
		String sql = "select * from users";
		return this.jdbcTemplate.query(sql, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO 自動生成されたメソッド・スタブ
				return null;
			}
		});
	}

}
