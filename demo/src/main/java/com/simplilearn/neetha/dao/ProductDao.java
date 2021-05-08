package com.simplilearn.neetha.dao;

import java.util.List;

import com.simplilearn.neetha.model.CreateProductRequestVO;
import com.simplilearn.neetha.model.GetProductResponseVO;

public interface ProductDao {
	
	public Integer saveProduct(final CreateProductRequestVO createProductVO);
	
	public void deleteProduct(final Integer id);
	
	public void updatePrice(final Integer id, Double price);
	
	public List<GetProductResponseVO> getProductsByCategory(String category);

}
