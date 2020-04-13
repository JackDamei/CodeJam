package y2018.r1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MainB {
	
	static long MAX = (long) Math.pow(10, 18);

	public static class Cashier {
		final int M;
		final int S;
		final int P;
		public Cashier(int m, int s, int p) {
			M = m;
			S = s;
			P = p;
		}
		public int capacity (long t) {
			return (int) Math.min((t-P)/S, M);
		}
	}
	
	
	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int R = in.nextInt();
			int B = in.nextInt();
			int C = in.nextInt();

			Cashier[] cashiers = new Cashier[C];
			for (int i=0; i<C; i++) {
				int M = in.nextInt();
				int S = in.nextInt();
				int P = in.nextInt();
				cashiers[i] = new Cashier(M,S,P);
			}
			
			// algo
			long a = 1;
			long b = MAX;
			while (a < b) {
				long half = (a+b)/2;
				if (isPossible(R,B,C,cashiers,half))
					b = half;
				else
					a = half+1;
			}
			
			System.out.println(String.format("Case #%d: %d",t+1,a));
		}
		in.close();
	}
	
	private static boolean isPossible(int R, int B, int C, Cashier[] cashiers, long time) {
		int[] list = new int[C];
		for (int i=0; i<C; i++)
			list[i] = cashiers[i].capacity(time);
		Arrays.sort(list);
		long cpt=0;
		for (int i=0; i<R; i++) {
			cpt += list[C-i-1];
		}
		return cpt >= B;
	}

}
