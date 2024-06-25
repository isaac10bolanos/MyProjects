package www.skillstorm.general;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Notes {
	
	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(10, 9, 6, 2, 7, 5);
		
		Stream<Integer> data = nums.stream();
		Stream<Integer> mappedData = data.map(n -> n *2);
		
//		mappedData.forEach(n -> System.out.println(n));
		
		// This one liner is the same as above
		nums.stream()
				.filter(n -> n % 2 == 1) // filter finds a value and passes it to the next stream
				.sorted() // sorts the stream
				.map(n -> n *2) // maps the stream to a function
				.forEach(n -> System.out.println(n)); // prints it out
		
//		This for each essentially is the same as above as well	
//		for (int n : nums) {
//			System.out.println(n * 2);
//		}
		
		
//		data.forEach(n -> System.out.println(n));
//		can only use Stream once
//		data.forEach(n -> System.out.println(n));
		
//		nums.forEach(n -> System.out.println(n));
		
		//multiplyBy2();
		oddNumbers();
		//evenSquares();
		
		
	}
	
	public static void multiplyBy2() {
		
		List<Integer> nums = Arrays.asList(10, 9, 6, 2, 7, 5);
		
		Stream<Integer> data = nums.stream();
		Stream<Integer> mappedData = data.map(n -> n * 2);
		System.out.println("\nMultiplying by 2 using Stream API:");
		mappedData.forEach(n -> System.out.println(n));
		
	}
	
	public static void oddNumbers() {
		
		List<Integer> nums = Arrays.asList(10, 9, 6, 2, 7, 5);
		
		nums.stream()
					.filter(n -> n % 2 == 1)
					.sorted()
					.map(n -> n * 2)
					.forEach(n -> System.out.println(n));
		
	}
	
	public static void evenSquares() {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		List<Integer> evenSquares = numbers.stream()
									.filter(num -> num % 2 == 0)
									.map(num -> num * 2)
									.collect(Collectors.toList());
		
		System.out.println(evenSquares);
		
	}
	
	public static void primitiveTypes() {
		
	}

}
