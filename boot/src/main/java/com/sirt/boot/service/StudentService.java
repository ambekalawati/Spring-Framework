package com.sirt.boot.service;

import java.util.List;

import com.sirt.boot.vo.Student;

public interface StudentService {
	public List<Student> getALLStudent();

	public Student getStudentById(int sid);

	public void save(Student stu);

	public void save(List<Student> stu);

	public String deleteById(int sid);

	public void updateRecord(Student stu);
	
}