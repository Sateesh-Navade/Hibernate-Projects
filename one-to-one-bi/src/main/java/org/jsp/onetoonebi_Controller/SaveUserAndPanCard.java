package org.jsp.onetoonebi_Controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetoonebi_dto.Pancard;
import org.jsp.onetoonebi_dto.User;

public class SaveUserAndPanCard {
	public static void main(String[] args) {

		User p=new User();
		p.setName("yash");
		p.setPhone(55762372598l);

		
		Pancard card=new Pancard();
		card.setNumber("efhwfhwielfwh456");
		card.setDob(LocalDate.parse("2020-09-12"));
		card.setPincode(984646);
		card.setUser(p);//Assigning User to Card
		
		p.setCard(card);//Assigning Card To a User
		
		EntityManager m= Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction  t= m.getTransaction();
		m.persist(p);
		t.begin();
		t.commit();
	}
}
