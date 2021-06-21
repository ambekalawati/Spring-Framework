package com.sirt.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sirt.boot.hibernate.associationmapping.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {

}
