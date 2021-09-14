package org.objectworld.shopping.domain;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * A Customer.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"firstName", "lastName", "email", "telephone"}, callSuper=true)
@ToString(callSuper=true)
@Builder
@Entity
@Table(name = "customers")
public class Customer extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private Set<Cart> carts;

    @Embedded
    @AttributeOverride(name = "address1", column = @Column(name = "home_address_1"))
    @AttributeOverride(name = "address2", column = @Column(name = "home_address_2"))
    @AttributeOverride(name = "city", column = @Column(name = "home_city"))
    @AttributeOverride(name = "country", column = @Column(name = "home_country"))
    @AttributeOverride(name = "postcode", column = @Column(name = "home_postcode"))
    private Address homeAddress;
    
    @Embedded
    @AttributeOverride(name = "address1", column = @Column(name = "office_address_1"))
    @AttributeOverride(name = "address2", column = @Column(name = "office_address_2"))
    @AttributeOverride(name = "city", column = @Column(name = "office_city"))
    @AttributeOverride(name = "country", column = @Column(name = "office_country"))
    @AttributeOverride(name = "postcode", column = @Column(name = "office_postcode"))
    private Address officeAddress;
    
    @Column(name = "enabled", nullable = false)
    private Boolean enabled;
}
