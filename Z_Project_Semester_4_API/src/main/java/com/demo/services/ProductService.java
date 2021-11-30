//package com.demo.services;
//
//import java.util.List;
//
//import org.springframework.data.repository.query.Param;
//
//import com.demo.models.Product;
//import com.demo.models.ProductInfo;
//import com.demo.models.ProductInfoCreate;
//import com.demo.models.ProductInfoUpdate;
//
//public interface ProductService {
//	
//	public Product find(int id);
//	
//	public ProductInfo findByClient(int id);
//	
//	public Iterable<Product> findAll();
//	
//	public List<ProductInfo> findAll2();
//	
//	public List<ProductInfo> searchByPrice(double min, double max);
//	
//	public ProductInfo create(ProductInfoCreate productInfoCreate);
//	
//	public ProductInfo update(int id, ProductInfoUpdate productInfoUpdate);
//	
//	public void delete(int id);
//}
