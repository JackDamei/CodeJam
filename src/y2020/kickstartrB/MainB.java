package y2020.kickstartrB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainB {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
		
			int N = in.nextInt();
			long D = in.nextLong();
			
			long[] X = new long[N]; 
			for (int i=0; i<N; i++)
				X[i] = in.nextLong();
			
			long res = D;
			for (int i=N-1; i>=0; i--)
				res -= res%X[i];
			
			System.out.println(String.format("Case #%d: %d",t+1, res));
		}
		
		in.close();
	}

}
