package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;

public interface StudentDao {
	public int insert(Student student);
	public int change(Student student);
	public int delete(Student student);
	public Student getStudentById(int id);
	public List<Student> getAllStudents();

}
