package br.edu.infnet.restaurants.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.restaurants.model.Staff;
import br.edu.infnet.restaurants.repository.StaffRepository;

@Service
public class StaffService {
	
	@Autowired
	private StaffRepository staffRepository;
	
	public Staff salvar(Staff staff) {
		return staffRepository.save(staff);
	}
	
	public List<Staff> listAll(){
		return staffRepository.findAll();
	}
	
	public Optional<Staff> getById(Integer staffId){
		return staffRepository.findById(staffId);
	}
	
	public void delete(Integer staffId) {
		staffRepository.deleteById(staffId);
	}
	
}
