package y2019.kickstartPr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainC {
	
	static int MODULO = (int) Math.pow(10,  7) + 7;

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			// size of A (10⁶)
			int N = in.nextInt();
			// clock rings K times (10⁴)
			int K = in.nextInt();
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int C = in.nextInt();
			int D = in.nextInt();
			int E1 = in.nextInt();
			int E2 = in.nextInt();
			int F = in.nextInt();
			// A_1 = x1 + y1
			// A_i = (C+D)*A_i-1 + E1+E2
			long[] A = new long[N+1];
			int a = C+D;
			int b = E1+E2;
			A[1] = x1+y1;
			for (int i=2; i<N+1; i++)
				A[i] = (a*A[i-1]+b)%F;
			
			// EASYMODE
			
			for (int k=1; k<=K; k++) {
				
			}
		}
		in.close();
	}
}


