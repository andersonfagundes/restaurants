package br.edu.infnet.restaurants.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.restaurants.model.Menu;
import br.edu.infnet.restaurants.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;
	
	public Menu salvar(Menu menu) {
		//aplicar as regras de negócio
		return menuRepository.save(menu);
	}

	public List<Menu> listAll(){
		return menuRepository.findAll();
	}

	public Optional<Menu> getById(Integer menuId) { 
		return menuRepository.findById(menuId);
	}

	public void delete(Integer menuId) {
		menuRepository.deleteById(menuId);
	}

}
