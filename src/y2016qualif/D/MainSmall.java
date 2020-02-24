package y2016qualif.D;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class MainSmall {

	public static void main(String[] args) {

		//String filename = "src/y2016qualif/D-test";
		//String filename = "src/y2016qualif/D-small-attempt0";
		//String filename = "src/y2016qualif/D-small-attempt1";
		String filename = "src/y2016qualif/D-small-attempt2";
		//String filename = "src/y2016qualif/D-large";

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
				String data[] = in.readLine().split(" ");
				int K = Integer.parseInt(data[0]);
				int C = Integer.parseInt(data[1]);
				int S = Integer.parseInt(data[2]);

				String res = solve(K,C,S);
				// calcul
				
				System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+":"+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	static String solve (int K, int C, int S) {
		// S students
		// K size
		// C complexity
		
		String res = "";
		
		for (int i=0; i<S; i++) {
			int ind = i+1;
			res += " "+ind;
		}
		
		return res;
	}
	
}

