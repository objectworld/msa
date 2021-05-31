package org.objectworld.shopping.web;

import org.objectworld.shopping.service.OrderService;
import org.objectworld.shopping.web.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import static org.objectworld.shopping.common.Web.API;

import java.util.List;

/**
 * @author Nebrass Lamouchi
 */
@RestController
@RequestMapping(API + "/orders")
public class OrderResource {

    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto> findAll() {
        return this.orderService.findAll();
    }

    @GetMapping("/customer/{id}")
    public List<OrderDto> findAllByUser(@PathVariable Long id) {
        return this.orderService.findAllByUser(id);
    }

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable Long id) {
        return this.orderService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.orderService.delete(id);
    }
}
