package org.jsp.hibernate_template_demo.controller;

import java.util.List;
import java.util.Scanner;

import org.jsp.hibernate_template_demo.dao.ProductDao;
import org.jsp.hibernate_template_demo.dto.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductController {

	static ProductDao dao;
	static Scanner scan = new Scanner(System.in);

	static {
		ApplicationContext context = new ClassPathXmlApplicationContext("product-cfg.xml");
		dao = context.getBean(ProductDao.class);
	}

	public static void main(String[] args) {

		while (true) {
			System.out.println("=======Welcome to Product App=======" + "\n1) Save product" + "\n2) Update product"
					+ "\n3) Find product by id" + "\n4) Find all product" + "\n5) Delete product" + "\n6) Exit");

			switch (scan.nextByte()) {

			case 1:
				save();
				break;

			case 2:
				update();
				break;

			case 3:
				findById();
				break;

			case 4:
				findAll();
				break;

			case 5:
				delete();
				break;

			case 6:
				System.exit(0);

			default:
				System.err.println("Invalid option..!!!");
			}
		}
	}

	public static void save() {
		scan.nextLine();
		System.out.println("Enter the product details to save product...");
		Product p = new Product();
		System.out.print("Enter product name: ");
		p.setName(scan.nextLine());
		System.out.print("Enter product brand: ");
		p.setBrand(scan.nextLine());
		System.out.print("Enter product category: ");
		p.setCategory(scan.nextLine());
		System.out.print("Enter product description: ");
		p.setDescription(scan.nextLine());
		System.out.print("Enter product cost: ");
		p.setCost(scan.nextDouble());

		Product s = dao.saveProduct(p);
		System.out.println("Product save with id " + s.getId());
	}

	public static void update() {
		System.out.println("Enter the product details to save product...");
		Product p = new Product();
		System.out.println("Enter porduct id: ");
		p.setId(scan.nextInt());
		scan.nextLine();
		System.out.print("Enter product name: ");
		p.setName(scan.nextLine());
		System.out.print("Enter product brand: ");
		p.setBrand(scan.nextLine());
		System.out.print("Enter product category: ");
		p.setCategory(scan.nextLine());
		System.out.print("Enter product description: ");
		p.setDescription(scan.nextLine());
		System.out.print("Enter product cost: ");
		p.setCost(scan.nextDouble());

		Product s = dao.updateProduct(p);
		if (s != null)
			System.out.println("Product updateed");
		else
			System.err.println("Error..!!!\nInvalid id...");
	}

	public static void findById() {
		System.out.println("Enter the product id to find product...");

		System.out.println("Enter porduct id: ");
		int id = scan.nextInt();

		Product p = dao.findById(id);
		if (p != null) {
			System.out.println("porduct id: " + p.getId());
			System.out.println("porduct name: " + p.getName());
			System.out.println("porduct brand: " + p.getBrand());
			System.out.println("porduct category: " + p.getCategory());
			System.out.println("porduct description: " + p.getDescription());
			System.out.println("porduct cost: " + p.getCost());
		} else
			System.err.println("Error..!!!\nInvalid id...");
	}

	public static void findAll() {
		List<Product> products = dao.findAll();
		if (products.size() > 0) {
			for (Product p : products) {
				System.out.println("porduct id: " + p.getId());
				System.out.println("porduct name: " + p.getName());
				System.out.println("porduct brand: " + p.getBrand());
				System.out.println("porduct category: " + p.getCategory());
				System.out.println("porduct description: " + p.getDescription());
				System.out.println("porduct cost: " + p.getCost());
			}
		} else
			System.err.println("Product doesn't present yet..!!!");
	}

	public static void delete() {
		System.out.println("Enter the product id to delete product...");

		System.out.println("Enter porduct id: ");
		int id = scan.nextInt();

		if (dao.deleteProduct(id))
			System.out.println("Product deleted");
		else
			System.err.println("Error..!!!\\nInvalid id...");
	}

}
