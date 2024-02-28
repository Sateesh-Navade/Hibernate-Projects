package org.jsp.manytomanyuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.manytomanyuni.dto.Batch;

public class FindBatchById {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter Batch Id to Show Details");
		int id= scan.nextInt();
		EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Batch b=m.find(Batch.class, id);
		
		if(b!=null) {
		System.out.println("Batch id: "+b.getId());
		System.out.println("Batch Coad: "+b.getBatch_code());
		System.out.println("Triner: "+b.getTrainer());
		System.out.println("Subject: "+b.getSubject());
		}else {
			System.err.println("Enterd Invalid ID ");
		}
		
	}
}
