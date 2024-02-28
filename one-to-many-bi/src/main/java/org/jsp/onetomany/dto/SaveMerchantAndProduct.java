package org.jsp.onetomany.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMerchantAndProduct {
	public static void main(String[] args) {
		Merchant m=new Merchant();
		m.setGst_no("wert123");
		m.setName("ABC");
		m.setPassword("wer345rfg");
		m.setPhone(78963244L);
		
		Product p1=new Product();
		p1.setBrand("Apple");
		p1.setCost(999);
		p1.setName("SmartWatch");
		p1.setMerchant(m);
		
		Product p2=new Product();
		p2.setBrand("Apple");
		p2.setCost(9999);
		p2.setName("SmartPhone");
		p2.setMerchant(m);
		
		List<Product> p=new ArrayList<Product>();
		p.add(p1);
		p.add(p2);
		m.setProducts(p);
		
		EntityManager maneger=Persistence.createEntityManagerFactory("dev").createEntityManager();
		maneger.persist(m);
		EntityTransaction t=maneger.getTransaction();
		t.begin();
		t.commit();
	}
}
