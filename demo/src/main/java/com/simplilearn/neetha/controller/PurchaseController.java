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
import com.simplilearn.neetha.model.GetPurchaseByCategoryReqVO;
import com.simplilearn.neetha.model.GetPurchaseByDateReqVO;
import com.simplilearn.neetha.model.GetPurchaseByUserReqVO;
import com.simplilearn.neetha.model.GetPurchaseResponseVO;
import com.simplilearn.neetha.model.MakePurchaseRequestVO;
import com.simplilearn.neetha.model.MakePurchaseResponseVO;
import com.simplilearn.neetha.model.StatusResponseVO;
import com.simplilearn.neetha.service.PurchaseService;

@RestController
@RequestMapping(RequestUrls.purchaseClassURL)
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	private static final Logger logger=LoggerFactory.getLogger(PurchaseController.class);

	@PostMapping(value = "/createPurchaseOrder", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public SportyShoesGateway<?> createPurchaseOrder(@RequestBody MakePurchaseRequestVO makePurchaseRequestVO) {
		
		MakePurchaseResponseVO result = purchaseService.makePurchaseOrder(makePurchaseRequestVO);

		return new SportyShoesGateway<>(true, HttpStatus.OK, result);

	}
	
	@PostMapping(value = "/deletePurchase", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public SportyShoesGateway<?> deletePurchase(@RequestBody DeleteRequestVO deleteRequestVO) {
		
		StatusResponseVO result = purchaseService.deletePurchase(deleteRequestVO);

		return new SportyShoesGateway<>(true, HttpStatus.OK, result);

	}
	
	@PostMapping(value = "/getPurchaseByCategory", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public SportyShoesGateway<?> getPurchaseByCategory(@RequestBody GetPurchaseByCategoryReqVO getPurchaseByCategoryReqVO) {
		
		List<GetPurchaseResponseVO> result = purchaseService.getPurchaseByCategory(getPurchaseByCategoryReqVO);

		return new SportyShoesGateway<>(true, HttpStatus.OK, result);

	}
	
	@PostMapping(value = "/getPurchaseByUser", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public SportyShoesGateway<?> getPurchaseByUser(@RequestBody GetPurchaseByUserReqVO getPurchaseByUserReqVO) {
		
		List<GetPurchaseResponseVO> result = purchaseService.getPurchaseByUser(getPurchaseByUserReqVO);

		return new SportyShoesGateway<>(true, HttpStatus.OK, result);

	}
	
	@PostMapping(value = "/getPurchaseByDate", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public SportyShoesGateway<?> getPurchaseByDate(@RequestBody GetPurchaseByDateReqVO getPurchaseByDateReqVO) {
		
		List<GetPurchaseResponseVO> result = purchaseService.getPurchaseByDate(getPurchaseByDateReqVO);

		return new SportyShoesGateway<>(true, HttpStatus.OK, result);

	}

}
