package org.jsp.hibernate_demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteUser {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter User Id to Delete The Record");
		int id= sc.nextInt();
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		User u=s.get(User.class, id); 
		
		if(u!=null) {
			s.delete(u);
			Transaction t=s.beginTransaction();
			t.commit();
			System.out.println("User Deleted");
		}else {
			System.err.println("User Not Deleted As u Enterd Invalid ID");
		}
	}
}
