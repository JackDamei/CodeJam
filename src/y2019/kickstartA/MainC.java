package y2019.kickstartA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainC {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int Q = in.nextInt();
			int[] L = new int[Q];
			int[] R = new int[Q];
			for (int i=0; i<Q; i++) {
				L[i] = in.nextInt();
				R[i] = in.nextInt();
			}
			
			IntervalTree tree = new IntervalTree(1,N,0);
			

			
			System.out.println("Case #"+(t+1)+": "+tree);
		}
		in.close();
	}
	
	public static class IntervalTree {
		int L;
		int R;
		int orders;
		ArrayList<IntervalTree> C;
		
		public IntervalTree (int L, int R, int orders) {
			this.L = L;
			this.R = R;
			this.orders = orders;
			this.C = new ArrayList<IntervalTree>();
		}
	}
	
}

