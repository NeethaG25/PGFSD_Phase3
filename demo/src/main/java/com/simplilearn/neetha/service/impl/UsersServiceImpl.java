package com.simplilearn.neetha.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.neetha.dao.UsersDao;
import com.simplilearn.neetha.exception.GlobalException;
import com.simplilearn.neetha.model.DeleteRequestVO;
import com.simplilearn.neetha.model.GetAllUsersVO;
import com.simplilearn.neetha.model.RegisterUserRequestVO;
import com.simplilearn.neetha.model.RegisterUserResponseVO;
import com.simplilearn.neetha.model.StatusResponseVO;
import com.simplilearn.neetha.model.UpdatePriceReqVO;
import com.simplilearn.neetha.model.ValidUserLoginReqVO;
import com.simplilearn.neetha.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDao usersDao;
	
	@Override
	public RegisterUserResponseVO registerUser(RegisterUserRequestVO registerUserRequestVO) {
		
		RegisterUserResponseVO registerUserResponseVO = new RegisterUserResponseVO();
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String className = this.getClass().getName();
		
		if (StringUtils.isEmpty(registerUserRequestVO.getUserId())) {
			throw new GlobalException("UserId cannot be empty", className,methodName);
		}
		
		if (StringUtils.isEmpty(registerUserRequestVO.getPassword())) {
			throw new GlobalException("Password cannot be empty", className,methodName);
		}
		
		Integer count = usersDao.saveNewUser(registerUserRequestVO);
		
		if(count>0) {
			registerUserResponseVO.setStatus("The User was created successfully");
		} else {
			registerUserResponseVO.setStatus("The USer was not created successfully");
		}
		
		return registerUserResponseVO;
	}
	
	@Override
	public StatusResponseVO deleteUser(DeleteRequestVO deleteRequestVO) {
		
		StatusResponseVO statusResponseVO = new StatusResponseVO();
		
		usersDao.deleteUser(deleteRequestVO.getId());
		
		statusResponseVO.setStatus("The User has been deleted");
		
		return statusResponseVO;
		
	}
	
	@Override
	public StatusResponseVO changePassword(ValidUserLoginReqVO validUserLoginReqVO) {
		
		StatusResponseVO statusResponseVO = new StatusResponseVO();
		
		usersDao.changePassword(validUserLoginReqVO.getUserId(), validUserLoginReqVO.getPassword());
		
		statusResponseVO.setStatus("The Password has been changed");
		
		return statusResponseVO;
		
	}
	
	

	@Override
	public List<GetAllUsersVO> getAllUsers() {
		
		List<GetAllUsersVO> getAllUsersVOList = usersDao.getAllUsers();
		
		return getAllUsersVOList;
	}
	
	@Override
	public StatusResponseVO isValidAdminLogin(ValidUserLoginReqVO validUserLoginReqVO) {
		
		StatusResponseVO deleteResponseVO = new StatusResponseVO();
		
		Integer count = usersDao.isValidAdminLogin(validUserLoginReqVO.getUserId(), validUserLoginReqVO.getPassword());
		
		if(count!=null && count==1) {
			deleteResponseVO.setStatus("The Logged in Admin User is Valid");
		} else {
			deleteResponseVO.setStatus("The Logged in Admin User is not Valid");
		}
		
		return deleteResponseVO;
		
	}
	
	@Override
	public StatusResponseVO isValidUserLogin(ValidUserLoginReqVO validUserLoginReqVO) {
		
		StatusResponseVO deleteResponseVO = new StatusResponseVO();
		
		Integer count = usersDao.isValidUSerLogin(validUserLoginReqVO.getUserId(), validUserLoginReqVO.getPassword());
		
		if(count!=null && count==1) {
			deleteResponseVO.setStatus("The Logged in User is Valid");
		} else {
			deleteResponseVO.setStatus("The Logged in User is not Valid");
		}
		
		return deleteResponseVO;
		
	}

}
