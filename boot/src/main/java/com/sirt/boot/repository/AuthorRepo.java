package com.sirt.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sirt.boot.hibernate.associationmapping.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {

}
