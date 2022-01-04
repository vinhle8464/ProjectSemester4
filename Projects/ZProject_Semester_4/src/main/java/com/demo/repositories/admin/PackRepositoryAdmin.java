package com.demo.repositories.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entites.PackAjax;
import com.demo.models.Pack;

@Repository
public interface PackRepositoryAdmin extends JpaRepository<Pack, Integer> {


	@Query("select new com.demo.entites.PayAjax(packId, title, expiry, fee, description, status) from Pack where packId = :packId")
	public PackAjax findByIdAjax(@Param("packId") int packId);
	
}
