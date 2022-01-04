package com.demo.repositories.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.Email;
import com.demo.models.Pack;

@Repository
public interface PricingRepository extends CrudRepository<Pack, Integer>{

}
