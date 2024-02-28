package org.jsp.jdbctemplatedemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SaveUser {
	public static void main(String[] args) {
		ApplicationContext c=new ClassPathXmlApplicationContext("jdbc-template.xml");
		JdbcTemplate t=c.getBean("jdbcTemplate",JdbcTemplate.class);
		int r=t.update("insert into user values (1,'ABC',77788,'abc123')");
		System.out.println(r+" Row Saved");
	}
}
