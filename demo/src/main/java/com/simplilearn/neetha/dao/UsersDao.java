package com.simplilearn.neetha.dao;

import java.util.List;

import com.simplilearn.neetha.model.GetAllUsersVO;
import com.simplilearn.neetha.model.RegisterUserRequestVO;

public interface UsersDao {
	
	public Integer saveNewUser(final RegisterUserRequestVO registerUserRequestVO);
	
	public void deleteUser(final Integer id);
	
	public void changePassword(final String userId, String password);
	
	public Integer isValidUSerLogin(String userId, String password);
	
	public Integer isValidAdminLogin(String userId, String password);
	
	public List<GetAllUsersVO> getAllUsers();

}
