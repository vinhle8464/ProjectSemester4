package com.demo.repositories.admin;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.models.Salary;

@Repository
public interface SalaryRepositoryAdmin extends JpaRepository<Salary, Integer> {


	@Query(value = "select * from Salary order by salary_id desc limit 1", nativeQuery = true)
	public Salary findNewestSalary(); 
	
	@Query(value = "select * from Salary where accountId = :accountId order by salary_id desc limit 1", nativeQuery = true)
	public Salary findNewestSalaryByAccountId(@Param("accountId") int accountId); 
}
