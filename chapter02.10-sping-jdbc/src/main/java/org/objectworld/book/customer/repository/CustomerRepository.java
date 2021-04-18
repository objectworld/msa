package org.objectworld.book.customer.repository;

import java.util.List;
import java.util.Optional;

import org.objectworld.book.customer.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	Optional<Customer> findById(Long id);
    List<Customer> findAll();	
    List<Customer> findAllByEnabled(Boolean enabled);
}
