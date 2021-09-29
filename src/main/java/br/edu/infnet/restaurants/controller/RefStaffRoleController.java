package br.edu.infnet.restaurants.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.infnet.restaurants.model.RefStaffRole;
import br.edu.infnet.restaurants.service.RefStaffRoleService;

@RestController
@RequestMapping("api/refstaffroles")
public class RefStaffRoleController {
	
	private RefStaffRoleService refStaffRoleService;
	
	public RefStaffRoleController(RefStaffRoleService refStaffRoleService) {
		this.refStaffRoleService = refStaffRoleService;
	}
	
	@GetMapping
	public ResponseEntity<List<RefStaffRole>> listAll(){
		return ResponseEntity.ok(refStaffRoleService.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RefStaffRole> getRefStaffRoleById(@PathVariable Integer id){
		Optional<RefStaffRole> refStaffRoleById = refStaffRoleService.getById(id);
		if(!refStaffRoleById.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(refStaffRoleById.get());
	}
	
	@PostMapping
	public ResponseEntity<?> createRefStaffRole(@RequestBody RefStaffRole refStaffRole){
		RefStaffRole refStaffRoleDB = refStaffRoleService.salvar(refStaffRole);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(refStaffRoleDB.getStaffRoleCode()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRefStaffRoleById(@PathVariable  Integer id) {
		refStaffRoleService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
