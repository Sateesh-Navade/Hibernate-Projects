package org.jsp.hibernate_demo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FindAllUsersByUsingHQL {
	public static void main(String[] args) {
		String hql="Select u from User u ";
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q= s.createQuery(hql);
		List<User> users=q.getResultList();
		
		for (User u : users) {
			System.out.println("User id: "+u.getId());
			System.out.println("User name: "+u.getName());
			System.out.println("User Email: "+u.getEmail());
			System.out.println("User Phone No: "+u.getPhone());
			System.err.println("===================================");
		}
	}
}
