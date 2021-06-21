package com.sirt.boot.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirt.boot.entity.StudentEntity;
import com.sirt.boot.mail.MailUtil;
import com.sirt.boot.repository.StudentRepo;
import com.sirt.boot.service.StudentService;
import com.sirt.boot.vo.Student;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo repo;
	@Autowired
	private MailUtil mailUtil;

	@Override
	public List<Student> getALLStudent() {
		List<StudentEntity> students = repo.findAll();
		log.info("fetching students from DB {}", students);
//		convert entity to value object
		List<Student> stuList = new ArrayList<>();
		for (StudentEntity entity : students) {
			Student stu = new Student();
			stu.setSid(entity.getSid());
			stu.setFirstName(entity.getFirstName());
			stu.setLastName(entity.getLastName());
			stu.setState(entity.getState());
			stuList.add(stu);
		}
		return stuList;
	}

	@Override
	public Student getStudentById(int sid) {
		StudentEntity entity = repo.findById(sid).get();
		Student stu = new Student();
		stu.setSid(entity.getSid());
		stu.setFirstName(entity.getFirstName());
		stu.setLastName(entity.getLastName());
		stu.setState(entity.getState());
		mailUtil.sendEmailWithAttachment();
		return stu;
	}

	@Override
	public void save(Student stu) {
		StudentEntity entity = new StudentEntity();
		entity.setSid(stu.getSid());
		entity.setFirstName(stu.getFirstName());
		entity.setLastName(stu.getLastName());
		entity.setState(stu.getState());
		repo.save(entity);
	}

	@Override
	public void save(List<Student> stuList) {
		List<StudentEntity> entityList = new ArrayList<>();
		for (Student stu : stuList) {
			StudentEntity entity = new StudentEntity();
			entity.setSid(stu.getSid());
			entity.setFirstName(stu.getFirstName());
			entity.setLastName(stu.getLastName());
			entity.setState(stu.getState());
			entityList.add(entity);
		}
		repo.saveAll(entityList);
	}

	@Override
	public String deleteById(int sid) {
		repo.deleteById(sid);

		return "Student Id= " + sid + " Deleted successfully";
	}

	@Override
	public void updateRecord(Student stu) {
		StudentEntity entity = mappingStudentToStudentEntity(stu);
		repo.save(entity);
	}
	private StudentEntity mappingStudentToStudentEntity(Student stu) {
		StudentEntity entity=new StudentEntity();
		entity.setSid(stu.getSid());
		entity.setFirstName(stu.getFirstName());
		entity.setLastName(stu.getLastName());
		entity.setState(stu.getState());
		return entity;
		}
}