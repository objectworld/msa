package org.objectworld.book.nolombok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WithoutLombokClass {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	public void hello() {
		log.info("Say Hello");
	}
}
