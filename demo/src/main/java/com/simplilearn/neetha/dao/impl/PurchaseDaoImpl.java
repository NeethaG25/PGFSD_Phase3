package com.simplilearn.neetha.dao.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.simplilearn.neetha.dao.PurchaseDao;
import com.simplilearn.neetha.model.GetPurchaseResponseVO;
import com.simplilearn.neetha.model.MakePurchaseRequestVO;

@Repository
public class PurchaseDaoImpl extends JdbcDaoSupport implements PurchaseDao{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	@Override
	public Integer savePurchaseOrder(final MakePurchaseRequestVO makePurchaseRequestVO) {
		
		logger.info("inserting Purchase Order in db {}" + makePurchaseRequestVO);
		
		String sql = "INSERT INTO purchase_orders (userId, productId, quantity, amount, purchase_date) VALUES (:userId, :productId, :quantity, :amount, now())";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(makePurchaseRequestVO);

		int count = namedParameterJdbcTemplate.update(sql, parameterSource);

		if(count > 0) {
			System.out.println("Purchase Order was created successfully");
		} else {
			System.out.println("Purchase Order was not created");
		}
		
		return count;
	}
	
	@Override
	public void deletePurchaseOrder(final Integer id) {
		
		String sql = "delete from purchase_orders where id = :id";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);

		namedParameterJdbcTemplate.update(sql, namedParameters);
		
	}
	
	@Override
	public List<GetPurchaseResponseVO> getPurchaseByUser(String userId) {
		String sql = "select * from purchase_orders where userId=:userId";
		SqlParameterSource parameterSource =  new MapSqlParameterSource("userId",userId);
		List<GetPurchaseResponseVO> data = namedParameterJdbcTemplate.query(sql, parameterSource, BeanPropertyRowMapper.newInstance(GetPurchaseResponseVO.class));
		return data;
	}
	
	@Override
	public List<GetPurchaseResponseVO> getPurchaseByCategory(String category) {
		System.out.println("Category : "+category);
		String sql = "select * from purchase_orders where category=:category";
		SqlParameterSource parameterSource =  new MapSqlParameterSource("category",category);
		List<GetPurchaseResponseVO> data = namedParameterJdbcTemplate.query(sql, parameterSource, BeanPropertyRowMapper.newInstance(GetPurchaseResponseVO.class));
		return data;
	}
	
	@Override
	public List<GetPurchaseResponseVO> getPurchaseByDate(LocalDate purchaseDate) {
		String sql = "select * from purchase_orders where purchase_date=:purchaseDate";
		SqlParameterSource parameterSource =  new MapSqlParameterSource("purchaseDate",purchaseDate);
		List<GetPurchaseResponseVO> data = namedParameterJdbcTemplate.query(sql, parameterSource, BeanPropertyRowMapper.newInstance(GetPurchaseResponseVO.class));
		return data;
	}

}
