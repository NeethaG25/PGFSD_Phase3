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

import com.simplilearn.neetha.service.ProductService;
import com.simplilearn.neetha.constants.RequestUrls;
import com.simplilearn.neetha.gateway.SportyShoesGateway;
import com.simplilearn.neetha.model.CreateProductRequestVO;
import com.simplilearn.neetha.model.CreateProductResponseVO;
import com.simplilearn.neetha.model.DeleteRequestVO;
import com.simplilearn.neetha.model.GetProductRequestVO;
import com.simplilearn.neetha.model.GetProductResponseVO;
import com.simplilearn.neetha.model.StatusResponseVO;
import com.simplilearn.neetha.model.UpdatePriceReqVO;


@RestController
@RequestMapping(RequestUrls.productClassURL)
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	private static final Logger logger=LoggerFactory.getLogger(ProductController.class);

	@PostMapping(value = "/createProduct", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public SportyShoesGateway<?> createProduct(@RequestBody CreateProductRequestVO createProductRequestVO) {
		
		CreateProductResponseVO result = productService.createProduct(createProductRequestVO);

		return new SportyShoesGateway<>(true, HttpStatus.OK, result);

	}

	@PostMapping(value = "/updatePrice", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public SportyShoesGateway<?> updatePrice(@RequestBody UpdatePriceReqVO updatePriceReqVO) {
		
		StatusResponseVO result = productService.updatePrice(updatePriceReqVO);

		return new SportyShoesGateway<>(true, HttpStatus.OK, result);

	}
	
	@PostMapping(value = "/deleteProduct", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public SportyShoesGateway<?> deleteProduct(@RequestBody DeleteRequestVO deleteRequestVO) {
		
		StatusResponseVO result = productService.deleteProduct(deleteRequestVO);

		return new SportyShoesGateway<>(true, HttpStatus.OK, result);

	}
	
	@PostMapping(value = "/getProductByCategory", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE })
	public SportyShoesGateway<?> getProductByCategory(@RequestBody GetProductRequestVO getProductRequestVO) {
		
		List<GetProductResponseVO> result = productService.getProductByCategory(getProductRequestVO);

		return new SportyShoesGateway<>(true, HttpStatus.OK, result);

	}

}
