package org.jsp.jdbctemplatedemo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class FetchUsers {
	public static void main(String[] args) {
		ApplicationContext c=new ClassPathXmlApplicationContext("jdbc-template.xml");
		 JdbcTemplate t=c.getBean("jdbcTemplate",JdbcTemplate.class);
		List<User> users= t.query("select * from user", new UserResultExtractor());
		for (User u : users) {
			System.out.println("User ID :"+u.getId());
			System.out.println("User Name :"+u.getName());
			System.out.println("User Phone Number :"+u.getPhone());
			System.out.println("====================================");
		}
	}
}


class UserResultExtractor implements ResultSetExtractor<List<User>>{

	public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<User> users=new ArrayList<User>();
		while (rs.next()) {
			User u=new User();
			u.setId(rs.getInt(1));
			u.setName(rs.getNString(2));
			u.setPhone(rs.getLong(3));
			u.setPassword(rs.getString(4));
			users.add(u);
		}
		return users;
	}
	
}