package edunova.projectEuler;

import java.util.Arrays;

public class Problem32PrimePermutations {

	public static void main(String[] args) {
		final int n = 10000;

		var sorted = new int[n];
		var isPrime = new boolean[n];
		Arrays.fill(isPrime, true);

		for (int i = 2; i < n; ++i) {
			if (isPrime[i]) {
				for (int j = i + i; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = 1000; i < n; ++i) {
			var digits = String.valueOf(i).toCharArray();
			Arrays.sort(digits);
			sorted[i] = Integer.parseInt(String.valueOf(digits));
		}

		for (int i = 1000; i < n; ++i) {
			if (isPrime[i]) {
				for (int j = i + 1; j + (j - i) < n; ++j) {
					if (isPrime[j] && isPrime[j + (j - i)] && sorted[i] == sorted[j]
							&& sorted[i] == sorted[j + (j - i)]) {
						System.out.printf("%d %d %d\n", i, j, j + (j - i));
					}
				}
			}
		}
	}

}
