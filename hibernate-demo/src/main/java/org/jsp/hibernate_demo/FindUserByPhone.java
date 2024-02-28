package org.jsp.hibernate_demo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FindUserByPhone {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter User Phone Number to Print Details of The User");
		long p= sc.nextLong();
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		String hql="Select u from User u where u.phone=:phone";
		Query<User> q= s.createQuery(hql);
		q.setParameter("phone", p);
		try {
			User u= q.getSingleResult();
			System.out.println("User id: "+u.getId());
			System.out.println("User name: "+u.getName());
			System.out.println("User Email: "+u.getEmail());
			System.out.println("User Phone No: "+u.getPhone());
		} catch (NoResultException e) {
			System.err.println("You Have Entered Invalid Phone No");
		}


	}
}
