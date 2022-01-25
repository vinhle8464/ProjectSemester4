package com.demo.repositories.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.models.Rating;

@Repository
public interface RatingRepositoryAdmin extends JpaRepository<Rating, Integer> {

	
}
