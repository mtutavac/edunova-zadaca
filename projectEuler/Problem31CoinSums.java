package edunova.projectEuler;

public class Problem31CoinSums {

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 };

		var numberOfTimes = new long[201][coins.length];
		numberOfTimes[0][0] = 1;

		for (int i = 1; i <= 200; ++i) {
			for (int j = 0; j < coins.length; ++j) {
				if (i - coins[j] >= 0) {
					for (int k = 0; k <= j; ++k) {
						numberOfTimes[i][j] += numberOfTimes[i - coins[j]][k];
					}
				}
			}
		}

		long total = 0;
		for (int i = 0; i < coins.length; ++i) {
			total += numberOfTimes[200][i];
		}
		System.out.println(total);
	}

}
