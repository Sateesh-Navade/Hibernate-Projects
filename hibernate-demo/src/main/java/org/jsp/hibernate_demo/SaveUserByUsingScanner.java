package org.jsp.hibernate_demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveUserByUsingScanner {
	public static void main(String[] args) {
		User u=new User();
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter Name");
		u.setName(scan.next());
		System.out.println("Enter Password");
		u.setPassword(scan.next());
		System.out.println("Enter Email");
		u.setEmail(scan.next());
		System.out.println("Enter Phone No");
		u.setPhone(scan.nextLong());

		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Transaction t= s.beginTransaction();
		int id=(Integer) s.save(u);
		t.commit();
		
		System.out.println("User Saved With ID: "+id);

	}
}
