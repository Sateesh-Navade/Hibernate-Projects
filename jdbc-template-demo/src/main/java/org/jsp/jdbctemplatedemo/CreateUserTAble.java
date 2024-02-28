package org.jsp.jdbctemplatedemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreateUserTAble {
	public static void main(String[] args) {
		String sql="create table user(id int not null,name varchar(45) not null,phone bigint(20) not null unique,password varchar(20) not null,primary key(id)) ";
		ApplicationContext c=new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate t=c.getBean("jdbcTemplate",JdbcTemplate.class);
		t.execute(sql);
		System.out.println("Table Created Successfully");
	}
}
