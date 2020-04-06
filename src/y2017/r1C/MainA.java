package y2017.r1C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainA {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//String filename = "src/y2017r1C/A-test";
		//String filename = "src/y2017r1C/A-small-practice";
		String filename = "src/y2017r1C/A-large-practice";

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
				int N = Integer.parseInt(buff[0]);
				int K = Integer.parseInt(buff[1]);
				int[] R = new int[N];
				int[] H = new int[N];
				for (int i=0; i<N; i++) {
					buff = in.readLine().split(" ");
					R[i] = Integer.parseInt(buff[0]);
					H[i] = Integer.parseInt(buff[1]);
				}

				// calcul
				String res = solve(N,K,R,H);
				
				System.out.println("Result "+ind+": "+res+" "+K);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static String solve (int N, int K, int[] R, int[] H) {
		String res = "";

		class Pancake {
			public int R;
			public int H;
			public Pancake (int R, int H) {
				this.R = R;
				this.H = H;
			}
		}
		class PancakeComparator implements Comparator<Pancake> {
			public int compare(Pancake p1, Pancake p2) {
				if (1.*p1.R*p1.H > 1.*p2.R*p2.H)
					return 1;
				if (1.*p1.R*p1.H < 1.*p2.R*p2.H)
					return -1;
				return 0;
			}
		}
		ArrayList<Pancake> list = new ArrayList<Pancake>();
		for (int i=0; i<N; i++) {
			list.add(new Pancake(R[i], H[i]));
		}
		list.sort(new PancakeComparator());
		Collections.reverse(list);
		
		double best = 0;
		for (int i=0; i<N; i++) {
			Pancake p = list.get(i);
			double sum = 1.*p.R*p.R + 2.*p.R*p.H;
			int cpt = 1;
			for (int j=0; j<N && cpt<K; j++) {
				if (i == j)
					continue;
				p = list.get(j);
				sum += 2.*p.R*p.H;
				cpt++;
			}
			if (sum > best)
				best = sum;
		}
		
		res += best*Math.PI;
		
		return res;
	}	
}