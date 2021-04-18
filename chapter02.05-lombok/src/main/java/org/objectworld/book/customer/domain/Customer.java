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
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper=true, exclude = {"email", "telephone"})
public class Customer extends AbstractEntity {
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	private String email;
	private String telephone;
	@NonNull
	private Boolean enabled;
}
