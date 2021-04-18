package org.objectworld.book.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Data;
import lombok.ToString;

/**
 * A Customer.
 */
@Data
@Entity
@Table(name = "customers")
@ToString(callSuper=true)
public class Customer extends AbstractEntity {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Email
	@Column(name = "email")
	private String email;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "enabled", nullable = false)
	private Boolean enabled;
}
