package com.sirt.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sirt.boot.hibernate.CollectionMapping;

public interface CollectionMappingRepo extends JpaRepository<CollectionMapping,Integer > {

}
