package com.simplilearn.neetha.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.neetha.dao.PurchaseDao;
import com.simplilearn.neetha.exception.GlobalException;
import com.simplilearn.neetha.model.DeleteRequestVO;
import com.simplilearn.neetha.model.GetProductRequestVO;
import com.simplilearn.neetha.model.GetProductResponseVO;
import com.simplilearn.neetha.model.GetPurchaseByCategoryReqVO;
import com.simplilearn.neetha.model.GetPurchaseByDateReqVO;
import com.simplilearn.neetha.model.GetPurchaseByUserReqVO;
import com.simplilearn.neetha.model.GetPurchaseResponseVO;
import com.simplilearn.neetha.model.MakePurchaseRequestVO;
import com.simplilearn.neetha.model.MakePurchaseResponseVO;
import com.simplilearn.neetha.model.StatusResponseVO;
import com.simplilearn.neetha.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired
	private PurchaseDao purchaseDap;
	
	@Override
	public MakePurchaseResponseVO makePurchaseOrder(MakePurchaseRequestVO makePurchaseRequestVO) {
		
		MakePurchaseResponseVO makePurchaseResponseVO = new MakePurchaseResponseVO();
		String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		String className = this.getClass().getName();
		
		if (StringUtils.isEmpty(makePurchaseRequestVO.getUserId())) {
			throw new GlobalException("UserId cannot be empty", className,methodName);
		}
		
		if (makePurchaseRequestVO.getQuantity()<=0) {
			throw new GlobalException("Quantity cannot be 0 or less than 0", className,methodName);
		}
		
		if (makePurchaseRequestVO.getAmount().equals(null)) {
			throw new GlobalException("Amount cannot be empty", className,methodName);
		}
		
		if (makePurchaseRequestVO.getQuantity()<=0.00) {
			throw new GlobalException("Amount cannot be 0 or less than 0", className,methodName);
		}
		
		
		Integer count = purchaseDap.savePurchaseOrder(makePurchaseRequestVO);
		
		if(count>0) {
			makePurchaseResponseVO.setStatus("The Purchase Order was created successfully");
		} else {
			makePurchaseResponseVO.setStatus("The Purchase Order was not created successfully");
		}
		
		return makePurchaseResponseVO;
		
	}
	
	@Override
	public StatusResponseVO deletePurchase(DeleteRequestVO deleteRequestVO) {
		
		StatusResponseVO statusResponseVO = new StatusResponseVO();
		
		purchaseDap.deletePurchaseOrder(deleteRequestVO.getId());
		
		statusResponseVO.setStatus("The Purchase Order has been deleted");
		
		return statusResponseVO;
		
	}
	
	@Override
	public List<GetPurchaseResponseVO> getPurchaseByCategory(GetPurchaseByCategoryReqVO getPurchaseByCategoryReqVO) {
	
		List<GetPurchaseResponseVO> getPurchaseResponseVOList= purchaseDap.getPurchaseByCategory(getPurchaseByCategoryReqVO.getCategory());
		
		return getPurchaseResponseVOList;
		
	}
	
	@Override
	public List<GetPurchaseResponseVO> getPurchaseByUser(GetPurchaseByUserReqVO getPurchaseByUserReqVO) {
	
		List<GetPurchaseResponseVO> getPurchaseResponseVOList= purchaseDap.getPurchaseByUser(getPurchaseByUserReqVO.getUserId());
		
		return getPurchaseResponseVOList;
		
	}
	
	@Override
	public List<GetPurchaseResponseVO> getPurchaseByDate(GetPurchaseByDateReqVO getPurchaseByDateReqVO) {
	
		List<GetPurchaseResponseVO> getPurchaseResponseVOList= purchaseDap.getPurchaseByDate(getPurchaseByDateReqVO.getPurchaseDate());
		
		return getPurchaseResponseVOList;
		
	}

}
