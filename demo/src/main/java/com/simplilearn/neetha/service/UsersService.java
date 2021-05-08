package com.simplilearn.neetha.service;

import java.util.List;

import com.simplilearn.neetha.model.DeleteRequestVO;
import com.simplilearn.neetha.model.GetAllUsersVO;
import com.simplilearn.neetha.model.RegisterUserRequestVO;
import com.simplilearn.neetha.model.RegisterUserResponseVO;
import com.simplilearn.neetha.model.StatusResponseVO;
import com.simplilearn.neetha.model.ValidUserLoginReqVO;

public interface UsersService {

	public RegisterUserResponseVO registerUser(RegisterUserRequestVO registerUserRequestVO);
	
	public StatusResponseVO deleteUser(DeleteRequestVO deleteRequestVO);
	
	public List<GetAllUsersVO> getAllUsers();
	
	public StatusResponseVO isValidAdminLogin(ValidUserLoginReqVO validUserLoginReqVO);
	
	public StatusResponseVO isValidUserLogin(ValidUserLoginReqVO validUserLoginReqVO);
	
	public StatusResponseVO changePassword(ValidUserLoginReqVO validUserLoginReqVO);

}
