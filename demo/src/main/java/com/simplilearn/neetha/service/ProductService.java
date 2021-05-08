package com.simplilearn.neetha.service;

import java.util.List;

import com.simplilearn.neetha.model.CreateProductRequestVO;
import com.simplilearn.neetha.model.CreateProductResponseVO;
import com.simplilearn.neetha.model.DeleteRequestVO;
import com.simplilearn.neetha.model.GetProductRequestVO;
import com.simplilearn.neetha.model.GetProductResponseVO;
import com.simplilearn.neetha.model.StatusResponseVO;
import com.simplilearn.neetha.model.UpdatePriceReqVO;

public interface ProductService {
	
	public CreateProductResponseVO createProduct(CreateProductRequestVO createProductVO);
	
	public StatusResponseVO updatePrice(UpdatePriceReqVO updatePriceReqVO);
	
	public StatusResponseVO deleteProduct(DeleteRequestVO deleteRequestVO);
	
	public List<GetProductResponseVO> getProductByCategory(GetProductRequestVO getProductRequestVO);

}
