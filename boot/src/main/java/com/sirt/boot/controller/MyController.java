package com.sirt.boot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.SSLEngineResult.Status;
import javax.validation.Valid;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sirt.boot.hibernate.CollectionMapping;
import com.sirt.boot.hibernate.SimpleMapping;
import com.sirt.boot.repository.CollectionMappingRepo;
import com.sirt.boot.repository.SimpleMappingRepo;
import com.sirt.boot.repository.StudentRepo;
import com.sirt.boot.service.StudentService;
import com.sirt.boot.sms.SMSSender;
import com.sirt.boot.vo.SMSRequest;
import com.sirt.boot.vo.Student;

import lombok.extern.slf4j.Slf4j;

/**
 * Important MVC Annotations :- 1. @RestController 2. @Controller
 * 3. @RequestMapping 4. @GetMapping 5. @PostMapping 6. @PutMapping
 * 7. @PathVariable 8. @RequestBody 9. @QueryString 10. @ResponseBody
 *
 * @author Ambe Kalawati
 *
 */
@Slf4j
@RestController
public class MyController {
	@Autowired
	private StudentService service;
	@Autowired
	private SMSSender smsSender;
	@Autowired
	private SimpleMappingRepo repo;
	@Autowired
	private CollectionMappingRepo cmRepo;

	@GetMapping("/test")
	public String hibernateTest() {
		SimpleMapping sm = new SimpleMapping();
		sm.setAccountNo(123);
		sm.setAccountBalance(1000.20);
		sm.setAccountType("Saving");
		sm.setOpenDate(new Date());
		repo.save(sm);
		return "Successful";
	}

	@GetMapping("/cmapping")
	public String collectionMapping() {
		CollectionMapping cm = new CollectionMapping();
		String[] courses = { "Java", "Jdbc", "Spring" };
		List<Integer> phones = new ArrayList<>();
		phones.add(123);
		phones.add(456);
		Set<String> emails = new HashSet<>();
		emails.add("make@gmail.com");
		emails.add("tulsi@gmail.com");
		Map<String, String> reference = new HashMap<>();
		reference.put("State", "Bihar");
		reference.put("City", "Patna");
		cm.setCourses(courses);
		cm.setPhones(phones);
		cm.setEmails(emails);
		cm.setReference(reference);
		cmRepo.save(cm);

		return "Successful";
	}

	@GetMapping("/greetings")
	public String greetings(@RequestParam String name, @RequestParam String state) {
		return "Welcome To Spring Boot Application " + name + " belongs to " + state;
	}

//	@ResponseBody
	@GetMapping(path = "/get", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> stuList = service.getALLStudent();
		log.info("all student info: {}", stuList);
		return new ResponseEntity<>(stuList, HttpStatus.OK);
	}

	@GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int sid) {
		Student student = service.getStudentById(sid);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}

//	@RequestMapping(value="/student/{id}",method=RequestMethod.GET,produces="application/json")
	@GetMapping(path = "/student/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	public Student getStudent(@PathVariable("id") int sid) {
		Student student = service.getStudentById(sid);
		return student;
	}

	@PostMapping(path = "/students/save")
	public String saveStudent(@Valid @RequestBody Student stu) {
		log.info("student data {}", stu);
		service.save(stu);
		return "student saved successfully";
	}

	@PostMapping(path = "/students/saveall")
	public String saveAllStudent(@RequestBody List<Student> stuList) {
		log.info("student data {}", stuList);
		service.save(stuList);
		return "All student saved successfully";
	}

	@DeleteMapping(path = "/students/{id}")
	public String deleteStudent(@PathVariable("id") int sid) {
		log.info("student data {}", sid);
		service.deleteById(sid);
		return "Student Id= " + sid + " Deleted successfully";
	}

	@PutMapping(path = "/students/update")
	public String updateStudent(@RequestBody Student stu) {
		log.info("student data {}", stu);
		service.updateRecord(stu);
		return "Student id= " + stu.getSid() + " data updated";
	}

	@PostMapping(path = "students/sms")
	public ResponseEntity<String> sendSMS(@RequestBody SMSRequest smsRequest) {
		smsSender.sendSms(smsRequest);
		return new ResponseEntity<>("message has been send", HttpStatus.OK);

	}
}