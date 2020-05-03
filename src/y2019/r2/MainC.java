package y2019.r2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class MainC {

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
			int[] C = new int[N];
			int[] J = new int[N];
			for (int i=0; i<N; i++) {
				C[i] = in.nextInt();
				J[i] = in.nextInt();
			}

//			String res = solve(N,C,J);
			
//			System.out.println(String.format("Case #%d: %s",t+1, res));
		}

		in.close();
	}
	/*
	public static String solve (int N, int[] C, int[] J) {
		Interval range = new Interval(0,Double.POSITIVE_INFINITY);
		
		for (int j=1; j<N; j++) {
			int i = j-1;
			if (C[j]<=C[i] && J[j]<=J[i])
				return "IMPOSSIBLE";
			if (C[j]>=C[i] && J[j]>=J[i])
				continue;
		}
	}
	*/
	
}
