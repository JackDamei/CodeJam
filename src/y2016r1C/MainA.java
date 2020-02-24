package y2016r1C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class MainA {

	public static void main(String[] args) {

		//String filename = "src/y20161C/A-test";
		//String filename = "src/y20161C/A-small-attempt1";
		String filename = "src/y20161C/A-large";

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
				int N = Integer.parseInt(in.readLine());
				String data[] = in.readLine().split(" ");
				int P[] = new int[N];
				for (int j=0; j<N; j++) {
					P[j] = Integer.parseInt(data[j]);
				}
				
				// calcul
				String res = solve(N, P);
				
				System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	static String solve (int N, int P[]) {
		String res = "";
		
		//looking for the 2 highest
		int max1 = 0;
		int max2 = 0;
		int ind1 = -1;
		int ind2 = -1;
		for (int i=0; i<N; i++) {
			if (P[i] > max1) {
				if (max1 > max2) {
					max2 = P[i];
					ind2 = i;
				} else {
					max1 = P[i];
					ind1 = i;
				}
			} else if (P[i] > max2) {
				max2 = P[i];
				ind2 = i;
			}
		}
		
		int tab[] = P.clone();
		//egalize the 2 highest
		while (tab[ind1] != tab[ind2]) {
			if (tab[ind1] > tab[ind2]) {
				res += " "+(char)('A'+ind1);
				tab[ind1]--;
			} else {
				res += " "+(char)('A'+ind2);
				tab[ind2]--;
			}				
		}
		
		//remove others
		for (int i=0; i<N; i++) {
			if (i == ind1 || i == ind2)
				continue;
			while (tab[i] > 1) {
				res += " "+(char)('A'+i)+(char)('A'+i);
				tab[i] -= 2;
			}
			if (tab[i] == 1) {
				res += " "+(char)('A'+i);
			}
		}
		
		while (tab[ind1] > 0) {
			res += " "+(char)('A'+ind1)+(char)('A'+ind2);
			tab[ind1]--;
			tab[ind2]--;
		}
		
		res = res.substring(1);
		
		return res;
	}
	
}
