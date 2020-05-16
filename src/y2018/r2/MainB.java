package y2018.r2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class MainB {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		PrintStream out = System.out;
		int T = in.nextInt();
			
		for (int t=0; t<T; t++) {
			
			int R = in.nextInt();
			int B = in.nextInt();
			
			int res = solve(R,B);
			out.println(String.format("Case #%d: %s", t+1, res));
		}
		
		in.close();
	}

	public static int solve (int R, int B) {
		int res = 0;
	
		
		return 0;
	}
	
}
