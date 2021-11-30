//package com.demo.repositories;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import com.demo.models.Product;
//import com.demo.models.ProductInfo;
//
//@Repository
//public interface ProductRepository extends CrudRepository<Product, Integer>{
//
//	@Query("select new com.demo.models.ProductInfo(id, name, price, quantity, status, created, description, category.id, category.name) from Product ")
//	public List<ProductInfo> findAll2();
//	
//	@Query("select new com.demo.models.ProductInfo(id, name, price, quantity, status, created, description, category.id, category.name) from Product where price >= :min and price <= :max")
//	public List<ProductInfo> searchByPrice(@Param("min") double min, @Param("max") double max);
//	
//	
//}
