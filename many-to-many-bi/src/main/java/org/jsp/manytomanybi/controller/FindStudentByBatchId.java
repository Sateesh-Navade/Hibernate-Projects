package org.jsp.manytomanybi.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.manytomanybi.dto.Batch;
import org.jsp.manytomanybi.dto.Student;

public class FindStudentByBatchId {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter BatchId Id to Show Details of Batch");
		int id= scan.nextInt();
		EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Student s=m.find(Student.class, id);
		if(s!=null) {
		System.out.println("Student id: "+s.getId());
		System.out.println("Student Name: "+s.getName());
		System.out.println("Student Percentage: "+s.getPerc());
		System.out.println("Student Year of Passing: "+s.getYop());
		}else {
			System.err.println("Enterd Invalid ID ");
		}
	}
}
