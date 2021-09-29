package br.edu.infnet.restaurants.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.restaurants.model.RefStaffRole;
import br.edu.infnet.restaurants.repository.RefStaffRoleRepository;

@Service
public class RefStaffRoleService {

	@Autowired
	private RefStaffRoleRepository refStaffRoleRepository;
	
	public RefStaffRole salvar(RefStaffRole refStaffRole) {
		//aplicar as regras de negócio
		return refStaffRoleRepository.save(refStaffRole);
	}
	
	public List<RefStaffRole> listAll(){
		return refStaffRoleRepository.findAll();
	}
	
	public Optional<RefStaffRole> getById(Integer staffRoleCode){
		return refStaffRoleRepository.findById(staffRoleCode);
	}
	
	public void delete(Integer staffRoleCode) {
		refStaffRoleRepository.deleteById(staffRoleCode);
	}
	
}
