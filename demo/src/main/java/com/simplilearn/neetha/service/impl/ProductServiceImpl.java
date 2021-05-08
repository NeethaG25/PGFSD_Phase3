package com.simplilearn.neetha.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.neetha.dao.ProductDao;
import com.simplilearn.neetha.exception.GlobalException;
import com.simplilearn.neetha.model.CreateProductResponseVO;
import com.simplilearn.neetha.model.DeleteRequestVO;
import com.simplilearn.neetha.model.GetProductRequestVO;
import com.simplilearn.neetha.model.GetProductResponseVO;
import com.simplilearn.neetha.model.StatusResponseVO;
import com.simplilearn.neetha.model.UpdatePriceReqVO;
import com.simplilearn.neetha.model.CreateProductRequestVO;
import com.simplilearn.neetha.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public CreateProductResponseVO createProduct(CreateProductRequestVO createProductVO) {
		
		CreateProductResponseVO createProductResponseVO = new CreateProductResponseVO();
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String className = this.getClass().getName();
		
		if (StringUtils.isEmpty(createProductVO.getBrand())) {
			throw new GlobalException("Shoe Brand cannot be empty", className,methodName);
		}
		
		if (StringUtils.isEmpty(createProductVO.getCategory())) {
			throw new GlobalException("Shoe Category cannot be empty", className,methodName);
		}
		
		if (StringUtils.isEmpty(createProductVO.getColour())) {
			throw new GlobalException("Shoe Colour cannot be empty", className,methodName);
		}
		
		if (createProductVO.getShoeSize().equals(null)) {
			throw new GlobalException("Shoe Colour cannot be empty", className,methodName);
		}
		
		if (createProductVO.getShoeSize()<=0) {
			throw new GlobalException("Shoe Size cannot be 0 or less than 0", className,methodName);
		}
		
		if (createProductVO.getPrice().equals(null)) {
			throw new GlobalException("Shoe Price cannot be 0 or less than 0", className,methodName);
		}
		
		if (createProductVO.getPrice()<=0) {
			throw new GlobalException("Shoe Price cannot be 0 or less than 0", className,methodName);
		}
		
		Integer count = productDao.saveProduct(createProductVO);
		
		if(count>0) {
			createProductResponseVO.setStatus("The Product was created successfully");
		} else {
			createProductResponseVO.setStatus("The Product was not created successfully");
		}
		
		return createProductResponseVO;
	}
	
	@Override
	public StatusResponseVO updatePrice(UpdatePriceReqVO updatePriceReqVO) {
		
		StatusResponseVO deleteResponseVO = new StatusResponseVO();
		
		productDao.updatePrice(updatePriceReqVO.getId(),updatePriceReqVO.getPrice());
		
		deleteResponseVO.setStatus("The Price has been updated");
		
		return deleteResponseVO;
		
	}
	
	@Override
	public StatusResponseVO deleteProduct(DeleteRequestVO deleteRequestVO) {
		
		StatusResponseVO statusResponseVO = new StatusResponseVO();
		
		productDao.deleteProduct(deleteRequestVO.getId());
		
		statusResponseVO.setStatus("The Product has been deleted");
		
		return statusResponseVO;
		
	}
	
	@Override
	public List<GetProductResponseVO> getProductByCategory(GetProductRequestVO getProductRequestVO) {
		
		
		List<GetProductResponseVO> getProductResponseVOList= productDao.getProductsByCategory(getProductRequestVO.getCategory());
		
		
		
		return getProductResponseVOList;
		
	}

}
