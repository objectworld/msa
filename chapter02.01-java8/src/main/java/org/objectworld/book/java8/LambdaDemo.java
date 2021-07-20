package org.objectworld.book.java8;

import java.util.Arrays;
import java.util.List;

public class LambdaDemo {
	public interface Numbers {
		public void printList(List<Integer> numberList);
	}
	
	public static void main(String[] args) {
		Integer[] numbers = new Integer[] {
				6, 5, 4, 3, 2, 1
		};
		List<Integer> myList = Arrays.asList(numbers);
		
		// Integer List를 프린트하는 람다 표현식
		Numbers myNumber = (numberList) -> numberList.forEach(number -> System.out.println(number));
		myNumber.printList(myList);
	}
}
