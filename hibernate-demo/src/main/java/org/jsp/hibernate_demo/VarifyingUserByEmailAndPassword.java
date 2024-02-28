package org.jsp.hibernate_demo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class VarifyingUserByEmailAndPassword {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Email And Password");
		String email =sc.next();
		String password=sc.next();
		String qry="Select u from User u where u.email=?1 and u.password=?2";
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			User u= q.getSingleResult();
			System.out.println("User id: "+u.getId());
			System.out.println("User name: "+u.getName());
			System.out.println("User Email: "+u.getEmail());
			System.out.println("User Phone No: "+u.getPhone());
		} catch (NoResultException e) {
			System.err.println("You Have Entered Invalid Email or Password");
		}
	}
}
