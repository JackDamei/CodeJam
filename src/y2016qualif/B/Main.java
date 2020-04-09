package y2016qualif.B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) {

		//String filename = "src/y2016qualif/B-test";
		//String filename = "src/y2016qualif/B-small-attempt0";
		String filename = "src/y2016qualif/B-large";

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
				int res = solve(in.readLine());
				// calcul
				
				System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	static int solve (String str) {
		boolean tab[] = new boolean[str.length()];
		for (int i=0; i<str.length(); i++)
			tab[i] = (str.charAt(i) == '+');

		int cpt=0, ind, top, last;
		
		while (!check(tab)) {
			cpt++;
			//operation
			if (tab[0]) {
				//flip tops
				ind=0;
				while (tab[ind]){
					tab[ind] = false;
					ind++;				
				}
			} else {
				//flip minus
				last = tab.length-1;
				while(tab[last]) last--;
				top = 0;
				while (top <= last) {
					boolean tmp = !tab[top];
					tab[top] = !tab[last];
					tab[last] = tmp;
					top++; last--;
				}
			}
		}
		
		return cpt;
	}
	
	static boolean check (boolean[] tab) {
		boolean res = true;
		for (int i=0; i<tab.length && res; i++) {
			res = res && tab[i];
		}
		return res;
	}
	
}
