package y2019.kickstartrE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MainA {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintStream out = System.out;

		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int M = in.nextInt();

			boolean[] visited = new boolean[N];
			boolean[] linked = new boolean[N];
			ArrayList<LinkedList<Integer>> nb = new ArrayList<LinkedList<Integer>>(N);
			for (int i=0; i<N; i++)
				nb.add(new LinkedList<Integer>());
			
			for (int i=0; i<M; i++) {
				int c = in.nextInt()-1;
				int d = in.nextInt()-1;
				nb.get(c).add(d);
				nb.get(d).add(c);
			}
			
			LinkedList<Integer> stack = new LinkedList<Integer>();
			for (int i=0; i<N; i++)
				stack.add(i);
			
			int cpt = 0;
			while (!stack.isEmpty()) {
				int curr = stack.pollLast();
				if (visited[curr]) continue;
				visited[curr] = true;
				linked[curr] = true;
				for (int next : nb.get(curr))
					if (!linked[next]) {
						linked[next] = true;
						stack.addLast(next);
						cpt++;
					}
			}
			
			int res = 2*(N-1)-cpt;
			
			out.println(String.format("Case #%d: %d",t+1,res));
		}

		in.close();
	}

}
