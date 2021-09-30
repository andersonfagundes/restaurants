package br.edu.infnet.restaurants.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Meal {
	
	@Id
	@GeneratedValue
	@Column(name = "meal_id")
	private Integer mealId;
	
	@Column(name = "customer_id")
	private Integer customerId;
	
	@Column(name = "date_od_meal")
	private String dateOfMeal;
	
	@Column(name = "cost_of_meal")
	private String costOfMeal;
	
	@Column(name = "other_datails")
	private String otherDetails;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", insertable = false, updatable = false)
	private Customer customer;

	public Meal() {
	}

	public Meal(Integer customerId, String dateOfMeal, String costOfMeal, String otherDetails, Customer customer) {
		this.customerId = customerId;
		this.dateOfMeal = dateOfMeal;
		this.costOfMeal = costOfMeal;
		this.otherDetails = otherDetails;
		this.customer = customer;
	}

	public Integer getMealId() {
		return mealId;
	}

	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getDateOfMeal() {
		return dateOfMeal;
	}

	public void setDateOfMeal(String dateOfMeal) {
		this.dateOfMeal = dateOfMeal;
	}

	public String getCostOfMeal() {
		return costOfMeal;
	}

	public void setCostOfMeal(String costOfMeal) {
		this.costOfMeal = costOfMeal;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
