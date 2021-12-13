package com.demo.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.models.Pay;
import com.demo.repositories.user.PayRepository;

@Service
public class PayServiceImpl implements PayService{

	@Autowired
	private PayRepository payRepository;
	
	@Override
	public Pay save(Pay pay) {
		return payRepository.save(pay);
	}

}
