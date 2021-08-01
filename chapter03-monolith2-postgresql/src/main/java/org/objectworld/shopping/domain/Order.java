package org.objectworld.shopping.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.objectworld.shopping.domain.enumeration.OrderStatus;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

/**
 * A Orders.
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of= {"totalPrice", "status", "shipped", "payment", "shipmentAddress", "cart"}, callSuper=true)
@ToString(callSuper=true)
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Column(name = "total_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal totalPrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @Column(name = "shipped")
    private ZonedDateTime shipped;

    @OneToOne
    @JoinColumn(unique = true)
    private Payment payment;

    @Embedded
    private Address shipmentAddress;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<OrderItem> orderItems;

    @OneToOne
    @JsonIgnore
    private Cart cart;

    public Order(@NotNull BigDecimal totalPrice, @NotNull OrderStatus status,
                 ZonedDateTime shipped, Payment payment, Address shipmentAddress,
                 Set<OrderItem> orderItems, Cart cart) {
        this.totalPrice = totalPrice;
        this.status = status;
        this.shipped = shipped;
        this.payment = payment;
        this.shipmentAddress = shipmentAddress;
        this.orderItems = orderItems;
        this.cart = cart;
    }
}
