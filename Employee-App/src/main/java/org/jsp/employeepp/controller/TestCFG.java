package org.jsp.employeepp.controller;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestCFG {
	public static void main(String[] args) {
		Configuration cfg =new Configuration().configure();
		SessionFactory f=cfg.buildSessionFactory();     //OR
		
	//SessionFactory f=new Configuration().configure().buildSessionFactory();

		System.out.println(f);
	}
}
