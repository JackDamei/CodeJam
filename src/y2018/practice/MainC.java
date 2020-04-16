package y2018.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class MainC {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		PrintStream out = System.out;
		
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int D = in.nextInt();
			int N = in.nextInt();
			
			double maxTime = 0;
			for (int i=0; i<N; i++) {
				int K = in.nextInt();
				int S = in.nextInt();
				double time = (double)(D-K)/S;
				maxTime = Math.max(maxTime, time);
			}
			
			double speed = D/maxTime;
			out.println(String.format("Case #%d: %6f", t+1, speed));
		}
	
		in.close();
	}
	
}
