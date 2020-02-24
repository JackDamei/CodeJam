package y2016qualif.A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) {

		//String filename = "src/y2016qualif/A-test";
		//String filename = "src/y2016qualif/A-small-attempt0";
		String filename = "src/y2016qualif/A-large";

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

				String res = solve(N);
				// calcul
				
				//System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	static String solve (int N) {
		if (N == 0)
			return "INSOMNIA";

		boolean tab[] = new boolean[10];
		for (int i=0; i<10; i++)
			tab[i] = false;
		
		int nb = 0;
		boolean check;
		
		do {
			nb+=N;
			int q=nb, r;
			while (q>0) {
				r = q%10;
				q = q/10;
				tab[r] = true;
			}
			
			check = true;
			for(int i=0; i<10 && check; i++)
				check = check && tab[i];
		} while (!check);
		
		return Integer.toString(nb);
	}
	
}
