package com.simplilearn.neetha.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.simplilearn.neetha.dao.ProductDao;
import com.simplilearn.neetha.model.CreateProductRequestVO;
import com.simplilearn.neetha.model.GetProductResponseVO;

@Repository
public class ProductDaoImpl extends JdbcDaoSupport implements ProductDao{
	
	private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

	@Autowired
	DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	@Override
	public Integer saveProduct(final CreateProductRequestVO createProductVO) {
		
		logger.info("inserting Products in db {}" + createProductVO.getBrand());
		
		String sql = "INSERT INTO product_master (brand, colour, category, shoe_size, price) VALUES (:brand, :colour, :category, :shoeSize, :price)";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(createProductVO);

		int count = namedParameterJdbcTemplate.update(sql, parameterSource);

		if(count > 0) {
			System.out.println("Products were created successfully");
		} else {
			System.out.println("Products were not created");
		}
		
		return count;
	}
	
	@Override
	public void deleteProduct(final Integer id) {
		
		String sql = "delete from product_master where id = :id";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);

		namedParameterJdbcTemplate.update(sql, namedParameters);
		
	}
	
	@Override
	public void updatePrice(final Integer id, Double price) {
		
		String sql = "update product_master set price = :price where id = :id";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("price", price).addValue("id", id);

		namedParameterJdbcTemplate.update(sql, namedParameters);
		
	}
	
	@Override
	public List<GetProductResponseVO> getProductsByCategory(String category) {
		String sql = "select * from product_master where category=:category";
		SqlParameterSource parameterSource =  new MapSqlParameterSource("category",category);
		List<GetProductResponseVO> data = namedParameterJdbcTemplate.query(sql, parameterSource, BeanPropertyRowMapper.newInstance(GetProductResponseVO.class));
		return data;
	}
	
	

}
