package org.jsp.hibernate_demo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchingNamesFromUser {
	public static void main(String[] args) {
		Session s= new Configuration().configure().buildSessionFactory().openSession();
		String hql="Select u.name from User u ";
		Query<String> q= s.createQuery(hql);
		List<String> names=q.getResultList();
		
		for (String ele : names) {
			System.out.println(ele);
		}
	}
}
