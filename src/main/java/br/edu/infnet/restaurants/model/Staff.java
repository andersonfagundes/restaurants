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
public class Staff {
	
	@Id
	@GeneratedValue
	@Column(name = "staff_id")
	private Integer staffId;
	
	@Column(name = "staff_role_code")
	private Integer staffRoleCode;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	@ManyToOne
	@JoinColumn(name = "staff_role_code", insertable = false, updatable = false)
	private RefStaffRole refStaffRole;
	
	@OneToMany(mappedBy = "staff")
	private List<Meal> meal;
	
	public Staff() {
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Integer getStaffRoleCode() {
		return staffRoleCode;
	}

	public void setStaffRoleCode(Integer staffRoleCode) {
		this.staffRoleCode = staffRoleCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public RefStaffRole getRefStaffRole() {
		return refStaffRole;
	}

	public void setRefStaffRole(RefStaffRole refStaffRole) {
		this.refStaffRole = refStaffRole;
	}

	public List<Meal> getMeal() {
		return meal;
	}

	public void setMeal(List<Meal> meal) {
		this.meal = meal;
	}

}
