package com.sirt.boot.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sirt.boot.hibernate.entity.Employee;
import com.sirt.boot.hibernate.repository.EmployeeRepo;
import com.sirt.boot.hibernate.repository.EmployeeRepository;

@RestController
public class HibernateController {
	@Autowired
	private EmployeeRepo empRepo;
	@Autowired
	private EmployeeRepository empRepository;

	@GetMapping(path = "/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {
		Employee emp = empRepo.findById(id).get();

		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	@GetMapping(path = "/employees")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> empList = empRepo.findFirstXEmployee();

		return new ResponseEntity<>(empList, HttpStatus.OK); 
	}
	
	@GetMapping(path = "/employees/v2/{pageNo}/{pageSize}")
	public ResponseEntity<List<Employee>> getAllEmployeeV2(@PathVariable("pageNo") int pageNo,@PathVariable("pageSize")int pageSize) {
		PageRequest paging = PageRequest.of(pageNo, pageSize,Sort.by("firstName").ascending());
//		PageRequest.of(pageNo, size, sort)
		Page<Employee> empList = empRepository.findAll(paging); 
//		if(empList.hasContent()) {
//			List<Employee> content = empList.getContent();
//		}
		return new ResponseEntity<>(empList.getContent(), HttpStatus.OK); 
	} 

}
