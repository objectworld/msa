package org.objectworld.book.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
	public interface Numbers {
		default public void introduce() {
			System.out.println("Let's print nubmers");
		}
		public void printList(List<Integer> numberList, int lessThan);
	}
	
	public static void main(String[] args) {
		Integer[] numbers = new Integer[] {
				6, 5, 4, 3, 2, 1
		};
		List<Integer> myList = Arrays.asList(numbers);
		
		Numbers myNumber = (numberList, lessThan) -> {
			Stream<Integer> filteredList = numberList.stream().filter(
					numberStream -> (numberStream.compareTo(lessThan) < 0));
			filteredList.forEach(System.out::println);
		};
		myNumber.introduce();
		myNumber.printList(myList, 3);
	}
}
