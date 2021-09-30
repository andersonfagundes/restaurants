package br.edu.infnet.restaurants.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.infnet.restaurants.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

}
