package org.jsp.onetomanyuni_Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanyuni_dto.Department;

public class FindDeptById {
	public static void main(String[] args) {
		System.out.println("Enter Dept Id");
		Scanner s= new Scanner(System.in);
		int id =s.nextInt();
		EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=m.createQuery("select d from Department d where d.id=?1");
		q.setParameter(1, id);
		try {
		Department d=(Department) q.getSingleResult();
		System.out.println("Department Name :"+d.getName());
		System.out.println("Department location :"+d.getLocation());
		
		}catch (NoResultException e) {
			System.err.println("Invalid ID");
		}
	}
}
