package org.jsp.onetomanyuni_Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomanyuni_dto.Department;
import org.jsp.onetomanyuni_dto.Employee;

public class SaveDeptAndEmp{
	public static void main(String[] args) {

		Department p=new Department();
		p.setName("Devloper");
		p.setLocation("BTM");

		Employee e1=new Employee();
		e1.setName("Arun");
		e1.setDesg("dev");
		e1.setSalary(200000);
		
		Employee e2=new Employee();
		e2.setName("Varun");
		e2.setDesg("dev");
		e2.setSalary(200000);
		
		Employee e3=new Employee();
		e3.setName("Tarun");
		e3.setDesg("dev");
		e3.setSalary(200000);
		
		List<Employee> emps=new ArrayList<Employee>();
		emps.add(e1);
		emps.add(e2);
		emps.add(e3);
		
		p.setEmps(emps);
		
		EntityManager m= Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction  t= m.getTransaction();
		m.persist(p);
		t.begin();
		t.commit();
	}
}
