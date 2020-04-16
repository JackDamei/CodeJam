package y2020.kickstartrA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

			int maxDiff = 0;
			int[] diff = new int[N-1];
			for (int i=0; i<N-1; i++) {
				diff[i] = M[i+1]-M[i];
				maxDiff = Math.max(maxDiff, diff[i]);
			}
			int a = 1;
			int b = maxDiff;
			while (a<b) {
				int half = (a+b)/2;
				int cpt = 0;
				for (int i=0; i<N-1; i++)
					if (diff[i] > half)
						cpt += (diff[i]-1)/half;
				if (cpt > K)
					a = half+1;
				else
					b = half;
			}
			
			System.out.println("Case #"+(t+1)+": "+a);
		}
		in.close();
	}
}