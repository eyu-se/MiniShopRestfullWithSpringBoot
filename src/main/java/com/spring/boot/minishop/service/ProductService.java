package com.spring.boot.minishop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.minishop.dao.ProductDAO;
import com.spring.boot.minishop.model.Product;
import com.spring.boot.minishop.model.ProductQtyUpdate;

@Service
public class ProductService {
	
	
	@Autowired
	ProductDAO productDAO;
	
	public int createProduct(Product product) {
		if( productDAO.getProductByCode(product.getCode()) != null) {
			return 0;
		}
		int status = productDAO.create(product);
		
		return status;
	}
	
	
	public int updateProductQty(ProductQtyUpdate productQtyUpdate) {
		Product product = productDAO.getProductByCode(productQtyUpdate.getProduct_code());
		if (product == null) {
			return 0;
		}
		product.setCurrent_qty(product.getCurrent_qty() + productQtyUpdate.getQty());
		
		int status = productDAO.updateProductQty(product);
		
		return status;
	}
	
	public List<Product> getProducts(){
		return productDAO.getAll();
	}
	
	
	public List<Product> getProductsByCategory(String category){
		return productDAO.getByCategory(category);
	}
	
	
	public Product getProductByCode(String code){
		return productDAO.getProductByCode(code);
	}
	

}
