package org.jsp.timestamp_demo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String food_items;
	
	@Column(nullable = false)
	private double cost;
	
	@Column(nullable = false)
	private String address;
	
	@CreationTimestamp
	private LocalDateTime ordered_time;
	
	@UpdateTimestamp
	private LocalDateTime del_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFood_items() {
		return food_items;
	}

	public void setFood_items(String food_items) {
		this.food_items = food_items;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getOrdered_time() {
		return ordered_time;
	}

	public void setOrdered_time(LocalDateTime ordered_time) {
		this.ordered_time = ordered_time;
	}

	public LocalDateTime getDel_time() {
		return del_time;
	}

	public void setDel_time(LocalDateTime del_time) {
		this.del_time = del_time;
	}
	
	
}
