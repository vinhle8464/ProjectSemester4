package com.demo.services.admin;

import java.util.List;

import com.demo.models.Pay;
public interface PayServiceAdmin {

		public Pay find(int payId);
		
		public List<Pay> findAllPay();
		
}
