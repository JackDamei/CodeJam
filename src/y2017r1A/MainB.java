package y2017r1A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MainB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String filename = "src/y2017r1A/B-test";
		//String filename = "src/y2017r1A/B-small-attempt0";
		//String filename = "src/y2017r1A/B-large";

		FileInputStream file;
		int T;

		try {
			file = new FileInputStream(filename+".in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));

			T = Integer.parseInt(in.readLine());

			BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".out"));

			for (int ind=1; ind<T+1; ind++) {
				// parser
				String buff[] = in.readLine().split(" ");
				int N = Integer.parseInt(buff[0]);
				int P = Integer.parseInt(buff[1]);
				int[] R = new int[N];
				buff = in.readLine().split(" ");
				for (int i=0; i<N; i++)
					R[i] = Integer.parseInt(buff[i]);
				int [][] Q = new int[N][P];
				for (int i=0; i<N; i++) {
					buff = in.readLine().split(" ");
					for (int j=0; j<P; j++) {
						Q[i][j] = Integer.parseInt(buff[j]);
					}
				}
				// calcul
				String res = solve(N,P,R,Q);
				
				//System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static String solve (int N, int P, int[] R, int[][] Q) {
		String res = "";
		int[][] min = new int[N][P];
		int[][] max = new int[N][P];
		ArrayList<Double> list = new ArrayList<Double>(P);
		for (int i=0; i<N; i++) {
			list.clear();
			for (int j=0; j<P; j++)
				list.add((double)Q[i][j]/R[i]);
			Collections.sort(list);			
			for (int j=0; j<P; j++) {
				min[i][j] = (int)Math.ceil(list.get(j)/1.1);
				max[i][j] = (int)Math.floor(list.get(j)/0.9);
			}
		}
		int[] cur = new int[N];
		for (int i=0; i<N; i++)
			cur[i] = 0;
		int min_space, max_space;
		for (int i=0; i<P; i++) {
			
		}
		int cpt = 0;
		res += cpt;
		return res;
	}	
}