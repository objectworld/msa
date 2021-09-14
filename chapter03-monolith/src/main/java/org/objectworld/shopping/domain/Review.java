package org.objectworld.shopping.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.objectworld.shopping.domain.enumeration.CartStatus;
import org.objectworld.shopping.domain.enumeration.ProductStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

/**
 * A Review.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"title", "description", "rating"}, callSuper=true)
@ToString(of = {"title", "description", "rating"}, callSuper=true)
@Entity
@Table(name = "reviews")
public class Review extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "rating", nullable = false)
    private Long rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "products_reviews"	// 조인 테이블명
		, joinColumns = @JoinColumn(name = "reviews_id")	// 외래 키
		, inverseJoinColumns = @JoinColumn(name = "product_id")	// Target 엔티티의 외래키
    )
    private Product product;
    
    @Builder
    public Review(@NotNull String title, @NotNull String description, @NotNull Long rating) {
        this.title = title;
        this.description = description;
        this.rating = rating;
    }
}
