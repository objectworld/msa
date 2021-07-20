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
		
		// Optional을 사용하여 Integer List 중 null값이 있으면 -1로 대체하는 람다 표현식
		Numbers myNumber = (numberList) -> numberList.forEach((number) -> 
			System.out.println(Optional.ofNullable(number).map(Integer::new).orElse(-1)));
		
		myNumber.introduce();
		myNumber.printList(myList);
	}
}
