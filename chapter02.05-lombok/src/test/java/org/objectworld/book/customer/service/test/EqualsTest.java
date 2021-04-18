package org.objectworld.book.customer.service.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.objectworld.book.customer.domain.Customer;

class EqualsTest {

	@Test
	void EqualCaseTest() {
		Customer customer1 = new Customer("길동", "홍", true);
		customer1.setId(1L);
		Customer customer2 = new Customer("길동", "홍", true);
		customer2.setId(1L);
		// @EqualsAndHashCode의 callSuper 값에 상관없이 동일한 객체로 간주한다.
		Assertions.assertEquals(customer1, customer2);
	}

	@Test
	void NotEqualCaseTest() {
		Customer customer1 = new Customer("길동", "홍", true);
		customer1.setId(1L);
		Customer customer2 = new Customer("길동", "홍", true);
		customer2.setId(2L);
		// 만약 Customer 클래스가 @EqualsAndHashCode(callSuper = false)이면 이 테스트케이스는 실패한다.
		Assertions.assertNotEquals(customer1, customer2);
	}
	
	@Test
	void MutableCaseTest() {
		Customer customer = new Customer("길동", "홍", true);		
		HashSet<Customer> customerList = new HashSet<>();
		customerList.add(customer);
		System.out.println(customer);
		System.out.println(customerList);
		// customerList.contains(customer) == true
		Assertions.assertTrue(customerList.contains(customer), "Fail before setId");
		
		customer.setId(1L);	
		System.out.println(customer);
		System.out.println(customerList);
		// customerList.contains(customer) == false, because hashCode() value is changed
		Assertions.assertFalse(customerList.contains(customer), "Fail after setId");
	}
}
