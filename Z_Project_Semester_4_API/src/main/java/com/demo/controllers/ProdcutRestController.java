//package com.demo.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.MimeTypeUtils;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.demo.models.Product;
//import com.demo.models.ProductInfo;
//import com.demo.models.ProductInfoCreate;
//import com.demo.models.ProductInfoUpdate;
//import com.demo.services.ProductService;
//
//@RestController
//@RequestMapping("api/product")
//public class ProdcutRestController {
//	
//	@Autowired
//	private ProductService productService;
//	
//	@RequestMapping(value = "findall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Iterable<Product>> findall(){
//		try {
//			return new ResponseEntity<Iterable<Product>>(productService.findAll(), HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<Iterable<Product>>( HttpStatus.BAD_REQUEST);
//			
//		}
//	}
//	
//	@RequestMapping(value = "findall2", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<ProductInfo>> findall2(){
//		try {
//			return new ResponseEntity<List<ProductInfo>>(productService.findAll2(), HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<List<ProductInfo>>( HttpStatus.BAD_REQUEST);
//			
//		}
//	}
//	
//	@RequestMapping(value = "findbyid/{id}", method = RequestMethod.GET,	
//			produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<ProductInfo> findbyid(@PathVariable("id") int id){
//		try {
//		
//			return new ResponseEntity<ProductInfo>(productService.findByClient(id), HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<ProductInfo>( HttpStatus.BAD_REQUEST);
//			
//		}
//	}
//	
//	
//	@RequestMapping(value = "search/{min}/{max}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<ProductInfo>> search(@PathVariable("min") double min, @PathVariable("max") double max){
//		try {
//			return new ResponseEntity<List<ProductInfo>>(productService.searchByPrice(min, max), HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<List<ProductInfo>>( HttpStatus.BAD_REQUEST);
//			
//		}
//	}
//	
//
//	@RequestMapping(value = "create", method = RequestMethod.POST,
//			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE,
//			produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<ProductInfo> create(@RequestBody ProductInfoCreate productInfoCreate){
//		try {
//		
//			return new ResponseEntity<ProductInfo>(productService.create(productInfoCreate), HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<ProductInfo>( HttpStatus.BAD_REQUEST);
//			
//		}
//	}
//	
//	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT,
//			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE,
//			produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
//	public ResponseEntity<ProductInfo> create(@PathVariable("id") int id, @RequestBody ProductInfoUpdate productInfoUpdate){
//		try {
//		
//			return new ResponseEntity<ProductInfo>(productService.update(id, productInfoUpdate), HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<ProductInfo>( HttpStatus.BAD_REQUEST);
//			
//		}
//	}
//	
//	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Void> delete(@PathVariable("id") int id){
//		try {
//			productService.delete(id);
//			return new ResponseEntity<Void>( HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<Void>( HttpStatus.BAD_REQUEST);
//			
//		}
//	}
//	
//}
