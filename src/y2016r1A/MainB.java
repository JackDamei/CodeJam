package y2016r1A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class MainB {

	public static void main(String[] args) {

		//String filename = "src/y20161A/B-test";
		//String filename = "src/y20161A/B-small-practice";
		String filename = "src/y20161A/B-large-practice";

		FileInputStream file;
		int T;

		try {
			file = new FileInputStream(filename+".in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));

			T = Integer.parseInt(in.readLine());

			BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".out"));

			for (int i=0; i<T; i++) {
				int ind = i+1;
				// parser
				int N = Integer.parseInt(in.readLine());
				int sheets[][] = new int[2*N-1][N];
				for (int j=0; j<2*N-1; j++) {
					String buff[] = in.readLine().split(" ");
					for (int k=0; k<N; k++)
						sheets[j][k] = Integer.parseInt(buff[k]);
				}
				
				String res = solve(N, sheets);
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
	
	static String solve (int N, int[][] sheets) {
		String res = "";
		int MAX = 25001;
		int cpt[] = new int[MAX];
		for (int i=0; i<MAX; i++)
			cpt[i] = 0;
		for (int i=0; i<2*N-1; i++)
			for (int j=0; j<N; j++)
				cpt[sheets[i][j]]++;
		
		for (int i=0; i<MAX; i++) {
			if (cpt[i]%2 == 1)
				res += i+" ";
		}
		
		return res;
	}
		
}
