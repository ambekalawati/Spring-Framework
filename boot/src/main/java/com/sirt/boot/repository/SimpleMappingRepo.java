package com.sirt.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sirt.boot.hibernate.SimpleMapping;

@Repository
public interface SimpleMappingRepo extends JpaRepository<SimpleMapping, Integer> {

}
