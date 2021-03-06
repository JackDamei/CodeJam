package y2015qualif.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainDijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream file;
		int T;
		ArrayList<TestDijkstra> tests;
				
		try {
			
//			file = new FileInputStream("input_Dijkstra");
//			file = new FileInputStream("C-small-attempt0.in");
//			file = new FileInputStream("C-large.in");
			file = new FileInputStream("C-large-practice.in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));

			
			String buff = in.readLine();
			T = Integer.parseInt(buff);
			tests = new ArrayList<TestDijkstra>();
			
			for (int i=0; i<T; i++){
				int L;
				long X;
				char[] str;

				buff = in.readLine();
				String[] data = buff.split(" ");				
				L = Integer.parseInt(data[0]);
				System.out.println(L);
				X = Long.parseLong(data[1]);
				System.out.println(X);

				buff = in.readLine();
				str = buff.toCharArray();

				tests.add(new TestDijkstra(L, X, str));
			}

			in.close();


			BufferedWriter bw = new BufferedWriter(new FileWriter("output_Dijkstra_long"));
			
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
