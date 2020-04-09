package y2016r1C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class MainC {

	public static void main(String[] args) {

		String filename = "src/y20161C/C-test";
		//String filename = "src/y20161C/C-small-attempt0";
		//String filename = "src/y20161C/C-large";

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
				//String S = in.readLine();
				//int N = Integer.parseInt(in.readLine());
				String data[] = in.readLine().split(" ");
				int J = Integer.parseInt(data[0]);
				int P = Integer.parseInt(data[0]);
				int S = Integer.parseInt(data[0]);
				int K = Integer.parseInt(data[0]);
				
				// calcul
				String res = solve(J, P, S, K);
				
				System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@SuppressWarnings("unused")
	static String solve (int J, int P, int S, int K) {
		String res = "";
		
		int total = J*P*S;
		
		return res;
	}
	
}
