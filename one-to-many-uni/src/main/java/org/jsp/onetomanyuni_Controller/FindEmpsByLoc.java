package org.jsp.onetomanyuni_Controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanyuni_dto.Employee;

public class FindEmpsByLoc {
	public static void main(String[] args) {
		String jpql="select d.emps from Department d where d.location=?1";
		EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner s= new Scanner(System.in);
		System.out.println("Enter The Dept Location to Display Details");
		String loc= s.next();
		Query q=m.createQuery(jpql);
		q.setParameter(1, loc);
		List<Employee> emps=q.getResultList();
		if (emps.size()>0) {
			for (Employee e : emps) {
				System.out.println("Empolyee Id:"+e.getId());
				System.out.println("Empolyee Name:"+e.getName());
				System.out.println("Empolyee Designation:"+e.getDesg());
				System.out.println("Empolyee Salary:"+e.getSalary());	
				System.out.println("===============================");
			}
		}else {
			System.err.println("Invalid Id");
		}
	}
}
