package org.objectworld.shopping.repository;

import org.objectworld.shopping.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCartCustomer_Id(Long id);
}
