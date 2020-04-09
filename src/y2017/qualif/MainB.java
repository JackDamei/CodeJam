package y2017.qualif;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class MainB {

	public static void main(String[] args) {

		//String filename = "src/y2017qualif/B-test";
		//String filename = "src/y2017qualif/B-small-attempt";
		String filename = "src/y2017qualif/B-large";

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
				String S = in.readLine();

				// calcul
				String res = solve(S);

				//System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	static String solve (String S) {
		int len = S.length();
		char[] tab = S.toCharArray();
		int i=0;

		while ((i<len-1) && (tab[i]<=tab[i+1]))
			i++;
		if (i == len-1)
			return S;
		for (;i>=0;i--) {
			if (tab[i] > tab[i+1]) {
				tab[i]--;	
				for (int j=i	+1;j<len;j++)
					tab[j] = '9';
			}
		}

		if (tab[0] == '0')
			return String.copyValueOf(tab,1,len-1);
		return String.copyValueOf(tab);
	}

}
