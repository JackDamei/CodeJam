package y2018.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainB {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int[] tab = new int[N];
			for (int i=0; i<N; i++)
				tab[i] = in.nextInt();

			System.out.print(String.format("Case #%d: ", t+1));
			int first = 0;
			int second = 0;
			int value = 0;
			for (int i=0; i<N; i++)
				if (tab[i] > value) {
					value = tab[i];
					first = i;
				}
			value = 0;
			for (int i=0; i<N; i++)
				if (i != first && tab[i] > value) {
					value = tab[i];
					second = i;
				}

			for (int k=tab[second]; k<tab[first]; k++)
				System.out.print((char)('A'+first)+" ");
			for (int i=0; i<N; i++)
				if (i!=first && i!=second)
					for (int k=0; k<tab[i]; k++)
						System.out.print((char)('A'+i)+" ");
			for (int k=0; k<tab[second]; k++) {
				System.out.print((char)('A'+first));
				System.out.print((char)('A'+second)+" ");
			}

			System.out.println();
		}

		in.close();
	}

}
