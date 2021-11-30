//package com.demo.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.demo.models.Category;
//import com.demo.models.Product;
//import com.demo.models.ProductInfo;
//import com.demo.models.ProductInfoCreate;
//import com.demo.models.ProductInfoUpdate;
//import com.demo.repositories.ProductRepository;
//
//@Service
//public class ProductServiceImpl implements ProductService {
//
//	@Autowired
//	private ProductRepository productRepository;
//
//	@Autowired
//	private CategoryService categoryService;
//	
//	
//	@Override
//	public Iterable<Product> findAll() {
//		return productRepository.findAll();
//	}
//
//	@Override
//	public List<ProductInfo> findAll2() {
//		return productRepository.findAll2();
//	}
//
//	@Override
//	public List<ProductInfo> searchByPrice(double min, double max) {
//		return productRepository.searchByPrice(min, max);
//	}
//
//	@Override
//	public ProductInfo create(ProductInfoCreate productInfoCreate) {
//		Product product = new Product();
//		Category category = new Category();
//		category.setId(productInfoCreate.getCategoryId());
//		product.setCategory(category);
//		product.setCreated(productInfoCreate.getCreated());
//		product.setDescription(productInfoCreate.getDescription());
//		product.setName(productInfoCreate.getName());
//		product.setPrice(productInfoCreate.getPrice());
//		product.setQuantity(productInfoCreate.getQuantity());
//		product.setStatus(productInfoCreate.isStatus());
//		product = productRepository.save(product);
//		product.getCategory().setName(categoryService.find(product.getCategory().getId()).getName());
//		return new ProductInfo(productRepository.save(product));
//	}
//
//	
//
//	@Override
//	public Product find(int id) {
//		return productRepository.findById(id).get();
//	}
//	
//	@Override
//	public ProductInfo update(int id, ProductInfoUpdate productInfoUpdate) {
//		Product product = find(id);
//		product.setName(productInfoUpdate.getName());
//		product.setPrice(productInfoUpdate.getPrice());
//		product.setStatus(productInfoUpdate.isStatus());
//		productRepository.save(product);
//		return new ProductInfo(product);
//	}
//
//	@Override
//	public void delete(int id) {
//		productRepository.deleteById(id);
//	}
//
//	@Override
//	public ProductInfo findByClient(int id) {
//		
//		return new ProductInfo(find(id));
//	}
//	
//}
