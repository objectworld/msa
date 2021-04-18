package org.objectworld.book.customer.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * A Customer.
 */
@Data
@Alias("customer")
@ToString(callSuper=true)
public class Customer extends AbstractEntity {
	private String firstName;
	private String lastName;
	private String email;
	private String telephone;
	private Boolean enabled;
}
