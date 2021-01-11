package edunova.projectEuler;

import java.util.Arrays;

public class Problem77PrimeSummations {

	public static void main(String[] args) {
		final int n = 101;

		var isPrime = new boolean[n];
		Arrays.fill(isPrime, true);

		for (int i = 2; i < n; ++i) {
			if (isPrime[i]) {
				for (int j = i + i; j < n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		var sums = new long[n][n];
		sums[0][0] = 1;

		for (int i = 2; i < n; ++i) {
			for (int j = 2; j <= i; ++j) {
				sums[i][j] = sums[i][j - 1];
				if (isPrime[j]) {
					sums[i][j] += sums[i - j][Math.min(i - j, j)];
				}
			}
			if (sums[i][i] - (isPrime[i] ? -1 : 0) > 5000) {
				System.out.printf("%d %d\n", i, sums[i][i]);
			}
		}

		System.out.println(sums[10][10]);
		System.out.println(sums[100][100]);
	}

}
