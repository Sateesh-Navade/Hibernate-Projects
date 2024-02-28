package org.jsp.hibernate_demo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveUser {
	public static void main(String[] args) {
	
		User u=new User();
		u.setName("Yash");
		u.setPassword("abc1236");
		u.setEmail("abc@1236");
		u.setPhone(7896321478l);
		
		//SessionFactory f=new Configuration().configure().buildSessionFactory();
                       //or
		Session f=new Configuration().configure().buildSessionFactory().openSession();
//		Session s= f.openSession();
		Transaction t=f.beginTransaction();
		int id=(Integer) f.save(u);
		t.commit();
		System.out.println("User Saved With ID: "+id);
	
	}
}
