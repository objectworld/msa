package org.objectworld.shopping.service;

import java.util.List;
import java.util.stream.Collectors;

import org.objectworld.shopping.domain.Order;
import org.objectworld.shopping.domain.Payment;
import org.objectworld.shopping.domain.enumeration.PaymentStatus;
import org.objectworld.shopping.dto.PaymentDto;
import org.objectworld.shopping.repository.OrderRepository;
import org.objectworld.shopping.repository.PaymentRepository;
import org.objectworld.util.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentService(PaymentRepository paymentRepository, 
    					  OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    public static PaymentDto mapToDto(Payment payment) {
    	return ObjectMapper.map(payment, PaymentDto.class);
    }
	
    public static Payment createFromDto(PaymentDto paymentDto) {
    	return ObjectMapper.map(paymentDto, Payment.class);
	}
	
    @Transactional(readOnly = true)
    public List<PaymentDto> findAll() {
        log.debug("Request to get all Payments");
        return this.paymentRepository.findAll()
            .stream()
            .map(PaymentService::mapToDto)
            .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PaymentDto findById(Long id) {
        log.debug("Request to get Payment : {}", id);
        return this.paymentRepository.findById(id)
            .map(PaymentService::mapToDto).orElse(null);
    }

    public PaymentDto create(PaymentDto paymentDto) {
        log.debug("Request to create Payment : {}", paymentDto);
        Order order = this.orderRepository.findById(paymentDto.getOrderId())
        	.orElseThrow(() -> new IllegalStateException("The Order does not exist!"));

        Payment payment = createFromDto(paymentDto);
        payment.setOrder(order);
        
        return mapToDto(this.paymentRepository.save(payment));
    }

    public void delete(Long id) {
        log.debug("Request to delete Payment : {}", id);
        this.paymentRepository.deleteById(id);
    }
}