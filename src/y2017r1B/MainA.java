package y2017r1B;

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

		//String filename = "src/y2017r1B/A-test";
		//String filename = "src/y2017r1B/A-small-attempt0";
		String filename = "src/y2017r1B/A-large";

		FileInputStream file;
		int T;

		try {
			file = new FileInputStream(filename+".in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));

			T = Integer.parseInt(in.readLine());

			BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".out"));

			for (int ind=1; ind<=T; ind++) {
				// parser
				String buff[] = in.readLine().split(" ");
				int D = Integer.parseInt(buff[0]);
				int N = Integer.parseInt(buff[1]);
				int[] start = new int[N];
				int[] speed = new int[N];
				for (int i=0; i<N; i++) {
					buff = in.readLine().split(" ");
					start[i] = Integer.parseInt(buff[0]);
					speed[i] = Integer.parseInt(buff[1]);
				}
					
				// calcul
				String res = solve(D,N,start,speed);
				
				//System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static String solve (int D, int N, int[] start, int[] speed) {
		String res = "";
		double t = 0;
		double max = 0;		
		for (int i=0; i<N; i++) {
			double d = D-start[i];
			t = d/speed[i];
			if (t > max)
				max = t;
		}
		double v = D/max;
		res += v;
		return res;
	}	
}