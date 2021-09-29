package br.edu.infnet.restaurants.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
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

	public MenuItem() {
	}

	public MenuItem(Integer menuId, String menuItemName, String otherDetails, Menu menu) {
		this.menuId = menuId;
		MenuItemName = menuItemName;
		this.otherDetails = otherDetails;
		this.menu = menu;
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
	
}
