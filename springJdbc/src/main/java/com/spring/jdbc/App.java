package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImp;
import com.spring.jdbc.entities.Student;

public class App {

	public static void main(String[] args) {
	
//		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		//insert query
		String query ="insert into student(id,name,city) values(?,?,?)";
		
		StudentDaoImp studentDao = context.getBean("studentDaoImp",StudentDaoImp.class);
		
		//insert
//		Student s= new Student(24,"Nishant","Delhi");
//		studentDao.insert(s);
//		System.out.println("Inserted successfully");
		
		//update 
//		Student s= new Student(23,"Himanshu","Delhi");
//		studentDao.change(s);
//		System.out.println("Updation in id:"+s.getId()+" done");
		
		//deleting by id 
//		Student s= new Student();
//		s.setId(21);
//		studentDao.delete(s);
//		System.out.println("Deletion of id:"+s.getId()+" done");
		
		//get student detail by using rowMapper
//		Student s=studentDao.getStudentById(23);
//		System.out.print(s);
		
		List<Student>students = studentDao.getAllStudents();
		for(Student student : students)
			System.out.println(student);
		
		

	}

}
