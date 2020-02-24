package y2017r1B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class MainC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String filename = "src/y2017r1B/C-test";
		//String filename = "src/y2017r1B/C-small-practice";
		//String filename = "src/y2017r1B/C-large-practice";

		FileInputStream file;
		int T;

		try {
			file = new FileInputStream(filename+".in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));

			T = Integer.parseInt(in.readLine());

			BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".out"));

			for (int ind=1; ind<=T; ind++) {

				// parser
				String buff[];
				buff = in.readLine().split(" ");
				int N = Integer.parseInt(buff[0]);
				int Q = Integer.parseInt(buff[1]);
				int[] E = new int[N];
				double[] S = new double[N];
				for (int i=0; i<N; i++) {
					buff = in.readLine().split(" ");
					E[i] = Integer.parseInt(buff[0]);
					S[i] = Double.parseDouble(buff[1]);
				}
				int[][] D = new int[N][N];
				for (int i=0; i<N; i++) {
					buff = in.readLine().split(" ");
					for (int j=0; j<N; j++) {
						D[i][j] = Integer.parseInt(buff[j]);
					}
				}
				int[] U = new int[N];
				int[] V = new int[N];
				for (int k=0; k<Q; k++) {
					buff = in.readLine().split(" ");
					U[k] = Integer.parseInt(buff[0]);
					V[k] = Integer.parseInt(buff[1]);
				}
				
				// calcul
				String res = solve(N,Q,E,S,D,U,V);
				
				//System.out.println("Result "+ind+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static String solve (int N, int Q, int[] E, double[] S, int[][] D, int[] U, int[] V) {
		String res = "";
		
		// time matrix creation
		double T[][] = new double[N][N];
		// Dijkstra from each node
		for (int n=0; n<N; n++) {
			for (int i=0; i<N; i++)
				T[n][i] = -1;
			T[n][n] = 0;
			LinkedList<Integer> set = new LinkedList<Integer>();
			set.add(0);
			while (!set.isEmpty()) {
				//int cur = set.;
			}
			
		}
		
		// Dijkstra from each Uk
		
		return res;
	}	
}