package y2016r1A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainC {

	public static void main(String[] args) {

		//String filename = "src/y20161A/C-test";
		//String filename = "src/y20161A/C-small-practice";
		String filename = "src/y20161A/C-large-practice";

		FileInputStream file;
		int T;

		try {
			file = new FileInputStream(filename+".in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));

			T = Integer.parseInt(in.readLine());

			BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".out"));

			for (int t=0; t<T; t++) {
				int ind = t+1;
				// parser
				int N = Integer.parseInt(in.readLine());
				int F[] = new int[N];
				String buff[] = in.readLine().split(" ");
				for (int i=0; i<N; i++)
					F[i] = Integer.parseInt(buff[i]);
				
				String res = solve(N,F);
				// calcul

				//System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	static String solve (int N, int[] F) {
		String res = "";
		
		boolean visited[] = new boolean[N]; //true if already visited
		boolean couple[] = new boolean[N]; //true if belonging to a couple
		boolean loop[] = new boolean[N]; //true if belonging to a loop
		Arrays.fill(visited, false);
		Arrays.fill(couple, false);
		Arrays.fill(loop, false);
		int chain[] = new int[N]; //depth of tree from a couple member
		Arrays.fill(chain, 0);
		
		int sum = 0; //sum of tree depths
		int max_boucle = 0;
		
		//looking for couples
		for (int i=0; i<N; i++) {
			if (visited[i])
				continue;
			if (F[F[i]-1]-1 == i) {
				couple[i] = true;
				couple[F[i]-1] = true;
				visited[i] = true;
				visited[F[i]-1] = true;
				chain[i] = 1;
				chain[F[i]-1] = 1;
			}
		}
		
		//looking for leaves and going to a couple or a loop
		for (int i=0; i<N; i++) {
			if (visited[i])
				continue;
			boolean b = true;
			for (int j=0; j<N && b; j++)
				if (F[j]-1 == i)
					b = false;
			if (b) {
				visited[i] = true;
				int ind = i;
				int cpt = 1;
				boolean current[] = new boolean[N];
				Arrays.fill(current, false);
				while (!loop[ind] && !couple[ind] && !current[ind]) {
					cpt++;
					current[ind] = true;
					visited[ind] = true;
					ind = F[ind]-1;
				}
				if (couple[ind])
					chain[ind] = Math.max(cpt, chain[ind]);
				else if (current[ind]) {
					//there is a loop, now looking for the size of this loop
					int start = ind;
					int boucle = 1;
					loop[ind] = true;
					while (F[ind]-1 != start) {
						boucle++;
						ind = F[ind]-1;
						loop[ind] = true;
						visited[ind] = true; //useless because already visited
					}
					max_boucle = Math.max(max_boucle, boucle);
				}
			}
		}
		
		//looking for isolated loops
		for (int i=0; i<N; i++) {
			if (visited[i])
				continue;
			int ind = i;
			int start = ind;
			int boucle = 1;
			loop[ind] = true;
			visited[ind] = true;
			while (F[ind]-1 != start) {
				boucle++;
				ind = F[ind]-1;
				loop[ind] = true;
				visited[ind] = true;
			}
			max_boucle = Math.max(max_boucle, boucle);
		}
		
		for (int i=0; i<N; i++)
			sum += chain[i];
		
		res += Math.max(sum, max_boucle);
		
		return res;
	}

	
	
}
