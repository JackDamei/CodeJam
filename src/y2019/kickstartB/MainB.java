package y2019.kickstartB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainB {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();

			Stone[] stones = new Stone[N];
			for (int i=0; i<N; i++) {
				int S = in.nextInt();
				int E = in.nextInt();
				int L = in.nextInt();
				stones[i] = new Stone(S,E,L);
			}
			
			// test 1
			int time = 0;
			int energy = 0;
			
			energy = time;
			
			
			System.out.println(String.format("Case #%d: %d",t+1, energy));
		}

		in.close();
	}
	
	public static class Stone {
		final int S;
		final int E;
		final int L;
		public Stone(int s, int e, int l) {
			super();
			S = s;
			E = e;
			L = l;
		}
		public int getEnergy(int t) {
			return E-L*t;
		}
	}
	
}
