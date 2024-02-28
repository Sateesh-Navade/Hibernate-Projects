package org.jsp.manytooneuni.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.manytooneuni.dto.Hospital;

public class FindHospitalById {
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter Hospital id");
		int id=s.nextInt();
		EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Hospital h=m.find(Hospital.class, id);
		if (h!=null) {
			System.out.println("Hospital Name :"+h.getName());
			System.out.println("Hospital Founder :"+h.getFounder());
			System.out.println("Hospital Year of Establish :"+h.getYear_of_est());
		}else {
			System.err.println("Invalid ID");
		}
	}
}
