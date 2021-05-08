package com.simplilearn.neetha.dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.simplilearn.neetha.model.GetPurchaseResponseVO;
import com.simplilearn.neetha.model.MakePurchaseRequestVO;

public interface PurchaseDao {
	
	public Integer savePurchaseOrder(final MakePurchaseRequestVO makePurchaseRequestVO);
	
	public void deletePurchaseOrder(final Integer id);
	
	public List<GetPurchaseResponseVO> getPurchaseByUser(String userId);
	
	public List<GetPurchaseResponseVO> getPurchaseByCategory(String category);
	
	public List<GetPurchaseResponseVO> getPurchaseByDate(LocalDate purchaseDate);

}
