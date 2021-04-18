package org.objectworld.book.lombok;

import java.time.LocalDate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WithLombokMain {
	
	public static void main(String[] args) {
		log.info("Application will be statated at {}", LocalDate.now());
		WithLombokClass hello = new WithLombokClass();
		hello.hello();
	}
}
