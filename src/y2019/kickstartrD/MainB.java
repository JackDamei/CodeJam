package y2019.kickstartrD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MainB {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintStream out = System.out;

		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int G = in.nextInt();
			int M = in.nextInt();
			// pos 1->N to 0->N-1
			int[] H = new int[G];
			boolean[] C = new boolean[G];
			for (int i=0; i<G; i++) {
				H[i] = in.nextInt()-1;
				C[i] = in.next().equals("C");
			}

			ArrayList<LinkedList<Integer>> listC = new ArrayList<LinkedList<Integer>>(N);
			ArrayList<LinkedList<Integer>> listA = new ArrayList<LinkedList<Integer>>(N);
			for (int i=0; i<N; i++) {
				listC.add(new LinkedList<Integer>());
				listA.add(new LinkedList<Integer>());
			}

			for (int i=0; i<G; i++)
				if (C[i]) {
					int pos = (H[i]+M)%N;
					listC.get(pos).add(i);
				} else {
					int pos = ((H[i]-M)%N+N)%N;
					listA.get(pos).add(i);
				}

			
			int[] rewC = new int[N];
			int[] rewA = new int[N];

			int start, rewind;

			// C loop init
			start = 0;
			while (start < N && listC.get(start).isEmpty())
				start++;
			if (start == N)
				Arrays.fill(rewC,Integer.MAX_VALUE);
			else {
				rewind = 0;
				for (int i=0; i<N; i++) {
					int ind = (start+N-i)%N;
					if (!listC.get(ind).isEmpty()) {
						rewind = 0;
					}
					rewC[ind] = rewind;
					rewind++;
				}
			}

			// A loop init
			start = 0;
			while (start < N && listA.get(start).isEmpty())
				start++;
			if (start == N)
				Arrays.fill(rewA,Integer.MAX_VALUE);
			else {
				rewind = 0;
				for (int i=0; i<N; i++) {
					int ind = (start+i)%N;
					if (!listA.get(ind).isEmpty()) {
						rewind = 0;
					}
					rewA[ind] = rewind;
					rewind++;
				}
			}
			
			// cpt update
			int[] cpt = new int[G];
			for (int i=0; i<N; i++) {
				if (rewC[i] <= M && rewC[i] <= rewA[i])
					for (int g : listC.get((i+rewC[i])%N))
						cpt[g]++;
				if (rewA[i] <= M && rewA[i] <= rewC[i])
					for (int g : listA.get((i+N-rewA[i])%N))
						cpt[g]++;
			}
			String res = "";
			for (int i=0; i<G; i++)
				res += cpt[i]+" ";

			out.println(String.format("Case #%d: %s",t+1,res));
		}

		in.close();
	}

}
