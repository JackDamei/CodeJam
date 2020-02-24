package y2010_1B.B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainB {

	public static void main(String[] args) {

		//String filename = "src/y2010_1B/input-B";
		//String filename = "src/y2010_1B/B-small-practice";
		String filename = "src/y2010_1B/B-large-practice";

		FileInputStream file;
		int C;
		ArrayList<Test> tests;

		try {

			file = new FileInputStream(filename+".in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));


			String buff = in.readLine();
			C = Integer.parseInt(buff);
			tests = new ArrayList<Test>();

			for (int i=0; i<C; i++){

				int N, K, B, T;
				buff = in.readLine();
				String[] data = buff.split(" ");				
				N = Integer.parseInt(data[0]);
				K = Integer.parseInt(data[1]);
				B = Integer.parseInt(data[2]);
				T = Integer.parseInt(data[3]);

				int[] X = new int[N];
				int[] V = new int[N];
				data = in.readLine().split(" ");
				String[]data2 = in.readLine().split(" ");
				for (int j=0; j<N; j++) {
					X[j] = Integer.parseInt(data[j]);
					V[j] = Integer.parseInt(data2[j]);
				}

				tests.add(new Test(N, K, B, T, X, V));
			}

			in.close();


			BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".out"));

			for (int i=0; i<C; i++) {
				int ind = i+1;
				int res = tests.get(i).getResult();
				System.out.println("Result "+ i + " : "+ res);
				if (res == -1)
					bw.write("Case #"+ind+": IMPOSSIBLE\n");
				else
					bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();





		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
