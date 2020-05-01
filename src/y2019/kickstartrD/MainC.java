package y2019.kickstartrD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class MainC {

	public static class Position {
		final int X;
		final int C;
		public Position (int x, int c) {
			X = x;
			C = c;
		}
	}
	
	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintStream out = System.out;

		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int K = in.nextInt();
			int N = in.nextInt();
			int[] X = new int[N];
			for (int i=0; i<N; i++)
				X[i] = in.nextInt();
			int[] C = new int[N];
			for (int i=0; i<N; i++)
				C[i] = in.nextInt();

			// we don't need to pay attention to the warehouse
			// act like if it's a stall
			// so the warehouse is the middle stall
			// (one of the two middle stalls if even, doesn't matter which)
			// cost = S(C) + S(X)furthesthalf - S(X)closesthalf
			
			int[] l = new int[N];
			int[] r = new int[N];
			for (int i=0; i<N; i++) {
				l[i] = C[i] - X[i];
				r[i] = C[i] + X[i];
			}
			
			for (int mid=K/2; mid<N-(K/2); mid++) {
				
			}
			
			int min = 0;

			out.println(String.format("Case #%d: %d %d",t+1,min));
		}

		in.close();
	}

}
