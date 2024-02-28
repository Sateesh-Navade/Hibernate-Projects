package org.jsp.onetooneuni.controller;

import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetooneuni.dto.Person;

public class FindPersonByName {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter Name to Find");
		String name = s.next();
		String qry="select p from Person p where p.name=?1";
		EntityManager m= Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=m.createQuery(qry);
		q.setParameter(1, name);
		try {
			Person p= (Person) q.getSingleResult();
			System.out.println("Person Id :"+ p.getId());
			System.out.println("Person name :"+ p.getName());
			System.out.println("Person Phone :"+ p.getPhone());
			System.out.println("Person Age :"+ p.getAge());
			System.out.println("Person Card Number:"+ p.getCard());
		} catch (NoResultException e) {
			System.err.println("Inavlid ID");
		}
	}
}
