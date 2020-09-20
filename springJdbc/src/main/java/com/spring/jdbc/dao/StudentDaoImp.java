package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImp implements StudentDao {

	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	
	public int insert(Student student) {
		// insert query
		String query = "insert into student(id,name,city) values(?,?,?)";
		int res = template.update(query,student.getId(),student.getName(),student.getCity());
		return res;
	}
	
	public int change(Student student) {
		// insert query
		String query = "Update student set name=? , city=? where id=?";
		int res = template.update(query,student.getName(),student.getCity(),student.getId());
		return res;
	}

	public int delete(Student student) {
		String query = "delete from student where id=?";
		int res = template.update(query,student.getId());
		return res;
	}

	public Student getStudentById(int id) {
		String query = "Select * from student where id=?";
		RowMapper<Student> mapper = new RowMapperImp(); 
		Student s= template.queryForObject(query, mapper,id);
		return s;
	}
	
	
	public List<Student> getAllStudents()
	{
		String query ="Select * from student";
		List<Student>students = template.query(query,new RowMapperImp());
		return students;
	}
	
}
