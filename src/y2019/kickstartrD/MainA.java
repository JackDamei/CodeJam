package y2019.kickstartrD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class MainA {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintStream out = System.out;

		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int Q = in.nextInt();
			int[] A = new int[N];
			for (int i=0; i<N; i++)
				A[i] = in.nextInt();
			int[] P = new int[Q];
			int[] V = new int[Q];
			for (int i=0; i<N; i++) {
				P[i] = in.nextInt();
				V[i] = in.nextInt();
			}

			String res = "";
			int max = 0;
			
			for (int q=0; q<Q; q++) {
				int p = P[q];
				int v = V[q];
				A[p] = v;
				
				res += max+" ";
			}
			
			out.println(String.format("Case #%d: %s",t+1,res));
		}

		in.close();
	}

}
