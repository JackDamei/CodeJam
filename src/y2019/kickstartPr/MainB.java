package y2019.kickstartPr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainB {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			
			int N = in.nextInt();
			String s = in.next();
			int[] beauty = new int[N];
			for (int i=0; i<N; i++)
				beauty[i] = Integer.parseInt(s.substring(i, i+1));
			
			int size = (N+1)/2;
			int sum = 0;
			for (int i=0; i<size; i++)
				sum += beauty[i];
			int best = sum;
			for (int i=1; i<N-size+1; i++) {
				sum -= beauty[i-1];
				sum += beauty[i+size-1];
				best = Math.max(best, sum);
			}
			
			System.out.println("Case #"+(t+1)+": "+best);

		}
		in.close();
	}
}

