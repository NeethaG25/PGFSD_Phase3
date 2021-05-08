package com.simplilearn.neetha.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.neetha.constants.RequestUrls;
import com.simplilearn.neetha.gateway.SportyShoesGateway;
import com.simplilearn.neetha.model.DeleteRequestVO;
import com.simplilearn.neetha.model.GetAllUsersVO;
import com.simplilearn.neetha.model.GetProductRequestVO;
import com.simplilearn.neetha.model.GetProductResponseVO;
import com.simplilearn.neetha.model.RegisterUserRequestVO;
import com.simplilearn.neetha.model.RegisterUserResponseVO;
import com.simplilearn.neetha.model.StatusResponseVO;
import com.simplilearn.neetha.model.UpdatePriceReqVO;
import com.simplilearn.neetha.model.ValidUserLoginReqVO;
import com.simplilearn.neetha.service.UsersService;

@RestController
@RequestMapping(RequestUrls.usersClassURL)
public class UsersController {

		@Autowired
		private UsersService usersService;
		
		private static final Logger logger=LoggerFactory.getLogger(UsersController.class);

		@PostMapping(value = "/registerUser", produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_ATOM_XML_VALUE })
		public SportyShoesGateway<?> registerUser(@RequestBody RegisterUserRequestVO registerUserRequestVO) {
			
			RegisterUserResponseVO result = usersService.registerUser(registerUserRequestVO);

			return new SportyShoesGateway<>(true, HttpStatus.OK, result);

		}
		
		@PostMapping(value = "/changePassword", produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_ATOM_XML_VALUE })
		public SportyShoesGateway<?> changePassword(@RequestBody ValidUserLoginReqVO validUserLoginReqVO) {
			
			StatusResponseVO result = usersService.changePassword(validUserLoginReqVO);

			return new SportyShoesGateway<>(true, HttpStatus.OK, result);

		}
		
		@PostMapping(value = "/deleteUser", produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_ATOM_XML_VALUE })
		public SportyShoesGateway<?> deleteUser(@RequestBody DeleteRequestVO deleteRequestVO) {
			
			StatusResponseVO result = usersService.deleteUser(deleteRequestVO);

			return new SportyShoesGateway<>(true, HttpStatus.OK, result);

		}
		
		@PostMapping(value = "/getAllUsers", produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_ATOM_XML_VALUE })
		public SportyShoesGateway<?> getAllUsers() {
			
			List<GetAllUsersVO> result = usersService.getAllUsers();

			return new SportyShoesGateway<>(true, HttpStatus.OK, result);

		}
		
		@PostMapping(value = "/isValidAdminLogin", produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_ATOM_XML_VALUE })
		public SportyShoesGateway<?> isValidAdminLogin(@RequestBody ValidUserLoginReqVO validUserLoginReqVO) {
			
			StatusResponseVO result = usersService.isValidAdminLogin(validUserLoginReqVO);

			return new SportyShoesGateway<>(true, HttpStatus.OK, result);

		}
		
		@PostMapping(value = "/isValidUserLogin", produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_ATOM_XML_VALUE })
		public SportyShoesGateway<?> isValidUserLogin(@RequestBody ValidUserLoginReqVO validUserLoginReqVO) {
			
			StatusResponseVO result = usersService.isValidUserLogin(validUserLoginReqVO);

			return new SportyShoesGateway<>(true, HttpStatus.OK, result);

		}

}
