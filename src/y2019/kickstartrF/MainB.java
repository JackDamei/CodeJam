package y2019.kickstartrF;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MainB {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintStream out = System.out;

		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int S = in.nextInt();
			int[][] A = new int[N][];
			int[] C = new int[N];
			ArrayList<LinkedList<Integer>> skills = new ArrayList<LinkedList<Integer>>(S);
			for (int i=0; i<S; i++)
				skills.add(new LinkedList<Integer>());
			for (int i=0; i<N; i++) {
				C[i] = in.nextInt();
				A[i] = new int[C[i]];
				for (int j=0; j<C[i]; j++) {
					int s = in.nextInt()-1;
					A[i][j] = s;
					skills.get(s).add(i);
				}
			}
				
			int res = 0;
			for (int i=0; i<N; i++) {
				boolean[] isVisited = new boolean[N];
				isVisited[i] = true;
				//int visited = 1;
				for (int j=0; j<C[i]; j++) {
					int a = A[i][j];
					for (int k : skills.get(a)) {
						//int tmp = visited;
						if (!isVisited[k]) {
							isVisited[k] = true;
							res++;
						}
					}
				}
			}

			out.println(String.format("Case #%d: %d",t+1,res));
		}

		in.close();
	}

}
