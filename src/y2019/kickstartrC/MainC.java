package y2019.kickstartrC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MainC {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintStream out = System.out;

		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int K = in.nextInt();
			int[] P = new int[N];
			for (int i=0; i<N; i++)
				P[i] = in.nextInt();
			int[] A = new int[N];
			for (int i=0; i<N; i++)
				A[i] = in.nextInt();

			HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
			for (int i=0; i<N; i++) {
				int color = A[i];
				if (!map.containsKey(color))
					map.put(color, new ArrayList<Integer>());
				map.get(color).add(P[i]);
			}

			int[] bestw = new int[K+1];
			Arrays.fill(bestw, Integer.MAX_VALUE);
			int[] bestwo = new int[K+1];
			Arrays.fill(bestwo, Integer.MAX_VALUE);
			bestw[0] = 0;
			bestwo[0] = 0;


			int done = 0;
			boolean first = true;
			for (ArrayList<Integer> l : map.values()) {

				Collections.sort(l);
				int size = l.size();				

				if (first) {
					first = false;
					int cpt=0;
					Iterator<Integer> it = l.iterator();
					while (it.hasNext()) {
						cpt++;
						if (cpt > K) break;
						int d = it.next();
						bestw[cpt] = d;
						bestwo[cpt] = 2*d;
					}					
				} else {
					for (int n=Integer.min(done+size,K); n>0; n--) {				
						int cpt=0;
						Iterator<Integer> it = l.iterator();

						while (it.hasNext()) {
							cpt++;
							int d = it.next();
							if (cpt > n) break;
							if (n-cpt > done) continue;
							// wo + one-way
							bestw[n] = Integer.min(bestw[n],bestwo[n-cpt]+d);
							// w + two-way
							bestw[n] = Integer.min(bestw[n],bestw[n-cpt]+2*d);
							// wo + two-way
							bestwo[n] = Integer.min(bestwo[n],bestwo[n-cpt]+2*d);						
						}
					}
				}
				done += size;
			}

			out.println(String.format("Case #%d: %d",t+1,bestw[K]));
		}

		in.close();
	}

}
