package org.jsp.hibernate_template_demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.jsp.hibernate_template_demo.dto.Product;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class ProductDao {

	private HibernateTemplate template;

	@Transactional
	public Product saveProduct(Product p) {
		 template.save(p);
		 return p;
	}

	@Transactional
	public Product updateProduct(Product p) {
		Product dP = template.get(Product.class, p.getId());
		if (dP != null) {
			dP.setName(p.getName());
			dP.setBrand(p.getBrand());
			dP.setCategory(p.getCategory());
			dP.setDescription(p.getDescription());
			dP.setCost(p.getCost());
			template.update(dP);
		}
		return dP;
	}

	public Product findById(int id) {
		return template.get(Product.class, id);
	}

	public List<Product> findAll() {
		return template.loadAll(Product.class);
	}

	@Transactional
	public boolean deleteProduct(int id) {
		Product p = findById(id);
		if (p != null) {
			template.delete(p);
			return true;
		}
		return false;
	}

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

}
