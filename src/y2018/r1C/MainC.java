package y2018.r1C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MainC {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			
			int N = in.nextInt();
			long[] w = new long[N];
			for (int i=0; i<N; i++)
				w[i] = in.nextLong();
			
			long[] min = new long[N+1];
			Arrays.fill(min,Long.MAX_VALUE);
			min[0] = 0;
			int maxstack = 0;
			
			for (int i=0; i<N; i++) {
				for (int k=maxstack; k>=0; k--) {
					if (min[k] <= 6*w[i]) {
						maxstack = Math.max(maxstack, k+1);
						min[k+1] = Math.min(min[k+1], min[k]+w[i]);
					}
				}
			}
			
			System.out.println(String.format("Case #%d: %d",t+1,maxstack));
		}
		
		in.close();
	}
	
}
