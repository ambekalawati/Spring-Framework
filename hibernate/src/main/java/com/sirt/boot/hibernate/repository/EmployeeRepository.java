package com.sirt.boot.hibernate.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sirt.boot.hibernate.entity.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {

}
