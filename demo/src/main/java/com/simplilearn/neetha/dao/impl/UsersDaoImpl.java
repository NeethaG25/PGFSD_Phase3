package com.simplilearn.neetha.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.simplilearn.neetha.dao.UsersDao;
import com.simplilearn.neetha.exception.GlobalException;
import com.simplilearn.neetha.model.GetAllUsersVO;
import com.simplilearn.neetha.model.GetPurchaseResponseVO;
import com.simplilearn.neetha.model.RegisterUserRequestVO;

@Repository
public class UsersDaoImpl extends JdbcDaoSupport implements UsersDao{
	
	private static final Logger logger = LoggerFactory.getLogger(UsersDaoImpl.class);

	@Autowired
	DataSource dataSource;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	@Override
	public Integer saveNewUser(final RegisterUserRequestVO registerUserRequestVO) {
		
		logger.info("inserting Users in db {}" + registerUserRequestVO.getUserId());
		
		String sql = "INSERT INTO users (userId, firstName, lastName, password, role) VALUES (:userId, :firstName, :lastName, :password, 'normal')";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(registerUserRequestVO);

		int count = namedParameterJdbcTemplate.update(sql, parameterSource);

		if(count > 0) {
			System.out.println("User was created successfully");
		} else {
			System.out.println("User was not created");
		}
		
		return count;
	}
	
	@Override
	public void deleteUser(final Integer id) {
		
		String sql = "delete from users where id = :id";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);

		namedParameterJdbcTemplate.update(sql, namedParameters);
		
	}
	
	@Override
	public void changePassword(final String userId, String password) {
		
		String sql = "update users set password = :password where userId = :userId";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("password", password).addValue("userId", userId);

		namedParameterJdbcTemplate.update(sql, namedParameters);
		
	}
	
	@Override
	public Integer isValidUSerLogin(String userId, String password) {
		
		Integer count = 0;
		
		try {
			String sql = "select count(*) from users where userId = ? and password = ? and role = 'Normal'";
			
			count = getJdbcTemplate().queryForObject(sql, new Object[]{userId, password}, Integer.class);
		} catch(InvalidResultSetAccessException e) {
			throw new GlobalException("The Count data type is not matching with the return type", "saveNewUser", "isValidUSerLogin");
		}
		catch (DataAccessException e)
		{
			throw new GlobalException("There is no User with the given UserId and Password", "saveNewUser", "isValidUSerLogin");
		}
		return count;
		
	}
	
	@Override
	public Integer isValidAdminLogin(String userId, String password) {
		
		Integer count = 0;
		
		try {
			String sql = "select count(*) from users where userId = ? and password = ? and role = 'Admin'";
			
			count = getJdbcTemplate().queryForObject(sql, new Object[]{userId, password}, Integer.class);
		} catch(InvalidResultSetAccessException e) {
			throw new GlobalException("The Count data type is not matching with the return type", "saveNewUser", "isValidAdminLogin");
		}
		catch (DataAccessException e)
		{
			throw new GlobalException("There is no User with the given UserId and Password", "saveNewUser", "isValidAdminLogin");
		}
		return count;
		
	}

	
	@Override
	public List<GetAllUsersVO> getAllUsers() {
		String sql = "select * from users";

		List<GetAllUsersVO> data = namedParameterJdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(GetAllUsersVO.class));
		return data;
	}
}
