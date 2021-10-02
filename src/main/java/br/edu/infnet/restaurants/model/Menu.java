package br.edu.infnet.restaurants.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menus")
public class Menu {

	@Id
	@GeneratedValue
	@Column(name = "menu_id")
	private Integer menuId;

	@Column(name = "menu_name")
	private String menuName;

	@Column(name = "available_date_from")
	private String availableDateFrom;

	@Column(name = "available_date_to")
	private String availableDateTo;

	@Column(name = "other_datails")
	private String otherDatails;

	@OneToMany(mappedBy = "menu")
	private List<MenuItem> menuItem;

	public Menu() {
	}

	public Menu(String menuName, String availableDateFrom, String availableDateTo, String otherDatails,
			List<MenuItem> menuItem) {
		this.menuName = menuName;
		this.availableDateFrom = availableDateFrom;
		this.availableDateTo = availableDateTo;
		this.otherDatails = otherDatails;
		this.menuItem = menuItem;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getAvailableDateFrom() {
		return availableDateFrom;
	}

	public void setAvailableDateFrom(String availableDateFrom) {
		this.availableDateFrom = availableDateFrom;
	}

	public String getAvailableDateTo() {
		return availableDateTo;
	}

	public void setAvailableDateTo(String availableDateTo) {
		this.availableDateTo = availableDateTo;
	}

	public String getOtherDatails() {
		return otherDatails;
	}

	public void setOtherDatails(String otherDatails) {
		this.otherDatails = otherDatails;
	}

	public List<MenuItem> getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(List<MenuItem> menuItem) {
		this.menuItem = menuItem;
	}

}
