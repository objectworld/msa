package org.objectworld.shopping.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A OrderItem.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"quantity", "product", "order"}, callSuper=true)
@Builder
@Entity
@Table(name = "order_items")
public class OrderItem extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    
    @Override
    public String toString() {
        return "OrderItem{" +
                "quantity=" + quantity +
                ", product=" + product.getName() +
                '}';
    }
}
