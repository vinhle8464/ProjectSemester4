package com.demo.services;

import java.util.List;

import com.demo.models.Product;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProductAPIService {
	

	@GET("product/findall2")
	Call<List<Product>> findAll();
	
	@GET("product/search/{min}/{max}")
	Call<List<Product>> search(@Path("min") double min, @Path("max") double max);
	
	@GET("findbyid/{id}")
	Call<Product> find(@Path("id") int id);
	
	@POST("product/create")
	Call<Product> create(@Body Product product);
	
	@PUT("product/update/{id}")
	Call<Product> update(@Path("id") int id, @Body Product product);
	
	@DELETE("product/delete/{id}")
	Call<Void> delete(@Path("id") int id);
	
	
	
	
}
