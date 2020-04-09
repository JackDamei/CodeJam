package y2020.kickstartA;

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
			
			
			
			
			//System.out.println("Case #"+(t+1)+": "+res);
		}
		in.close();
	}
}