package org.objectworld.book.java8;

import java.util.Arrays;
import java.util.List;

public class DefaultMethodDemo {
	public interface Numbers {
		// 인터페이스 기본 메소드
		default public void introduce() {
			System.out.println("Let's print nubmers");
		}
		public void printList(List<Integer> numberList);
	}
	
	public static void main(String[] args) {
		Integer[] numbers = new Integer[] {
				6, 5, 4, 3, 2, 1
		};
		List<Integer> myList = Arrays.asList(numbers);
		
		Numbers myNumber = (numberList) -> numberList.forEach(System.out::println);
		myNumber.introduce();
		myNumber.printList(myList);
	}
}
