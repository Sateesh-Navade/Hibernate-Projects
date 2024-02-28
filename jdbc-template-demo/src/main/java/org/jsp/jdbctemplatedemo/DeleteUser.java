package org.jsp.jdbctemplatedemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DeleteUser {
	public static void main(String[] args) {
		String dsql="delete from user where id=2";
		ApplicationContext c=new ClassPathXmlApplicationContext("jdbc-template.xml");
		 JdbcTemplate t=c.getBean("jdbcTemplate",JdbcTemplate.class);
		int r=t.update(dsql);
		System.out.println(r+" Row is Deleted");
	}
}
