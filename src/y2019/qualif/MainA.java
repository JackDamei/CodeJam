package y2019.qualif;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();
				
		for (int t=0; t<T; t++) {
			String N = in.next();
			String A = N;
			String B = N;
			A = A.replace('4', '3');
			B = B.replaceAll("[^4]","0");
			B = B.replace('4', '1');
			System.out.println("Case #"+(t+1)+": "+A+" "+B);
		}
		in.close();
	}
}