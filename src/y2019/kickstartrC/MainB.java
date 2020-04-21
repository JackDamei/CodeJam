package y2019.kickstartrC;

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

			int R = in.nextInt();
			int C = in.nextInt();
			int K = in.nextInt();
			int[][] V = new int[R][C];
			for (int i=0; i<R; i++)
				for (int j=0; j<C; j++)
					V[i][j] = in.nextInt();
			
			int max = 0;
			
			out.println(String.format("Case #%d: %d %d",t+1,max));
		}

		in.close();
	}

}
