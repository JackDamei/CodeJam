package y2015qualif.standingovation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

import y2015qualif.dijkstra.TestDijkstra;


public class MainStandingOvation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream file;
		int T;
		ArrayList<TestDijkstra> tests;
				
		try {
			
			file = new FileInputStream("input_Dijkstra");
//			file = new FileInputStream("A-small-attempt0.in");
//			file = new FileInputStream("A-large.in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));

			
			String buff = in.readLine();
			T = Integer.parseInt(buff);
			tests = new ArrayList<TestDijkstra>();
			
			for (int i=0; i<T; i++){
				int L, X;
				char[] str;

				buff = in.readLine();
				String[] data = buff.split(" ");				
				L = Integer.parseInt(data[0]);
				System.out.println(L);
				X = Integer.parseInt(data[1]);
				System.out.println(X);

				buff = in.readLine();
				str = buff.toCharArray();

				tests.add(new TestDijkstra(L, X, str));
			}

			in.close();


			BufferedWriter bw = new BufferedWriter(new FileWriter("output_StandingOvation"));
			
			for (int i=0; i<T; i++) {
				int ind = i+1;
				String res = tests.get(i).getResult();
				System.out.println("Result "+ i + " : "+ res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
