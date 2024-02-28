package org.jsp.timestamp_demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PlaceOrder {
	public static void main(String[] args) {
		FoodOrder o=new FoodOrder();
		o.setAddress("jp");
		o.setFood_items("chiken Biryani");
		o.setCost(1500);
	    EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();
	    EntityTransaction t=m.getTransaction();
	    m.persist(o);
	    t.begin();
	    t.commit();
	    System.out.println("Order Placed With ID "+o.getId());
	}
}
