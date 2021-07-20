package org.objectworld.book.lombok;

import lombok.extern.slf4j.Slf4j;

@Slf4j //로깅을 위한 롬복 애노테이션
public class WithLombokClass {
	public void hello() {
		log.info("Say Hello");
	}
}
