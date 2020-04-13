package y2018.r1B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainB {

	static int DEF_VALUE = Integer.MAX_VALUE;

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int S = in.nextInt();

			int[] M = new int[S];
			int[] N = new int[S];

			for (int i=0; i<S; i++) {
				int D = in.nextInt();
				int A = in.nextInt();
				int B = in.nextInt();
				M[i] = D+A;
				N[i] = D-B;
			}

			for (int i=0; i<S; i++) {
			}
			
			// W-E
			//boolean[] doubleChecked = new boolean[S];
			//Arrays.fill(doubleChecked, false);

			int max = 0;
			int maxcpt = 0;

			for (int i=0; i<S; i++) {
				if (i + max > S)
					break;

				int Ma, Mb, Na, Nb;
				Ma = M[i];
				Nb = N[i];
				Mb = DEF_VALUE;
				Na = DEF_VALUE;

				int cpt = 1;
				boolean validA = true;
				boolean validB = true;
				int j=i+1;

				while (validA || validB) {
					if (j>=S)
						break;
					
				
					if (validA)
						if (M[j] == Ma)
							cpt++;
						else
							if (Na == DEF_VALUE) {
								Na = N[j];
								cpt++;
							} else
								cpt+= (validA = Na==N[j]) ? 1 : 0;
					if (validB)
						if (N[j] == Nb)
							cpt+= validA ? 0 : 1;
						else
							if (Mb == DEF_VALUE) {
								Mb = M[j];
								cpt+= validA ? 0 : 1;
							} else
								cpt+= !validA & (validB = Mb==M[j]) ? 1 : 0;
					
					j++;
				}
				
				if (cpt == max) {
					maxcpt++;
				}
				if (cpt > max) {
					max = cpt;
					maxcpt = 1;
				}
			}

			System.out.println(String.format("Case #%d: %d %d",t+1,max,maxcpt));
		}
		in.close();
	}

}
