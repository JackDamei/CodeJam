package y2009_1C.C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) {

		//String filename = "src/y2009_1C/input-C";
		//String filename = "src/y2009_1C/C-small-practice";
		String filename = "src/y2009_1C/C-large-practice";

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
				String[] data = in.readLine().split(" ");
				int P = Integer.parseInt(data[0]);
				int Q = Integer.parseInt(data[1]);
				int[] tab = new int[Q];
				data = in.readLine().split(" ");
				for (int j=0; j<Q; j++) {
					tab[j] = Integer.parseInt(data[j])-1;
				}
				Test test = new Test(P,Q,tab);

				int res = test.solve(0, P-1);

				System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}	

	public static class Test {
		public int P;
		public int Q;
		public int[] tab;
		public int[][] cache;
		public Test (int P, int Q, int[] tab) {
			this.P = P;
			this.Q = Q;
			this.tab = tab;
			cache = new int[P][P];
			for (int i=0; i<P; i++)
				for (int j=0; j<P; j++)
					cache[i][j] = -1;
		}

		public int solve (int a, int b) {
			if (a>b) return 0;
			int tmp;
			if ((tmp = cache[a][b]) > -1)
				return tmp;
			int r = 0;
			for (int i=0; i<Q; i++) {
				if (tab[i] >= a && tab[i] <= b) {
					tmp = (b-a) + solve(a,tab[i]-1) + solve (tab[i]+1,b);
//					System.out.println(a+" "+b+" "+tmp);
					if (r == 0 || tmp < r) {
						r = tmp;
					}
				}
			}
//			if (b-a == P-1) System.out.println("ORIGIN");
			cache[a][b] = r;
//			System.out.println(a+" "+b+" "+r);
			return r;			
		}
	}


}
