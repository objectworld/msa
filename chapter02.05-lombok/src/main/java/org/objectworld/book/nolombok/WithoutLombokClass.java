package org.objectworld.book.nolombok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WithoutLombokClass {
	// getClass() 함수로 로깅 클래스를 지정할 수 있므로 복사하기/붙여넣기를 할 수 있다.
	private Logger log = LoggerFactory.getLogger(getClass());
	
	public void hello() {
		log.info("Say Hello");
	}
}
