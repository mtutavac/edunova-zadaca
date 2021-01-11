package edunova.zimskiZadaci;

import java.util.Scanner;

public class PrimBrojevi {

	public static void main(String[] args) throws Exception {
		var ulaz = new Scanner(System.in);
		int a = ulaz.nextInt();
		int b = ulaz.nextInt();
		ulaz.close();

		if (a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		if (a < 0 || b < 0 || a > 1000 || b > 1000) {
			return;
		}

		var isPrime = new boolean[b + 1];
		for (int i = 2; i <= b; ++i) {
			isPrime[i] = true;
		}

		for (int i = 2; i <= b; ++i) {
			if (isPrime[i]) {
				for (int j = i + i; j <= b; j += i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = a; i <= b; ++i) {
			if (isPrime[i]) {
				System.out.println(i);
			}
		}
	}

}
