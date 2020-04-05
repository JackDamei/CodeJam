package y2020qualif;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainE {

	public static void main(String[] args) {

		Integer[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		List<Integer> list = Arrays.asList(primes);
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			
			int N = in.nextInt();
			int K = in.nextInt();

			String res = "";
			
			// EASY CASE
			if (K%N == 0) {
				System.out.println("Case #"+(t+1)+": POSSIBLE");
				int base = K/N;
				for (int i=0; i<N; i++) {
					res = "";
					for (int j=0; j<N; j++)
						res += ((base+i-j+N-1)%N+1)+" ";
					System.out.println(res);
				}
				continue;
			} 
			if(K==N+1 || K==N*N-1) {
				System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
				continue;
			}
			
			// Find a divisor
			// Create groups
			
			
		}
		in.close();
	}
}
