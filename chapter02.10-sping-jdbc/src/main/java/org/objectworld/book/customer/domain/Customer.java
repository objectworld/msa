package org.objectworld.book.customer.domain;

import javax.validation.constraints.Email;

import org.springframework.data.relational.core.mapping.Table;

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
@Table("CUSTOMERS")
public class Customer extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
	private String firstName;
	private String lastName;
	@Email
	private String email;
	private String telephone;
	private Boolean enabled;
}
