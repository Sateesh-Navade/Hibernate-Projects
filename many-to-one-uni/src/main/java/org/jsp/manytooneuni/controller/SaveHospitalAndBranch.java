package org.jsp.manytooneuni.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytooneuni.dto.Branch;
import org.jsp.manytooneuni.dto.Hospital;

public class SaveHospitalAndBranch {
	public static void main(String[] args) {
		EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t=m.getTransaction();
		
		Hospital h=new Hospital();
		h.setName("Manipal");
		h.setFounder("Yash");
		h.setYear_of_est(2023);
		
		Branch b1=new Branch();
		b1.setName("Bengalore Manipal");
		b1.setEmail("BM@gmail.com");
		b1.setPhone(23456789L);
		b1.setHospital(h);
		
		Branch b2=new Branch();
		b2.setName("Mysore Manipal");
		b2.setEmail("MM@gmail.com");
		b2.setPhone(4534566789L);
		b2.setHospital(h);

		m.persist(b1);
		m.persist(b2);
		t.begin();
		t.commit();
	}
}
