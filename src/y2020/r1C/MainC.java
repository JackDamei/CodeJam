package y2020.r1C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class MainC {

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

		long MAX_SIZE = 0;
		for (int i=0; i<N; i++)
			MAX_SIZE = Long.max(MAX_SIZE, slices[i]);

		// binary search for max target (with a margin of 1 because of doubles) 
		long a = 1;
		long b = MAX_SIZE+1;
		double MAX_TARGET = 0;
		double UPPER_BOUND;
		while (a < b) {
			long mid = (a+b)/2;
			long cpt = 0;
			for (int i=0; i<N; i++)
				cpt += slices[i]/mid;
			if (cpt >= D) {
				MAX_TARGET = a;
				a = mid+1;
			} else
				b = mid;
		}		
		UPPER_BOUND = a;

		HashMap<Double,ArrayList<Integer>> map = new HashMap<Double,ArrayList<Integer>>();
		for (int i=0; i<N; i++) {		
			for (int j=D; j>0; j--) {
				double size = 1.*slices[i]/j;

				if (size > UPPER_BOUND) break;

				if (!map.containsKey(size))
					map.put(size,new ArrayList<Integer>());
				map.get(size).add(j);
			}
		}

		for (Entry<Double,ArrayList<Integer>> e : map.entrySet()) {
			double size = e.getKey();

			if (size >= UPPER_BOUND) continue;
			if (size > MAX_TARGET) {
				long cpt = 0;
				for (int i=0; i<N; i++)
					cpt += slices[i]/size;
				if (cpt >= D)
					MAX_TARGET = size;
				else {
					UPPER_BOUND = size;
					if (size >= UPPER_BOUND) continue;
				}				
			}

			ArrayList<Integer> list = e.getValue();
			Collections.sort(list);
			int cpt = 0;
			int cuts = 0;
			for (Integer i : list) {
				if (cpt+i > D) break;
				cuts += i-1;
				cpt += i;
				if (cpt == D) break;
			}
			cuts += D-cpt;
			min = Math.min(min, cuts);
		}

		return min;
	}

}
