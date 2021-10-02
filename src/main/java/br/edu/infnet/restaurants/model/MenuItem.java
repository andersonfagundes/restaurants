package br.edu.infnet.restaurants.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menu_items")
public class MenuItem {

	@Id
	@GeneratedValue
	@Column(name = "menu_item_id")
	private Integer menuItemId;

	@Column(name = "menu_id")
	private Integer menuId;

	@Column(name = "menu_item_name")
	private String MenuItemName;

	@Column(name = "other_datails")
	private String otherDetails;

	@ManyToOne
	@JoinColumn(name = "menu_id", insertable = false, updatable = false)
	private Menu menu;

	@OneToMany(mappedBy = "menuItem")
    private List<MealDishe> mealDishe;

	public MenuItem() {
	}

	public Integer getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(Integer menuItemId) {
		this.menuItemId = menuItemId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuItemName() {
		return MenuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		MenuItemName = menuItemName;
	}

	public String getOtherDetails() {
		return otherDetails;
	}

	public void setOtherDetails(String otherDetails) {
		this.otherDetails = otherDetails;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<MealDishe> getMealDishe() {
		return mealDishe;
	}

	public void setMealDishe(List<MealDishe> mealDishe) {
		this.mealDishe = mealDishe;
	}
	
}
