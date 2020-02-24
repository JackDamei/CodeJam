package y2017qualif;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class MainA {

	public static void main(String[] args) {

		//String filename = "src/y2017qualif/A-test";
		//String filename = "src/y2017qualif/A-small-attempt0";
		String filename = "src/y2017qualif/A-large";

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
				String S = buff[0];
				int K = Integer.parseInt(buff[1]);

				// calcul
				String res = solve(S, K);
				
				//System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	static String solve (String S, int K) {
		int len = S.length();
		char[] tab = S.toCharArray();
		int cpt = 0;
		for (int i=0; i<len-K+1; i++) {
			if (tab[i] == '-') {
				cpt++;
				for (int j=0; j<K; j++) {
					if (tab[i+j] == '-')
						tab[i+j] = '+';
					else
						tab[i+j] = '-';
				}
			}
		}
		
		for (int i=0; i<len; i++)
			if (tab[i] == '-')
				return "IMPOSSIBLE";	
		
		return Integer.toString(cpt);
	}
	
}
