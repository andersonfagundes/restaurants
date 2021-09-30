package br.edu.infnet.restaurants.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.restaurants.model.Customer;
import br.edu.infnet.restaurants.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer salvar(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public List<Customer> listAll(){
		return customerRepository.findAll();
	}
	
	public Optional<Customer> getById(Integer customerId){
		return customerRepository.findById(customerId);
	}
	
	public void delete(Integer customerId) {
		customerRepository.deleteById(customerId);
	}
	
}
