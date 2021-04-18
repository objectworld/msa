package org.objectworld.book.nolombok;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WithoutLombokMain {
	private static Logger log = LoggerFactory.getLogger(WithoutLombokMain.class);
	
	public static void main(String[] args) {
		log.info("Application will be statated at {}", LocalDate.now());
		WithoutLombokClass hello = new WithoutLombokClass();
		hello.hello();
	}
}
