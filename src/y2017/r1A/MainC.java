package y2017.r1A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class MainC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String filename = "src/y2017qualif/C-test";
		//String filename = "src/y2017qualif/C-small-attempt0";
		//String filename = "src/y2017qualif/C-large";

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
				//String buff[] = in.readLine().split(" ");
				//String S = in.readline();

				// calcul
				String res = solve();
				
				//System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static String solve () {
		String res = "";
		return res;
	}	
}