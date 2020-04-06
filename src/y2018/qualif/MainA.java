package y2018.qualif;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();
		
		int[] pow2 = new int[30];
		int x = 1;
		for (int i=0; i<30; i++) {
			pow2[i] = x;
			x *= 2;
		}
		
		for (int t=0; t<T; t++) {
			
			int D = in.nextInt();
			String s = in.next();			
			int len = s.length();
			
			int S_count = 0;
			int sum = 0;
			int exp = 0;
			int[] map = new int[30];
			for (int i=0; i<len; i++) {
				char c = s.charAt(i);
				if (c == 'S') {
					S_count++;
					sum += pow2[exp];
					map[exp]++;
				} else {
					exp++;
				}
			}
			
			if (S_count > D)
				System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
			else {
				int hack = 0;
				exp = 29;
				while (sum > D) {
					if (map[exp] == 0) {
						exp--;
						continue;
					}
					hack++;
					map[exp]--;
					map[exp-1]++;
					sum -= pow2[exp-1];
				}
				
				System.out.println("Case #"+(t+1)+": "+hack);
			}
		}
		in.close();
	}
}