package org.objectworld.book.customer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.objectworld.book.customer.domain.Customer;
import org.objectworld.book.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(Customer customer) {
        log.debug("Request to create Customer : {}", customer);
        return this.customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        log.debug("Request to get all Customers");
        return this.customerRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Customer findById(Long id) {
        log.debug("Request to get Customer : {}", id);
        return this.customerRepository.findById(id).get();
    }

    public List<Customer> findAllActive() {
        log.debug("Request to get all Customers");
        return this.customerRepository.findAllByEnabled(true);
    }

    public List<Customer> findAllInactive() {
        log.debug("Request to get all Customers");
        return this.customerRepository.findAllByEnabled(false);
    }

    public void delete(Long id) {
        log.debug("Request to delete Customer : {}", id);

        Customer customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Customer with id " + id));

        customer.setEnabled(false);
        this.customerRepository.save(customer);
    }
}
