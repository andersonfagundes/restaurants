package br.edu.infnet.restaurants.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.restaurants.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
