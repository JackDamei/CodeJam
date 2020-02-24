package y2016r1A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class MainA {

	public static void main(String[] args) {

		//String filename = "src/y20161A/A-test";
		//String filename = "src/y20161A/A-small-practice";
		String filename = "src/y20161A/A-large-practice";

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

				String res = solve(S);
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

	
	static String solve (String S) {
		String res = "";
		for (int i=0; i<S.length(); i++) {
			String cur = S.substring(i, i+1);
			if ((res+cur).compareTo(cur+res) > 0) {
				res = res+cur;
			} else {
				res = cur+res;
			}
		}
		return res;
	}
	
}
