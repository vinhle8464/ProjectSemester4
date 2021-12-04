package com.demo.services;

import java.util.List;

import com.demo.models.Account;
import com.demo.models.Role;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AccountAPIService {

	@GET("user/findbyid/{username}")
	public Account findById(@Path("username") String username);
	
	@POST("user/account/create")
	Call<Account> create(@Body Account account);
	
//	@GET("product/findall2")
//	Call<List<Product>> findAll();
//	
//	@GET("product/search/{min}/{max}")
//	Call<List<Product>> search(@Path("min") double min, @Path("max") double max);
//	
//	@GET("findbyid/{id}")
//	Call<Product> find(@Path("id") int id);
//	

//	
//	@PUT("product/update/{id}")
//	Call<Product> update(@Path("id") int id, @Body Product product);
//	
//	@DELETE("product/delete/{id}")
//	Call<Void> delete(@Path("id") int id);
}
