package y2020.kickstartA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainC {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			int N = in.nextInt();
			int K = in.nextInt();

			int[] M = new int [N];
			for (int i=0; i<N; i++)
				M[i] = in.nextInt();



			//System.out.println("Case #"+(t+1)+": "+res);
		}
		in.close();
	}
}