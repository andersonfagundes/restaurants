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

import br.edu.infnet.restaurants.model.Menu;
import br.edu.infnet.restaurants.service.MenuService;

@RestController
@RequestMapping("/api/menus")
public class MenuController {

	/*
	 * GET, POST, PUT, DELETE 
	 * get    -> retorna 1 ou retorna uma lista (paginada ou não)
	 * post   -> inclusão
	 * put    -> alteração
	 * delete -> exclusão
	 * 
	 * CRUD
	 */
	
	private MenuService menuService;
	
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@GetMapping
	public ResponseEntity<List<Menu>> listAll() {
		return ResponseEntity.ok (menuService.listAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Menu> getAlunoById(@PathVariable  Integer id) {
		Optional<Menu> menuByID = menuService.getById(id);
		if(!menuByID.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(menuByID.get());
	}
	
	@PostMapping
	public ResponseEntity<?> createMenu(@RequestBody Menu menu){
		Menu menuDB = menuService.salvar(menu);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(menuDB.getMenuId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	  
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMenuById(@PathVariable  Integer id) {
		menuService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}