package org.objectworld.shopping.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.objectworld.shopping.domain.Order;
import org.objectworld.shopping.domain.OrderItem;
import org.objectworld.shopping.domain.Product;
import org.objectworld.shopping.dto.OrderItemDto;
import org.objectworld.shopping.repository.OrderItemRepository;
import org.objectworld.shopping.repository.OrderRepository;
import org.objectworld.shopping.repository.ProductRepository;
import org.objectworld.util.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderItemService(OrderItemRepository orderItemRepository,
                            OrderRepository orderRepository,
                            ProductRepository productRepository) {
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public static OrderItemDto mapToDto(OrderItem orderItem) {
    	return ObjectMapper.map(orderItem, OrderItemDto.class);
    }
    
    public static OrderItem createFromDto(OrderItemDto orderItemDto) {
        return ObjectMapper.map(orderItemDto, OrderItem.class);
    }
    
    @Transactional(readOnly = true)
    public List<OrderItemDto> findAll() {
        log.debug("Request to get all OrderItems");
        return this.orderItemRepository.findAll()
            .stream()
            .map(OrderItemService::mapToDto)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderItemDto findById(Long id) {
        log.debug("Request to get OrderItem : {}", id);
        return this.orderItemRepository.findById(id)
    		.map(OrderItemService::mapToDto).orElse(null);
    }

    public OrderItemDto create(OrderItemDto orderItemDto) {
        log.debug("Request to create OrderItem : {}", orderItemDto);
        Order order = this.orderRepository.findById(orderItemDto.getOrderId())
        	.orElseThrow(() -> new IllegalStateException("The Order does not exist!"));

        Product product = this.productRepository.findById(orderItemDto.getProductId())
        	.orElseThrow(() -> new IllegalStateException("The Product does not exist!"));

        OrderItem orderItem = createFromDto(orderItemDto);
        orderItem.setProduct(product);
        orderItem.setOrder(order);
        orderItem = this.orderItemRepository.save(orderItem);

        order.setTotalPrice(order.getTotalPrice().add(
        	product.getPrice().multiply(
        		BigDecimal.valueOf(orderItem.getQuantity()))));
        this.orderRepository.save(order);

        return mapToDto(orderItem);
    }

    public void delete(Long id) {
        log.debug("Request to delete OrderItem : {}", id);
        
        OrderItem orderItem = this.orderItemRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException("The OrderItem does not exist!"));
        
        Order order = orderItem.getOrder();
        Product product = orderItem.getProduct();
        order.setTotalPrice(order.getTotalPrice().subtract(
        	product.getPrice().multiply(
        		BigDecimal.valueOf(orderItem.getQuantity()))));
        this.orderRepository.save(order);
        
        this.orderItemRepository.deleteById(id);
    }
}
