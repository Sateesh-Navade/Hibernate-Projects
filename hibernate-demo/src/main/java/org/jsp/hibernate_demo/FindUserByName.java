package org.jsp.hibernate_demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FindUserByName {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter User Name to Print Details of The User");
		String name= sc.next();
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		String hql="Select u from User u where u.name=?1";
		Query<User> q= s.createQuery(hql);
		q.setParameter(1, name);
		List<User> users=q.getResultList();
		if(users.size()>0) {
			for (User u : users) {
				System.out.println("User id: "+u.getId());
				System.out.println("User name: "+u.getName());
				System.out.println("User Email: "+u.getEmail());
				System.out.println("User Phone No: "+u.getPhone());
			}
		}
		else
		{
			System.out.println("You Have Entered Invalid Name");
		}

	}

}
//public class FindUserByName {
//	public static void main(String[] args) {
//		Scanner sc= new Scanner(System.in);
//		System.out.println("Enter User Name to Print Details of The User");
//		String name= sc.next();
//		Session s= new Configuration().configure().buildSessionFactory().openSession();
//		String hql="Select u from User u where u.name=:name";
//		Query<User> q= s.createQuery(hql);
//		q.setParameter("name", name);
//		try {
//			User u= q.getSingleResult();
//			System.out.println("User id: "+u.getId());
//			System.out.println("User name: "+u.getName());
//			System.out.println("User Email: "+u.getEmail());
//			System.out.println("User Phone No: "+u.getPhone());
//		} catch (NoResultException e) {
//			System.out.println("You Have Entered Invalid Name");
//		}
//		
//		
//	}
//}
