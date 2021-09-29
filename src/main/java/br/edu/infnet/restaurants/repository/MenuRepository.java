package br.edu.infnet.restaurants.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.restaurants.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
