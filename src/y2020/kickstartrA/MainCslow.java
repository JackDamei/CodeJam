package y2020.kickstartrA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class MainCslow {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			int N = in.nextInt();
			int K = in.nextInt();

			int[] M = new int [N];
			for (int i=0; i<N; i++)
				M[i] = in.nextInt();

			LinkedList<Integer> Kmost = new LinkedList<Integer>();

			int target = 0;
			for (int i=1; i<N; i++) {
				int diff = M[i]-M[i-1];
				if (diff > target) {
					Kmost.add(diff);
					Collections.sort(Kmost);
					if (Kmost.size() > K+1) {
						Kmost.removeFirst();
						target = Kmost.getFirst();
					}
				}
			}
			for (int i=0; i<K; i++) {
				int tmp = Kmost.removeLast();
				int split = tmp/2;
				if (split > target) {
					Kmost.add(split);
					Collections.sort(Kmost);
					target = Kmost.getFirst();
				}
				split = (tmp+1)/2;
				if (split > target) {
					Kmost.add(split);
					Collections.sort(Kmost);
					target = Kmost.getFirst();
				}
			}

			System.out.println("Case #"+(t+1)+": "+Kmost.getLast());
		}
		in.close();
	}
}