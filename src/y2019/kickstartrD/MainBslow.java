package y2019.kickstartrD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MainBslow {

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

			int[] cpt = new int[G];

			for (int i=0; i<N; i++) {
				int rewind = 0;
				while (rewind<=M) {
					int c = (i+rewind)%N;
					int a = (i+N-rewind)%N;
					if (listC.get(c).isEmpty() && listA.get(a).isEmpty())
						rewind++;
					else {
						for (int g : listC.get(c))
							cpt[g]++;
						for (int g : listA.get(a))
							cpt[g]++;
						break;
					}
				}
			}

			String res = "";
			for (int i=0; i<G; i++)
				res += cpt[i]+" ";
			
			out.println(String.format("Case #%d: %s",t+1,res));
		}

		in.close();
	}

}
