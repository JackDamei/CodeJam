package y2019.kickstartrF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class MainA {

	@SuppressWarnings("unused")
	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintStream out = System.out;

		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int K = in.nextInt();

			int[] A = new int[N];
			for (int i=0; i<N; i++)
				A[i] = in.nextInt();
			
			int res = 0;
			
			out.println(String.format("Case #%d: %d",t+1,res));
		}

		in.close();
	}

}
