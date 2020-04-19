package y2020.kickstartrB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainA {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
		
			int N = in.nextInt();
			int[] H = new int[N];
			for (int i=0; i<N; i++) {
				H[i] = in.nextInt();
			}
			
			int res = 0;
			for (int i=1; i<N-1; i++)
				res += H[i]>H[i-1]&&H[i]>H[i+1] ? 1 : 0;
			
			System.out.println(String.format("Case #%d: %d",t+1, res));
		}
		
		in.close();
	}
	
}
