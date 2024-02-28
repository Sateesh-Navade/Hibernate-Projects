package org.jsp.manytomanybi.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanybi.dto.Batch;

public class FindBatchByStudentPerc {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter Student Percentage to Show Details of Batch");
		double perc= scan.nextDouble();
		EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q=m.createQuery("select s.Batches from Student s where s.perc=?1");
		q.setParameter(1, perc);
		List<Batch> batches = q.getResultList();
		for(Batch b:batches) {
		
		System.out.println("Batch id: "+b.getId());
		System.out.println("Batch Coad: "+b.getBatch_code());
		System.out.println("Triner: "+b.getTrainer());
		System.out.println("Subject: "+b.getSubject());
		System.out.println("--------------------------------");
		}
	}
}

