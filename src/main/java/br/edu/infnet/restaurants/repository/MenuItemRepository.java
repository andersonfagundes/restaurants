package br.edu.infnet.restaurants.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.restaurants.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

}
