package www.skillstorm.general;

public class CalculatingFactorials {
	
	public static void main(String[] args) {
		System.out.println("Recursive Factorial\n");
//		System.out.println(factorial(-1));
		System.out.println(factorial(0)); // 1
		System.out.println(factorial(1)); // 1
		System.out.println(factorial(2)); // 2
		System.out.println(factorial(3)); // 6
		System.out.println(factorial(4)); // 24
		System.out.println(factorial(5)); // 120
		System.out.println(factorial(6)); // 720
		System.out.println(factorial(20)); // 2432902008176640000
		System.out.println(factorial(21)); // produces range long doesn't have
		System.out.println("\nIterative Factorial\n");
//		System.out.println(iterativeFactorial(-1));
		System.out.println(iterativeFactorial(0)); // 1
		System.out.println(iterativeFactorial(1)); // 1
		System.out.println(iterativeFactorial(2)); // 2
		System.out.println(iterativeFactorial(3)); // 6
		System.out.println(iterativeFactorial(4)); // 24
		System.out.println(iterativeFactorial(5)); // 120
		System.out.println(iterativeFactorial(6)); // 720
		System.out.println(iterativeFactorial(20)); // 2432902008176640000
		System.out.println(iterativeFactorial(21)); // produces range long doesn't have

	}
	
	// n! = n * (n - 1) * (n - 2) * ... 1
	public static long factorial(int n) {
		// negative numbers are no good
		if(n < 0) {
			throw new IllegalArgumentException("Not a valid number");
			// at 21 and above exceeds long range
		} else if(n >= 21) {
			System.out.println("Exeeded long range");
			return 0;	
		}
		// if given 0 then return 1
		if(n == 0) {
			//System.out.print(" = ");
			return 1;
		} 
		//System.out.print(n + " | ");
			
		// recursive n * (n - 1)
		return n * factorial(n - 1);	
		
	}
	
	public static long iterativeFactorial(int n) {
		
		if(n < 0) {
			throw new IllegalArgumentException("Cannot accept negative numbers");
			// at 21 and above exceeds long range
		} else if(n >= 21) {
			System.out.println("Exeeded long range");
			return 0;	
		}
		if(n == 0) {
			return 1;
		}
		// long for large values
		long sum = n;
		// i is one less than n ( 3 - 1) == 2
		// sum = 3 * 2
		// we continue as i is greater than 0
		for(int i = n - 1; i > 0; i--) {
			sum = sum * i;
		}
		return sum;
	}

}
