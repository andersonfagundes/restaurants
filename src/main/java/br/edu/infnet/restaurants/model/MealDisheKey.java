package br.edu.infnet.restaurants.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MealDisheKey implements Serializable {

	@Column(name = "meal_id")
    Integer mealId;

    @Column(name = "menu_item_id")
    Integer menuItemId;

	public MealDisheKey() {
	}

	public Integer getMealId() {
		return mealId;
	}

	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}

	public Integer getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(Integer menuItemId) {
		this.menuItemId = menuItemId;
	}
    
}
