package org.jsp.hibernate_demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateUser1 {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter The User Id to Update");
		int id=scan.nextInt();
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		User u= new User();
	
			System.out.println("Enter the name,Phone,Email and Password");
			u.setName(scan.next());
			u.setPhone(scan.nextLong());
			u.setEmail(scan.next());
			u.setPassword(scan.next());
			s.saveOrUpdate(u);
			Transaction t=s.beginTransaction();
			t.commit();


		
	}
}
