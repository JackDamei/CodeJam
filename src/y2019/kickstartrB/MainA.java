package y2019.kickstartrB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MainA {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int Q = in.nextInt();

			String s = in.next();
			int[][] tab = new int[N+1][26];
			for (int i=0; i<N; i++) {
				tab[i+1] = Arrays.copyOf(tab[i], 26);
				char c = s.charAt(i);
				tab[i+1][c-'A']++;
			}

			int cpt = 0;
			for (int i=0; i<Q; i++) {
				int L = in.nextInt()-1;
				int R = in.nextInt()-1;
				cpt += solve(L,R,tab);
			}		

			System.out.println(String.format("Case #%d: %d",t+1, cpt));
		}

		in.close();
	}

	public static int solve (int l, int r, int[][] tab) {
		boolean done = (r-l+1)%2 == 0;
		for (int i=0; i<26; i++) {
			int cpt = tab[r+1][i]-tab[l][i];
			if (cpt % 2 == 0)
				continue;
			if (done)
				return 0;
			done = true;
		}
		return 1;
	}

}
