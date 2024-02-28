package org.jsp.hibernate_demo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class VarifyUserByPhoneAndPassword {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Phone And Password");
		long phone =sc.nextLong();
		String password=sc.next();
		String qry="Select u from User u where u.phone=?1 and u.password=?2";
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			User u= q.getSingleResult();
			System.out.println("User id: "+u.getId());
			System.out.println("User name: "+u.getName());
			System.out.println("User Email: "+u.getEmail());
			System.out.println("User Phone No: "+u.getPhone());
		} catch (NoResultException e) {
			System.err.println("You Have Entered Invalid Phone No or Password");
		}
	}
}
