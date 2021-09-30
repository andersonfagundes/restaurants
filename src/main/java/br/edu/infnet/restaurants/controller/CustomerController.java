package br.edu.infnet.restaurants.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.infnet.restaurants.model.Customer;
import br.edu.infnet.restaurants.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
	
	private CustomerService customerService;
	                          
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> listAll(){
		return ResponseEntity.ok(customerService.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable  Integer id) {
		Optional<Customer> customerByID = customerService.getById(id);
		if(!customerByID.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customerByID.get());
	}
	
	@PostMapping
	public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
		Customer customerDB = customerService.salvar(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(customerDB.getCustomerId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	  
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable  Integer id) {
		customerService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
