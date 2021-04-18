package org.objectworld.book.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
	public interface Numbers {
		default public void introduce() {
			System.out.println("Let's print nubmers");
		}
		public void printList(List<Integer> numberList);
	}
	
	public static void main(String[] args) {
		Integer[] numbers = new Integer[] {
				6, 5, 4, 3, 2, null
		};
		List<Integer> myList = Arrays.asList(numbers);
		
		// null 이면 -1을 프린트
		Numbers myNumber = (numberList) -> numberList.forEach((number) -> 
			System.out.println(Optional.ofNullable(number).map(Integer::new).orElse(-1)));
		
		myNumber.introduce();
		myNumber.printList(myList);
	}
}
