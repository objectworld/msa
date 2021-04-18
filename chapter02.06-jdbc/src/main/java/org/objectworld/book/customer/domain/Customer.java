package org.objectworld.book.customer.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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
