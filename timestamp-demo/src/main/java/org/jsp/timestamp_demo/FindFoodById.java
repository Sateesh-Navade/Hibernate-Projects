package org.jsp.timestamp_demo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FindFoodById {
	public static void main(String[] args) {
		 EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();
		   
		    System.out.println("Enter ID of Ordered Food");
		    Scanner s= new Scanner(System.in);
		    int id=s.nextInt();
		 FoodOrder o=m.find(FoodOrder.class, id);
		 if(o!=null) {
			 System.out.println("Name of The Food :"+o.getFood_items());
			 System.out.println("Cost of The Food :"+o.getCost());
		 }
	}
}
