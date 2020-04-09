package y2010_1C.A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) {

		//String filename = "src/y2010_1C/input-B";
		//String filename = "src/y2010_1C/B-small-practice";
		String filename = "src/y2010_1C/B-large-practice";

		FileInputStream file;
		int T;

		try {
			file = new FileInputStream(filename+".in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));


			T = Integer.parseInt(in.readLine());

			BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".out"));

			for (int i=0; i<T; i++) {
				int ind = i+1;

				/* parser */
				int L, P, C;
				String[] data = in.readLine().split(" ");
				L = Integer.parseInt(data[0]);
				P = Integer.parseInt(data[1]);
				C = Integer.parseInt(data[2]);
				
				int res = 0;
				double rapport = (double)P/(double)L;
				while (rapport > (double)C) {
					res++;
					rapport = Math.sqrt(rapport);
				}				
				
				System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}