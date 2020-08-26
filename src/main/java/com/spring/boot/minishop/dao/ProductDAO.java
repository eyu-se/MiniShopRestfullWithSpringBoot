package com.spring.boot.minishop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.boot.minishop.model.Product;

@Repository
public class ProductDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int create(Product product) {

		String sql = "insert into product(code,title,description, category, price, init_qty, current_qty) values(?,?,?,?,?,?,?)";

		try {
			int counter = jdbcTemplate.update(sql,
					new Object[] { product.getCode(), product.getTitle(), product.getDescription(),
							product.getCategory(), product.getPrice(), product.getInit_qty(),
							product.getCurrent_qty() });
			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<Product> getAll() {
		List<Product> products = jdbcTemplate.query("SELECT * FROM product", new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product pro = new Product();
				pro.setCode(rs.getString("code"));
				pro.setTitle(rs.getString("title"));
				pro.setDescription(rs.getString("description"));
				pro.setCategory(rs.getString("category"));
				pro.setPrice(rs.getDouble("price"));
				pro.setInit_qty(rs.getInt("init_qty"));
				pro.setCurrent_qty(rs.getInt("current_qty"));
				pro.setInsert_date(rs.getDate("insert_date"));
				return pro;
			}
		});
		return products;
	}

	public List<Product> getByCategory(String category) {
		List<Product> products = jdbcTemplate.query("SELECT * FROM product where category=?", new Object[] {category},
				new RowMapper<Product>() {

					@Override
					public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
						Product pro = new Product();
						pro.setCode(rs.getString("code"));
						pro.setTitle(rs.getString("title"));
						pro.setDescription(rs.getString("description"));
						pro.setCategory(rs.getString("category"));
						pro.setPrice(rs.getDouble("price"));
						pro.setInit_qty(rs.getInt("init_qty"));
						pro.setCurrent_qty(rs.getInt("current_qty"));
						pro.setInsert_date(rs.getDate("insert_date"));
						return pro;
					}
				});
		return products;
	}
	
	
	
	public Product getProductByCode(String code) {
		List<Product> products = jdbcTemplate.query("SELECT * FROM product where code=?", new Object[] {code},
				new RowMapper<Product>() {

					@Override
					public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
						Product pro = new Product();
						pro.setCode(rs.getString("code"));
						pro.setTitle(rs.getString("title"));
						pro.setDescription(rs.getString("description"));
						pro.setCategory(rs.getString("category"));
						pro.setPrice(rs.getDouble("price"));
						pro.setInit_qty(rs.getInt("init_qty"));
						pro.setCurrent_qty(rs.getInt("current_qty"));
						pro.setInsert_date(rs.getDate("insert_date"));
						return pro;
					}
				});
		
		if(products.size() != 0) {
			return products.get(0);
		}
		return null;
	}
	
	public int updateProductQty(Product product) {
		
		String sql = "update  product set current_qty=? where code=?";
		 
		try {
 
			int counter = jdbcTemplate.update(sql,new Object[] { product.getCurrent_qty(), product.getCode() });
			return counter;
 
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	
	}
}
