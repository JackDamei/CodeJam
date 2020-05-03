package y2020.r1C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MainCmedium {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		PrintStream out = System.out;
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int D = in.nextInt();
			long[] slices = new long[N];
			for (int i=0; i<N; i++) {
				slices[i] = in.nextLong();
			}
			Arrays.sort(slices);

			int res = solve(N,D,slices);
			out.println(String.format("Case #%d: %s", t+1, res));
		}

		in.close();
	}

	public static int solve (int N, int D, long[] slices) {

		int min = D-1;
		long prev = 0;

		for (int i=0; i<N; i++) {
			if (slices[i] == prev) continue;

			for (int div=D; div>0; div--) {

				double base = 1.*slices[i]/div;

				int identical = 0;
				long potential = 0;
				ArrayList<Long> mult = new ArrayList<Long>();

				for (int j=i; j<N; j++) {
					long tmp = slices[j];
					double d = tmp/base;
					long l = (long)d;
					if (d == l)
						if (l == 1)
							identical++;
						else
							mult.add(l);
					potential += l;

					if (tmp >= D*base)
						break;				
				}

				if (potential < D)
					break;

				// if enough equal slices, don't need to cut
				if (identical >= D)
					return 0;

				Collections.sort(mult);

				int cuts = 0;
				int cpt = identical;				

				for (long l : mult) {
					if (cpt+l > D) {
						cuts += D-cpt;
						cpt = D;
					} else {
						cuts += l-1;
						cpt += l;
					}
					if (cpt == D) break;
				}

				// it not enough, do the remaining cuts
				cuts += D-cpt;
				min = Math.min(min, cuts);
			}

			prev = slices[i];
		}

		return min;
	}

}
