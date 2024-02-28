package org.jsp.hibernate_demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FindUserbyId {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter User Id to Show Details");
		int id= scan.nextInt();
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		User u=s.get(User.class, id); 
		
		if(u!=null) {
		System.out.println("User id: "+u.getId());
		System.out.println("User name: "+u.getName());
		System.out.println("User Email: "+u.getEmail());
		System.out.println("User Phone No: "+u.getPhone());
		}else {
			System.err.println("Enterd Invalid ID ");
		}
		
	}
}
