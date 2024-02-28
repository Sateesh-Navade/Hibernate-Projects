package org.jsp.onetomanyuni_dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomanyuni_dto.Admin;
import org.jsp.onetomanyuni_dto.Hospital;

public class HospitalDao {

	private EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();

	public Hospital saveHospital(int admin_id, Hospital h) {
		Admin a=m.find(Admin.class, admin_id);
		if (a!=null) {
			a.getHospitals().add(h);
			h.setAdmin(a);
			EntityTransaction t=m.getTransaction();
			t.begin();
			t.commit();
			return h;
		}
		return null;
	}

	public Hospital updateHospital(Hospital h) {
		Hospital dbHospital=m.find(Hospital.class, h.getId());
		if (dbHospital!=null) {
			dbHospital.setName(h.getName());
			dbHospital.setFounder(h.getFounder());
			dbHospital.setGst_number(h.getGst_number());
			dbHospital.setYear_of_estb(h.getYear_of_estb());
			return dbHospital;
		}
		return null;
	}
	
}
