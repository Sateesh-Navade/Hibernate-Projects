package org.jsp.onetomanyuni_dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanyuni_dto.Admin;

public class AdminDao {

	private EntityManager m = Persistence.createEntityManagerFactory("dev").createEntityManager();

	public Admin saveAdmin(Admin a) {
		EntityTransaction t = m.getTransaction();
		m.persist(a);
		t.begin();
		t.commit();
		return a;
	}

	public Admin findAdminById(int id) {
		return m.find(Admin.class, id);
	}

	public Admin updateAdmin(Admin a) {
		Admin bdAdmin = findAdminById(a.getId());
		if (bdAdmin != null) {
			bdAdmin.setName(a.getName());
			bdAdmin.setPhone(a.getPhone());
			bdAdmin.setEmail(a.getEmail());
			bdAdmin.setPassword(a.getPassword());
			EntityTransaction t = m.getTransaction();
			t.begin();
			t.commit();
			return a;
		}
		return null;
	}

	public Admin varifyAdminByPhone(long phone, String pass) {
		Query q = m.createQuery("select a from Admin a where a.phone=?1 and a.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, pass);

		try {
			return (Admin) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Admin varifyAdminByEmail(String email, String pass) {
		Query q = m.createQuery("select a from Admin a where a.email=?1 and a.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, pass);

		try {
			return (Admin) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
