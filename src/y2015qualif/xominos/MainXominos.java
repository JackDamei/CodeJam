package y2015qualif.xominos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainXominos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FileInputStream file;
		int T;
		ArrayList<TestXominos> tests;
				
		try {
			
//			file = new FileInputStream("input_Xominos");
//			file = new FileInputStream("D-small-attempt6.in");
			file = new FileInputStream("D-large.in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));

			
			String buff = in.readLine();
			T = Integer.parseInt(buff);
			tests = new ArrayList<TestXominos>();
			
			for (int i=0; i<T; i++){
				int X, R, C;

				buff = in.readLine();
				String[] data = buff.split(" ");				
				X = Integer.parseInt(data[0]);
				R = Integer.parseInt(data[1]);
				C = Integer.parseInt(data[2]);
				
				tests.add(new TestXominos(X, R, C));
			}

			in.close();


			BufferedWriter bw = new BufferedWriter(new FileWriter("output_Xominos"));
			
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
