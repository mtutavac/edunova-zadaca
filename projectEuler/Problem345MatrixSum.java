package edunova.projectEuler;

import java.util.Scanner;

public class Problem345MatrixSum {

	public static void main(String[] args) {
		int n = 5;
		var mat = new int[n][n];
		var dyn = new int[1 << n];
		var input = new Scanner(System.in);
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				mat[i][j] = input.nextInt();
			}
		}
		input.close();
		for (int i = (1 << n) - 2; i >= 0; --i) {
			var row = mat[Integer.bitCount(i)];
			for (int j = 0; j < n; ++j) {
				if ((i >> j & 1) == 0) {
					dyn[i] = Math.max(dyn[i], dyn[i | 1 << j] + row[j]);
				}
			}
		}
		System.out.println(dyn[0]);
	}

}
