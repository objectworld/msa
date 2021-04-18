package org.objectworld.book.java8;

import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {
	public interface Numbers {
		public void printList(List<Integer> numberList);
	}
	
	public static void main(String[] args) {
		Integer[] numbers = new Integer[] {
				6, 5, 4, 3, 2, 1
		};
		List<Integer> myList = Arrays.asList(numbers);
		
		Numbers myNumber = (numberList) -> numberList.forEach(System.out::println);
		myNumber.printList(myList);
	}
}
