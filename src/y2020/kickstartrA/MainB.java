package y2020.kickstartrA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainB {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			int N = in.nextInt();
			int K = in.nextInt();
			int P = in.nextInt();

			int[][] beauty = new int [N][K];
			for (int i=0; i<N; i++)
				for (int j=0; j<K; j++)
					beauty[i][j] = in.nextInt();

			int[][] stackScore = new int[N][K+1];
			for (int i=0; i<N; i++) {
				stackScore[i][0] = 0;
				int sum = 0;
				for (int j=0; j<K; j++) {
					sum += beauty[i][j];
					stackScore[i][j+1] = sum;
				}
			}

			int[][] best = new int [N][P+1];
			for (int n=0; n<N; n++)
				best[n][0] = 0;
			// init best with first column
			for (int k=0; k<=K; k++) {
				if (k > P)
					break;
				best[0][k] = stackScore[0][k];
			}
			
			for (int n=1; n<N; n++) {
				for (int p=1; p<=P; p++) {
					if (p > (n+1)*K)
						break;
					int max = 0;
					for (int k=0; k<=K; k++) {
						if (k > p)
							break;
						int score = best[n-1][p-k] + stackScore[n][k];
						if (score > max)
							max = score;
					}
					best[n][p] = max;
				}
			}

			System.out.println("Case #"+(t+1)+": "+best[N-1][P]);
		}
		in.close();
	}
}