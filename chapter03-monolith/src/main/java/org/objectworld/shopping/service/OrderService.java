package org.objectworld.shopping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.objectworld.shopping.domain.Cart;
import org.objectworld.shopping.domain.Order;
import org.objectworld.shopping.dto.OrderDto;
import org.objectworld.shopping.repository.CartRepository;
import org.objectworld.shopping.repository.OrderRepository;
import org.objectworld.util.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public static OrderDto mapToDto(Order order) {
    	return ObjectMapper.map(order, OrderDto.class);
    }

    public static Order createFromDto(OrderDto orderDto) {
		return ObjectMapper.map(orderDto, Order.class);
	}
	
    @Transactional(readOnly = true)
    public List<OrderDto> findAll() {
        log.debug("Request to get all Orders");
        return this.orderRepository.findAll()
                .stream()
                .map(OrderService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderDto findById(Long id) {
        log.debug("Request to get Order : {}", id);
        return this.orderRepository.findById(id)
        		.map(OrderService::mapToDto).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<OrderDto> findAllByCustomerId(Long customerId) {
        log.debug("Request to get Order with Customer : {}", customerId);
        return this.orderRepository.findByCartCustomerId(customerId)
                .stream()
                .map(OrderService::mapToDto)
                .collect(Collectors.toList());
    }

    public OrderDto create(OrderDto orderDto) {
        log.debug("Request to create Order : {}", orderDto);
        return mapToDto(this.orderRepository.save(createFromDto(orderDto)));
    }

    public void delete(Long id) {
        log.debug("Request to delete Order : {}", id);
        this.orderRepository.deleteById(id);
    }
}
