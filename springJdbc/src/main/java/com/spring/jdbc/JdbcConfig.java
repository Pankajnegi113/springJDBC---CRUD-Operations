package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImp;

@Configuration
public class JdbcConfig {

	@Bean("ds")
	//or @Bean(name={"ds"}) - both do same work
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds= new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean("jdbctemplate")
	public JdbcTemplate getTemplate()
	{
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;
	}
	
	@Bean("studentDaoImp")
	public StudentDao getStudentDao()
	{
		StudentDaoImp dao = new StudentDaoImp();
		dao.setTemplate(getTemplate());
		return dao;
	}
	
}
