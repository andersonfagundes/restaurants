package br.edu.infnet.restaurants.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.restaurants.model.Meal;
import br.edu.infnet.restaurants.model.Menu;
import br.edu.infnet.restaurants.repository.MealRespository;

@Service
public class MealService {

	@Autowired
	private MealRespository mealRepository;
	
	public Meal salvar(Meal meal) {
		return mealRepository.save(meal);
	}
	
	public List<Meal> listAll(){
		return mealRepository.findAll();
	}
	
	public Optional<Meal> getById(Integer mealId) { 
		return mealRepository.findById(mealId);
	}

	public void delete(Integer mealId) {
		mealRepository.deleteById(mealId);
	}
	
}
