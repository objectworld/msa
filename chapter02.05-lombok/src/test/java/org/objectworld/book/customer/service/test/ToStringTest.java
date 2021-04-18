package org.objectworld.book.customer.service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.objectworld.book.customer.domain.Customer;

class ToStringTest {

	@Test
	void toStringTest() {
		Customer customer = new Customer("길동", "홍", true);
		customer.setId(1L);
		System.out.println(customer);
	}
}
