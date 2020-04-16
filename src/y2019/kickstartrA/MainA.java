package y2019.kickstartrA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MainA {

	static int S_MAX = 10000;
	
	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			
			int N = in.nextInt();
			int P = in.nextInt();
			int[] S = new int[N];
			for (int i=0; i<N; i++)
				S[i] = in.nextInt();
			
			// Sort the tab
			int[] repartition = new int[S_MAX+1];
			Arrays.fill(repartition,0);
			for (int i=0; i<N; i++)
				repartition[S[i]]++;
			int ind = 0;
			for (int i=0; i<S_MAX+1; i++)
				for (int j=0; j<repartition[i]; j++) {
					S[ind] = i;
					ind++;
				}

			long sum = 0;
			for (int i=0; i<P; i++)
				sum += S[i];
			long best = S[P-1]*P - sum;
			for (int i=1; i+P-1<N; i++) {
				sum -= S[i-1];
				sum += S[i+P-1];
				long score = S[i+P-1]*P - sum;
				best = Math.min(best, score);
			}
				
			System.out.println("Case #"+(t+1)+": "+best);

		}
		in.close();
	}
}

