package y2016r1B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;


public class MainA {

	public static void main(String[] args) {

		//String filename = "src/y20161B/A-test";
		//String filename = "src/y20161B/A-small-practice";
		String filename = "src/y20161B/A-large-practice";

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
				String S = in.readLine();
				
				// calcul
				String res = solve(S);
				
				System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	static String solve (String S) {
		String res = "";
		
		//count all letters
		int letters[] = new int[26];
		Arrays.fill(letters, 0);
		for (int i=0; i<S.length(); i++)
			letters[S.charAt(i)-65]++;

		int nb[] = new int[10];
		Arrays.fill(nb, 0);
		
		//look Zero
		nb[0] = letters[25];
		letters[25] -= nb[0];
		letters[4] -= nb[0];
		letters[17] -= nb[0];
		letters[14] -= nb[0];
		
		//look tWo
		nb[2] = letters[22];
		letters[19] -= nb[2];
		letters[22] -= nb[2];
		letters[14] -= nb[2];
		
		//look foUr
		nb[4] = letters[20];
		letters[5] -= nb[4];
		letters[14] -= nb[4];
		letters[20] -= nb[4];
		letters[17] -= nb[4];
		
		//look siX
		nb[6] = letters[23];
		letters[18] -= nb[6];
		letters[8] -= nb[6];
		letters[23] -= nb[6];
		
		//look eiGht
		nb[8] = letters[6];
		letters[4] -= nb[8];
		letters[8] -= nb[8];
		letters[6] -= nb[8];
		letters[7] -= nb[8];
		letters[19] -= nb[8];
		
		//look tHree
		nb[3] = letters[7];
		letters[19] -= nb[3];
		letters[7] -= nb[3];
		letters[17] -= nb[3];
		letters[4] -= 2*nb[3];

		//look Five
		nb[5] = letters[5];
		letters[5] -= nb[5];
		letters[8] -= nb[5];
		letters[21] -= nb[5];
		letters[4] -= nb[5];
		
		//look seVen
		nb[7] = letters[21];
		letters[18] -= nb[7];
		letters[4] -= 2*nb[7];
		letters[21] -= nb[7];
		letters[13] -= nb[7];
		
		//look nIne
		nb[9] = letters[8];
		letters[13] -= 2*nb[9];
		letters[8] -= nb[9];
		letters[4] -= nb[9];
		
		//look One
		nb[1] = letters[14];
		letters[14] -= nb[1];
		letters[13] -= nb[1];
		letters[4] -= nb[1];
		
		//build string
		for (int i=0; i<10; i++) {
			for (int j=0; j<nb[i]; j++)
				res += i;
		}
		
		return res;
	}
	
}
