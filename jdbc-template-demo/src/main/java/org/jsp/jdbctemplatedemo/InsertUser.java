package org.jsp.jdbctemplatedemo;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class InsertUser {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter The User id,Name ,Phone And Password");
		int id=s.nextInt();
		String name =s.next();
		long phone=s.nextLong();
		String password =s.next();
		
		String qry="insert into user value(?,?,?,?)";
		ApplicationContext c=new ClassPathXmlApplicationContext("jdbc-template.xml");
		 JdbcTemplate t=c.getBean("jdbcTemplate",JdbcTemplate.class);
		 
		 int r=t.update(qry,id,name,phone,password);
		 System.out.println(r+" Row Insertd");
	}
}
