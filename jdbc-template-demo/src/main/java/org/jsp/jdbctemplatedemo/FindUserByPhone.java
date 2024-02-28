package org.jsp.jdbctemplatedemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class FindUserByPhone {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter Phone Number Of User");
		long phone=s.nextLong();
		
		String qry="select * from user where phone=?";
		
		ApplicationContext c=new ClassPathXmlApplicationContext("jdbc-template.xml");
		 JdbcTemplate t=c.getBean("jdbcTemplate",JdbcTemplate.class);
		 
		User u =t.query(qry, new Object[] {phone},new MyResultExtractor());
		 
		if (u!=null) {
			System.out.println("User ID :"+u.getId());
			System.out.println("User Name :"+u.getName());
			System.out.println("User Phone Number :"+u.getPhone());
			System.out.println("====================================");
		} else {
			System.out.println("Invalid User ID");
		}
	}
}


class MyResultExtractor implements ResultSetExtractor<User>{

	public User extractData(ResultSet rs) throws SQLException, DataAccessException {
		if (rs.next()) {
			User u=new User();
			u.setId(rs.getInt(1));   //rs.getInt(1)
			u.setName(rs.getNString(2));
			u.setPhone(rs.getLong(3));
			u.setPassword(rs.getString(4));
			return u;
		}
		return null;
	}
}