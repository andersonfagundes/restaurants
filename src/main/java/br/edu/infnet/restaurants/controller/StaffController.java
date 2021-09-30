package br.edu.infnet.restaurants.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.infnet.restaurants.model.Staff;
import br.edu.infnet.restaurants.service.StaffService;

@RestController
@RequestMapping("/api/staffs")
public class StaffController {
	
	private StaffService staffService;
	
	public StaffController(StaffService staffService) {
		this.staffService = staffService; 
	}
	
	@GetMapping
	public ResponseEntity<List<Staff>> listAll(){
		return ResponseEntity.ok(staffService.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Staff> getStaffById(@PathVariable Integer id){
		Optional<Staff> staffById = staffService.getById(id);
		if(!staffById.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(staffById.get());
	}
	
	public ResponseEntity<?> createStaff(@RequestBody Staff staff){
		Staff staffBD = staffService.salvar(staff);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(staffBD.getStaffId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}
