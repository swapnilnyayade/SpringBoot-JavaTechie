package com.swap.sprdataredis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swap.sprdataredis.entity.Product;
import com.swap.sprdataredis.repository.ProductDao;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductDao dao;
	
	@PostMapping
	public Product save(@RequestBody Product product) {
		return dao.save(product);
	}
	
	@GetMapping
	public List<Product> getAllProducts() {
		return dao.findall();
	}
	
	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id) {
		return dao.findProductById(id);
	}
	
	@PutMapping("/{id}")
	public Product upgrade(@PathVariable int id, @RequestBody Product product) {
		product.setId(id);
		return dao.update(product);
	}
	
	@DeleteMapping("/{id}")
	public String remove(@PathVariable int id) {
		return dao.deleteProduct(id);
	}

}
