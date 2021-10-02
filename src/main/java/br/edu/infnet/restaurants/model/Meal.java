package br.edu.infnet.restaurants.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "meals")
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

	@OneToMany(mappedBy = "meal")
    private List<MealDishe> mealDishe;
	
	@ManyToOne
	@JoinColumn(name = "staff_id", insertable = false, updatable = false)
	private Staff staff;

	public Meal() {
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

	public List<MealDishe> getMealDishe() {
		return mealDishe;
	}

	public void setMealDishe(List<MealDishe> mealDishe) {
		this.mealDishe = mealDishe;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
}
