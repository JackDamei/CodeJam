package y2017r1A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class MainA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//String filename = "src/y2017r1A/A-test";
		//String filename = "src/y2017r1A/A-small-practice";
		String filename = "src/y2017r1A/A-large-practice";

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
				String buff[] = in.readLine().split(" ");
				int R = Integer.parseInt(buff[0]);
				int C = Integer.parseInt(buff[1]);
				char[][] tab = new char[R][C];
				for (int j=0; j<R; j++) {
					String S = in.readLine();
					for (int k=0; k<C; k++)
						tab[j][k] = S.charAt(k);
				}

				// calcul
				String res = solve(R,C,tab);
				
				//System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static String solve (int R, int C, char[][] tab) {
		String res = "\n";
		int fr, fc;
		int i, j;
		fr = -1;
		for (i=0; i<R; i++) {
			fc = -1;
			for (j=0; j<C; j++) {
				if (tab[i][j] == '?') {
					if (fc != -1)
						tab[i][j] = tab[i][j-1];
				} else {
					if (fc == -1)
						fc = j;
					if (fr == -1)
						fr = i;
				}
			}
			for (j=fc-1; j>=0; j--)
				tab[i][j] = tab[i][j+1];
			if ((fc == -1) && (fr != -1)) {
				for (j=0; j<C; j++)
					tab[i][j] = tab[i-1][j];
			}
		}
		for (i=fr-1; i>=0; i--)
			for (j=0; j<C; j++)
				tab[i][j] = tab[i+1][j];
		
		for (i=0; i<R; i++) {
			for (j=0; j<C; j++)
				res += tab[i][j];
			if (i != R-1)
				res += "\n";
		}
		return res;
	}	
}