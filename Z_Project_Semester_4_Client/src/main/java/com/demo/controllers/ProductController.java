//package com.demo.controllers;
//
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.demo.models.Product;
//import com.demo.services.APIClient;
//import com.demo.services.ProductAPIService;
//
//@Controller
//@RequestMapping(value = { "", "product" })
//public class ProductController {
//
//	@RequestMapping(value = { "", "index" }, method = RequestMethod.GET)
//	public String index(ModelMap modelMap) {
//		try {
//			ProductAPIService productAPIService = APIClient.getClient().create(ProductAPIService.class);
//			List<Product> products = productAPIService.findAll().execute().body();
//			modelMap.put("products", products);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		return "product/index";
//	}
//
//	@RequestMapping(value = { "create" }, method = RequestMethod.GET)
//	public String create(ModelMap modelMap) {
//
//		Product product = new Product();
//		modelMap.put("product", product);
//
//		return "product/create";
//	}
//
//	@RequestMapping(value = { "create" }, method = RequestMethod.POST)
//	public String create(@ModelAttribute("product") Product product) {
//		try {
//			ProductAPIService productAPIService = APIClient.getClient().create(ProductAPIService.class);
//			productAPIService.create(product).execute().body();
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		return "redirect:/product/index";
//	}
//
//	@RequestMapping(value = { "update/{id}" }, method = RequestMethod.GET)
//	public String update(@PathVariable("id") int id, ModelMap modelMap) {
//		try {
//			ProductAPIService productAPIService = APIClient.getClient().create(ProductAPIService.class);
//			Product product = productAPIService.find(id).execute().body();
//			modelMap.put("product", product);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		return "product/update";
//	}
//
//	@RequestMapping(value = {"", "update" }, method = RequestMethod.POST)
//	public String update(@ModelAttribute("product") Product product) {
//		try {
//			ProductAPIService productAPIService = APIClient.getClient().create(ProductAPIService.class);
//			productAPIService.update(product.getId(), product).execute().body();
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		return "redirect:/product/index";
//	}
////
////	@RequestMapping(value = {"delete/{id}" }, method = RequestMethod.GET)
////	public String delete(@PathVariable("id") int id) {
////		try {
////			ProductAPIService productAPIService = APIClient.getClient().create(ProductAPIService.class);
////			productAPIService.delete(id).execute().isSuccessful();
////
////		} catch (Exception e) {
////			System.out.println(e.getMessage());
////		}
////		
////	
////		return "product/index";
////	}
//	
//	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
//	public String delete(@RequestParam("id") int id)
//	{
//		System.out.println("id: " + id);
//		return "product/delete";
//	}
//
//}
