package y2018.r2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MainC {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		PrintStream out = System.out;
		int T = in.nextInt();
			
		for (int t=0; t<T; t++) {
			
			int N = in.nextInt();
			int[][] A = new int[N][N];
			for (int i=0; i<N; i++)
				for (int j=0; j<N; j++)
					A[i][j] = in.nextInt();
			
			ArrayList<HashMap<Integer,HashSet<Integer>>> rows = new ArrayList<HashMap<Integer,HashSet<Integer>>>();
			ArrayList<HashMap<Integer,HashSet<Integer>>> columns = new ArrayList<HashMap<Integer,HashSet<Integer>>>();

			for (int i=0; i<N; i++) {
				rows.add(new HashMap<Integer,HashSet<Integer>>());
				columns.add(new HashMap<Integer,HashSet<Integer>>());
			}
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					int val = A[i][j];
					if (!rows.get(i).containsKey(val))
						rows.get(i).put(val, new HashSet<Integer>());
					rows.get(i).get(val).add(j);
					if (!columns.get(j).containsKey(val))
						columns.get(j).put(val,  new HashSet<Integer>());
					columns.get(j).get(val).add(i);
				}
			}
			
			int res = 0;
			
			// eliminate double problems
			for (int i=0; i<N; i++)
				for (int j=0; j<N; j++) {
					int val = A[i][j];
					boolean b1 = rows.get(i).get(val).contains(j)
							&& rows.get(i).get(val).size() > 1;
					boolean b2 = columns.get(j).get(val).size() > 1;
					if (b1 && b2) {
						res++;
						rows.get(i).get(val).remove(j);
						columns.get(j).get(val).remove(i);
					}
				}
			
			// eliminate simple remaining problems
			for (int i=0; i<N; i++)
				for (int j=0; j<N; j++) {
					int val = A[i][j];
					boolean b1 = rows.get(i).get(val).contains(j)
							&& rows.get(i).get(val).size() > 1;
					boolean b2 = columns.get(j).get(val).contains(i)
							&& columns.get(j).get(val).size() > 1;
					if (b1) {
						res++;
						rows.get(i).get(val).remove(j);
					}
					if (b2) {
						res++;
						columns.get(j).get(val).remove(i);
					}
				}

			out.println(String.format("Case #%d: %d", t+1, res));
		}
				
		in.close();
	}
	
}
