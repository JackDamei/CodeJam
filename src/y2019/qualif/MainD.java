package y2019.qualif;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainD {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			int N = in.nextInt();
			int B = in.nextInt();
			@SuppressWarnings("unused")
			int F = in.nextInt();

			int[][] table = new int[N-B][4];

			for (int i=0; i<4; i++) {
				String query = "";
				int alt = (int)Math.pow(2,i);
				for (int j=0; j<N; j++)
					query += (j/alt)%2;
				System.out.println(query);
				System.out.flush();
				String ans = in.next();
				for (int j=0; j<N-B; j++)
					table[j][i] = Integer.parseInt(ans.substring(j, j+1));
			}
			
			int cpt = 0;
			int i = 0;
			String res = "";
			while (cpt < B) {
				if ((i-cpt>=N-B)
						|| (i%16) != getTableValue(table, i-cpt)) {
					res += i+" ";
					cpt++;
				}
				i++;
			}
			
			System.out.println(res);
			System.out.flush();
			N = in.nextInt();
			if (N == -1) {
				in.close();
				return;
			}
		}
		in.close();
	}

	public static int getTableValue (int[][] table, int n) {
		int size = 4;
		int res = 0;
		for (int i=0; i<size; i++)
			res += table[n][i] * Math.pow(2, i);
		return res;
	}

}
