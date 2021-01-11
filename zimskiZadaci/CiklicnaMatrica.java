package edunova.zimskiZadaci;

import java.util.Scanner;

public class CiklicnaMatrica {

	public static void main(String[] args) throws Exception {
		var ulaz = new Scanner(System.in);
		int n = ulaz.nextInt();
		int m = ulaz.nextInt();
		ulaz.close();

		var izlaz = System.out;
//		var izlaz = new PrintStream(new File("output.txt"));

		if (n < 0 || m < 0 || n > 100 || m > 100) {
			return;
		}

		var mat = new int[n][m];

		int broj = 1; // trenutni broj
		int rPoz = n - 1; // trenutni redak
		int sPoz = m; // trenutni stupac

		while (broj <= n * m) {
			while (sPoz - 1 >= 0 && mat[rPoz][sPoz - 1] == 0) {
				mat[rPoz][--sPoz] = broj++;
			}
			while (rPoz - 1 >= 0 && mat[rPoz - 1][sPoz] == 0) {
				mat[--rPoz][sPoz] = broj++;
			}
			while (sPoz + 1 < m && mat[rPoz][sPoz + 1] == 0) {
				mat[rPoz][++sPoz] = broj++;
			}
			while (rPoz + 1 < n && mat[rPoz + 1][sPoz] == 0) {
				mat[++rPoz][sPoz] = broj++;
			}
		}

		int brojZnamenki = (int) Math.ceil(Math.log10(n * m + 1));
		var format = String.format("%%%dd ", brojZnamenki); // -> "%{digits}d "

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				izlaz.printf(format, mat[i][j]);
//				izlaz.printf("%3d ", mat[i][j]);
			}
			izlaz.println();
		}
	}

}
