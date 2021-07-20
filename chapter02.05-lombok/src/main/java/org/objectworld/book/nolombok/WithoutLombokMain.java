package org.objectworld.book.nolombok;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WithoutLombokMain {
	// 정적 함수에서 로그를 사용할 때에는 getClass() 함수를 사용할 수 없으므로 
	// 복사하기/붙여넣기를 할 수 없다.
	private static Logger log = LoggerFactory.getLogger(WithoutLombokMain.class);
	
	public static void main(String[] args) {
		log.info("Application will be statated at {}", LocalDate.now());
		WithoutLombokClass hello = new WithoutLombokClass();
		hello.hello();
	}
}
