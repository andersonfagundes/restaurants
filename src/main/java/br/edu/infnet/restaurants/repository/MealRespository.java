package br.edu.infnet.restaurants.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.restaurants.model.Meal;

@Repository
public interface MealRespository extends JpaRepository<Meal, Integer> {

}
