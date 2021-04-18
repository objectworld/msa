package org.objectworld.book.customer.domain;

import lombok.Data;
import lombok.ToString;

/**
 * A Customer.
 */
@Data
@ToString(callSuper=true)
public class Customer extends AbstractEntity {
	private String firstName;
	private String lastName;
	private String email;
	private String telephone;
	private Boolean enabled;
}
