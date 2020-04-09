package y2019.qualif;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainB {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();
				
		for (int t=0; t<T; t++) {
			@SuppressWarnings("unused")
			int N = in.nextInt();
			String P = in.next();
			String res = P.replaceAll("E", "A");
			res = res.replaceAll("S", "E");
			res = res.replaceAll("A", "S");
			System.out.println("Case #"+(t+1)+": "+res);
		}
		in.close();
	}
}