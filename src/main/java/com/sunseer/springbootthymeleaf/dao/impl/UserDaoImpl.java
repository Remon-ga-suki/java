package com.sunseer.springbootthymeleaf.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
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
			/**
			 * Resultsetのマーピング
			 */
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserTable usertable = new UserTable();
				usertable.setUserid(rs.getInt("userid"));
				usertable.setUsername(rs.getString("username"));
				usertable.setUsersex(rs.getString("usersex"));
				return usertable;
			}
		});
	}

	@Override
	public UserTable selectUserById(Integer id) {
		String sql = "select * from users where userid = ?";
		UserTable user= new UserTable();
		Object[] arr = new Object[] {id};
		this.jdbcTemplate.query(sql, arr, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setUsersex(rs.getString("usersex"));
			}
		});
		return user;
	}

	@Override
	public void updateusers(UserTable users) {
		String sql = "update users set username = ?, usersex=? where userid = ?";

		this.jdbcTemplate.update(sql, users.getUsername(),users.getUsersex(), users.getUserid());
	}

	@Override
	public void deleteuserById(Integer id) {
		String sql = "delete from users where userid = ?";
		this.jdbcTemplate.update(sql, id);
		
	}

}
