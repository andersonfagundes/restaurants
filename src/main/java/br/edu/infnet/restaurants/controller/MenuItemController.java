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

import br.edu.infnet.restaurants.model.MenuItem;
import br.edu.infnet.restaurants.service.MenuItemService;

@RestController
@RequestMapping("/api/menuitens")
public class MenuItemController {
	
	private MenuItemService menuItemService;
	
	public MenuItemController(MenuItemService menuItemService) {
		this.menuItemService = menuItemService; 
	}
	
	@GetMapping
	public ResponseEntity<List<MenuItem>> listAll(){
		return ResponseEntity.ok(menuItemService.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MenuItem> getMenuItemById(@PathVariable Integer id){
		Optional<MenuItem> menuItemById = menuItemService.getById(id);
		if(!menuItemById.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(menuItemById.get());
	}
	
	public ResponseEntity<?> createMenuItem(@RequestBody MenuItem menuItem){
		MenuItem menuItemBD = menuItemService.salvar(menuItem);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(menuItemBD.getMenuItemId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}
