package y2018.r1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int R = in.nextInt();
			int C = in.nextInt();
			int H = in.nextInt();
			int V = in.nextInt();
			
			boolean[][] waffle = new boolean[R][C];
			for (int i=0; i<R; i++) {
				String s = in.next();
				for (int j=0; j<C; j++) {
					waffle[i][j] = s.charAt(j) == '@';
				}
			}
			
			String res = solve(R,C,H,V, waffle) ? "POSSIBLE" : "IMPOSSIBLE";
			
			System.out.println("Case #"+(t+1)+": "+res);
		}
		in.close();
	}

	private static boolean solve(int R, int C, int H, int V, boolean[][] waffle) {
		int total = 0;
		for (int i=0; i<R; i++)
			for (int j=0; j<C; j++)
				total += waffle[i][j] ? 1 : 0;
		if (total == 0)
			return true;
		if (total%((H+1)*(V+1)) != 0)
			return false;

		// find cuts
		int[] rows = new int[H+2];
		int[] columns = new int[V+2];
		rows[0] = 0;
		columns[0] = 0;
		int index = 0;
		int score = 0;
		int target = total/(H+1);
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++)
				score += waffle[i][j] ? 1 : 0;
			if (score == target) {
				rows[++index] = i+1;
				score = 0;
			}
			if (score > target)
				return false;
		}
		index = 0;
		score = 0;
		target = total/(V+1);
		for (int i=0; i<C; i++) {
			for (int j=0; j<R; j++)
				score += waffle[j][i] ? 1 : 0;
			if (score == target) {
				columns[++index] = i+1;
				score = 0;
			}
			if (score > target)
				return false;
		}
		
		// check cuts
		target = total/((H+1)*(V+1));
		for (int r=0; r<H+1; r++)
			for (int c=0; c<V+1; c++) {
				score = 0;
				for (int i=rows[r]; i<rows[r+1]; i++)
					for (int j=columns[c]; j<columns[c+1]; j++)
						score += waffle[i][j] ? 1 : 0;
				if (score != target)
					return false;
			}
		
		return true;
	}

}
