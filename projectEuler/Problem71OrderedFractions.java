package edunova.projectEuler;

public class Problem71OrderedFractions {

	static int gcd(int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}

	static boolean isLess(int a, int b, int c, int d) {
		return 1L * a * d < 1L * c * b;
	}

	public static void main(String[] args) {
		final int n = 1000000;

		int resNum = 0;
		int resDen = 1;

		for (int den = 1; den <= n; ++den) {
			int num = den * 3 / 7;
			if (num > 0 && isLess(num, den, 3, 7) && isLess(resNum, resDen, num, den)) {
				resNum = num / gcd(num, den);
				resDen = den / gcd(num, den);
			}
		}

		System.out.printf("%d/%d", resNum, resDen);
	}

}
