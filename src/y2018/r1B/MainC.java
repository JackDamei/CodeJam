package y2018.r1B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MainC {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int M = in.nextInt();
			int[][] R = new int[M+1][2];
			for (int i=1; i<=M; i++) {
				R[i][0] = in.nextInt();
				R[i][1] = in.nextInt();
			}
			int[] G = new int[M+1];
			for (int i=1; i<=M; i++)
				G[i] = in.nextInt();

			int created;
			do {
				created = 0;
				boolean[] isEmpty = new boolean[M+1];
				Arrays.fill(isEmpty, false);
				isEmpty[1] = true;
				int[] formula = new int[M+1];
				Arrays.fill(formula, 0);
				if (createOne(1,R,G,formula,isEmpty))
					created = 1+update(G,formula);
				//System.out.println(G[1]);
			} while (created > 0);

			System.out.println(String.format("Case #%d: %d", t+1, G[1]));

		}

		in.close();
	}


	private static boolean createOne(int e, int[][] R, int[] G, int[] f, boolean[] isEmpty) {	
		// ingredients
		int a = R[e][0];
		int b = R[e][1];

		// impossible if empty element is self-dependant
		if (isEmpty[a] || isEmpty[b])
			return false;
		
		// if we have ingredients
		if (G[a] > 0 && G[b] > 0) {
			f[a]++;
			f[b]++;
			G[a]--;
			G[b]--;
			G[e]++;
			return true;
		}

		//System.out.println(String.format("Yp a:%d b:%d",a,b));
		if ((isEmpty[a] = G[a]==0)
				&& !createOne(a,R,G,f,isEmpty))
			return false;
		else {
			f[a] += isEmpty[a] ? 0 : 1;
			G[a]--;
		}
		isEmpty[a] = false;
		if ((isEmpty[b] = G[b]==0)
				&& !createOne(b,R,G,f,isEmpty))
			return false;
		else {
			f[b] += isEmpty[b] ? 0 : 1;
			G[b]--;
		}
		isEmpty[b] = false;

		G[e]++;
		return true;
	}


	private static int update(int[] G, int[] f) {
		int M = G.length-1;
		int min = Integer.MAX_VALUE;
		for (int i=2; i<=M; i++) {
			//System.out.println(String.format("%d %d %d", i, f[i], G[i]));
			int tmp = f[i]==0 ? Integer.MAX_VALUE : G[i]/f[i];
			min = Math.min(min,tmp);
		}

		G[1] += min;
		for (int i=2; i<=M; i++)
			G[i] -= min*f[i];
		return min;
	}

}
