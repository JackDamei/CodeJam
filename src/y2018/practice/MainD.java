package y2018.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class MainD {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		PrintStream out = System.out;
		
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			long N = in.nextLong();
			long K = in.nextLong();
			
			long min, max;
			
			// calculate round
			long pow = 1;
			while (K >= 2*pow)
				pow *= 2;
			
			// calculate remaining
			long passed = pow-1;
			long remaining = N-passed;
			long rank = K-passed;
			long size = remaining/(passed+1);
			long nbBig = remaining%(passed+1);
			
			// get the answer
			size += rank <= nbBig ? 1 : 0;
			min = (size-1)/2;
			max =  size/2;
			
			out.println(String.format("Case #%d: %d %d", t+1, max, min));
		}
	
		in.close();
	}
	
}
