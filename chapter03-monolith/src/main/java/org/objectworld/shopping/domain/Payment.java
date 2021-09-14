package org.objectworld.shopping.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.objectworld.shopping.domain.enumeration.PaymentStatus;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * A Payment.
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {"paypalPaymentId"}, callSuper=false)
@ToString(callSuper=true)
@Entity
@Table(name = "payments")
public class Payment extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "paypal_payment_id")
    private String paypalPaymentId;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PaymentStatus status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id", unique = true)
    @ToString.Exclude	
    private Order order;

    @ToString.Include
    public Long orderId() {
    	return order.getId();
    }

    @Builder
    public Payment(String paypalPaymentId, @NotNull PaymentStatus status, Order order) {
        this.paypalPaymentId = paypalPaymentId;
        this.status = status;
        this.order = order;
    }
}
