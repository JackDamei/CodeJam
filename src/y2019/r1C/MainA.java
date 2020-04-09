package y2019.r1C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			int A = in.nextInt();
			String[] C = new String[A];
			for (int i=0; i<A; i++)
				C[i] = in.next();

			boolean[] def = new boolean[A];
			int cpt_def = 0;
			Arrays.fill(def, false);

			String res = "";

			int i = 0;
			boolean isPossible = true;

			while (isPossible && cpt_def<A) {
				boolean isP=false, isR=false, isS=false;
				char mymove = 'x';
				
				for (int a=0; a<A; a++) {
					if (def[a])
						continue;
					char c = C[a].charAt(i%C[a].length());
					switch (c) {
					case 'P':
						isP = true;
						break;
					case 'R':
						isR = true;
						break;
					case 'S':
						isS = true;
						break;
					}
				}
				
				int moves = 0;
				if (isP)
					moves++;
				if (isR)
					moves++;
				if (isS)
					moves++;
				
				switch (moves) {
				case 3:
					isPossible = false;
					break;
				case 1:
					if (isP)
						res += 'S';
					if (isR)
						res += 'P';
					if (isS)
						res += 'R';
					cpt_def = A;
					break;
				case 2:
					if (!isP) // R&S
						mymove = 'R';
					if (!isR) // P&S
						mymove = 'S';
					if (!isS) // P&R
						mymove = 'P';
					for (int a=0; a<A; a++)
						if (!def[a] && C[a].charAt(i%C[a].length()) != mymove) {
							def[a] = true;
							cpt_def++;
						}
					res += mymove;
					break;
				}
				
				i++;
			}
			if (!isPossible)
				res = "IMPOSSIBLE";

			System.out.println("Case #"+(t+1)+": "+res);
		}
		in.close();
	}
}