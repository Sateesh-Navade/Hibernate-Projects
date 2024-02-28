package org.jsp.manytomanyuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanyuni.dto.Batch;

public class FindBatchByTrainer {
	public static void main(String[] args) {
		System.out.println("Enter Trainer Name");
		Scanner s= new Scanner(System.in);
		String name=s.next();
		EntityManager m=new Persistence().createEntityManagerFactory("dev").createEntityManager();
		Query q=m.createQuery("select b from Batch b where b.Trainer=?1");
		q.setParameter(1, name);
		List<Batch> b=q.getResultList();
		for (Batch ba : b) {
			try {
				System.out.println("Batch id: " + ba.getId());
				System.out.println("Batch Coad: " + ba.getBatch_code());
				System.out.println("Subject: " + ba.getSubject());
			} catch (Exception e) {
				System.err.println("Enterd Invalid Subject ");
			}
		}
	}
}
