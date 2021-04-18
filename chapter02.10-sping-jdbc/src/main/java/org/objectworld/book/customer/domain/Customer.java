package org.objectworld.book.customer.domain;

import javax.validation.constraints.Email;

import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * A Customer.
 */
@Data
@Table("CUSTOMERS")
@ToString(callSuper=true)
public class Customer extends AbstractEntity {
	private String firstName;
	private String lastName;
	@Email
	private String email;
	private String telephone;
	private Boolean enabled;
}
