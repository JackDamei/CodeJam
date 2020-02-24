package y2018qualif;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class MainB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();
				
		for (int t=0; t<T; t++) {
			
			int N = in.nextInt();
			
			int[] even = new int[(N+1)/2];
			int[] odd = new int[N/2];
			for (int i=0; i<N; i++) {
				if (i%2 == 0)
					even[i/2] = in.nextInt();
				else
					odd[i/2] = in.nextInt();
			}

			Arrays.sort(even);
			Arrays.sort(odd);
			
			int i = 0;
			int prev = Integer.MIN_VALUE;
			while (i < N) {
				if (i%2 == 0) {
					if (even[i/2] < prev)
						break;
					prev = even[i/2];
				} else {
					if (odd[i/2] < prev)
						break;
					prev = odd[i/2];
				}
				i++;
			}
			if (i < N)
				System.out.println("Case #"+(t+1)+": "+(i-1));
			else
				System.out.println("Case #"+(t+1)+": OK");
			
		}
		in.close();
	}

}
