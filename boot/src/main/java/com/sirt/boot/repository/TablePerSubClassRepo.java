package com.sirt.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sirt.boot.hibernate.inheritancemapping.Student;

public interface TablePerSubClassRepo extends JpaRepository<Student, Integer> {

}