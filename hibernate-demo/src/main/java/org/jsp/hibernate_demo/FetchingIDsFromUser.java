package org.jsp.hibernate_demo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchingIDsFromUser {
	public static void main(String[] args) {
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		String hql="Select u.id from User u ";
		Query<Integer> q= s.createQuery(hql);
		List<Integer> ids=q.getResultList();
		
		for (Integer ele : ids) {
			System.out.println(ele);
		}
	}
}
