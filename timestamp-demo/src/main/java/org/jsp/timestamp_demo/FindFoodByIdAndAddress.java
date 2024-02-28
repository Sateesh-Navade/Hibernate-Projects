package org.jsp.timestamp_demo;

import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindFoodByIdAndAddress {
	public static void main(String[] args) {
		EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();

		System.out.println("Enter Address & ID of Ordered Food");
		Scanner s= new Scanner(System.in);
		String address=s.next();
		int id=s.nextInt();
		Query q=m.createQuery("select f from FoodOrder f where f.address=?1 and f.id=?2");
		q.setParameter(1, address);
		q.setParameter(2, id);
		try {
			FoodOrder o=(FoodOrder) q.getSingleResult();
			System.out.println("Id of The Food :"+o.getId());
			System.out.println("Name of The Food :"+o.getFood_items());
			System.out.println("Cost of The Food :"+o.getCost());
		}catch (NoResultException e) {
			System.err.println("Invalid Address");
		}
	}
}

