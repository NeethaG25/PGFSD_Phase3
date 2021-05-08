package com.simplilearn.neetha.service;

import java.util.List;

import com.simplilearn.neetha.model.DeleteRequestVO;
import com.simplilearn.neetha.model.GetPurchaseByCategoryReqVO;
import com.simplilearn.neetha.model.GetPurchaseByDateReqVO;
import com.simplilearn.neetha.model.GetPurchaseByUserReqVO;
import com.simplilearn.neetha.model.GetPurchaseResponseVO;
import com.simplilearn.neetha.model.MakePurchaseRequestVO;
import com.simplilearn.neetha.model.MakePurchaseResponseVO;
import com.simplilearn.neetha.model.StatusResponseVO;

public interface PurchaseService {
	
	public MakePurchaseResponseVO makePurchaseOrder(MakePurchaseRequestVO makePurchaseRequestVO);
	
	public StatusResponseVO deletePurchase(DeleteRequestVO deleteRequestVO);
	
	public List<GetPurchaseResponseVO> getPurchaseByCategory(GetPurchaseByCategoryReqVO getPurchaseByCategoryReqVO);
	
	public List<GetPurchaseResponseVO> getPurchaseByUser(GetPurchaseByUserReqVO getPurchaseByUserReqVO);
	
	public List<GetPurchaseResponseVO> getPurchaseByDate(GetPurchaseByDateReqVO getPurchaseByDateReqVO);
	
	

}
