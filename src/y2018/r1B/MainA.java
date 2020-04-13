package y2018.r1B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int L = in.nextInt();
			
			int done = 0;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i=0; i<L; i++) {
				int n = in.nextInt();
				list.add(n);
				done += n;
			}
			
			// test each group size
			double unit = 100./N;
			int[] pct = new int[N];
			for (int i=0; i<N; i++)
				pct[N] = (int) Math.round(unit*i);
			
			int[] bestw = new int[N];
			int[] bestwo = new int[N];
			Arrays.fill(bestw,0);
			// calculate actual score
			int score = 0;
			for (Integer i : list)
				score += pct[i];
			bestw[done] = score;
			Arrays.fill(bestwo,0);
			
			for (int i=0; i<N; i++) {
				// i=size of group
				int value = (int) Math.round(unit*i);
				// update bestwo
				for (int j=i; j<N; j+=i)
					bestwo[j] = Math.max(bestwo[j], value);
				// update best
			}
			
			String res = "";
			
			System.out.println("Case #"+(t+1)+": "+res);
		}
		in.close();
	}

}
