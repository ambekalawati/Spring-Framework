package com.sirt.boot.hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sirt.boot.hibernate.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	@Query(value = "select * from employees limit 500", nativeQuery = true)
	public List<Employee> findFirstXEmployee();
}
