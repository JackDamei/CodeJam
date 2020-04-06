package y2019.r1C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class MainB {

	public static int[] fact = {0, 1, 2, 6, 24, 120};
	
	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();
		@SuppressWarnings("unused")
		int F = in.nextInt();

		for (int t=0; t<T; t++) {

			String res = "";

			char[] ans = new char[119];
			Arrays.fill(ans, 'x');
			char prev = 'x';
			boolean isA=false, isB=false, isC=false, isD=false, isE=false;
			
			for (int pos=0; pos<4; pos++) {
				int cptA=0, cptB=0, cptC=0, cptD=0, cptE=0;

				char[] tmp = ans;
				ans = new char[119];
				Arrays.fill(ans, 'x');
				for (int i=0; i<119; i++) {
					if(tmp[i] != prev)
						continue;
					System.out.println(i*5+pos+1);
					ans[i] = in.next().charAt(0);
					switch (ans[i]) {
					case 'A':
						cptA++;
						break;
					case 'B':
						cptB++;
						break;
					case 'C':
						cptC++;
						break;
					case 'D':
						cptD++;
						break;
					case 'E':
						cptE++;
						break;
					}
				}
				int max = fact[5-pos-1];
				if (!isA && cptA != max) {
					prev = 'A';
					res += 'A';
					isA = true;
				}
				if (!isB && cptB != max) {
					prev = 'B';
					res += 'B';
					isB = true;
				}
				if (!isC && cptC != max) {
					prev = 'C';
					res += 'C';
					isC = true;
				}
				if (!isD && cptD != max) {
					prev = 'D';
					res += 'D';
					isD = true;
				}
				if (!isE && cptE != max) {
					prev = 'E';
					res += 'E';
					isE = true;
				}
			}
			if (!isA)
				res += 'A';
			if (!isB)
				res += 'B';
			if (!isC)
				res += 'C';
			if (!isD)
				res += 'D';
			if (!isE)
				res += 'E';

			System.out.println(res);
			if (in.next().equals("N"))
				break;
		}
		in.close();
	}
		
}