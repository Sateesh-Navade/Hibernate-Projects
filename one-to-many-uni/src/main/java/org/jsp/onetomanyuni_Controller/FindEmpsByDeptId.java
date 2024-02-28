package org.jsp.onetomanyuni_Controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.onetomanyuni_dto.Employee;

public class FindEmpsByDeptId {
	public static void main(String[] args) {
		String jpql="select d.emps from Department d where d.id=?1";
		EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner s= new Scanner(System.in);
		System.out.println("Enter THe Dept ID to Display Details");
		int id= s.nextInt();
		Query q=m.createQuery(jpql);
		q.setParameter(1, id);
		List<Employee> emps=q.getResultList();
		if (emps.size()>0) {
			for (Employee e : emps) {
				System.out.println("Empolyee Id:"+e.getId());
				System.out.println("Empolyee Name:"+e.getName());
				System.out.println("Empolyee Designation:"+e.getDesg());
				System.out.println("Empolyee Salary:"+e.getSalary());	
				System.out.println("====================================");
			}
		}else {
			System.err.println("Invalid Id");
		}
	}
}
