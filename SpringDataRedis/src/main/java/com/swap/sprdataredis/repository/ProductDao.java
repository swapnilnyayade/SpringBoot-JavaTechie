package com.swap.sprdataredis.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.swap.sprdataredis.entity.Product;


@Repository
public class ProductDao {

	public static final String HASH_KEY = "Product";
	
	private Logger logger = LoggerFactory.getLogger(ProductDao.class);
	
	@Autowired
	private RedisTemplate template;
	
	public Product save(Product product) {
		template.opsForHash().put(HASH_KEY, product.getId(), product);
		return product;
	}
	
	public List<Product> findall(){
		return template.opsForHash().values(HASH_KEY);
	}
	
	public Product findProductById(int id) {
		return (Product)template.opsForHash().get(HASH_KEY, id);
	}
	
	public Product update(Product product) {
		
		template.opsForHash().put(HASH_KEY, product.getId(), product);
		return product;
	}
	
	public String deleteProduct(int id) {
		template.opsForHash().delete(HASH_KEY, id);
		return "Product Deleted!!";
	}
}
