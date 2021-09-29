package br.edu.infnet.restaurants.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	public Staff() {
	}

	public Staff(Integer staffRoleCode, String firstName, String lastName, RefStaffRole refStaffRole) {
		this.staffRoleCode = staffRoleCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.refStaffRole = refStaffRole;
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
	
}
