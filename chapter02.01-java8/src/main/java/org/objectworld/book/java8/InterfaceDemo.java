package org.objectworld.book.java8;

import java.util.Arrays;
import java.util.List;

public class InterfaceDemo {	public interface Numbers {
		public void printList(List<Integer> numberList);
	}
	
	public static void main(String[] args) {
		Integer[] numbers = new Integer[] {
				6, 5, 4, 3, 2, 1
		};
		List<Integer> myList = Arrays.asList(numbers);
		
		// Interger List를 프린트하는 익명 클래스
		Numbers myNumber = new Numbers() {
			@Override 
			public void printList(List<Integer> numberList) {
				numberList.forEach(number -> System.out.println(number));
			}
		};
		myNumber.printList(myList);
	}
}
