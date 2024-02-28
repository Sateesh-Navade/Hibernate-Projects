package org.jsp.hibernate_demo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FindUserByEmail {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter User Email ID to Print Details of The User");
		String email= sc.next();
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		String hql="Select u from User u where u.email=:email";
		Query<User> q= s.createQuery(hql);
		q.setParameter("email", email);
		try {
			User u= q.getSingleResult();
			System.out.println("User id: "+u.getId());
			System.out.println("User name: "+u.getName());
			System.out.println("User Email: "+u.getEmail());
			System.out.println("User Phone No: "+u.getPhone());
		} catch (NoResultException e) {
			System.out.println("You Have Entered Invalid Email ID");
		}


	}
}
