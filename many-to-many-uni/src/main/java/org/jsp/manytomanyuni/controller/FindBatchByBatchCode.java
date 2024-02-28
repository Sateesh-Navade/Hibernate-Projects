package org.jsp.manytomanyuni.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.manytomanyuni.dto.Batch;

public class FindBatchByBatchCode {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter BatchCode to Show Details");
		String bc = scan.next();
		EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = m.createQuery("select b from Batch b where b.batch_code=?1");
		q.setParameter(1, bc);

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
