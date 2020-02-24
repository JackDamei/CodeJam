package y2016r1C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class MainB {

	public static void main(String[] args) {

		String filename = "src/y20161C/B-test";
		//String filename = "src/y20161C/B-small-attempt0";
		//String filename = "src/y20161C/B-large";

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
				long B = Long.parseLong(in.readLine());
				long M = Long.parseLong(in.readLine());
				
				// calcul
				String res = solve (B, M);
				
				System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	static String solve (long B, long M) {
		String res = "";
		
		
		for (int i=0; i*i<M; i++) {
			if (M%i == 0) {
				
			}
		}
		
		return res;
	}
	
}
