package y2020.kickstartA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int B = in.nextInt();
			
			int[] A = new int[N];
			for (int i=0; i<N; i++)
				A[i] = in.nextInt();
			Arrays.sort(A);

			int res = 0;
			int price = 0;			
			while (res < N && (price += A[res]) <= B) {
				res++;
			}
			
			System.out.println("Case #"+(t+1)+": "+res);
		}
		in.close();
	}
}
