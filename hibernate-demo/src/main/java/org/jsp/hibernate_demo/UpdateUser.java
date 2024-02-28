package org.jsp.hibernate_demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateUser {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter The User Id to Update");
		int id=scan.nextInt();
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		User u=s.get(User.class, id);
		if (u!=null) {
			System.out.println("Enter the name,Phone,Email and Password");
			u.setName(scan.next());
			u.setPhone(scan.nextLong());
			u.setEmail(scan.next());
			u.setPassword(scan.next());
			
			Transaction t=s.beginTransaction();
			t.commit();
		}else {
			System.err.println("Not Updated Bcoz of Invalid Id ");
		}
		
	}
}
