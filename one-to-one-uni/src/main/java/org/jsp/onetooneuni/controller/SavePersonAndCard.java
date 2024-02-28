package org.jsp.onetooneuni.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetooneuni.dto.AadharCard;
import org.jsp.onetooneuni.dto.Person;

public class SavePersonAndCard {
	public static void main(String[] args) {

		Person p=new Person();
		p.setName("yash");
		p.setAge(55);
		p.setPhone(873666543);
		
		AadharCard card=new AadharCard();
		card.setNumber(9876543678L);
		card.setDob(LocalDate.parse("2020-09-12"));
		card.setAddress("Bengaluru");
		
		p.setCard(card);//Assigning Aadhar Card To a Person
		
		EntityManager m= Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction  t= m.getTransaction();
		m.persist(p);
		m.persist(card);
		t.begin();
		t.commit();
	}
}
