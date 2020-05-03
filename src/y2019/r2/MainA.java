package y2019.r2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MainA { // TO BE CORRECTED

	public static class Interval {
		double a, b;
		public Interval (double a, double b) {
			this.a = a;
			this.b = b;
		}
		public Interval intersection (Interval other) {
			if (this == null || other == null)
				return null;
			double resA = Double.max(a, other.a);
			double resB = Double.min(b, other.b);
			if (resA >= resB)
				return null;
			return new Interval(resA,resB);
		}
	}

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int[][] molecules = new int[N][2];
			for (int i=0; i<N; i++) {
				molecules[i][0] = in.nextInt();
				molecules[i][1] = in.nextInt();
			}

			Interval[][] intervals = new Interval[N][N];
			for (int i=0; i<N; i++) {
				int Ci = molecules[i][0];
				int Ji = molecules[i][1];
				for (int j=0; j<N; j++) {

					int Cj = molecules[j][0];
					int Jj = molecules[j][1];

					double diffC = Cj-Ci;
					double diffJ = Jj-Ji;						

					if (diffC <= 0 && diffJ <= 0) continue;

					// case same ratio
					if (diffC >= 0 && diffJ >= 0)
						intervals[i][j] = new Interval(0,Double.POSITIVE_INFINITY);
					else if (diffC > 0)
						intervals[i][j] = new Interval(0,-diffJ/diffC);
					else
						intervals[i][j] = new Interval(-diffJ/diffC,Double.POSITIVE_INFINITY);					
				}
			}

			boolean[] used = new boolean[N];
			long res = solve(N, intervals, new Interval(0,Double.POSITIVE_INFINITY), 0, used, -1);

			System.out.println(String.format("Case #%d: %d",t+1, res));
		}

		in.close();
	}

	private static long solve(int N, Interval[][] intervals, Interval range, int sorted, boolean[] used, int prev) {
		
		// base case
		if (sorted == N-1) {
			int i=0;
			while (used[i]) i++;
			return range.intersection(intervals[prev][i]) == null ?
					0 : 1;
		}
		
		int cpt = 0;
		
		// recursion
		for (int i=0; i<N; i++) {
			
			if (used[i]) continue;
			
			Interval tmp = prev == -1 ? range : intervals[prev][i];
			tmp = range.intersection(tmp);
			
			if (tmp == null) continue;
			
			boolean[] copy = Arrays.copyOf(used, N);
			copy[i] = true;
			cpt += solve(N,intervals,tmp,sorted+1,copy,i);
		}
		
		return cpt;
	}

}
