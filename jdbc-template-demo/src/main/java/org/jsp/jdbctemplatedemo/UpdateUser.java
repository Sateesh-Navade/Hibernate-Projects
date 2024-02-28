package org.jsp.jdbctemplatedemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class UpdateUser {
	public static void main(String[] args) {
		ApplicationContext c=new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate t=c.getBean("jdbcTemplate",JdbcTemplate.class);
		int r=t.update("update user set name='XYZ', password='xyz123' where id=2");
		System.out.println(r+" Row Updated");
	}
}
