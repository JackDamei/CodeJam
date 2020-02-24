package y2010_1B.A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainA {

	public static void main(String[] args) {

//		String filename = "src/y2010_1B/input-A";
//		String filename = "src/y2010_1B/A-small-practice";
		String filename = "src/y2010_1B/A-large-practice";

		FileInputStream file;
		int T;
		ArrayList<TestA> tests;

		try {

			file = new FileInputStream(filename+".in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));


			String buff = in.readLine();
			T = Integer.parseInt(buff);
			tests = new ArrayList<TestA>();

			for (int i=0; i<T; i++){

				int N, M;
				buff = in.readLine();
				String[] data = buff.split(" ");				
				N = Integer.parseInt(data[0]);
				M = Integer.parseInt(data[1]);
				
				String[] s = new String[N+M];
				for (int j=0; j<N+M; j++) {
					buff = in.readLine();
					s[j] = buff;
				}
				
				tests.add(new TestA(N, M, s));
			}

			in.close();


			BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".out"));

			for (int i=0; i<T; i++) {
				int ind = i+1;
				int res = tests.get(i).getResult();
				System.out.println("Result "+ i + " : "+ res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();





		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
