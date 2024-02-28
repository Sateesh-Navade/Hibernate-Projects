package org.jsp.manytomanyuni.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytomanyuni.dto.Batch;
import org.jsp.manytomanyuni.dto.Student;

public class SaveBatchAndStudent {
	public static void main(String[] args) {
		Batch b1=new Batch();
		b1.setBatch_code("jsf-efk-a3");
		b1.setSubject("Adv Java");
		b1.setTrainer("Sateesh");
		
		Batch b2=new Batch();
		b2.setBatch_code("jsf-efwee-a5");
		b2.setSubject("Hibernate");
		b2.setTrainer("Sameer");
		
		Batch b3=new Batch();
		b3.setBatch_code("jsf-wqrweee-3m3");
		b3.setSubject("React JS");
		b3.setTrainer("Harish");
		
		Student s1=new Student();
		s1.setName("Kejariwal");
		s1.setPerc(50);
		s1.setYop(2000);
		
		Student s2=new Student();
		s2.setName("Modi");
		s2.setPerc(99);
		s2.setYop(1995);
		
		Student s3=new Student();
		s3.setName("Rahul");
		s3.setPerc(30);
		s3.setYop(2020);
		
		List<Student> forB1=new ArrayList<Student>(Arrays.asList(s1,s2,s3));
		List<Student> forB2=new ArrayList<Student>(Arrays.asList(s1,s3));
		List<Student> forB3=new ArrayList<Student>(Arrays.asList(s1,s2,s3));
		
		b1.setStudents(forB1);
		b2.setStudents(forB2);
		b3.setStudents(forB3);
		
		EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction t=m.getTransaction();
		m.persist(b1);
		m.persist(b2);
		m.persist(b3);
		t.begin();
		t.commit();
	}
}
