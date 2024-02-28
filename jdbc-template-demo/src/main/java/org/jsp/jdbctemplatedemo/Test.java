package org.jsp.jdbctemplatedemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;   //copy the Class path from here 

//import org.springframework.jdbc.datasource.DriverManagerDataSource; //copy the Class path from here 

public class Test {
	public static void main(String[] args) {
//		DriverManagerDataSource
		ApplicationContext c=new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate t=c.getBean("jdbcTemplate",JdbcTemplate.class);
		t.execute("create database jdbc_template_demo");
		System.out.println("DataBase Created");
	}
}
