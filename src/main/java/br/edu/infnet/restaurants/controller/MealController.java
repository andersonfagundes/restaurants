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

import br.edu.infnet.restaurants.model.Meal;
import br.edu.infnet.restaurants.service.MealService;

@RestController
@RequestMapping("/api/meals")
public class MealController {

	private MealService mealService;
	
	public MealController(MealService mealService) {
		this.mealService = mealService; 
	}
	
	@GetMapping
	public ResponseEntity<List<Meal>> listAll(){
		return ResponseEntity.ok(mealService.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Meal> getMealById(@PathVariable Integer id){
		Optional<Meal> mealById = mealService.getById(id);
		if(!mealById.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(mealById.get());
	}
	
	public ResponseEntity<?> createMeal(@RequestBody Meal meal){
		Meal mealBD = mealService.salvar(meal);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(mealBD.getMealId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}
