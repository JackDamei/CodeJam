package y2015qualif.houseofpancakes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainPancakes {

	public static void main(String[] args) {

		FileInputStream file;
		int T;
		ArrayList<TestPancakes> tests;

		try {

//			file = new FileInputStream("input_Pancakes");
			//			file = new FileInputStream("B-small-attempt0.in");
//			file = new FileInputStream("B-small-practice.in");
			file = new FileInputStream("B-large-practice.in");
			//          file = new FileInputStream("B-large.in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));


			String buff = in.readLine();
			T = Integer.parseInt(buff);
			tests = new ArrayList<TestPancakes>();

			for (int i=0; i<T; i++){

				int D;
				buff = in.readLine();
				D = Integer.parseInt(buff);

				int[] s = new int[D];
				buff = in.readLine();
				String[] data = buff.split(" ");				
				for (int j=0; j<D; j++) {
					s[j] = Integer.parseInt(data[j]);
				}
				
				tests.add(new TestPancakes(D, s));
			}

			in.close();


			BufferedWriter bw = new BufferedWriter(new FileWriter("output_Pancakes"));

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
