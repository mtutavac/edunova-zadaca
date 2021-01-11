package edunova.projectEuler;

public class Problem2EvenFibonacciNumbers {

	public static void main(String[] args) {
		int sum = 0;
		int fib1 = 0;
		int fib2 = 1;
		while (fib1 + fib2 < 4000000) {
			int fib3 = fib1 + fib2;
			fib1 = fib2;
			fib2 = fib3;
			if (fib2 % 2 == 0) {
				sum += fib2;
			}
			System.out.println(fib2);
		}
		System.out.println(sum);
	}

}
