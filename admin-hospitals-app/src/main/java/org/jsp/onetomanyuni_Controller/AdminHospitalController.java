package org.jsp.onetomanyuni_Controller;

import java.util.Scanner;

import javax.persistence.Query;

import org.jsp.onetomanyuni_dao.AdminDao;
import org.jsp.onetomanyuni_dao.HospitalDao;
import org.jsp.onetomanyuni_dto.Admin;
import org.jsp.onetomanyuni_dto.Hospital;

public class AdminHospitalController {

	private static Scanner s = new Scanner(System.in);
	private static AdminDao AdminDao = new AdminDao();
	private static HospitalDao hospitalDao = new HospitalDao();

	public static void main(String[] args) {
		System.out.println("1.Save Admin");
		System.out.println("2.Update Admin");
		System.out.println("3.Find Admin By Id");
		System.out.println("4.Verify Admin By Phone and Password");
		System.out.println("5.Verify Admin By Email and password");
		System.out.println("6.Save Hospital");
		System.out.println("7.Update Hospital");
		System.out.println("8.Find Hospital By Admin Id");
		System.out.println("9.Find Hospitals By Admin Phone and password");
		System.out.println("10.Find Hospitals By Admin Email and password");

		switch (s.nextInt()) {
		case 1:
			saveAdmin();
			break;
		case 2:
			updateAdmin();
			break;
		case 3:
			findAdminByID();
			break;
		case 4:
			varifyAdminByPhoneAndPassword();
			break;
		case 5:
			verifyAdminByEmailAndPassword();
			break;
		case 6:
			saveHospital();
			break;
		case 7:
			updateHospital();
			break;
		case 8:
			saveHospital();
			break;

		}
	}

	private static void updateHospital() {
		Hospital h=new Hospital();
		System.out.println("Enter Hospital ID to Update");
		int id=s.nextInt();
		h.setId(id);
		
		System.out.println("Enter Hosptal name,founder,gst,yos");
		h.setName(s.next());
		h.setFounder(s.next());
		h.setGst_number(s.next());
		h.setYear_of_estb(s.nextInt());
		h=hospitalDao.updateHospital(h);
		if (h!=null) {
			System.out.println("Hospital Updated :"+h.getId());
		}else {
			System.err.println("Invalid Credentials");
		}
	}

	private static void saveHospital() {
		System.out.println("Enter the Admin Id to add Hospital");
		int admin_id = s.nextInt();
		System.out.println("Enter the name,founder,gst number and year of establishment to add hospital");
		Hospital h = new Hospital();
		h.setFounder(s.next());
		h.setGst_number(s.next());
		h.setName(s.next());
		h.setYear_of_estb(s.nextInt());
		h=hospitalDao.saveHospital(admin_id,h);
		if (h!=null) {
			System.out.println("saved");
		}else {
			System.out.println("Invalid");
		}
	}

	private static void verifyAdminByEmailAndPassword() {
		Admin a = new Admin();
		System.out.println("Enter Admin Email And Password");
		String email = s.next();
		String pass = s.next();
		a = AdminDao.varifyAdminByEmail(email, pass);
		if (a != null) {
			System.out.println("Admin Id:" + a.getId());
			System.out.println("Name:" + a.getName());
			System.out.println("Phone Number:" + a.getPhone());
			System.out.println("Email Id:" + a.getEmail());
		}
	}

	private static void varifyAdminByPhoneAndPassword() {
		Admin a = new Admin();
		System.out.println("Enter Admin Phone And Password");
		long phone = s.nextLong();
		String pass = s.next();
		a = AdminDao.varifyAdminByPhone(phone, pass);
		if (a != null) {
			System.out.println("Admin Id:" + a.getId());
			System.out.println("Name:" + a.getName());
			System.out.println("Phone Number:" + a.getPhone());
			System.out.println("Email Id:" + a.getEmail());
		}
	}

	private static void findAdminByID() {
		System.out.println("Enter Admin ID");
		int id = s.nextInt();
		Admin a = AdminDao.findAdminById(id);
		if (a != null) {
			System.out.println("Admin Id:" + a.getId());
			System.out.println("Name:" + a.getName());
			System.out.println("Phone Number:" + a.getPhone());
			System.out.println("Email Id:" + a.getEmail());
		} else
			System.err.println("You have entered an Invalid Admin Id");

	}

	private static void updateAdmin() {
		System.out.println("Enter Admin ID to Update");
		int id = s.nextInt();
		Admin a = new Admin();
		System.out.println("Enter Name,Phone,Email,Password");
		a.setId(id);
		a.setName(s.next());
		a.setPhone(s.nextLong());
		a.setEmail(s.next());
		a.setPassword(s.next());
		a = AdminDao.updateAdmin(a);
		if (a != null) {
			System.out.println("Admin Updated with id :" + a.getId());
		} else {
			System.err.println("Invalid ID");
		}
	}

	private static void saveAdmin() {
		Admin a = new Admin();
		System.out.println("Enter Name");
		a.setName(s.next());
		System.out.println("Enter Phone");
		a.setPhone(s.nextLong());
		System.out.println("Enter Email");
		a.setEmail(s.next());
		System.out.println("Enter Password");
		a.setPassword(s.next());
		a = AdminDao.saveAdmin(a);
		System.out.println("Admin Saved With The ID :" + a.getId());
	}
}