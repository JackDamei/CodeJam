package y2017r1C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class MainB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String filename = "src/y2017r1C/B-test";
		//String filename = "src/y2017r1C/B-small-attempt0";
		//String filename = "src/y2017r1C/B-large";

		FileInputStream file;
		int T;

		try {
			file = new FileInputStream(filename+".in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));

			T = Integer.parseInt(in.readLine());

			BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".out"));

			for (int ind=1; ind<T+1; ind++) {
				// parser
				String buff[] = in.readLine().split(" ");
				int C = Integer.parseInt(buff[0]);
				int J = Integer.parseInt(buff[1]);
				int[] S = new int[C+J];
				int[] E = new int[C+J];
				for (int i=0; i<C+J; i++) {
					buff = in.readLine().split(" ");
					S[i] = Integer.parseInt(buff[0]);
					E[i] = Integer.parseInt(buff[1]);
				}
				// calcul
				String res = solve(C,J,S,E);

				//System.out.println("Result "+ind+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static String solve (int C, int J, int[] S, int[] E) {
		String res = "";
		
		class Activity {
			int S;
			int E;
			char c;
			public Activity (int S, int E, char c) {
				this.S = S;
				this.E = E;
				this.c = c;
			}
		}
		class ActivityComparator implements Comparator<Activity> {
			public int compare (Activity a1, Activity a2) {
				if (a1.S > a2.S)
					return 1;
				if (a1.S < a2.S)
					return -1;
				return 0;
			}
		}
		ArrayList<Activity> list = new ArrayList<Activity>();
		for (int i=0; i<C+J; i++) {
			char c = 'J';
			if (i<C)
				c = 'C';
			list.add(new Activity(S[i],E[i],c));
		}
		list.sort(new ActivityComparator());
		
		char c = 'N';
		int cpt = 0;
		for (int i=0; i<C+J; i++) {
			char tmp = list.get(i).c;
			if (tmp != c)
				cpt++;
			c = tmp;
		}

		res += cpt;
		return res;
	}

}