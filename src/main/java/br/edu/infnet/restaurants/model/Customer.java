package br.edu.infnet.restaurants.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue
	@Column(name = "customers_id")
	private Integer customerId;
	
	@Column(name = "customer_datails")
	private String customerDatails;
	
	@OneToMany(mappedBy = "customer")
	private List<Meal> meals;

	public Customer() {
	}

	public Customer(String customerDatails, List<Meal> meals) {
		this.customerDatails = customerDatails;
		this.meals = meals;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerDatails() {
		return customerDatails;
	}

	public void setCustomerDatails(String customerDatails) {
		this.customerDatails = customerDatails;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	
}
