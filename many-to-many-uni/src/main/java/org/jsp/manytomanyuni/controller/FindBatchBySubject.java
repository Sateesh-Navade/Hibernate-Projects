package org.jsp.manytomanyuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanyuni.dto.Batch;

public class FindBatchBySubject {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Subject to Show Details");
		String sub = scan.next();
		EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = m.createQuery("select b from Batch b where b.subject=?1");
		q.setParameter(1, sub);

//		          //if there is a unique one
//		Batch b = (Batch) q.getSingleResult();
//		System.out.println("Batch id: " + b.getId());
//		System.out.println("Batch Coad: " + b.getBatch_code());
//		System.out.println("Triner: " + b.getTrainer());
		
		
		List<Batch> b = q.getResultList();
		if (b.size() > 0) {
			for (Batch ba : b) {

				try {
					System.out.println("Batch id: " + ba.getId());
					System.out.println("Batch Coad: " + ba.getBatch_code());
					System.out.println("Triner: " + ba.getTrainer());
				} catch (Exception e) {
					System.err.println("Enterd Invalid Subject ");
				}
			}
		}
	}
}
