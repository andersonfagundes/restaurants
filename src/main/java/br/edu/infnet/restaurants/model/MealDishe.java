package br.edu.infnet.restaurants.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "meal_dishes")
public class MealDishe {

	@EmbeddedId
    MealDisheKey id;

    @ManyToOne
    @MapsId("menuItemId")
    @JoinColumn(name = "menu_item_id")
    MenuItem menuItem;

    @ManyToOne
    @MapsId("mealId")
    @JoinColumn(name = "meal_id")
    Meal meal;
    
    private Integer quantity;

	public MealDishe() {
	}

	public MealDisheKey getId() {
		return id;
	}

	public void setId(MealDisheKey id) {
		this.id = id;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
