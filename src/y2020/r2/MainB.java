package y2020.r2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class MainB {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		PrintStream out = System.out;
		int T = in.nextInt();
			
		for (int t=0; t<T; t++) {
			
			int N = in.nextInt();
			String M = in.next();
			int[] tab = new int[N];
			for (int i=0; i<N; i++)
				tab[i] = in.nextInt();
			
			String res = solve(N,M,tab);
			out.println(String.format("Case #%d: %s", t+1, res));
		}
		
		in.close();
	}

	public static String solve (int N, String M, int[] tab) {
		return "IMPOSSIBLE";
	}
	
}
