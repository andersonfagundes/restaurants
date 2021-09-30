package br.edu.infnet.restaurants.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.restaurants.model.MenuItem;
import br.edu.infnet.restaurants.repository.MenuItemRepository;

@Service
public class MenuItemService {
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	public MenuItem salvar(MenuItem menuItem) {
		return menuItemRepository.save(menuItem);
	}
	
	public List<MenuItem> listAll(){
		return menuItemRepository.findAll();
	}
	
	public Optional<MenuItem> getById(Integer menuItemId){
		return menuItemRepository.findById(menuItemId);
	}
	
	public void delete(Integer menuItemId) {
		menuItemRepository.deleteById(menuItemId);
	}
	
}
