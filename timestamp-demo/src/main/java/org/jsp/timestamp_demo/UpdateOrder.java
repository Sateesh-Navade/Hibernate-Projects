package org.jsp.timestamp_demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateOrder {
	public static void main(String[] args) {
		 EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();
		    EntityTransaction t=m.getTransaction();
		 FoodOrder o=m.find(FoodOrder.class, 1);
		 o.setFood_items("Paneer");
		    t.begin();
		    t.commit();
	}
}
