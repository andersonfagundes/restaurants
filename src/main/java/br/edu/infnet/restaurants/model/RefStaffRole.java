package br.edu.infnet.restaurants.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ref_staff_roles")
public class RefStaffRole {
	
	@Id
	@GeneratedValue
	@Column(name = "staff_role_code")
	private Integer staffRoleCode;
	
	@Column(name = "staff_role_description")
	private String staffRoleDescription;
	
	@OneToMany(mappedBy = "refStaffRole")
	private List<Staff> staff;

	public RefStaffRole() {
	}

	public Integer getStaffRoleCode() {
		return staffRoleCode;
	}

	public void setStaffRoleCode(Integer staffRoleCode) {
		this.staffRoleCode = staffRoleCode;
	}

	public String getStaffRoleDescription() {
		return staffRoleDescription;
	}

	public void setStaffRoleDescription(String staffRoleDescription) {
		this.staffRoleDescription = staffRoleDescription;
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}
		
}
