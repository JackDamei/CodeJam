package y2015r1A.trees;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainTrees {

	public static void main(String[] args) {

		FileInputStream file;
		int T;
		ArrayList<TestTrees> tests;

		try {

//			file = new FileInputStream("input_Trees");
//			file = new FileInputStream("C-small-attempt0.in");
//			file = new FileInputStream("C-small-practice.in");
//			file = new FileInputStream("C-large.in");
			file = new FileInputStream("C-large-practice.in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));


			String buff = in.readLine();
			T = Integer.parseInt(buff);
			tests = new ArrayList<TestTrees>();

			for (int i=0; i<T; i++){

				int N;
				buff = in.readLine();
				N = Integer.parseInt(buff);

				Point[] s = new Point[N];
				for (int j=0; j<N; j++) {
					buff = in.readLine();
					String[] data = buff.split(" ");
					int x = Integer.parseInt(data[0]);
					int y = Integer.parseInt(data[1]);
					s[j] = new Point(x,y);
				}
				tests.add(new TestTrees(N, s));
			}

			in.close();


			BufferedWriter bw = new BufferedWriter(new FileWriter("output_Trees2"));

			for (int i=0; i<T; i++) {
//			int i=1;
				int ind = i+1;
				int[] res = tests.get(i).getResult_large();
//				int[] res = tests.get(i).getResult_small();
				System.out.println("Result "+ i);// + " : "+ res);
				bw.write("Case #"+ind+":\n");
				for (int j=0; j<res.length; j++) {
					bw.write((res[j])+"\n");
//					System.out.println(res[j]);
				}
			}
			bw.close();





		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
