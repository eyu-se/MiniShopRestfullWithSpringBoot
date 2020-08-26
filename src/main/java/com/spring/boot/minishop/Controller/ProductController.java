package com.spring.boot.minishop.Controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.minishop.model.ErrorResponse;
import com.spring.boot.minishop.model.Product;
import com.spring.boot.minishop.model.ProductQtyUpdate;
import com.spring.boot.minishop.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	
	@Autowired
	ProductService productService;
	
	
	@PostMapping("/products")
	public ResponseEntity<Object> addUser(@Valid @RequestBody Product product, Errors errors) {
		
		if(errors.hasErrors()) {
			ErrorResponse err = new ErrorResponse();
			err.setMessage(errors.getAllErrors()
				.stream()
				.map(x -> x.getDefaultMessage())
				.collect(Collectors.joining(",")));
			
			return new ResponseEntity<Object>(err, HttpStatus.BAD_REQUEST);
			
			
		}
		
		int status = productService.createProduct(product);
		if(status == 0) {
			
			return new ResponseEntity<Object>("Unable to create the product", HttpStatus.INTERNAL_SERVER_ERROR);
			
			
		}
			
		
		return ResponseEntity.ok(product); // shortest way to write return new ResponseEntity<Object>(user, HttpStatus.OK);
		
		
		
	}
	
	
	@PostMapping("/products/updateqty")
	public ResponseEntity<Object> updateQty(@Valid @RequestBody ProductQtyUpdate productQtyUpdate, Errors errors) {
		
		if(errors.hasErrors()) {
			ErrorResponse err = new ErrorResponse();
			err.setMessage(errors.getAllErrors()
				.stream()
				.map(x -> x.getDefaultMessage())
				.collect(Collectors.joining(",")));
			
			return new ResponseEntity<Object>(err, HttpStatus.BAD_REQUEST);
			
			
		}
		
		int status = productService.updateProductQty(productQtyUpdate);
		if(status == 0) {
			
			return new ResponseEntity<Object>("Unable to update the product's quantity", HttpStatus.INTERNAL_SERVER_ERROR);
			
			
		}
			
		
		return ResponseEntity.ok(productQtyUpdate); // shortest way to write return new ResponseEntity<Object>(user, HttpStatus.OK);
		
		
		
	}
	
	@GetMapping("/products")
	public ResponseEntity<Object> getProducts() {
		
		
		List<Product> products = productService.getProducts();
		

		
		return ResponseEntity.ok(products); // shortest way to write return new ResponseEntity<Object>(user, HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/products/{category}")
	public ResponseEntity<Object> getProductsByCategory(@PathVariable("category") String category) {
		
		
		List<Product> products = productService.getProductsByCategory(category);
		
		
		return ResponseEntity.ok(products); // shortest way to write return new ResponseEntity<Object>(user, HttpStatus.OK);	
	}
	
	@GetMapping("/products/find/{code}")
	public ResponseEntity<Object> getProductBycode(@PathVariable("code") String code) {
		
		
		Product product = productService.getProductByCode(code);
		
		
		return ResponseEntity.ok(product); // shortest way to write return new ResponseEntity<Object>(user, HttpStatus.OK);
		
		
	}
	
	
	
	
	
}
